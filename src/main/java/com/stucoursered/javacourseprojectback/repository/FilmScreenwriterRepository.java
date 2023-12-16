package com.stucoursered.javacourseprojectback.repository;

import com.stucoursered.javacourseprojectback.model.FilmScreenwriter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmScreenwriterRepository extends JpaRepository<FilmScreenwriter, Long> {
    // Здесь могут быть определены дополнительные методы запросов, если необходимо
}
