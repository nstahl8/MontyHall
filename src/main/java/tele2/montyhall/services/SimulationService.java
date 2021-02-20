package tele2.montyhall.services;


import org.springframework.stereotype.Component;
import tele2.montyhall.interfaces.Box;
import tele2.montyhall.util.SimulationUtil;
import java.util.List;
import java.util.Random;
import org.json.JSONObject;

@Component
public class SimulationService {


    private SimulationUtil  util = new SimulationUtil();

    public JSONObject simulateKeep(int numberOfSimulations) {

        return simulate(numberOfSimulations, true);
    }

    public JSONObject simulateSwap(int numberOfSimulations) {

        return simulate(numberOfSimulations, false);
    }

    private JSONObject simulate(int numberOfSimulations, boolean keep) {

        JSONObject ret = new JSONObject();
        ret.put("numberOfSimulations", numberOfSimulations);
        ret.put("keep", keep);
        int n = 3;
        int numberOfWins = 0;
        int numberOfLosses = 0;
        for(int i = 0; i < numberOfSimulations; i++) {

            List<Box> boxes = util.generateNewBoxes(n);
            Box box = simulateMontyHall(boxes, keep);
            if(box.hasPrice()) {
                numberOfWins++;
            } else {
                numberOfLosses++;
            }

        }
        ret.put("numberOfWins", numberOfWins);
        ret.put("numberOfLosses", numberOfLosses);
        return ret;
    }

    private Box simulateMontyHall(List<Box> boxes, boolean keep) {

        Random rand = new Random();
        int pick = rand.nextInt(boxes.size());
        Box pickedBox = boxes.remove(pick);
        if(!keep) {
            util.removeOneEmptyBox(boxes);
            pickedBox = boxes.get(rand.nextInt(boxes.size()));
        }
        return pickedBox;

    }

}
