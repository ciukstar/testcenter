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
    case JsonPost(Nil, _) => JsonResponse(
      ("id" -> "10001") ~
      ("surname" -> "Starciuc") ~
      ("name" -> "Sergiu") ~
      ("patronymic" -> "Victor")
    )
  case _ => <p>not found</p>
  })
}
