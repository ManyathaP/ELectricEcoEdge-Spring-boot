package net.javaguides.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import net.javaguides.springboot.dto.MobileDetailsDTO;
import net.javaguides.springboot.model.Mobile;

@Repository
public interface MobileRepository extends JpaRepository<Mobile, Long> {
    // Add custom query methods if needed
	@Query("SELECT new net.javaguides.springboot.dto.MobileDetailsDTO(" +
            "m.brand, m.yearsUsed, m.description, m.imageUrl, s.name, s.email, s.phone_no, s.location) " +
            "FROM Mobile m JOIN m.signup s")
     List<MobileDetailsDTO> findAllMobileDetails();
}

