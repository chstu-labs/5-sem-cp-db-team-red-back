package com.stucoursered.javacourseprojectback.controller;

import com.stucoursered.javacourseprojectback.model.Screenwriter;
import com.stucoursered.javacourseprojectback.service.ScreenwriterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/screenwriters")
public class ScreenwriterController {
    private final ScreenwriterService screenwriterService;

    @Autowired
    public ScreenwriterController(ScreenwriterService screenwriterService) {
        this.screenwriterService = screenwriterService;
    }

    @GetMapping
    public List<Screenwriter> getAllScreenwriters() {
        return screenwriterService.getAllScreenwriters();
    }

    @GetMapping("/byFilm/{filmId}")
    public List<Screenwriter> getScreenwriterFilmId(@PathVariable Long filmId) {
        return screenwriterService.getScreenwritersByFilmId(filmId);
    }

    @GetMapping("/{id}")
    public Screenwriter getScreenwriterById(@PathVariable Long id) {
        return screenwriterService.getScreenwriterById(id);
    }

    @PostMapping
    public Screenwriter createScreenwriter(@RequestBody Screenwriter screenwriter) {
        return screenwriterService.createScreenwriter(screenwriter);
    }

    @PutMapping("/{id}")
    public Screenwriter updateScreenwriter(@PathVariable Long id, @RequestBody Screenwriter updatedScreenwriter) {
        return screenwriterService.updateScreenwriter(id, updatedScreenwriter);
    }

    @DeleteMapping("/{id}")
    public void deleteScreenwriter(@PathVariable Long id) {
        screenwriterService.deleteScreenwriter(id);
    }
}
