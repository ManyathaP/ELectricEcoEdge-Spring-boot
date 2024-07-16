package net.javaguides.springboot.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.model.Signup;
import net.javaguides.springboot.repository.CustomerRepository;
import net.javaguides.springboot.service.EmailService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private EmailService emailService;

    @PostMapping("/signup")
    public ResponseEntity<?> loginCustomer(@RequestBody Signup loginDetails) {
        Optional<Signup> customer = customerRepository.findByEmailAndPassword(
            loginDetails.getEmail(), loginDetails.getPassword()
        );
        
        if (customer.isPresent()) {
            return ResponseEntity.ok(customer.get());
        } else {
            return ResponseEntity.status(401).body("Invalid email or password");
        }
    }
    
    @PostMapping("/forgot-password")
    public ResponseEntity<?> forgotPassword(@RequestBody String email) {
        Optional<Signup> customer = customerRepository.findByEmail(email);
        if (!customer.isPresent()) {
            return ResponseEntity.status(404).body("Email address not found");
        }

        // Generate a password reset token and send the email
        String resetToken = "dummy-reset-token"; // Replace with actual token generation logic
        emailService.sendPasswordResetEmail(customer.get().getEmail(), resetToken);

        return ResponseEntity.ok("Password reset email sent");
    }
}
