/*
* Copyright 2012 Kazuhiro Sera
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
* either express or implied. See the License for the specific language
* governing permissions and limitations under the License.
*/
package object sff4smode {

  /**
   * Default future factory
   */
  implicit val defaultFutureFactory: sff4s.Futures = sff4s.impl.ActorsFuture

  /**
   * Returns body as a sff4s.Future
   */
  def future[A](body: => A)(implicit futureFactory: sff4s.Futures): sff4s.Future[A] = futureFactory.future(body)

  /**
   * Converts java.util.concurrent.Future
   */
  def toSff4s[A](jucFuture: java.util.concurrent.Future[A]): sff4s.Future[A] = sff4s.impl.JucSingleThreadExecutorFuture.toFuture(jucFuture)

  /**
   * Converts scala.actors.Future
   */
  def toSff4s[A](actorsFuture: scala.actors.Future[A]): sff4s.Future[A] = sff4s.impl.ActorsFuture.toFuture(actorsFuture)

  /**
   * Converts akka.dispatch.Future
   */
  def toSff4s[A](akkaFuture: akka.dispatch.Future[A]): sff4s.Future[A] = sff4s.impl.AkkaFuture.toFuture(akkaFuture)

  /**
   * Converts com.twitter.util.Future
   */
  def toSff4s[A](twitterUtilFuture: com.twitter.util.Future[A]): sff4s.Future[A] = sff4s.impl.TwitterUtilFuture.toFuture(twitterUtilFuture)

}


