#!/usr/bin/env amm

import scala.util._
import scala.concurrent._
import ExecutionContext.Implicits.global
import duration.Duration

import ammonite.ops._

@main
def main(hostFile: String) = {

  val hostList = refineHostFile(hostFile)

  def command(host: String) =
    %%(
      'ssh,
      s"deploy@$host",
      "-o StrictHostKeyChecking=no",
      List("wc -l", " /home/app/story-app-http/group1/shared/logs/story_contents/story_contents_20181211/story_contents.2018121108.log").mkString
    ).out.lines

  val result = hostList
    .take(1)
    .map(host => Future((host, command(host))))
    .map(x =>
      x.recover {
        case _: Throwable => ()
    })

  val r =
    Await
      .result(Future.sequence(result.toList), Duration.Inf)
      .map(_.asInstanceOf[Tuple2[String, Vector[String]]])
      .map(x => (x._1, x._2.filter(_.contains("total")).head.trim.split(" ")(0).toInt))

}

def refineHostFile(path: String): List[String] = 
  read(Path(path))
    .lines
    .toList
    .tail
    .map(_.trim)
    .filter(!_.startsWith("#"))
    .map(_.substring(2))
