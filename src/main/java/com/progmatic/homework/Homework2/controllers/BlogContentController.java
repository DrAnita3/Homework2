package com.progmatic.homework.Homework2.controllers;

import com.progmatic.homework.Homework2.models.BlogContent;
import com.progmatic.homework.Homework2.returnModels.ReturnModel;
import com.progmatic.homework.Homework2.services.BlogContentService;

import com.progmatic.homework.Homework2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BlogContentController {

    private BlogContentService service;

    private UserService userService;


    @Autowired
    public BlogContentController(BlogContentService service, UserService userService) {
        this.service = service;
        this.userService = userService;
    }



    @GetMapping("/blogs")
    public List<BlogContent> getAllBlogs() {
        return service.getAllBlogs();
    }


  /* @GetMapping("/blogs")
    public ReturnModel<BlogContent> getAllBlogs2() {
       ReturnModel<BlogContent> toReturn = new ReturnModel<>();
       if (userService.getLoggedInUser() != null) {
           toReturn.setSuccess(true);
           return toReturn;
       }
       return null;
    }   */

    @PostMapping("/blogs")
    public ReturnModel<String> registerBlog(
            @RequestBody BlogContent blog
    ) {
        ReturnModel<String> toReturn = new ReturnModel<>();
        if (userService.getLoggedInUser() != null) {
            toReturn.setObject("blog is registered");
            return toReturn;
        }
        return null;
    }
}
