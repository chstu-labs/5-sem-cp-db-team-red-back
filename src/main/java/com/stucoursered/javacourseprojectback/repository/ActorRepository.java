package com.stucoursered.javacourseprojectback.repository;

import com.stucoursered.javacourseprojectback.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {
    // Здесь могут быть определены дополнительные методы запросов, если необходимо
}
