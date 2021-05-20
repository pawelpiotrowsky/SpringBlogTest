package com.example.SpringBlogTest.controller;

import com.example.SpringBlogTest.service.UserService;
import com.example.SpringBlogTest.user.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class RegisterController {
    private UserService userService;


    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String getLoginView(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String createNewUser(User user) {
        userService.addUser(user);
        return "register";
    }
}
