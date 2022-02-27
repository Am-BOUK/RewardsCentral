package RewardsCentralController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import RewardsCentral.Application;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class RewardCentralControllerIT {
	@Autowired
    private MockMvc mock;

    @Test
    public void getRewardPointsTest() throws Exception {

        mock.perform(get("/getRewardPoints")
                        .param("attractionId", String.valueOf(UUID.randomUUID()))
                        .param("userId", String.valueOf(UUID.randomUUID())))
                .andExpect(status().isOk());
    }
}
