package com.example.library_management.Controller;

import com.example.library_management.Model.User;
import com.example.library_management.Repository.UserRepository;
import com.example.library_management.Validator.UserValidator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public class UserController {


    //insert new user
    //get all users
    // find user by id
    private UserRepository repository;
    // Find


    @GetMapping("/users")
    List<User> findAll() {
        return repository.findAll();
    }

    @PostMapping("/users")
    //return 201 instead of 200
    //@ResponseStatus(HttpStatus.CREATED)
    //@ApiOperation("This endpoint is to create new user")
    User newUser(@RequestBody User newUser) throws Exception {

        if(UserValidator.isValid(newUser))
            return repository.save(newUser);


        else throw new Exception();
    }

    // Find a given user
    @GetMapping("/users/{id}")
    Optional<User> findOne(@PathVariable int id) {
        //LOGGER.info("/users/{id} called with id "+ id);

        //Optional<User> user = repository.findById(id);
        //return user.get();

        return repository.findById(id);

    }
}
