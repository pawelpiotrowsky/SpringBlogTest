package com.example.SpringBlogTest.controller;

import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class LoginController {

    DefaultRedirectStrategy defaultRedirectStrategy;
    @GetMapping("/login")
    public String getRegisterView() {
        return "login";
    }

    @PostMapping("/login")
    public String loggedInView() {
        return "main";
    }

}
