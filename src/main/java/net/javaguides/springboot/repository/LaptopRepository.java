package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import net.javaguides.springboot.model.Laptop;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import net.javaguides.springboot.dto.LaptopDetailsDTO;


@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Long> {
    // Add custom query methods if needed
	@Query("SELECT new net.javaguides.springboot.dto.LaptopDetailsDTO(" +
            "l.brand, l.yearsUsed, l.description, l.imageUrl, s.name, s.email, s.phone_no, s.location) " +
            "FROM Laptop l JOIN l.signup s")
     List<LaptopDetailsDTO> findAllLaptopDetails();
}
