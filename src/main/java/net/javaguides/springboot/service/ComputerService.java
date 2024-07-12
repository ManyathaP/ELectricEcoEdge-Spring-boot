package net.javaguides.springboot.service;

import net.javaguides.springboot.dto.ComputerDetailsDTO;
import net.javaguides.springboot.model.Computer;
import net.javaguides.springboot.model.Signup;
import net.javaguides.springboot.repository.ComputerRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComputerService {

//    @Autowired
//    private ComputerRepository computerRepository;
//
//    public Computer saveComputer(String brand, int yearsUsed, String description, String imageUrl) {
//        Computer computer = new Computer(brand, yearsUsed, description, imageUrl);
//        return computerRepository.save(computer);
//    }
	
	 @Autowired
	    private ComputerRepository computerRepository;

	    public Computer saveComputer(String brand, int yearsUsed, String description, String imageUrl, Signup signup) {
	        Computer computer = new Computer(brand, yearsUsed, description, imageUrl, signup);
	        return computerRepository.save(computer);
	    }

	  

	    public List<ComputerDetailsDTO> getAllComputerDetails() {
	        return computerRepository.findAllComputerDetails();
	    }
}
