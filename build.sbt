name := "advent-of-code-2017"

version := "0.1"

scalaVersion := "2.12.7"

libraryDependencies ++= Seq(
  "com.github.nscala-time" %% "nscala-time" % "2.20.0",
  "org.specs2" %% "specs2-core" % "4.3.5" % "test"
)

scalacOptions in Test ++= Seq("-Yrangepos")