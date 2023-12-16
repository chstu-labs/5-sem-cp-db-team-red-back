package com.stucoursered.javacourseprojectback.service;

import com.stucoursered.javacourseprojectback.model.Actor;
import com.stucoursered.javacourseprojectback.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Optional<Actor> optionalActor = actorRepository.findById(id);
        return optionalActor.orElse(null);
    }

    public Actor createActor(Actor actor) {
        return actorRepository.save(actor);
    }

    public Actor updateActor(Long id, Actor updatedActor) {
        Optional<Actor> optionalExistingActor = actorRepository.findById(id);

        if (optionalExistingActor.isPresent()) {
            Actor existingActor = optionalExistingActor.get();
            // Обновление данных
            existingActor.setName(updatedActor.getName());
            existingActor.setBirthDate(updatedActor.getBirthDate());
            existingActor.setNationality(updatedActor.getNationality());
            
            return actorRepository.save(existingActor);
        } else {
            return null; // Актер с указанным идентификатором не найден
        }
    }

    public void deleteActor(Long id) {
        actorRepository.deleteById(id);
    }
}
