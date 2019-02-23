//package whats_wrong

import akka.actor.Actor

import scala.concurrent.Future
import scala.util.{ Failure, Success }
import scala.concurrent.ExecutionContext.Implicits.global

/*
Do you see anything that could lead to potential problems ?
What would you do to fix it ?
Do not mind about the not implemented code
*/

class WhatsWrong3 extends Actor {

  var internalState = "internal state"

  def receive: Receive = {
    case "a query" => {
      val requestF: Future[String] = queryAsyncServer()
      requestF.onComplete {
        case Success(r) => handleResponse(r)
        case Failure(e) => e.printStackTrace()
      }
    }
  }

  def handleResponse(r: String) = ??? // mutate internal state

  def queryAsyncServer(): Future[String] = ???
}
/*
With my current knowledge in scala this code seems good
Little things call me such as the values of the cases ("a query", Success(r) and Failure(e))
or the missing match around the cases but I'm not sure if it's normal or not
*/