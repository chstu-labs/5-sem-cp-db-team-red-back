package com.stucoursered.javacourseprojectback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.stucoursered.javacourseprojectback.model.Film;

import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {
    
    @Query("SELECT f.id, f.title FROM Film f WHERE f.studio.id = :studioId")
    List<Object[]> findFilmIdAndTitleByStudioId(@Param("studioId") Long studioId);

    @Query("SELECT f.id, f.title FROM Film f JOIN FilmParticipant fp ON f.id = fp.film.id JOIN Actor a ON fp.actor.id = a.id WHERE a.id = :actorId")
    List<Object[]> findFilmIdAndTitleByActorId(@Param("actorId") Long actorId);
}
