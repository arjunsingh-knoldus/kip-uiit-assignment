package com.knoldus.validator

import org.scalatest.flatspec.AsyncFlatSpec 
import com.knoldus.models.Employee

class EmailValidatorTest extends AsyncFlatSpec  {
    var emailValidator = new EmailValidator()

    "aBcD12@exampl3.org " should "be a valid email" in {
        assert(emailValidator.emailIdIsValid("aBcD12@exampl3.org"))
    }

    "aBcD12@exampl3.com " should "be a valid email" in {
        assert(emailValidator.emailIdIsValid("aBcD12@exampl3.com"))
    }

    "aBc D12@exampl3.org " should "be a invalid email" in {
        assert(!emailValidator.emailIdIsValid("aBc D12@exampl3.org"))
    }

    "aBcD12@exampl3.tech " should "be a invalid email" in {
        assert(!emailValidator.emailIdIsValid("aBcD12@exampl3.tech"))
    }
}