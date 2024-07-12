package net.javaguides.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import net.javaguides.springboot.dto.OtherItemDetailsDTO;
import net.javaguides.springboot.model.OtherItem;

@Repository
public interface OtherItemRepository extends JpaRepository<OtherItem, Long> {
    // Add custom query methods if needed
	@Query("SELECT new net.javaguides.springboot.dto.OtherItemDetailsDTO(" +
            "o.brand, o.yearsUsed, o.description, o.imageUrl, s.name, s.email, s.phone_no, s.location) " +
            "FROM OtherItem o JOIN o.signup s")
     List<OtherItemDetailsDTO> findAllOtherItemDetails();
}

