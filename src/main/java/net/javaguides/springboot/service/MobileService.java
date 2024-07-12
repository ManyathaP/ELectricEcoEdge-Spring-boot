package net.javaguides.springboot.service;


import net.javaguides.springboot.dto.MobileDetailsDTO;
import net.javaguides.springboot.model.Mobile;
import net.javaguides.springboot.model.Signup;
import net.javaguides.springboot.repository.MobileRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MobileService {

    @Autowired
    private MobileRepository mobileRepository;

    public Mobile saveMobile(String brand, int yearsUsed, String description, String imageUrl, Signup signup) {
        Mobile mobile = new Mobile(brand, yearsUsed, description, imageUrl, signup);
        return mobileRepository.save(mobile);
    }
    
    public List<MobileDetailsDTO> getAllMobileDetails() {
        return mobileRepository.findAllMobileDetails();
    }
}
