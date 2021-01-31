package com.knoldus;

import org.scalatest.flatspec.AsyncFlatSpec 

class PasswordValidatorTest extends AsyncFlatSpec  {
    val passValidator = new PasswordValidator()

    "the password \"HelloWorld@123\" " should "be valid" in {
        assert(passValidator.isValidPassword("HelloWorld@123"))
    }

    "the password \"HelloWorld @1234\"" should "not be valid as it contains space" in {
        assert(!passValidator.isValidPassword("HelloWorld @1234"))
    }

    "the password \"HelloWorld@\"" should "not be valid as it does not contain a number" in {
        assert(!passValidator.isValidPassword("HelloWorld@"))
    }

    "the password \"helloworld@1234\"" should "not be valid as it does not contain a uppercase" in {
        assert(!passValidator.isValidPassword("helloworld@1234"))
    }  

    "the password \"HELLOWORLD@1234\"" should "not be valid as it does not contain a lowercase" in {
        assert(!passValidator.isValidPassword("HELLOWORLD@1234"))
    }  

    "the password \"HelloWorld@12345\"" should "not be valid as it does not contain a Special character" in {
        assert(!passValidator.isValidPassword("HelloWorld2123"))
    } 

    "the password \"HelloWorld@12345\"" should "not be valid as it is too big" in {
        assert(!passValidator.isValidPassword("HelloWorld@12345"))
    }  

    "the password \"Hel@123\"" should "not be valid as it is too small" in {
        assert(!passValidator.isValidPassword("Hel@123"))
    }              
}