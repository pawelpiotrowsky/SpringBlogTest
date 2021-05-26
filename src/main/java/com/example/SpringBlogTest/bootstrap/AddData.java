package com.example.SpringBlogTest.bootstrap;

import com.example.SpringBlogTest.service.UserService;
import com.example.SpringBlogTest.user.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AddData implements CommandLineRunner {

    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserService userService;

    public AddData(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) {
        createNewUser();
    }

    private void createNewUser() {
        User user = new User();
        user.setEmail("kurko@gmail.com");
        user.setName("kurko");
        user.setPassword("12345");
        user.setConfirmPassword("12345");
        userService.addUser(user);
    }
}
