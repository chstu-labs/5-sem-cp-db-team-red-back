package com.stucoursered.javacourseprojectback.repository;

import com.stucoursered.javacourseprojectback.model.Screenwriter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScreenwriterRepository extends JpaRepository<Screenwriter, Long> {
    // Здесь могут быть определены дополнительные методы запросов, если необходимо
}
