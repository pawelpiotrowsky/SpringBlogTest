package com.example.SpringBlogTest.controller;

import com.example.SpringBlogTest.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
@Controller
public class HomePageController {

    private final UserService userService;

    public HomePageController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping ("/")
    public String getMainView() { return "main";}


    @GetMapping ("/error")
    public String getErrorView() {
        return "error";
    }



}
