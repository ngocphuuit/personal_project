package controllers

import models._
import models.crud.UserCRUD
import org.mindrot.jbcrypt.BCrypt
import play.api.data._
import play.api.data.Forms._
import play.api.mvc._
import org.joda.time.DateTime
import play.api.libs.concurrent.Execution.Implicits.defaultContext

class Application extends Controller {

  def UserModel = new UserCRUD

  def index = Action.async {
    UserModel.getByEmail("ngocphuasdasd.uit@gmail.com") match {
      case users => println(users)
      case _ => println("co ko nhi")
    }
    UserModel.getAll().map(c => Ok(views.html.index(c)))
  }

  def login = Action {
    Ok(views.html.login())
  }

  def signup = Action {
    Ok(views.html.signup())
  }
}
