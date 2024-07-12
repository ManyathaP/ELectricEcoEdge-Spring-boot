package net.javaguides.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.dto.ComputerDetailsDTO;
import net.javaguides.springboot.model.Computer;

@Repository
public interface ComputerRepository extends JpaRepository<Computer, Long> {
	

    @Query("SELECT new net.javaguides.springboot.dto.ComputerDetailsDTO(" +
            "c.brand, c.yearsUsed, c.description, c.imageUrl, s.name, s.email, s.phone_no, s.location,s.id) " +
            "FROM Computer c JOIN c.signup s")
     List<ComputerDetailsDTO> findAllComputerDetails();
}
