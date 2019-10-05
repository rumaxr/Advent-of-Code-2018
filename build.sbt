name := "advent-of-code-2018"

version := "0.1"

scalaVersion := "2.13.1"

libraryDependencies ++= Seq(
  "org.specs2" %% "specs2-core" % "4.7.1" % "test"
)

scalacOptions in Test ++= Seq("-Yrangepos")