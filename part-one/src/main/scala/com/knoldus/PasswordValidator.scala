package com.knoldus;
class PasswordValidator(){
    
    // password validation check; helper fn
    val containsSpace = (str: String) => str.contains(" ");
    val containsDigit = (str: String) => str.exists(_.isDigit);
    val containsUpperCase = (str: String) => str.exists(_.isUpper);
    val containsLowerCase = (str: String) => str.exists(_.isLower);
    val containsSpecialChar = (str: String) => str.exists(!_.isLetterOrDigit);
    val lengthBetween8and15 = (str: String) => str.length()>=8 && str.length()<=15;

    def isValidPassword(password: String): Boolean = {
        return (!containsSpace(password) &&
        lengthBetween8and15(password) && 
        containsDigit(password) && 
        containsUpperCase(password) && 
        containsLowerCase(password) && 
        containsSpecialChar(password))
    }

}