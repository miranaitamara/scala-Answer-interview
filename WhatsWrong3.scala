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
 
  def handleResponse(r: String) = {
    internalState = r
 }
 
  def queryAsyncServer(): Future[String] = Future { "a response" }
}

/* What may be wrong in this case is a bit subjective, and hard to figure out by just 
looking at the code, without any input who stated this */
/* for the query Future { "any string" } should be ok, and then mutate the internaState in the other.*/
/* what may be wrong is that this may be called with other things than "a query" which is not handled in the receive */



