package com.stucoursered.javacourseprojectback.repository;

import com.stucoursered.javacourseprojectback.model.FilmParticipant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmParticipantRepository extends JpaRepository<FilmParticipant, Long> {
    // Здесь могут быть определены дополнительные методы запросов, если необходимо
}
