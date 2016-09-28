
lazy val commonSettings = Seq(
  organization := "ciukstar",
  version := "0.1.0",
  scalaVersion := "2.11.8"
)

lazy val root = (project in file("."))
  .enablePlugins(JettyPlugin)
  .settings(commonSettings: _*)
  .settings(
    name := "testcenter",
    libraryDependencies ++= {
      val liftVersion = "3.0-RC3"
      Seq(
        "net.liftweb" %% "lift-webkit" % liftVersion % "compile",
        "net.liftweb" %% "lift-mapper" % liftVersion % "compile",
        "net.liftweb" %% "lift-json" % liftVersion % "compile",
        "com.h2database" % "h2" % "1.4.192" % "compile",
        "org.eclipse.jetty" % "jetty-webapp" % "9.3.12.v20160915" % "container,test",
        "org.eclipse.jetty" % "jetty-plus" % "9.3.12.v20160915" % "container,test",
        "org.eclipse.jetty.orbit" % "javax.servlet" % "3.0.0.v201112011016" % "container,test"
      )
    }
  )
