package models

case class ErrorDetail(statusCode: Int)
class EmployeeDetails {
  def fetchEmployeeDetailsById(id:Int): Any = {
    id match {
      case 101 => views.html.EmployeeDetails("Parneet","Chandigarh")
      case 102 => views.html.EmployeeDetails("Hitesh","Delhi")
      case _ => ErrorDetail(400)

    }

  }

}