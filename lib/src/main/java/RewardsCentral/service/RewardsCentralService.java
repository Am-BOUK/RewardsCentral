package RewardsCentral.service;

import java.util.UUID;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import RewardsCentral.exception.UUIDException;
import rewardCentral.RewardCentral;

@Service
public class RewardsCentralService {
	private Logger logger = LoggerFactory.getLogger("RewardsCentralService");
	private RewardCentral rewardCentral = new RewardCentral();
	private final static Pattern UUID_REGEX_PATTERN = Pattern
			.compile("^[{]?[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12}[}]?$");

	public int getRewardPointsRewardsCentral(String attractionId, String userId) throws UUIDException {
		logger.info("get Reward Points RewardsCentral");

		if (!isValidUUID(attractionId) || !isValidUUID(userId)) {
			logger.error("format UUID of attractionId or userId invalid!");
			throw new UUIDException("format UUID of attractionId or userId is invalid!");
		}

		UUID attractionIdUUID = UUID.fromString(attractionId);
		UUID userIdUUID = UUID.fromString(userId);

		return rewardCentral.getAttractionRewardPoints(attractionIdUUID, userIdUUID);
	}

	private static boolean isValidUUID(String str) {
		if (str == null) {
			return false;
		}
		return UUID_REGEX_PATTERN.matcher(str).matches();
	}
}
