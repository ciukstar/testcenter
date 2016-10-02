package code
package domain

import net.liftweb.mapper._
import net.liftweb.json._
import JsonAST._
import JsonDSL._

class Applicant extends LongKeyedMapper[Applicant] {
  def getSingleton = Applicant

  def primaryKeyField = id
  object id extends MappedLongIndex(this)
  object surname extends MappedString(this, 50)
  object name extends MappedString(this, 50)
  object patronymic extends MappedString(this, 50)

  def toJson: JObject =
    Applicant.toJson(this)
}

object Applicant extends Applicant with LongKeyedMetaMapper[Applicant] {

  def findAllAsJson: JArray =
    net.liftweb.json.JArray(findAll.map(_.toJson))

  def fromJson(json: JObject): Option[Applicant] = {
    Some(decodeFromJSON_!(json, true))
  }
  def toJson(a: Applicant): JObject =
    encodeAsJSON_!(a)
}
