package controllers

import play.api.mvc._

/**
  * Created by phunn on 1/4/16.
  */
class Users extends Controller {

  def index = Action {
    Ok(views.html.users.index())
  }

  def show(id: Int) = Action {
    Ok(views.html.users.show())
  }

  def edit(id: Int) = Action {
    Ok(views.html.users.edit())
  }

}
