package org.example.service.utils;

import org.example.service.exception.PasswordDomainNotValidException;
import org.example.service.exception.PasswordIsNotCombinedException;

public class Authentication {


    public static boolean isPasswordValid(String password) {

        if (password.length() > 6 && password.length()<16) {
            if (isPasswordCombined(password)){
                return true;
            }
            else {
                throw new PasswordIsNotCombinedException("password is not combined");
            }
        }
        else {
            throw new PasswordDomainNotValidException
                    ("password domain not valid must be at least 6 characters and at most 15 characters");
        }
    }


    private static boolean isPasswordCombined(String password){
        return password.matches("^(?=(.*\\d){3,})(?=(.*\\W){1,})(?=.*[a-zA-Z]).*$");
    }
}
