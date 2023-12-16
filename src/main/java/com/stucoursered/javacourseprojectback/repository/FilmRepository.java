package com.stucoursered.javacourseprojectback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.stucoursered.javacourseprojectback.model.Film;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {
    // Здесь могут быть определены дополнительные методы запросов, если необходимо
}
