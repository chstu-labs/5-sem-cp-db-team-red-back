package com.stucoursered.javacourseprojectback.controller;

import com.stucoursered.javacourseprojectback.model.Studio;
import com.stucoursered.javacourseprojectback.service.StudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/studios")
public class StudioController {
    private final StudioService studioService;

    @Autowired
    public StudioController(StudioService studioService) {
        this.studioService = studioService;
    }

    @GetMapping
    public List<Studio> getAllStudios() {
        return studioService.getAllStudios();
    }

    @GetMapping("/{id}")
    public Studio getStudioById(@PathVariable Long id) {
        return studioService.getStudioById(id);
    }

    @PostMapping
    public Studio createStudio(@RequestBody Studio studio) {
        return studioService.createStudio(studio);
    }

    @PutMapping("/{id}")
    public Studio updateStudio(@PathVariable Long id, @RequestBody Studio updatedStudio) {
        return studioService.updateStudio(id, updatedStudio);
    }

    @DeleteMapping("/{id}")
    public void deleteStudio(@PathVariable Long id) {
        studioService.deleteStudio(id);
    }
}
