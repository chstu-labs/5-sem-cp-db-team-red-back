package com.stucoursered.javacourseprojectback.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/some-resource")
public class SomeResourceController {

    @Secured("ROLE_USER")
    @GetMapping("/user-endpoint")
    public ResponseEntity<String> userEndpoint() {
        // Логика для обработки запросов от обычных пользователей
        return ResponseEntity.ok("Hello, User!");
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/admin-endpoint")
    public ResponseEntity<String> adminEndpoint() {
        // Логика для обработки запросов от администраторов
        return ResponseEntity.ok("Hello, Admin!");
    }
}
