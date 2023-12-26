package com.stucoursered.javacourseprojectback.repository;

import com.stucoursered.javacourseprojectback.model.Actor;
import com.stucoursered.javacourseprojectback.model.Film;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {

    @Query("SELECT a FROM Actor a JOIN FilmParticipant fp ON a.id = fp.actor.id JOIN Film f ON fp.film.id = f.id WHERE f.id = :filmId")
    List<Actor> findActorsByFilmId(@Param("filmId") Long filmId);

    List<Actor> findTop10ByOrderByBirthDateAsc();
}
