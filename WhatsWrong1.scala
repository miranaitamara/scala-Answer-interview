//package whats_wrong

object WhatsWrong1 extends App {

  trait Interface {
    val city: String
    val support: String = s"Ici c'est $city !"
  }

  case object Supporter extends Interface {

    override val city = "Paris"
    override val support = s"Ici c'est $city !"
  }

  println(Supporter.city) //What does this print ?
  /*
  This write "Paris"
  */
  println(Supporter.support) //What does this print and why ? How to fix it ?
  /*
  This write "Ici c'est null !" because it take the value of of variable city on the Interface.
  We need to define and override the support property in the Supporter object for that the bind be done
  */
}
