package controllers

import play.api._
import play.api.mvc._
import models.Applicant

object Application extends Controller {
  
  
  def list(page: Int, orderBy: Int, filter: String) = Action { implicit request =>
    
    Ok(views.html.list(
      Applicant.list(page = page, orderBy = orderBy, filter = filter),
      orderBy, filter
    ))
  }  
  def index = Action {
    Redirect(routes.Application.list())
  }
  
  
  def details(id: Int) = Action { implicit request =>
    
    Applicant.findById(id).map { product =>
    
    Ok(views.html.details(product))}.getOrElse(NotFound)
    
  }
  
 }