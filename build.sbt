import de.johoop.testngplugin.TestNGPlugin._

name := "learning-akka"

version := "1.0"

scalaVersion := "2.12.2"

lazy val akkaVersion = "2.5.3"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
  "com.typesafe.akka" %% "akka-testkit" % akkaVersion,
  "org.slf4j" % "slf4j-api" % "1.7.20",
  "io.ebean" % "ebean" % "10.4.1",
  "io.ebean" % "ebean-agent" % "10.3.1",
  "org.postgresql" % "postgresql" % "9.3-1102-jdbc4",
  "org.avaje.composite" % "composite-testing" % "3.1" % Test
)

testNGSettings


