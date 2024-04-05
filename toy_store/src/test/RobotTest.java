package test;

import org.junit.Before;
import org.junit.Test;
import toy.BatteryType;
import toy.Robot;

import static org.junit.Assert.*;

public class RobotTest {
    private Robot r2d2;

    @Before
    public void setUp() throws Exception {
        this.r2d2 = new Robot("R2-D2",249.99, BatteryType.AAA, 2,"BLEEP");
    }

    @Test
    public void testToString() {
        String str = "R2-D2 [product code=7000000, MSRP=249.99, condition=MINT, resale value=249.99, battery type=AAA, number of batteries=2, battery level=100%, sound=BLEEP]";
        assertEquals(str,this.r2d2.toString());
    }

    @Test
    public void play() {
        assertEquals(100,this.r2d2.getBatteryLevel());
        this.r2d2.play();
        this.r2d2.play();
        this.r2d2.play();
        this.r2d2.play();
        this.r2d2.play();
        this.r2d2.play();
        assertEquals(10,this.r2d2.getBatteryLevel());

    }
}