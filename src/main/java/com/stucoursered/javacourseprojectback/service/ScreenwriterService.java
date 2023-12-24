package com.stucoursered.javacourseprojectback.service;

import com.stucoursered.javacourseprojectback.model.Actor;
import com.stucoursered.javacourseprojectback.model.Screenwriter;
import com.stucoursered.javacourseprojectback.repository.ScreenwriterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScreenwriterService {
    private final ScreenwriterRepository screenwriterRepository;

    @Autowired
    public ScreenwriterService(ScreenwriterRepository screenwriterRepository) {
        this.screenwriterRepository = screenwriterRepository;
    }

    public List<Screenwriter> getAllScreenwriters() {
        return screenwriterRepository.findAll();
    }

    public Screenwriter getScreenwriterById(Long id) {
        Optional<Screenwriter> optionalScreenwriter = screenwriterRepository.findById(id);
        return optionalScreenwriter.orElse(null);
    }

    public Screenwriter createScreenwriter(Screenwriter screenwriter) {
        return screenwriterRepository.save(screenwriter);
    }

    public Screenwriter updateScreenwriter(Long id, Screenwriter updatedScreenwriter) {
        Optional<Screenwriter> optionalExistingScreenwriter = screenwriterRepository.findById(id);

        if (optionalExistingScreenwriter.isPresent()) {
            Screenwriter existingScreenwriter = optionalExistingScreenwriter.get();
            // Обновление данных
            existingScreenwriter.setName(updatedScreenwriter.getName());
            existingScreenwriter.setBirthDate(updatedScreenwriter.getBirthDate());
            existingScreenwriter.setNationality(updatedScreenwriter.getNationality());

            return screenwriterRepository.save(existingScreenwriter);
        } else {
            return null; // Сценарист с указанным идентификатором не найден
        }
    }

    public void deleteScreenwriter(Long id) {
        screenwriterRepository.deleteById(id);
    }

    public List<Screenwriter> getScreenwritersByFilmId(Long filmId) {
        return screenwriterRepository.findScreenwritersByFilmId(filmId);
    }
}
