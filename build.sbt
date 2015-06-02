name := """play2torial"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  javaWs,
   "org.springframework" % "spring-context" % "4.1.1.RELEASE",
  "org.springframework" % "spring-orm" % "4.1.1.RELEASE",
  "org.springframework" % "spring-jdbc" % "4.1.1.RELEASE",
  "org.springframework" % "spring-tx" % "4.1.1.RELEASE",
  "org.springframework" % "spring-expression" % "4.1.1.RELEASE",
  "org.springframework" % "spring-aop" % "4.1.1.RELEASE",
  "org.springframework" % "spring-test" % "4.1.1.RELEASE" % "test"
)

libraryDependencies +=   "mysql" % "mysql-connector-java" % "5.1.21"

val appDependencies = Seq(
    // Add your project dependencies here,
    "mysql" % "mysql-connector-java" % "5.1.18"
)

libraryDependencies += "org.hibernate" % "hibernate-entitymanager" % "4.3.10.Final"

libraryDependencies += "org.springframework" % "spring-web" % "3.1.1.RELEASE"

libraryDependencies += "org.springframework" % "spring-jdbc" % "4.1.6.RELEASE"

libraryDependencies += "org.springframework" % "spring-beans" % "4.1.6.RELEASE"

libraryDependencies += "org.springframework" % "spring-dao" % "2.0.8"

