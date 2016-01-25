package controllers

import play.api.mvc._

/**
  * Created by phunn on 1/4/16.
  */
class Tasks extends Controller{

  def index = Action {
    Ok(views.html.tasks.index())
  }

  def show = Action {
    Ok(views.html.tasks.show())
  }

  def edit = Action {
    Ok(views.html.tasks.edit())
  }
}
