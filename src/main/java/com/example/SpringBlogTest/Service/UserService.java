package com.example.SpringBlogTest.Service;

import com.example.SpringBlogTest.Repository.UserRepo;
import com.example.SpringBlogTest.User.User;
import com.example.SpringBlogTest.Exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {
    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }
    public User addUser(User user){
        user.setUserCode(UUID.randomUUID().toString());
        return userRepo.save(user);
    }

//    public List<User> findAllUser() {
//        return userRepo.findAll();
//    }

    public User updateUser(User user){
        return userRepo.save(user);
    }

    public User findUserById(Long id){
        return userRepo.findUserById(id)
                .orElseThrow(()-> new UserNotFoundException("User by id " + id + "was not found"));
    }
    public void deleteUser(Long id){
        userRepo.deleteUserById(id);
    }

}
