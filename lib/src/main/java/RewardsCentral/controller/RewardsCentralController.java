package RewardsCentral.controller;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import RewardsCentral.service.RewardsCentralService;

@RestController
public class RewardsCentralController {
	private Logger logger = LoggerFactory.getLogger("RewardsCentralController");
	
	@Autowired
	private RewardsCentralService rewardsCentralService;
	
	@RequestMapping("/getRewardPoints")
	public int getRewardPointsRewardsCentral(@RequestParam UUID attractionId,@RequestParam UUID userId) {
		logger.info("Get RewardPointsServer for attractionId : " + attractionId +" and userId : " + userId );
		return rewardsCentralService.getRewardPointsRewardsCentral(attractionId, userId);
		
	}
}
