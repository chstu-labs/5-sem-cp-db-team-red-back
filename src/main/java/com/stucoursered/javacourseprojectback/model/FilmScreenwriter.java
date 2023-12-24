package com.stucoursered.javacourseprojectback.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "film_screenwriters")
public class FilmScreenwriter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "film_id")
    private Film film;

    @ManyToOne
    @JoinColumn(name = "screenwriter_id")
    private Screenwriter screenwriter;

    // Геттеры
    public Long getId() {
        return id;
    }

    public Film getFilm() {
        return film;
    }

    public Screenwriter getScreenwriter() {
        return screenwriter;
    }

    // Сеттеры
    public void setId(Long id) {
        this.id = id;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public void setScreenwriter(Screenwriter screenwriter) {
        this.screenwriter = screenwriter;
    }
}

