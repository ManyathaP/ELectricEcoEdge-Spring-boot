package net.javaguides.springboot.repository;



import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import net.javaguides.springboot.model.Signup;

@Repository
public interface CustomerRepository extends JpaRepository<Signup, Long> {
    Optional<Signup> findByEmailAndPassword(String email, String password);
    Optional<Signup> findByEmail(String email);

    
   
}
