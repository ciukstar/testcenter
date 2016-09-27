package code
package domain

import net.liftweb.mapper._

class Applicant extends LongKeyedMapper[Applicant] {
  def getSingleton = Applicant

  def primaryKeyField = id
  object id extends MappedLongIndex(this)
  object surname extends MappedString(this, 50)
  object name extends MappedString(this, 50)
  object patronymic extends MappedString(this, 50)
}

object Applicant  extends Applicant with LongKeyedMetaMapper[Applicant] {

}
  

