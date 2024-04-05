package test;

import org.junit.Before;
import org.junit.Test;
import toy.BatteryType;
import toy.RCCar;

import static org.junit.Assert.*;

public class RCCarTest {
    private RCCar mcqueen;
    @Before
    public void setUp() throws Exception {
        this.mcqueen = new RCCar("McQueen", 99.99, BatteryType.AAA, 4, 45);
    }

    @Test
    public void testToString() {
        String str = "McQueen [product code=6000000, MSRP=99.99, condition=MINT, resale value=99.99, battery type=AAA, number of batteries=4, battery level=100%, speed=45]";
        assertEquals(str,this.mcqueen.toString());
    }

    @Test
    public void play() {
        assertEquals(100,this.mcqueen.getBatteryLevel());
        this.mcqueen.play();
        this.mcqueen.play();
        this.mcqueen.play();
        this.mcqueen.play();
        assertEquals(0,this.mcqueen.getBatteryLevel());
        this.mcqueen.play();
        assertEquals(75,this.mcqueen.getBatteryLevel());

    }
}