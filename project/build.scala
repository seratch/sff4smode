import sbt._
import Keys._

object Sff4sModeBuild extends Build {

  lazy val sff4smode = Project("sff4smode", file("."), settings = mainSettings)

  lazy val mainSettings: Seq[Project.Setting[_]] = Defaults.defaultSettings ++ Seq(
    sbtPlugin := false,
    organization := "com.github.seratch",
    name := "sff4smode",
    version := "0.1.1",
    publishTo <<= (version) {
      version: String =>
        Some(
          Resolver.file("GitHub Pages", Path.userHome / "github" / "seratch.github.com" / "mvn-repo" / {
            if (version.trim.endsWith("SNAPSHOT")) "snapshots" else "releases"
          })
        )
    },
   publishMavenStyle := true,
    scalacOptions ++= Seq("-deprecation", "-unchecked")
  )

}

