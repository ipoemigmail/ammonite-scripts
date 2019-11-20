//import coursierapi.MavenRepository
//
//interp.repositories.update(
//  interp.repositories() ++ Seq(
//    MavenRepository.of("https://jitpack.io/")
//  )
//)
//
interp.load.ivy(
  "kr.bydelta" % "koalanlp-core" % "2.0.2",
  "org.jetbrains.kotlin" % "kotlin-reflect" % "1.3.50",
  "kr.bydelta" %% "koalanlp-scala" % "2.0.2",
  ("kr.bydelta" % "koalanlp-kkma" % "2.0.2").withClassifier("assembly")
)

@

//import $ivy.`kr.bydelta::koalanlp-scala:2.0.2`
//import $ivy.`kr.bydelta:koalanlp-daon:2.0.2`

import kr.bydelta.koala.Implicits._
import kr.bydelta.koala.kkma.Tagger
import kr.bydelta.koala.kkma.Parser

val tagger = new Tagger
val parser = new Parser
