package code
package lib

import net.liftweb._
import http._
import common._
import rest.RestHelper
import domain._
import json._
import JsonAST._
import JsonDSL._

object ApplicantService extends RestHelper {

  def init() {
    LiftRules.statelessDispatch.append(ApplicantService)
  }

  serve("api" / "applicants" prefix {
    case id :: Nil JsonGet req =>
      Applicant.find(id).map(_.toJson)
    case Nil JsonPost req => 
      Applicant.fromJson(req._1.asInstanceOf[JObject]).map{ a => a.save; a.toJson }
    case Nil JsonGet _ =>
      JsonResponse(Applicant.findAllAsJson)
    case _ => <p>not found</p>
  })
}
