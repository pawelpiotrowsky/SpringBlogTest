package com.example.SpringBlogTest.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
@RequestMapping
@Controller
public class HomePageController {

    @GetMapping ("/main")
    public String getMainView() { return "main";}
    @GetMapping
    public String getLoginView() {
        return "register";
    }
    @GetMapping ("/login")
    public String getRegisterView() {return "login";}
    @GetMapping ("/passwordrecovery")
    public String getPasswordRecovery() {return null;}



}
