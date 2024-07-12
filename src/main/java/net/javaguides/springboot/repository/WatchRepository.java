package net.javaguides.springboot.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import net.javaguides.springboot.dto.WatchDetailsDTO;
import net.javaguides.springboot.model.Watch;

@Repository
public interface WatchRepository extends JpaRepository<Watch, Long> {
    // Add custom query methods if needed
	@Query("SELECT new net.javaguides.springboot.dto.WatchDetailsDTO(" +
            "w.brand, w.yearsUsed, w.description, w.imageUrl, s.name, s.email, s.phone_no, s.location) " +
            "FROM Watch w JOIN w.signup s")
     List<WatchDetailsDTO> findAllWatchDetails();
}

