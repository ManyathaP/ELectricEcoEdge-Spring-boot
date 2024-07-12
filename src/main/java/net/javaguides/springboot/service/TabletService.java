package net.javaguides.springboot.service;

import net.javaguides.springboot.dto.TabletDetailsDTO;
import net.javaguides.springboot.model.Signup;
import net.javaguides.springboot.model.Tablet;
import net.javaguides.springboot.repository.TabletRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TabletService {

    @Autowired
    private TabletRepository tabletRepository;

    public Tablet saveTablet(String brand, int yearsUsed, String description, String imageUrl, Signup signup) {
        Tablet tablet = new Tablet(brand, yearsUsed, description, imageUrl, signup);
        return tabletRepository.save(tablet);
    }
    
    public List<TabletDetailsDTO> getAllTabletDetails() {
        return tabletRepository.findAllTabletDetails();
    }
}
