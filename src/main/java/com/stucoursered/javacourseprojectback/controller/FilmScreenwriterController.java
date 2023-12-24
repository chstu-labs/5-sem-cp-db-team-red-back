package com.stucoursered.javacourseprojectback.controller;

import com.stucoursered.javacourseprojectback.model.FilmScreenwriter;
import com.stucoursered.javacourseprojectback.service.FilmScreenwriterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/film-screenwriters")
public class FilmScreenwriterController {
    private final FilmScreenwriterService filmScreenwriterService;

    @Autowired
    public FilmScreenwriterController(FilmScreenwriterService filmScreenwriterService) {
        this.filmScreenwriterService = filmScreenwriterService;
    }

    @GetMapping
    public List<FilmScreenwriter> getAllFilmScreenwriters() {
        return filmScreenwriterService.getAllFilmScreenwriters();
    }

    @GetMapping("/{id}")
    public FilmScreenwriter getFilmScreenwriterById(@PathVariable Long id) {
        return filmScreenwriterService.getFilmScreenwriterById(id);
    }

    @PostMapping
    public FilmScreenwriter createFilmScreenwriter(@RequestBody FilmScreenwriter filmScreenwriter) {
        return filmScreenwriterService.createFilmScreenwriter(filmScreenwriter);
    }

    @PutMapping("/{id}")
    public FilmScreenwriter updateFilmScreenwriter(@PathVariable Long id,
            @RequestBody FilmScreenwriter updatedFilmScreenwriter) {
        return filmScreenwriterService.updateFilmScreenwriter(id, updatedFilmScreenwriter);
    }

    @DeleteMapping("/{id}")
    public void deleteFilmScreenwriter(@PathVariable Long id) {
        filmScreenwriterService.deleteFilmScreenwriter(id);
    }
}
