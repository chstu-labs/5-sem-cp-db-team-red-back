package com.stucoursered.javacourseprojectback.service;

import com.stucoursered.javacourseprojectback.model.Studio;
import com.stucoursered.javacourseprojectback.repository.StudioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudioService {
    private final StudioRepository studioRepository;

    @Autowired
    public StudioService(StudioRepository studioRepository) {
        this.studioRepository = studioRepository;
    }

    public List<Studio> getAllStudios() {
        return studioRepository.findAll();
    }

    public Studio getStudioById(Long id) {
        Optional<Studio> optionalStudio = studioRepository.findById(id);
        return optionalStudio.orElse(null);
    }

    public Studio createStudio(Studio studio) {
        return studioRepository.save(studio);
    }

    public Studio updateStudio(Long id, Studio updatedStudio) {
        Optional<Studio> optionalExistingStudio = studioRepository.findById(id);

        if (optionalExistingStudio.isPresent()) {
            Studio existingStudio = optionalExistingStudio.get();
            // Обновление данных
            existingStudio.setName(updatedStudio.getName());

            return studioRepository.save(existingStudio);
        } else {
            return null; // Киностудия с указанным идентификатором не найдена
        }
    }

    public void deleteStudio(Long id) {
        studioRepository.deleteById(id);
    }
}
