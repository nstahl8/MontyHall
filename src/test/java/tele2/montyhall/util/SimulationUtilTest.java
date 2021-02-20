package tele2.montyhall.util;


import org.junit.Test;
import tele2.montyhall.domain.EmptyBox;
import tele2.montyhall.domain.PriceBox;
import tele2.montyhall.interfaces.Box;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SimulationUtilTest {

    private SimulationUtil util = new SimulationUtil();

    @Test
    public void testGenerateNewBoxes() {
        int n = 3;
        List<Box> boxes = util.generateNewBoxes(n);
        int numberOfPrices = 0;
        for(Box box: boxes) {
            if(box.hasPrice()) {
                numberOfPrices ++;
            }
        }

        assertEquals(boxes.size(), n);
        assertEquals(numberOfPrices, 1);
    }


    @Test
    public void testRemoveOneEmptyBox() {

        List<Box> boxes = new ArrayList<Box>();
        boxes.add(new EmptyBox());
        boxes.add(new EmptyBox());
        boxes.add(new PriceBox());
        Collections.shuffle(boxes);

        util.removeOneEmptyBox(boxes);
        int numberOfPrices = 0;
        int numberOfEmpty = 0;
        for(Box box: boxes) {
            if(box.hasPrice()) {
                numberOfPrices ++;
            } else {
                numberOfEmpty ++;
            }
        }

        assertEquals(boxes.size(), 2);
        assertEquals(numberOfEmpty, 1);
        assertEquals(numberOfPrices, 1);
    }
}
