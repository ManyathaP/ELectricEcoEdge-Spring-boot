package net.javaguides.springboot.service;


import net.javaguides.springboot.dto.WatchDetailsDTO;
import net.javaguides.springboot.model.Signup;
import net.javaguides.springboot.model.Watch;
import net.javaguides.springboot.repository.WatchRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WatchService {

    @Autowired
    private WatchRepository watchRepository;

    public Watch saveWatch(String brand, int yearsUsed, String description, String imageUrl, Signup signup) {
        Watch watch = new Watch(brand, yearsUsed, description, imageUrl, signup);
        return watchRepository.save(watch);
    }
    
    public List<WatchDetailsDTO> getAllWatchDetails() {
        return watchRepository.findAllWatchDetails();
    }
}

