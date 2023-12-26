package com.stucoursered.javacourseprojectback.controller;

import com.stucoursered.javacourseprojectback.model.Actor;
import com.stucoursered.javacourseprojectback.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/actors")
public class ActorController {
    private final ActorService actorService;

    @Autowired
    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping
    public List<Actor> getAllActors() {
        return actorService.getAllActors();
    }

    @GetMapping("/byFilm/{filmId}")
    public List<Actor> getActorsByFilmId(@PathVariable Long filmId) {
        return actorService.getActorsByFilmId(filmId);
    }

    @GetMapping("/{id}")
    public Actor getActorById(@PathVariable Long id) {
        return actorService.getActorById(id);
    }

    @PostMapping
    public Actor createActor(@RequestBody Actor actor) {
        return actorService.createActor(actor);
    }

    @PutMapping("/{id}")
    public Actor updateActor(@PathVariable Long id, @RequestBody Actor updatedActor) {
        return actorService.updateActor(id, updatedActor);
    }

    @DeleteMapping("/{id}")
    public void deleteActor(@PathVariable Long id) {
        actorService.deleteActor(id);
    }

    @GetMapping("/top")
    public ResponseEntity<List<Actor>> getOldestActors() {
        List<Actor> oldestActors = actorService.getOldestActors();
        return new ResponseEntity<>(oldestActors, HttpStatus.OK);
    }
}
