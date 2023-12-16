package com.stucoursered.javacourseprojectback.service;

import com.stucoursered.javacourseprojectback.model.FilmScreenwriter;
import com.stucoursered.javacourseprojectback.repository.FilmScreenwriterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmScreenwriterService {
    private final FilmScreenwriterRepository filmScreenwriterRepository;

    @Autowired
    public FilmScreenwriterService(FilmScreenwriterRepository filmScreenwriterRepository) {
        this.filmScreenwriterRepository = filmScreenwriterRepository;
    }

    public List<FilmScreenwriter> getAllFilmScreenwriters() {
        return filmScreenwriterRepository.findAll();
    }

    public FilmScreenwriter getFilmScreenwriterById(Long id) {
        Optional<FilmScreenwriter> optionalFilmScreenwriter = filmScreenwriterRepository.findById(id);
        return optionalFilmScreenwriter.orElse(null);
    }

    public FilmScreenwriter createFilmScreenwriter(FilmScreenwriter filmScreenwriter) {
        return filmScreenwriterRepository.save(filmScreenwriter);
    }

    public FilmScreenwriter updateFilmScreenwriter(Long id, FilmScreenwriter updatedFilmScreenwriter) {
        Optional<FilmScreenwriter> optionalExistingFilmScreenwriter = filmScreenwriterRepository.findById(id);

        if (optionalExistingFilmScreenwriter.isPresent()) {
            FilmScreenwriter existingFilmScreenwriter = optionalExistingFilmScreenwriter.get();
            // Обновление данных
            existingFilmScreenwriter.setFilm(updatedFilmScreenwriter.getFilm());
            existingFilmScreenwriter.setScreenwriter(updatedFilmScreenwriter.getScreenwriter());

            return filmScreenwriterRepository.save(existingFilmScreenwriter);
        } else {
            return null; // Автор сценария с указанным идентификатором не найден
        }
    }

    public void deleteFilmScreenwriter(Long id) {
        filmScreenwriterRepository.deleteById(id);
    }
}
