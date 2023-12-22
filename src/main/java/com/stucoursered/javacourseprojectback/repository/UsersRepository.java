package com.stucoursered.javacourseprojectback.repository;

import com.stucoursered.javacourseprojectback.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
    // Можете добавить дополнительные методы запросов, если необходимо
}
