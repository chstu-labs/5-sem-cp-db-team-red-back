package com.stucoursered.javacourseprojectback.dto;

public class FilmDto {
    private Long id;
    private String title;

    public FilmDto(Long id, String title) {
        this.id = id;
        this.title = title;
    }
       // Конструктор без параметров
       public FilmDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
