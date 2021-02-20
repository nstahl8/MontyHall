package tele2.montyhall.domain;

import org.junit.Test;
import tele2.montyhall.interfaces.Box;

import static org.junit.Assert.assertEquals;

public class BoxTest {

    @Test
    public void testEmptyBoxHasPrice() {
        Box box = new EmptyBox();

        assertEquals(box.hasPrice(), false);

    }

    @Test
    public void testPriceBoxHasPrice() {
        Box box = new PriceBox();

        assertEquals(box.hasPrice(), true);

    }
}
