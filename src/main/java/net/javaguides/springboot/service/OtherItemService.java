package net.javaguides.springboot.service;

import net.javaguides.springboot.dto.OtherItemDetailsDTO;
import net.javaguides.springboot.model.OtherItem;
import net.javaguides.springboot.model.Signup;
import net.javaguides.springboot.repository.OtherItemRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OtherItemService {

    @Autowired
    private OtherItemRepository otherItemRepository;

    public OtherItem saveOtherItem(String brand, int yearsUsed, String description, String imageUrl, Signup signup) {
        OtherItem otherItem = new OtherItem(brand, yearsUsed, description, imageUrl, signup);
        return otherItemRepository.save(otherItem);
    }
    
    public List<OtherItemDetailsDTO> getAllOtherItemDetails() {
        return otherItemRepository.findAllOtherItemDetails();
    }

}