package com.stucoursered.javacourseprojectback.controller;

import com.stucoursered.javacourseprojectback.model.FilmParticipant;
import com.stucoursered.javacourseprojectback.service.FilmParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/film-participants")
public class FilmParticipantController {
    private final FilmParticipantService filmParticipantService;

    @Autowired
    public FilmParticipantController(FilmParticipantService filmParticipantService) {
        this.filmParticipantService = filmParticipantService;
    }

    @GetMapping
    public List<FilmParticipant> getAllFilmParticipants() {
        return filmParticipantService.getAllFilmParticipants();
    }

    @GetMapping("/{id}")
    public FilmParticipant getFilmParticipantById(@PathVariable Long id) {
        return filmParticipantService.getFilmParticipantById(id);
    }

    @PostMapping
    public FilmParticipant createFilmParticipant(@RequestBody FilmParticipant filmParticipant) {
        return filmParticipantService.createFilmParticipant(filmParticipant);
    }

    @PutMapping("/{id}")
    public FilmParticipant updateFilmParticipant(@PathVariable Long id, @RequestBody FilmParticipant updatedFilmParticipant) {
        return filmParticipantService.updateFilmParticipant(id, updatedFilmParticipant);
    }

    @DeleteMapping("/{id}")
    public void deleteFilmParticipant(@PathVariable Long id) {
        filmParticipantService.deleteFilmParticipant(id);
    }
}
