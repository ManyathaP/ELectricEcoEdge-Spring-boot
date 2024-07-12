package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import net.javaguides.springboot.model.Reward;
import java.util.List;

@Repository
public interface RewardRepository extends JpaRepository<Reward, Long> {

//    @Query("SELECT SUM(r.points) FROM Reward r WHERE r.signup.id = :signupId")
//    Integer findTotalPointsBySignupId(Long signupId);
//    
//    @Query("SELECT r FROM Reward r WHERE r.signup.id = :signupId")
//    List<Reward> findBySignupId(Long signupId);
	 List<Reward> findBySignupId(Long signupId);
}

