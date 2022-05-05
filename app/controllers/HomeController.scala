package controllers

import java.awt.Desktop.Action
import java.lang.System.Logger
import javax.inject._

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(val controllerComponents: ControllerComponents) extends MessagesAbstractController(cc) with Logger {
  val employee = newEmployeeDetails

  def ping(): Action[AnyContent] = Action {implicit request: Request[AnyContent] =>
    Ok("pong")
  }

  def getEmployeeDetailsByEmployeeId(id:Int): Action[AnyContent] = Action {
    implicit request: Request[AnyContent] =>
      emplyee.fetchEmployeeDetailsById(id) match {
        case details.HtmlFormat.Appendable => Ok(details)
        case errorCode: ErrorDetail if errorCode.statusCode == 400 => NotFound("no employee exist from this")
        case _ => InternalServerError("something went wrong")
      }
  }


}
