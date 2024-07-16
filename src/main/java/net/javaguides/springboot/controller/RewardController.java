package net.javaguides.springboot.controller;

import net.javaguides.springboot.model.Reward;
import net.javaguides.springboot.model.Signup;
import net.javaguides.springboot.service.RewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/rewards")
public class RewardController {

    @Autowired
    private RewardService rewardService;

    @PostMapping
    public Reward addRewardPoints(@RequestParam("points") int points, @RequestParam("signupId") Long signupId) {
        Signup signup = new Signup();
        signup.setId(signupId);
        return rewardService.addRewardPoints(points, signup);
    }

    @GetMapping("/{signupId}/total")
    public int getTotalRewardPoints(@PathVariable("signupId") Long signupId) {
        return rewardService.getTotalRewardPoints(signupId);
    }

    @GetMapping("/{signupId}")
    public List<Reward> getAllRewards(@PathVariable("signupId") Long signupId) {
        return rewardService.getAllRewards(signupId);
    }
}
