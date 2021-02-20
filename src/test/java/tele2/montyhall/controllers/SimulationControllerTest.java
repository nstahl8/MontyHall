package tele2.montyhall.controllers;


import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import tele2.montyhall.services.SimulationService;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SimulationControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private SimulationService mockSimulationService;

    private final JSONObject MOCKED_JSON = new JSONObject();

    @Before
    public void setup() {
        Mockito.when(mockSimulationService.simulateKeep(anyInt())).thenReturn(MOCKED_JSON);
        Mockito.when(mockSimulationService.simulateSwap(anyInt())).thenReturn(MOCKED_JSON);


    }

    @Test
    public void testSimulKeep() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/simul/keep/1/").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo(MOCKED_JSON.toString())));
    }

    @Test
    public void testSimulSwap() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/simul/swap/1/").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo(MOCKED_JSON.toString())));
    }

}
