package com.knoldus;

import org.scalatest.flatspec.AsyncFlatSpec

class MyMathTest extends AsyncFlatSpec  {
    var math = new MyMath()

    "12321 " should "be a palindrome" in {
        assert(math.isPalindrome(12321))
    }

    "901 " should "not be a palindrome" in {
        assert(!math.isPalindrome(901))
    }

    "5! " should "be 120" in {
        assert(math.factorial(5).toInt == 120 )
    }    

    "0! " should "be 1" in {
        assert(math.factorial(0).toInt == 1 )
    }  
    "-1! " should "throw IllegalArgumentException" in {
        assertThrows[IllegalArgumentException]{
            math.factorial(-1)
        }
    }  
}