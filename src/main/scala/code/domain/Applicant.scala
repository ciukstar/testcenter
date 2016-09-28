package code
package domain

import net.liftweb.mapper._
import net.liftweb.json.JsonAST
import net.liftweb.json.JsonDSL._
import net.liftweb.json.JsonDSL.{pair2Assoc, pair2jvalue}

class Applicant extends LongKeyedMapper[Applicant] {
  def getSingleton = Applicant

  def primaryKeyField = id
  object id extends MappedLongIndex(this)
  object surname extends MappedString(this, 50)
  object name extends MappedString(this, 50)
  object patronymic extends MappedString(this, 50)

  def toJson: JsonAST.JObject =
    (id.name -> id.get) ~ 
    (surname.name -> surname.get) ~
    (name.name -> name.get) ~
    (patronymic.name -> patronymic.get)
}

object Applicant  extends Applicant with LongKeyedMetaMapper[Applicant] {

}
  

