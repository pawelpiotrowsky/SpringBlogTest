package com.example.SpringBlogTest.repository;

import com.example.SpringBlogTest.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {


    void deleteUserById(Long id);
    Optional<User> findUserById(Long id);
    Optional<User> findUserByEmail(String email);
}
