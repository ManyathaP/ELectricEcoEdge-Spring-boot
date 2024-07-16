package net.javaguides.springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import net.javaguides.springboot.model.Signup;
import net.javaguides.springboot.repository.CustomerRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {
	
	@Autowired
	private CustomerRepository customerRepository ;
	
		@GetMapping
		public List<Signup> getAllCustomer(){
			return customerRepository.findAll();
		}
	
	//build create customer REST API
		
		@PostMapping
		public Signup createCustomer(@RequestBody Signup signup) {
			return customerRepository.save(signup);
		}	
		
			@PostMapping("/login")
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
			

			
			
			
			
	}
	
	


