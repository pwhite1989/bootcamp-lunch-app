package controllers

import play.api.mvc._


class WelcomeController extends Controller {

  def welcome() = Action {implicit request =>
    Ok(views.html.welcome())
  }

}