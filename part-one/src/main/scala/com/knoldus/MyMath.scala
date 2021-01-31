package com.knoldus;

trait MathUtils {
    def isPalindrome(number: Int): Boolean
    def factorial(number: Int): BigInt
}


class MyMath extends MathUtils{

    // checks if number is a palindrome or not
    def isPalindrome(number: Int): Boolean = number.toString == number.toString.reverse

    // returns factorial
    def factorial(number: Int): BigInt = {
        if(number < 0)
            throw new IllegalArgumentException("Number Should Be Positive")
        if(number <= 1)
            return BigInt(1)
        else
            return BigInt(number) * factorial(number-1)
    }

}