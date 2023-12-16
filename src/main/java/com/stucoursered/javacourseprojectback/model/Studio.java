package com.stucoursered.javacourseprojectback.model;

import javax.persistence.*;

@Entity
@Table(name = "studio")
public class Studio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // Геттеры
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // Сеттеры
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
