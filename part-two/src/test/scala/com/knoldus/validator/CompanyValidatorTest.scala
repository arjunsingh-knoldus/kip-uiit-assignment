package com.knoldus.validator

import org.mockito.MockitoSugar.{mock, when}
import org.scalatest.flatspec.AsyncFlatSpec
import com.knoldus.db.CompanyReadDto
import com.knoldus.models.Company


class CompanyValidatorTest extends AsyncFlatSpec  {

    // two company objects for testing
    val knoldus = Company("Knoldus", "valid email", "Noida")
    val notKnoldus = Company("NotKnoldus", "invalid email", "Noida")

    // Mock of DB and email validators
    val mockCompanyDB = mock[CompanyReadDto]
    val mockEmailValidator = mock[EmailValidator]

    var companyValidator = new CompanyValidator(mockCompanyDB, mockEmailValidator)

    "knoldus " should "be valid since its not present in DB and email is valid" in {
        when(mockCompanyDB.getCompanyByName(knoldus.name)) thenReturn None
        when(mockEmailValidator.emailIdIsValid(knoldus.emailId)) thenReturn true

        assert(companyValidator.companyIsValid(knoldus))
    }

    "Not knoldus " should "be invalid since its present in DB" in {
        when(mockCompanyDB.getCompanyByName(notKnoldus.name)) thenReturn Some(notKnoldus)
        when(mockEmailValidator.emailIdIsValid(notKnoldus.emailId)) thenReturn true

        assert(!companyValidator.companyIsValid(notKnoldus))
    }

    "Not knoldus " should "be invalid since email id is invalid" in {
        when(mockCompanyDB.getCompanyByName(notKnoldus.name)) thenReturn None
        when(mockEmailValidator.emailIdIsValid(notKnoldus.emailId)) thenReturn false
        
        assert(!companyValidator.companyIsValid(notKnoldus))
    }

    "Not knoldus " should "be invalid since its present in DB and email id is also invalid" in {
        when(mockCompanyDB.getCompanyByName(notKnoldus.name)) thenReturn Some(notKnoldus)
        when(mockEmailValidator.emailIdIsValid(notKnoldus.emailId)) thenReturn false

        assert(!companyValidator.companyIsValid(notKnoldus))
    }

}