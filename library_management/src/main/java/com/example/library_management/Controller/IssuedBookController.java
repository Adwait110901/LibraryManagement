package com.example.library_management.Controller;

import com.example.library_management.Model.Book;
import com.example.library_management.Model.IssuedBook;
import com.example.library_management.Repository.IssuedBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

public class IssuedBookController {


    // issue book
    // get all issued books by a user,
     // get all books issued in the db


    @Autowired
    IssuedBookRepository  issuedBookRepository;

    @GetMapping("/findAllIssuedBooks")
    List<IssuedBook> findAllIssuedBooks(){
        return issuedBookRepository.findAll();
    }


    @GetMapping(value = "/searchIssuedBooksByUser")
    public List<IssuedBook> searchIssuedBooksByUser(@RequestParam(value = "q") String userId){
        //LOGGER.info("searchIssuedBooksByUser called with userId "+userId);
        List<IssuedBook> books = issuedBookRepository.findAll(); //
        ArrayList<IssuedBook> list = new ArrayList<IssuedBook>();
        for(IssuedBook book : books){
            int id = Integer.parseInt(userId);
            if(book.getUserId()==id){
                list.add(book);
            }
        }
        return list;
    }
    @GetMapping("/IssueBook")
    public IssuedBook issueBook(@RequestBody IssuedBook issuedBooks) throws Exception{
        try {
            issuedBooks.setStatus("issued");
            return issuedBookRepository.save(issuedBooks);
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception();
        }
    }
}
