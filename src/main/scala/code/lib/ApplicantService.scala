package code
package lib

import net.liftweb._
import http._
import common._
import rest.RestHelper

object ApplicantService extends RestHelper {
  
  def init() {
    LiftRules.statelessDispatch.append(ApplicantService)
  }

  serve {
    case "applicants" :: Nil XmlGet _ => <p>These are all Applicant(s)</p>
    case "applicants" :: id :: Nil XmlGet _ => <p>This is Applicant {id}</p>
    case "applicants" :: Nil XmlPost _ => <p>Applicant created </p>
    case "applicants" :: id :: Nil XmlDelete _ => <p>Applicant {id} deleted</p>
  }
}
