package com.example.library_management.Validator;

import com.example.library_management.Model.User;

public class UserValidator {
    public static boolean isValid(User newUser) {
        if(newUser.getEmail()!=null){
            return true;
        }
        return false;
    }
}
