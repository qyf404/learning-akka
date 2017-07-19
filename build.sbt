import de.johoop.testngplugin.TestNGPlugin._

name := "learning-akka"

version := "1.2"

scalaVersion := "2.12.2"

lazy val akkaVersion = "2.5.3"
lazy val hibernateVersion = "5.2.10.Final"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
  "com.typesafe.akka" %% "akka-slf4j" % akkaVersion,
  "org.slf4j" % "slf4j-api" % "1.7.25",
  "ch.qos.logback" % "logback-classic" % "1.2.3",
  "org.hibernate" % "hibernate-core" % hibernateVersion,
  "org.hibernate" % "hibernate-c3p0" % hibernateVersion,
  "javassist" % "javassist" % "3.12.1.GA",
  "org.postgresql" % "postgresql" % "9.3-1102-jdbc4",
  "com.typesafe.akka" %% "akka-testkit" % akkaVersion % Test,
  "org.testng" % "testng" % "6.10" % Test,
  "org.assertj" % "assertj-core" % "3.3.0" % Test,
  "com.h2database" % "h2" % "1.4.196" % Test,
  "org.mockito" % "mockito-core" % "1.10.19" % Test
)

testNGSettings