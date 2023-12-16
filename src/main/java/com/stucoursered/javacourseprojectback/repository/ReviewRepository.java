package com.stucoursered.javacourseprojectback.repository;

import com.stucoursered.javacourseprojectback.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    // Здесь могут быть определены дополнительные методы запросов, если необходимо
}
