package com.knoldus.validator

import org.scalatest.flatspec.AsyncFlatSpec
import com.knoldus.models.Company

class CompanyValidationIntegrationTest extends AsyncFlatSpec  {
    val companyValidator = new CompanyValidator()
    
    "New Company " should "be valid since its not present in DB and email is valid" in {
        assert(companyValidator.companyIsValid(Company("Alphabet Inc", "abc@gmail.com", "Delhi")))
    }

    "knoldus " should "be invalid since its present in DB" in {
        assert(!companyValidator.companyIsValid(Company("Knoldus", "abc@gmail.com", "Delhi")))
    }

    "New Company(InvalidEmail) " should "be invalid since email id is invalid" in {
        assert(!companyValidator.companyIsValid(Company("Alphabet", "@g.com", "Delhi")))
    }

    "Philips " should "be invalid since its present in DB and email id is also invalid" in {
        assert(!companyValidator.companyIsValid(Company("Philips", "@g.com", "Delhi")))
    }    
}