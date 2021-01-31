package com.knoldus.validator

import com.knoldus.models.Company
import com.knoldus.db.CompanyReadDto

// parameters to facilitate mocking
class CompanyValidator( val companyDB: CompanyReadDto = new CompanyReadDto(),
                        val emailValidator: EmailValidator = new EmailValidator() ) {

  def companyIsValid(company: Company): Boolean = 
    companyDB.getCompanyByName(company.name) == None && emailValidator.emailIdIsValid(company.emailId)

}
