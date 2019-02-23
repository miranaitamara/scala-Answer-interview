object MapYourMap extends App {

  //Tell developer names by the department code

  val devNames = Map("dev1" -> "Pierre", "dev2" -> "Remy", "dev3" -> "Noe", "dev4" -> "Alexandre")
  val devDepartments = Map("dev1" -> "analytics", "dev2" -> "frontend", "dev3" -> "api", "dev4" -> "frontend")

  /*
  Expected result:
  Map(frontend -> List(Remy, Alexandre), analytics -> List(Pierre), api -> List(Noe))
   */

  case class Item(id: String, job: String)

  val g = devNames.map(i => Item(i._1, i._2))

  val p = devDepartments.map(i => Item(i._1, i._2))

  var jobM = ""
  var str = ""
  var finalMap = Map[String, List[String]]()

  for(n <- g) {
    str = ""
    jobM = ""
    for(m <- p) {
      if(n.id == m.id) {
        jobM = m.job
        str += n.job + " "
      }
      if(m.job == jobM && n.id != m.id) {
        for(k <- g) {
          if(m.id == k.id) {
            str += k.job + " "
          }
        }
      }
    }
    val strList = str.split(" ").toList
    finalMap += (jobM -> strList)
  }

  val namesInDepartments = finalMap

  println(namesInDepartments)
}