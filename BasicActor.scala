//package whats_wrong

//import akka.actor.{ Actor, ActorSystem, Props }
import scala.io.StdIn

/*
When receiving a message that says "Hello", BasicActor must print "Hello there."
It must print "What?" when receiving any other message
*/

class BasicActor {
  def helloWorld(): Unit ={
    print("Please enter your input : " )
    val line = StdIn.readLine()
    if(line == "Hello") {
      println("Hello there")
    } else {
      println("What ?")
    }
  }
}

object FireActor {

/*  Create an instance of BasicActor
  Make it print "Hello there." and "What?"*/
  def fireActor(): Unit = {
    //    val system = ActorSystem("Actor System")
    //    val basic_actor = system.actorOf(Props[BasicActor], name = "basic actor")
    val basicActor = new BasicActor()
    basicActor.helloWorld()
  }
}

FireActor.fireActor()