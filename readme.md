# sff4smode

A utility for https://github.com/eed3si9n/sff4s

## sbt

```scala
resolvers ++= Seq(
  "seratch.github.com releases"  at "http://seratch.github.com/mvn-repo/releases"
)

libraryDependencies ++= Seq(
  "com.github.seratch" %% "sff4smode" % "0.1.0" withSources ()
)
```

## Usage

### Simply use sff4s's Future

```scala
import sff4smode._
val future: sff4s.Future[String] = future {
  // blocking operation...
  "result"
}
```

```scala
import sff4smode._
implicit val futureFactory: sff4s.Futures = sff4s.impl.TwitterUtilFuture
val future: sff4s.Future[String] = future {
  // blocking operation...
  "result"
} // use com.twitter.uti.Future internally
```

### Converters

```scala
import sff4smode._
val f: sff4s.Future[String] = toSff4s(scala.actors.Futures.future("fooo"))
val f: sff4s.Future[String] = toSff4s(akka.dispatch.Future.apply("fooo", 1))
val f: sff4s.Future[String] = toSff4s(com.twitter.util.Future.value("fooo"))
```

## License

Apache License, Version 2.0

http://www.apache.org/licenses/LICENSE-2.0.html

