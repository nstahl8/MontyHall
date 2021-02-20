package tele2.montyhall.services;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


public class SimulationServiceTest {

    private SimulationService simulationService = new SimulationService();

    @Test
    public void testSimulateKeep() {
        int n = 10;
        JSONObject obj = simulationService.simulateKeep(n);

        try {
            int numberOfSimulations = obj.getInt("numberOfSimulations");
            int numberOfWins = obj.getInt("numberOfWins");
            int numberOfLosses = obj.getInt("numberOfLosses");
            assertEquals(numberOfSimulations, n);
            assertEquals(numberOfLosses+numberOfWins, numberOfSimulations);
        } catch(JSONException je) {
            fail();
        }
    }

    @Test
    public void testSimulateSwap() {
        int n = 11;
        JSONObject obj = simulationService.simulateSwap(n);

        try {
            int numberOfSimulations = obj.getInt("numberOfSimulations");
            int numberOfWins = obj.getInt("numberOfWins");
            int numberOfLosses = obj.getInt("numberOfLosses");
            assertEquals(numberOfSimulations, n);
            assertEquals(numberOfLosses+numberOfWins, numberOfSimulations);
        } catch(JSONException je) {
            fail();
        }
    }

}
