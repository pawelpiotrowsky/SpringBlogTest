package com.example.SpringBlogTest.controller;

import com.example.SpringBlogTest.service.UserService;
import com.example.SpringBlogTest.user.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
@Controller
public class HomePageController {

    private final UserService userService;

    public HomePageController(UserService userService) {
        this.userService = userService;
    }

        @GetMapping("/")
        public String getMainView() { return "main";}


        @GetMapping ("/error")
        public String getErrorView() {
        return "error";}

        @GetMapping("/login")
        public String getRegisterView() {
            return "login";}

        @GetMapping("/passwordrecovery")
        public String getPasswordRecovery() {return null;}

        @GetMapping("/register")
         public String getLoginView(Model model) {
        model.addAttribute("user", new User());
        return "register"; }

        @PostMapping("/register")
         public String createNewUser(User user) {
        userService.addUser(user);
        return "main"; }



}
