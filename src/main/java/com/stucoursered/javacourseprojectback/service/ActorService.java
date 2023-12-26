package com.stucoursered.javacourseprojectback.service;

import com.stucoursered.javacourseprojectback.model.Actor;
import com.stucoursered.javacourseprojectback.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService {

    private final ActorRepository actorRepository;

    @Autowired
    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    public List<Actor> getAllActors() {
        return actorRepository.findAll();
    }

    public Actor getActorById(Long id) {
        return actorRepository.findById(id).orElse(null);
    }

    public Actor createActor(Actor actor) {
        return actorRepository.save(actor);
    }

    public Actor updateActor(Long id, Actor updatedActor) {
        Actor existingActor = actorRepository.findById(id).orElse(null);

        if (existingActor != null) {
            existingActor.setName(updatedActor.getName());
            existingActor.setBirthDate(updatedActor.getBirthDate());
            existingActor.setNationality(updatedActor.getNationality());

            return actorRepository.save(existingActor);
        } else {
            return null; // Handle not found scenario
        }
    }

    public void deleteActor(Long id) {
        actorRepository.deleteById(id);
    }

    // New method to get actors by film ID
    public List<Actor> getActorsByFilmId(Long filmId) {
        return actorRepository.findActorsByFilmId(filmId);
    }
    public List<Actor> getOldestActors() {
        return actorRepository.findTop10ByOrderByBirthDateAsc();
    }
}
