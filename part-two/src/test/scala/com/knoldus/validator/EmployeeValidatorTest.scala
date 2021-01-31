package com.knoldus.validator

import org.mockito.MockitoSugar.{mock, when}
import org.scalatest.flatspec.AsyncFlatSpec
import com.knoldus.db.CompanyReadDto
import com.knoldus.models.{Employee, Company}


class EmployeeValidatorTest extends AsyncFlatSpec  {

    // employee object for testing
    val empl_1 = Employee("Fname", "lname", 33, 67.0, "Engineer", "Knoldus", "valid email")
 
    // Mock of DB and email validators
    val mockCompanyDB = mock[CompanyReadDto]
    val mockEmailValidator = mock[EmailValidator]

    var employeeValidator = new EmployeeValidator(mockCompanyDB, mockEmailValidator)

    "Employee " should "be valid since company is present in DB and email is valid" in {
        when(mockCompanyDB.getCompanyByName(empl_1.companyName)) thenReturn Some(Company("a", "b", "c"))
        when(mockEmailValidator.emailIdIsValid(empl_1.emailId)) thenReturn true

        assert(employeeValidator.employeeIsValid(empl_1))
    }

    "Not knoldus " should "be invalid since its not present in DB" in {
        when(mockCompanyDB.getCompanyByName(empl_1.companyName)) thenReturn None
        when(mockEmailValidator.emailIdIsValid(empl_1.emailId)) thenReturn true

        assert(!employeeValidator.employeeIsValid(empl_1))
    }

    "Not knoldus " should "be invalid since email id is invalid" in {
        when(mockCompanyDB.getCompanyByName(empl_1.companyName)) thenReturn Some(Company("a", "b", "c"))
        when(mockEmailValidator.emailIdIsValid(empl_1.emailId)) thenReturn false
        assert(!employeeValidator.employeeIsValid(empl_1))
    }

    "Not knoldus " should "be invalid since its not present in DB and email id is also invalid" in {
        when(mockCompanyDB.getCompanyByName(empl_1.companyName)) thenReturn None
        when(mockEmailValidator.emailIdIsValid(empl_1.emailId)) thenReturn false

        assert(!employeeValidator.employeeIsValid(empl_1))
    }

}