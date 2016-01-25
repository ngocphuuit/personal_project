package controllers

import play.api.mvc._

/**
  * Created by phunn on 1/4/16.
  */
class Plans extends Controller {

  def index = Action {
    Ok(views.html.plans.index())
  }

  def show(id: Int) = Action {
    Ok(views.html.plans.show())
  }

  def edit(id: Int) = Action {
    Ok(views.html.plans.edit())
  }

  def schedule = Action {
    Ok(views.html.plans.schedule())
  }

}
