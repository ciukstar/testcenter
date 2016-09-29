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

  serve("api" / "applicants" prefix {
    case XmlGet(Nil, _) =>
      <ul><li>Applicant 1</li><li>Applicant 2</li></ul>
    case XmlGet(id :: Nil, _) =>
      <p>Applicant {id}</p>
    case XmlPost(Nil, _) =>
      <p>Applicant created</p>
    case XmlDelete(id :: Nil, _) =>
      <p>Applicant {id} deleted</p>
  })
}
