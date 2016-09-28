package code
package lib

import domain._
import net.liftweb._
import common._
import http._
import json.JsonAST._
import json.JsonDSL._

object BasicExample {
  
  def init(): Unit = {
    LiftRules.statelessDispatch.append(BasicExample.findApplicant)
  }

  private def toResponse(suffix: String, applicant: Applicant) =
    suffix match {
      case "xml" => XmlResponse(<b>applicant</b>)
      case _ => JsonResponse(applicant.toJson)
    }

  lazy val findApplicant: LiftRules.DispatchPF = {
    case Req("applicants" :: "applicant" :: id :: Nil, suffix, GetRequest) => 
      () => Applicant.find(id).map(toResponse(suffix, _))
  }
}
