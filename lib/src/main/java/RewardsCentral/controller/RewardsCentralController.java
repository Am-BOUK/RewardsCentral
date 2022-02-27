package RewardsCentral.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import RewardsCentral.exception.UUIDException;
import RewardsCentral.service.RewardsCentralService;

@RestController
public class RewardsCentralController {
	private Logger logger = LoggerFactory.getLogger("RewardsCentralController");

	@Autowired
	private RewardsCentralService rewardsCentralService;

	/**
	 * GET the reward points endpoint
	 * 
	 * @param attractionId : the attractionId String in UUID form of the attraction
	 *                     we want to get its reward points
	 * @param userId       : the userId String in UUID form of the user we want to
	 *                     get his reward points
	 * @return int : reward points
	 * @throws UUIDException
	 */
	@RequestMapping("/getRewardPoints")
	public int getRewardPointsRewardsCentral(@RequestParam String attractionId, @RequestParam String userId)
			throws UUIDException {
		logger.info("Get RewardPointsServer for attractionId : " + attractionId + " and userId : " + userId);
		return rewardsCentralService.getRewardPointsRewardsCentral(attractionId, userId);

	}
}
