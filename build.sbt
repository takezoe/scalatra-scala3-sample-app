val ScalatraVersion = "3.0.0-M2"

ThisBuild / scalaVersion := "3.1.3"
ThisBuild / organization := "com.example"

lazy val hello = (project in file("."))
  .settings(
    name := "My Scalatra Web App",
    version := "0.1.0-SNAPSHOT",
    libraryDependencies ++= Seq(
      "org.scalatra" %% "scalatra" % ScalatraVersion,
      "org.scalatra" %% "scalatra-scalatest" % ScalatraVersion % "test",
      "ch.qos.logback" % "logback-classic" % "1.2.3" % "runtime",
      "jakarta.servlet" % "jakarta.servlet-api" % "5.0.0" % "provided",
      "org.eclipse.jetty" % "jetty-slf4j-impl" % "11.0.11", // Required for JettyRunner
    )
  )

enablePlugins(SbtTwirl)

// Use custom containr because xsbt-web-plugin doesn't support Jetty 11 and Servlet 5
enablePlugins(ContainerPlugin)
Container / containerLibs := Seq("org.eclipse.jetty" %  "jetty-runner" % "11.0.11")
Container / containerMain := "org.eclipse.jetty.runner.Runner"
