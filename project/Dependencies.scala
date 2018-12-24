import sbt._

object Version {
  val logbackVer        = "1.2.3"
  val scalaVer          = "2.12.6"
  val scalaTestVer      = "3.0.4"
}

object Dependencies {
  val dependencies = Seq(
    "com.github.mpilquist" %% "simulacrum" % "0.13.0",
    "org.scalaz" %% "scalaz-core" % "7.2.26",
    "org.scalaz" %% "scalaz-effect" % "7.2.26",
    "ch.qos.logback"                 %  "logback-classic"             % Version.logbackVer,
    "ch.qos.logback"                 %  "logback-classic"             % Version.logbackVer,
    "org.scalatest"                 %% "scalatest"                    % Version.scalaTestVer         % Test
  )
}
