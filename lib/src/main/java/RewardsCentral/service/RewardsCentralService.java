package RewardsCentral.service;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import rewardCentral.RewardCentral;

@Service
public class RewardsCentralService {
	private Logger logger = LoggerFactory.getLogger("RewardsCentralService");
    private RewardCentral rewardCentral = new RewardCentral();

    public int getRewardPointsRewardsCentral(UUID attractionId, UUID userId) {
        logger.info("get Reward Points RewardsCentral");
        return rewardCentral.getAttractionRewardPoints(attractionId, userId);
    }
}
