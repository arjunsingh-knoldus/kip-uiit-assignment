package com.knoldus.validator

class EmailValidator {

  def emailIdIsValid(emailId: String): Boolean = 
    """(\w+)@\w+\.(com|net|org)""".r.unapplySeq(emailId).isDefined
}
