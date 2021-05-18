package com.example.SpringBlogTest.bootstrap;

import com.example.SpringBlogTest.service.UserService;
import com.example.SpringBlogTest.user.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

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
        bCryptPasswordEncoder = new BCryptPasswordEncoder();
        User user = new User();
        user.setEmail("kurko@gmail.com");
        user.setPassword("{bcrypt}" + bCryptPasswordEncoder.encode( "12345"));
        user.setConfirmPassword("{bcrypt}" + bCryptPasswordEncoder.encode("12345"));
        userService.addUser(user);
    }
}
