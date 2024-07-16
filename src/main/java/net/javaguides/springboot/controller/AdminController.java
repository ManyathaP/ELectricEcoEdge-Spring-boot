package net.javaguides.springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import net.javaguides.springboot.model.Admin;
import net.javaguides.springboot.model.Signup;
import net.javaguides.springboot.repository.AdminRepository;
import net.javaguides.springboot.repository.CustomerRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/admins") // Ensure this path is correct
public class AdminController {

    @Autowired
    private AdminRepository adminRepository;

    @GetMapping
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }
    
    @PostMapping
    public Admin createAdmin(@RequestBody Admin admin) {
        return adminRepository.save(admin);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginAdmin(@RequestBody Admin loginDetails) {
        Optional<Admin> admin = adminRepository.findByEmailAndPassword(
            loginDetails.getEmail(), loginDetails.getPassword()
        );

        if (admin.isPresent()) {
            return ResponseEntity.ok(admin.get());
        } else {
            return ResponseEntity.status(401).body("Invalid email or password");
        }
    }
    
   
}
