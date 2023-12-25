package com.stucoursered.javacourseprojectback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.stucoursered.javacourseprojectback.model.Film;
import com.stucoursered.javacourseprojectback.dto.FilmDto;


import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {

    @Query("SELECT new com.stucoursered.javacourseprojectback.dto.FilmDto(f.id, f.title) FROM Film f WHERE f.studio.id = :studioId")
    List<FilmDto> findFilmIdAndTitleByStudioId(@Param("studioId") Long studioId);

    @Query("SELECT new com.stucoursered.javacourseprojectback.dto.FilmDto(f.id, f.title) FROM com.stucoursered.javacourseprojectback.model.Film f JOIN f.filmParticipants fp WHERE fp.actor.id = :actorId")
    List<FilmDto> getFilmsByActorId(@Param("actorId") Long actorId);

    @Query("SELECT new com.stucoursered.javacourseprojectback.dto.FilmDto(f.id, f.title) FROM Film f JOIN f.filmScreenwriters fs WHERE fs.screenwriter.id = :screenwriterId")
    List<FilmDto> findFilmsByScreenwriterId(@Param("screenwriterId") Long screenwriterId);
}
