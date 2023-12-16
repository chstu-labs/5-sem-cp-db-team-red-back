package com.stucoursered.javacourseprojectback.service;

import com.stucoursered.javacourseprojectback.model.Review;
import com.stucoursered.javacourseprojectback.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public Review getReviewById(Long id) {
        Optional<Review> optionalReview = reviewRepository.findById(id);
        return optionalReview.orElse(null);
    }

    public Review createReview(Review review) {
        return reviewRepository.save(review);
    }

    public Review updateReview(Long id, Review updatedReview) {
        Optional<Review> optionalExistingReview = reviewRepository.findById(id);

        if (optionalExistingReview.isPresent()) {
            Review existingReview = optionalExistingReview.get();
            // Обновление данных
            existingReview.setFilm(updatedReview.getFilm());
            existingReview.setUserName(updatedReview.getUserName());
            existingReview.setRating(updatedReview.getRating());
            existingReview.setComment(updatedReview.getComment());

            return reviewRepository.save(existingReview);
        } else {
            return null; // Обзор с указанным идентификатором не найден
        }
    }

    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }
}
