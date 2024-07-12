package net.javaguides.springboot.service;

import net.javaguides.springboot.dto.LaptopDetailsDTO;
import net.javaguides.springboot.model.Laptop;
import net.javaguides.springboot.model.Signup;
import net.javaguides.springboot.repository.LaptopRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LaptopService {

    @Autowired
    private LaptopRepository laptopRepository;

    public Laptop saveLaptop(String brand, int yearsUsed, String description, String imageUrl, Signup signup) {
        Laptop laptop = new Laptop(brand, yearsUsed, description, imageUrl, signup);
        return laptopRepository.save(laptop);
    }
    
    public List<LaptopDetailsDTO> getAllLaptopDetails() {
        return laptopRepository.findAllLaptopDetails();
    }
}
