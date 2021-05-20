package com.example.SpringBlogTest.controller;

import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class LoginController {

    DefaultRedirectStrategy defaultRedirectStrategy;
    @GetMapping("/login")
    public String getRegisterView() {
        return "login";
    }

}
