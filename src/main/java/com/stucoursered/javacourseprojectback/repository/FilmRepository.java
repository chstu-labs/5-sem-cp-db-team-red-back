package com.stucoursered.javacourseprojectback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.stucoursered.javacourseprojectback.model.Film;

import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {
    
 @Query(nativeQuery = true, value = "CALL GetFilmsByStudioId(:studioId)")
    List<Object[]> findFilmIdAndTitleByStudioId(@Param("studioId") Long studioId);

 @Query(nativeQuery = true, value = "CALL GetFilmsByActorId(:actorId)")
    List<Object[]> getFilmsByActorId(@Param("actorId") Long actorId);
}
