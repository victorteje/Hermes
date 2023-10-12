package com.example.Hermesbackend.services;

import com.example.Hermesbackend.models.Guide;
import com.example.Hermesbackend.repositories.IGuideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GuideService {

    @Autowired
    IGuideRepository guideRepository;

    public List<Guide> getAllGuides(){
        return guideRepository.findAll();
    }

    public Optional<Guide> getGuideById(Long id){
        return guideRepository.findById(id);
    }

    public void createGuide(Guide guide){
        guideRepository.save(guide);
    }

    public void updateGuide(Guide guide, Long id){
        guide.setId(id);
        guideRepository.save(guide);
    }

    public void deleteGuide(Long id){
        guideRepository.deleteById(id);
    }

    public List<Guide> search(String keyword) throws Exception {
        List<Guide> guides = guideRepository.findAll();
        return  guides.stream().filter(guide -> keyword.equals(guide.getDestination())).collect(Collectors.toList());
    }

}
