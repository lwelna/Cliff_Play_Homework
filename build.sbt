name := """play2torial"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs,
 "org.slf4j" % "slf4j-log4j12" % "1.7.12",
 "org.slf4j" % "slf4j-jdk14" % "1.7.12",
    "org.slf4j" % "log4j-over-slf4j" % "1.7.12",
  "org.slf4j" % "jcl-over-slf4j" % "1.7.12",
   "org.springframework" % "spring-context" % "4.1.1.RELEASE",
  "org.springframework" % "spring-orm" % "4.1.1.RELEASE",
  "org.springframework" % "spring-tx" % "4.1.1.RELEASE",
  "org.springframework" % "spring-expression" % "4.1.1.RELEASE",
  "org.springframework" % "spring-aop" % "4.1.1.RELEASE",
  "org.springframework" % "spring-test" % "4.1.1.RELEASE" % "test"
)

libraryDependencies +=   "mysql" % "mysql-connector-java" % "5.1.21"

val appDependencies = Seq(
    "mysql" % "mysql-connector-java" % "5.1.18"
)

libraryDependencies += "org.hibernate" % "hibernate-entitymanager" % "4.3.10.Final"

libraryDependencies += "org.springframework" % "spring-jdbc" % "4.1.6.RELEASE"

libraryDependencies += "org.springframework" % "spring-beans" % "4.1.6.RELEASE"

libraryDependencies += "org.springframework" % "spring-dao" % "2.0.8"

libraryDependencies += "org.webjars" % "bootstrap" % "2.1.1"

libraryDependencies += "org.webjars" % "jquery" % "1.11.2"
