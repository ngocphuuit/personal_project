package controllers

import org.mindrot.jbcrypt.BCrypt
import models._
import models.crud.UserCRUD
import commons.Authorize
import play.api.data._
import play.api.data.Forms._
import play.api.mvc._
import org.joda.time.DateTime
import play.api.libs.concurrent.Execution.Implicits.defaultContext

class Authorize extends Controller {

  def UserModel = new UserCRUD

  val formSignUp = Form(
    mapping(
      "first_name" -> text,
      "last_name" -> text,
      "username" -> text,
      "email" -> email,
      "password" -> text
    )(FormCreateUser.apply)(FormCreateUser.unapply)
  )

  val formLogin = Form(
    mapping(
      "email" -> email,
      "password" -> text
    )(FormLogin.apply)(FormLogin.unapply)
  )

  def index = Action.async {
    UserModel.getAll().map(c => Ok(views.html.index(c)))
  }

  def loginForm = Action {
    Ok(views.html.login())
  }

  def login = Action.async { implicit request =>
    val userData = formLogin.bindFromRequest.get
    UserModel.getByEmail(userData.email).map { users =>
      if (users.isEmpty) {
        NotFound
      } else {
        val user = users.get
        if (BCrypt.checkpw(userData.password, user.password)) {
          Redirect("/").withSession("user" -> user.email)
        } else {
          Ok(views.html.login())
        }
      }
    }
  }

  def signup = Authorize.Logged { request =>
    Ok(views.html.signup())
  }

  def store = Action.async { implicit request =>
    val userData = formSignUp.bindFromRequest.get

    val user = new User(
                null,
                userData.email,
                BCrypt.hashpw(userData.password, BCrypt.gensalt(12)),
                "r_user",
                Option{userData.first_name},
                Option{userData.last_name},
                null ,
                "asd213123",
                null,
                1,
                DateTime.now(),
                DateTime.now()
              )
    UserModel.store(user).map(_ => Redirect("/login"))
  }

}
