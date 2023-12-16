package com.stucoursered.javacourseprojectback.model;

import javax.persistence.*;

@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "film_id")
    private Film film;

    private String userName;
    private Double rating;
    private String comment;

    // Геттеры
    public Long getId() {
        return id;
    }

    public Film getFilm() {
        return film;
    }

    public String getUserName() {
        return userName;
    }

    public Double getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }

    // Сеттеры
    public void setId(Long id) {
        this.id = id;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
