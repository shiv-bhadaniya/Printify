package com.printify.sgpproject.controller;

import com.printify.sgpproject.controller.exception.UserNotFoundException;
import com.printify.sgpproject.model.User;
import com.printify.sgpproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {
    @Autowired
    private UserRepository userRepository;//object of Userrepository from package:: repository
        @PostMapping("/user")//map http request named user to this below function(technically to post the data)
                User newUser(@RequestBody User newUser){//request body is a data sent by a client to you thru a api

        return userRepository.save(newUser);//this will return what we have given it as a data
        }

        @GetMapping("/users")//to get the data from database
        List<User> getAllUsers(){//list of all users from databse will be returned
                    return userRepository.findAll();
        }

        @GetMapping("/user/{id}")
            User getUserById(@PathVariable Long id){
            return userRepository.findById(id)
                    .orElseThrow(()->new UserNotFoundException(id));
        }
    @DeleteMapping("/user/{id}")
    String deleteUser(@PathVariable Long id){
        if(!userRepository.existsById(id)){
            throw new UserNotFoundException(id);
        }
        userRepository.deleteById(id);
        return  "User with id "+id+" has been deleted success.";
    }




}
