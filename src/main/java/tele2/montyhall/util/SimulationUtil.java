package tele2.montyhall.util;

import tele2.montyhall.domain.EmptyBox;
import tele2.montyhall.domain.PriceBox;
import tele2.montyhall.interfaces.Box;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SimulationUtil {


    public List<Box> generateNewBoxes(int numberOfBoxes) {

        List<Box> boxes = new ArrayList<Box>();
        boxes.add(new PriceBox());
        for(int i = 1; i < numberOfBoxes; i++) {
            boxes.add(new EmptyBox());
        }
        Collections.shuffle(boxes);
        return boxes;
    }

    public void removeOneEmptyBox(List<Box> boxes) {

        for(Box box: boxes) {
            if(!box.hasPrice()) {
                boxes.remove(box);
                return;
            }
        }
    }
}
