package com.stucoursered.javacourseprojectback.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "films")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private Integer year;
    private String genre;
    private String director;
    private String description;
    private String country;

    @ManyToOne
    @JoinColumn(name = "studio_id")
    private Studio studio;

    @OneToMany(mappedBy = "film")
    private List<Review> reviews;

    @OneToMany(mappedBy = "film")
    private List<FilmParticipant> filmParticipants;

    @OneToMany(mappedBy = "film")
    private List<FilmScreenwriter> filmScreenwriters;

    // Геттеры
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getYear() {
        return year;
    }

    public String getGenre() {
        return genre;
    }

    public String getDirector() {
        return director;
    }

    public String getDescription() {
        return description;
    }

    public String getCountry() {
        return country;
    }

    public Studio getStudio() {
        return studio;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public List<FilmParticipant> getFilmParticipants() {
        return filmParticipants;
    }

    public List<FilmScreenwriter> getFilmScreenwriters() {
        return filmScreenwriters;
    }

    // Сеттеры
    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setStudio(Studio studio) {
        this.studio = studio;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public void setFilmParticipants(List<FilmParticipant> filmParticipants) {
        this.filmParticipants = filmParticipants;
    }

    public void setFilmScreenwriters(List<FilmScreenwriter> filmScreenwriters) {
        this.filmScreenwriters = filmScreenwriters;
    }
}

