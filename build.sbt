name := "sff4smode"

organization := "com.github.seratch"

crossScalaVersions := Seq("2.9.1")

scalaVersion := "2.9.1"

resolvers ++= Seq(
  "scala-tools-snapshots" at "http://scala-tools.org/repo-snapshots",
  "scala-tools-releases"  at "http://scala-tools.org/repo-releases",
  "Akka repo"             at "http://akka.io/repository/",
  "seratch-github-repo"   at "http://seratch.github.com/mvn-repo/releases",
  "sbt-idea-repo"         at "http://mpeltonen.github.com/maven/"
)

libraryDependencies <++= (scalaVersion) { scalaVersion =>
  Seq(
    "ch.qos.logback"          %  "logback-classic"      % "1.0.0",
    "com.eed3si9n"            %% "sff4s-api"            % "0.1.0",
    "com.eed3si9n"            %% "sff4s-actors"         % "0.1.0",
    "com.eed3si9n"            %% "sff4s-juc"            % "0.1.0",
    "com.eed3si9n"            %% "sff4s-akka"           % "0.1.0",
    "com.eed3si9n"            %% "sff4s-twitter-util"   % "0.1.0",
    "junit"                   %  "junit"                % "4.10"     % "test",
    "org.scalatest"           %% "scalatest"            % "1.6.1"    % "test"
  )
}

seq(lsSettings :_*)

seq(testgenSettings :_*)

