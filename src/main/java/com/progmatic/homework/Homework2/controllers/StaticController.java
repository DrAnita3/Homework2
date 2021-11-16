package com.progmatic.homework.Homework2.controllers;

import com.progmatic.homework.Homework2.models.BlogContent;
import com.progmatic.homework.Homework2.models.UserProfile;
import com.progmatic.homework.Homework2.returnModels.ReturnModel;
import com.progmatic.homework.Homework2.services.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StaticController {

    @Autowired
    private DataService dataService;

    @GetMapping("/data")
    public List<String> getData() {
        return dataService.getDataList();
    }

    /*@GetMapping("/users")
    public ReturnModel<UserProfile> getAllUsers() {
        ReturnModel<UserProfile> toReturn = new ReturnModel<>(
                true, HttpStatus.OK, new UserProfile()
        );
        return toReturn;
    }*/

    @GetMapping("/users")
    public ReturnModel<UserProfile> getAllUsers() {
        ReturnModel<UserProfile> toReturn = new ReturnModel<>();
        toReturn.setSuccess(true);
        return toReturn;
    }

    @GetMapping("/user/{id}")
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
    }

    @PostMapping("/register")
    public ReturnModel<String> registerName(
            @RequestBody UserProfile user
    ) {
        ReturnModel<String> toReturn = new ReturnModel<>();
        toReturn.setObject("user is registered");
        return toReturn;
    }


    @GetMapping("/blogs")
    public ReturnModel<BlogContent> getAllBlogs() {
        ReturnModel<BlogContent> toReturn = new ReturnModel<>();
        toReturn.setSuccess(true);
        return toReturn;
    }

    @PostMapping("/blogs")
    public ReturnModel<String> registerBlog(
            @RequestBody BlogContent blog
    ) {
        ReturnModel<String> toReturn = new ReturnModel<>();
        toReturn.setObject("blog is registered");
        return toReturn;
    }


}
