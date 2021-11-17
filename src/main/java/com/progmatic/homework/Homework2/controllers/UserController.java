package com.progmatic.homework.Homework2.controllers;

import com.progmatic.homework.Homework2.models.BlogContent;
import com.progmatic.homework.Homework2.models.UserProfile;
import com.progmatic.homework.Homework2.returnModels.ReturnModel;
import com.progmatic.homework.Homework2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private UserService service;


    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }


    /*@GetMapping("/users")
    public ReturnModel<UserProfile> getAllUsers() {
        ReturnModel<UserProfile> toReturn = new ReturnModel<>(
                true, HttpStatus.OK, new UserProfile()
        );
        return toReturn;
    }*/

    /*@GetMapping("/users")
    public ReturnModel<UserProfile> getAllUsers() {
        ReturnModel<UserProfile> toReturn = new ReturnModel<>();
        toReturn.setSuccess(true);
        return toReturn;
    }*/

    @GetMapping("/users")
    public List<UserProfile> getAllUsers() {
        return service.getAllUsers();
    }

    @GetMapping("/user/{id}")
    public UserProfile getOneUser(
        @PathVariable ("userId") int userId
    ) {
        if (userId != 0) {
            return service.getOneUser(userId);
        }
        return null;
    }

    /*@GetMapping("/user/{id}")
    public ReturnModel<UserProfile> getUserById(
            @PathVariable Long id
    ) {
        ReturnModel<UserProfile> toReturn = new ReturnModel<>();
        if(id != 0) {
            toReturn.setSuccess(true);
        } else {
            toReturn.setSuccess(false);
        }
        return toReturn;
    }*/

    @GetMapping("/user")
    public UserProfile getLoggedInUser() {

        return service.getLoggedInUser();
    }


    @GetMapping("/register")
    public String registerUser() {
        boolean registered = service.registerUsers();
        if (registered) {
            return "ok";
        }
        return "not ok";
    }



    @PostMapping("/register")
    public ReturnModel<String> registerName(
            @RequestBody UserProfile user
    ) {
        ReturnModel<String> toReturn = new ReturnModel<>();
        toReturn.setObject("user is registered");
        return toReturn;
    }
}
