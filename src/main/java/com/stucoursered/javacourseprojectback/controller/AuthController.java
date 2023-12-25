package com.stucoursered.javacourseprojectback.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stucoursered.javacourseprojectback.model.User;
import com.stucoursered.javacourseprojectback.model.UserReq;
import com.stucoursered.javacourseprojectback.service.AuthService;

@RestController
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public User login(@RequestBody UserReq request) {
        String username = request.getUsername();
        String password = request.getPassword();

        return authService.login(username, password);
    }}

