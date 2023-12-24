package com.stucoursered.javacourseprojectback.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.stucoursered.javacourseprojectback.model.Film;
import com.stucoursered.javacourseprojectback.repository.FilmRepository;
import java.util.List;
import java.util.Optional;

@Service
public class FilmService {

    private final FilmRepository filmRepository;

    @Autowired
    public FilmService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public List<Film> getAllFilms() {
        return filmRepository.findAll();
    }

    public Film getFilmById(Long id) {
        Optional<Film> optionalFilm = filmRepository.findById(id);
        return optionalFilm.orElse(null);
    }

    public Film createFilm(Film film) {
        // Дополнительная логика перед сохранением фильма
        return filmRepository.save(film);
    }

    public Film updateFilm(Long id, Film updatedFilm) {
        Optional<Film> optionalExistingFilm = filmRepository.findById(id);

        if (optionalExistingFilm.isPresent()) {
            Film existingFilm = optionalExistingFilm.get();

            // Обновление полей существующего фильма
            existingFilm.setTitle(updatedFilm.getTitle());
            existingFilm.setYear(updatedFilm.getYear());
            existingFilm.setGenre(updatedFilm.getGenre());
            existingFilm.setDirector(updatedFilm.getDirector());
            existingFilm.setDescription(updatedFilm.getDescription());
            existingFilm.setCountry(updatedFilm.getCountry());

            // Дополнительная логика перед обновлением фильма
            return filmRepository.save(existingFilm);
        } else {
            return null; // Фильм с указанным идентификатором не найден
        }
    }

    public void deleteFilm(Long id) {
        filmRepository.deleteById(id);
    }

    public List<Film> getFilmsByStudioId(Long studioId) {
        return filmRepository.findFilmsByStudioId(studioId);
    }

    public List<Film> getFilmsByActorId(Long actorId) {
        return filmRepository.findFilmsByActorId(actorId);
    }
}
