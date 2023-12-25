package com.stucoursered.javacourseprojectback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.stucoursered.javacourseprojectback.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
