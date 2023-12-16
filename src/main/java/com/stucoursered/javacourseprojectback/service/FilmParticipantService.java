package com.stucoursered.javacourseprojectback.service;

import com.stucoursered.javacourseprojectback.model.FilmParticipant;
import com.stucoursered.javacourseprojectback.repository.FilmParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmParticipantService {
    private final FilmParticipantRepository filmParticipantRepository;

    @Autowired
    public FilmParticipantService(FilmParticipantRepository filmParticipantRepository) {
        this.filmParticipantRepository = filmParticipantRepository;
    }

    public List<FilmParticipant> getAllFilmParticipants() {
        return filmParticipantRepository.findAll();
    }

    public FilmParticipant getFilmParticipantById(Long id) {
        Optional<FilmParticipant> optionalFilmParticipant = filmParticipantRepository.findById(id);
        return optionalFilmParticipant.orElse(null);
    }

    public FilmParticipant createFilmParticipant(FilmParticipant filmParticipant) {
        return filmParticipantRepository.save(filmParticipant);
    }

    public FilmParticipant updateFilmParticipant(Long id, FilmParticipant updatedFilmParticipant) {
        Optional<FilmParticipant> optionalExistingFilmParticipant = filmParticipantRepository.findById(id);

        if (optionalExistingFilmParticipant.isPresent()) {
            FilmParticipant existingFilmParticipant = optionalExistingFilmParticipant.get();
            // Обновление данных
            existingFilmParticipant.setFilm(updatedFilmParticipant.getFilm());
            existingFilmParticipant.setActor(updatedFilmParticipant.getActor());

            return filmParticipantRepository.save(existingFilmParticipant);
        } else {
            return null; // Участник фильма с указанным идентификатором не найден
        }
    }

    public void deleteFilmParticipant(Long id) {
        filmParticipantRepository.deleteById(id);
    }
}
