name := """phuot_scala"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  //jdbc,
  cache,
  ws,
  evolutions,
  // Joda time
  "com.github.tototoshi" %% "slick-joda-mapper" % "2.1.0",
  "joda-time" % "joda-time" % "2.4",
  "org.joda" % "joda-convert" % "1.7",
  // Slick
  "com.typesafe.slick" %% "slick" % "3.1.1",
  "com.typesafe.play" %% "play-slick" % "1.1.1",
  "com.typesafe.play" %% "play-slick-evolutions" % "1.1.1",
  // Other
  "mysql" % "mysql-connector-java" % "5.1.35",
  "org.slf4j" % "slf4j-nop" % "1.6.4",
  "org.mindrot" % "jbcrypt" % "0.3m",
  "com.notnoop.apns" % "apns" % "0.1.6",
  "org.apache.poi" % "poi" % "3.8",
  "org.apache.poi" % "poi-ooxml" % "3.8"
)

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator
