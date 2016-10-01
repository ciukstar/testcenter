package code
package lib

import net.liftweb._
import http._
import common._
import rest.RestHelper
import domain._
import json.JsonAST
import json.JsonDSL._

object ApplicantService extends RestHelper {

  def init() {
    LiftRules.statelessDispatch.append(ApplicantService)
  }

  serve("api" / "applicants" prefix {
    case _ JsonPost json => 
      Applicant.createFromJson(json).map{ a => a.save; a.toJson }
  case _ => <p>not found</p>
  })
}
