package RewardsCentralService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import RewardsCentral.Application;
import RewardsCentral.exception.UUIDException;
import RewardsCentral.service.RewardsCentralService;

import static org.junit.Assert.assertTrue;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class RewardsCentralServiceTest {

	@Autowired
	private RewardsCentralService rewardCentralService;

	@Test
	public void getRewardsPointsTest() throws UUIDException {

		int points = rewardCentralService.getRewardPointsRewardsCentral(String.valueOf(UUID.randomUUID()),
				String.valueOf(UUID.randomUUID()));

		assertTrue(points >= 0 && points <= 1000);
	}

	@Test
	public void getRewardsPointsTest__whenUUIDIsNull_shouldReturnUUIDException() {

		try {
			rewardCentralService.getRewardPointsRewardsCentral("",
					String.valueOf(UUID.randomUUID()));
		} catch (UUIDException e) {
			assertTrue(e instanceof UUIDException);
			assertTrue(e.getMessage().contains("format UUID of attractionId or userId is invalid!"));
		}
	}
}