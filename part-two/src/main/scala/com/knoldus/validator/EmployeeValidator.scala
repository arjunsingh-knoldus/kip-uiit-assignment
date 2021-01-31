package com.knoldus.validator

import com.knoldus.models.Employee
import com.knoldus.db.CompanyReadDto

// parameters to facilitate mocking
class EmployeeValidator( val companyDB: CompanyReadDto = new CompanyReadDto(),
                        val emailValidator: EmailValidator = new EmailValidator() ) {

  def employeeIsValid(employee: Employee): Boolean =
    companyDB.getCompanyByName(employee.companyName)!=None && emailValidator.emailIdIsValid(employee.emailId)
}
