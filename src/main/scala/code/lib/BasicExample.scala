package code
package lib

import domain._
import net.liftweb._
import common._
import http._
import rest.RestHelper

object BasicExample extends RestHelper {
  
  def init(): Unit = {
    LiftRules.statelessDispatch.append(BasicExample)
  }

  serve("issues" / "by-state" prefix {
    case "open" :: Nil XmlGet _ => <p>None open</p>
    case "closed" :: Nil XmlGet _ => <p>None closed</p>
    case "closed" :: Nil XmlDelete _ => <p>All deleted</p>
  })

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
