package com.example.Hermesbackend.controllers;

import com.example.Hermesbackend.models.Guide;
import com.example.Hermesbackend.repositories.IGuideRepository;
import com.example.Hermesbackend.services.GuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/guides")
@CrossOrigin("*")
public class GuideController {
    @Autowired
    GuideService guideService;

    @GetMapping
    public List<Guide> getAllGuides(){
        return guideService.getAllGuides();
    }

    @GetMapping("/{id}")
    public Optional<Guide> getGuideById(@PathVariable("id") Long id){
        return guideService.getGuideById(id);
    }

    @PostMapping
    public void createGuide(@RequestBody Guide guide){
        guideService.createGuide(guide);
    }

    @PutMapping("/{id}")
    public void editGuide(@RequestBody Guide guide, @PathVariable("id") Long id){
        guideService.updateGuide(guide, id);
    }

    @DeleteMapping("/{id}")
    public void deleteGuide(@PathVariable("id") Long id){
        guideService.deleteGuide(id);
    }

    @GetMapping("/search")
    public List<Guide> getGuidesByDestination(@RequestParam String keyword) throws Exception {
        return  guideService.search(keyword);
    }
}
