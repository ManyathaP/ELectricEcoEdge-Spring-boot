package net.javaguides.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import net.javaguides.springboot.dto.TabletDetailsDTO;
import net.javaguides.springboot.model.Tablet;

@Repository
public interface TabletRepository extends JpaRepository<Tablet, Long> {
    // Add custom query methods if needed
	@Query("SELECT new net.javaguides.springboot.dto.TabletDetailsDTO(" +
            "t.brand, t.yearsUsed, t.description, t.imageUrl, s.name, s.email, s.phone_no, s.location) " +
            "FROM Tablet t JOIN t.signup s")
     List<TabletDetailsDTO> findAllTabletDetails();
}

