/**
  * Created by phunn on 2/16/16.
  */

package commons

import play.api.mvc._
import scala.util.{Success, Failure}

object Authorize extends Controller {

  def Logged(f: Request[AnyContent] => Result) = {
    Action { request =>
      request.session.get("user").map { email =>
        f(request)
      }.getOrElse(
        Redirect("/login")
      )
    }
  }

  def Guest(f: Request[AnyContent] => Result) = {
    Action { request =>
      request.session.get("user").map { email =>
        Redirect("/")
      }.getOrElse(
        f(request)
      )
    }
  }
}
