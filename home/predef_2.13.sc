import coursierapi.MavenRepository

interp.repositories.update(
  interp.repositories() ++ Seq(
    MavenRepository.of("https://repository.cloudera.com/content/repositories/releases/"),
    MavenRepository.of("http://builds.archive.org/maven2/")
  )
)

interp.load.ivy(
  "com.lihaoyi" %
  s"ammonite-shell_${scala.util.Properties.versionNumberString}" %
  ammonite.Constants.version
)

//import $plugin.$ivy.`pl.project13.scala:sbt-jmh:0.3.4`
import $plugin.$ivy.`org.typelevel::kind-projector:0.10.3`

interp.configureCompiler(_.settings.YmacroAnnotations.value = true)

@
val shellSession = ammonite.shell.ShellSession()
import shellSession._
import ammonite.ops._
import ammonite.shell._
ammonite.shell.Configure(interp, repl, shellSession.wd)

import $ivy.`com.github.mpilquist::simulacrum:0.19.0`
import simulacrum._

import $exec.scripts.`cats-import`

import scala.concurrent.duration._
import scala.concurrent.{ExecutionContext => ec}
import ec.Implicits.global
import scala.concurrent._

import $exec.scripts.`jodatime-import`

val ammoniteHome = home / ".ammonite"

def loadScript(fileName: String) = repl.load.exec(ammoniteHome / "scripts" / (fileName + ".sc"))

