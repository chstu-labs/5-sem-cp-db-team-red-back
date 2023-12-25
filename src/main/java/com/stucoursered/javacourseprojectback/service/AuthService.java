package com.stucoursered.javacourseprojectback.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stucoursered.javacourseprojectback.model.User;
import com.stucoursered.javacourseprojectback.repository.UserRepository;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    public User login(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            
            return user;
        }
        return null;
    }
}
