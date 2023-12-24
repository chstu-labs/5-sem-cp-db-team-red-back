package com.stucoursered.javacourseprojectback.repository;

import com.stucoursered.javacourseprojectback.model.Screenwriter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScreenwriterRepository extends JpaRepository<Screenwriter, Long> {
    @Query("SELECT a FROM Screenwriter a JOIN FilmScreenwriter fp ON a.id = fp.screenwriter.id JOIN Film f ON fp.film.id = f.id WHERE f.id = :filmId")
    List<Screenwriter> findScreenwritersByFilmId(@Param("filmId") Long filmId);
}
