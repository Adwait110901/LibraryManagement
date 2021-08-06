package com.example.library_management.Controller;

import com.example.library_management.Model.Book;
import com.example.library_management.Model.User;
import com.example.library_management.Repository.BookRepository;
import com.example.library_management.Repository.IssuedBookRepository;
import com.example.library_management.Repository.UserRepository;
import com.example.library_management.Validator.BookValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

public class BookController {

    //find all books
    //put new book;
    //searchBookByAuthor
    //Search bookBySubject
    @Autowired
    BookRepository bookRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    IssuedBookRepository issuedBookRepository;

    @GetMapping("/newBook")
    public void newBook(@RequestParam Book book){
        if(BookValidator.isValid(book)){
            bookRepository.save(book);
        }
    }
    @PostMapping("/searchBookByAuthor")
    public List<Book> searchBookByAuthor(@RequestParam String author) {
    List<Book> books = bookRepository.findAll();
    ArrayList<Book> listBook= new ArrayList<>();
    for(Book book:books){
        if(book.getAuthor().equals(author)) listBook.add(book);
    }
    return listBook;
    }
    @PostMapping("/searchBookBySubject")
    public List<Book> searchBookBySubject(@RequestParam String subject) {
        List<Book> books = bookRepository.findAll();
        ArrayList<Book> listBook= new ArrayList<>();
        for(Book book:books){
            if(book.getSubject().equals(subject)) listBook.add(book);
        }
        return listBook;
    }

    @PostMapping("/findAllBooks")
    public List<Book>findAllBooks(){
        List<Book> bookList = bookRepository.findAll();
        return bookList;
    }
}
