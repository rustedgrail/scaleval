package controllers

import play.api._
import play.api.mvc._

import com.twitter.util.Eval

object Application extends Controller {

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def eval = Action { request =>
    val text = request.body.asText
    val res: String = new Eval()(text.getOrElse("")).toString
    Ok(res)
  }
}
