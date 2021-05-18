package com.example.SpringBlogTest.service;

import com.example.SpringBlogTest.repository.UserRepository;
import com.example.SpringBlogTest.user.User;
import com.example.SpringBlogTest.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addUser(User user){
        User newUser = new User();
        newUser.setUserCode(UUID.randomUUID().toString());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        return userRepository.save(newUser);
    }

    public Optional<User> findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

/*    private String name;
    private String email;
    private Long number;
    private String password;
    private String imageUrl;
    private String userCode;*/



    public User updateUser(User user){
        return userRepository.save(user);
    }

    public User findUserById(Long id){
        return userRepository.findUserById(id)
                .orElseThrow(()-> new UserNotFoundException("User by id " + id + "was not found"));
    }
    public void deleteUser(Long id){
        userRepository.deleteUserById(id);
    }

}
