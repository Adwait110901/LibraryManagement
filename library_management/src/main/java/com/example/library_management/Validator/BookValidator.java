package com.example.library_management.Validator;

import com.example.library_management.Model.Book;

public class BookValidator {
    public static boolean isValid(Book book) {
        if(book.getBookName()!=null || book.getBookName()!=""){
            return true;
        }
        return false;
    }
}
