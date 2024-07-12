package net.javaguides.springboot.service;

import net.javaguides.springboot.model.Reward;
import net.javaguides.springboot.model.Signup;
import net.javaguides.springboot.repository.RewardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RewardService {

    @Autowired
    private RewardRepository rewardRepository;

    public Reward addRewardPoints(int points, Signup signup) {
        Reward reward = new Reward();
        reward.setPoints(points);
        reward.setSignup(signup);
        return rewardRepository.save(reward);
    }

    public int getTotalRewardPoints(Long signupId) {
        List<Reward> rewards = rewardRepository.findBySignupId(signupId);
        return rewards.stream().mapToInt(Reward::getPoints).sum();
    }

    public List<Reward> getAllRewards(Long signupId) {
        return rewardRepository.findBySignupId(signupId);
    }
}
