package com.stucoursered.javacourseprojectback.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "film_participants")
public class FilmParticipant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "film_id")
    private Film film;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "actor_id")
    private Actor actor;

    // Геттеры
    public Long getId() {
        return id;
    }

    public Film getFilm() {
        return film;
    }

    public Actor getActor() {
        return actor;
    }

    // Сеттеры
    public void setId(Long id) {
        this.id = id;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }
}

