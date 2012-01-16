package sff4smode.test

import org.scalatest._
import org.scalatest.matchers._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import java.lang.Thread
import java.util.concurrent.{Executors, Callable}

@RunWith(classOf[JUnitRunner])
class Sff4smodeSuite extends FunSuite with ShouldMatchers {

  type ? = this.type // for IntelliJ IDEA

  test("using default factory") {
    import sff4smode._
    val f = future {
      "fooo"
    }
    f onSuccess (t => t should equal("fooo")) onFailure (t => fail())
    f() should equal("fooo")
  }

  test("using AkkaFuture factory") {
    import sff4smode._
    implicit val futureFactory: sff4s.Futures = sff4s.impl.AkkaFuture
    val f = future {
      "fooo"
    }
    f onSuccess (t => t should equal("fooo")) onFailure (t => fail())
    f() should equal("fooo")
  }

  test("using TwitterUtilFuture factory") {
    import sff4smode._
    implicit val futureFactory: sff4s.Futures = sff4s.impl.TwitterUtilFuture
    val f = future {
      "fooo"
    }
    f onSuccess (t => t should equal("fooo")) onFailure (t => fail())
    f() should equal("fooo")
  }

  test("using ActorsFuture factory") {
    import sff4smode._
    implicit val futureFactory: sff4s.Futures = sff4s.impl.ActorsFuture
    val f = future {
      "fooo"
    }
    f onSuccess (t => t should equal("fooo")) onFailure (t => fail())
    f() should equal("fooo")
  }

  test("using JucSingleThreadExecutorFuture factory") {
    import sff4smode._
    implicit val futureFactory: sff4s.Futures = new sff4s.impl.JucFixedThreadPoolFuture(10)
    val f = future {
      "fooo"
    }
    f onSuccess (t => t should equal("fooo")) onFailure (t => fail())
    f() should equal("fooo")
  }

  // TODO  https://github.com/eed3si9n/sff4s/pull/1
  //  test("toSff4s from java.util.concurrent.Future") {
  //    import java.util.concurrent.FutureTask
  //    import sff4smode._
  //    val jucFuture = new FutureTask(new Callable[String]() {
  //      def call(): String = "fooo"
  //    })
  //    jucFuture.run()
  //    val f: sff4s.Future[String] = toSff4s(jucFuture)
  //    f onSuccess (t => t should equal("fooo")) onFailure (t => fail())
  //    f() should equal("fooo")
  //  }

  test("toSff4s from scala.actors.Future") {
    import sff4smode._
    val f: sff4s.Future[String] = toSff4s(scala.actors.Futures.future("fooo"))
    f onSuccess (t => t should equal("fooo")) onFailure (t => fail())
    f() should equal("fooo")
  }

  test("toSff4s from akka.dispatch.Future") {
    import sff4smode._
    val f: sff4s.Future[String] = toSff4s(akka.dispatch.Future.apply("fooo", 1))
    f onSuccess (t => t should equal("fooo")) onFailure (t => fail())
    f() should equal("fooo")
  }

  test("toSff4s from com.twitter.util.Future") {
    import sff4smode._
    val f: sff4s.Future[String] = toSff4s(com.twitter.util.Future.value("fooo"))
    f onSuccess (t => t should equal("fooo")) onFailure (t => fail())
    f() should equal("fooo")
  }


}

