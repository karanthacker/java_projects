package test;

import org.junit.Before;
import org.junit.Test;
import toy.Scooter;

import static org.junit.Assert.*;

public class ScooterTest {
    private Scooter vespa;

    @Before
    public void setUp() throws Exception {
        this.vespa = new Scooter("Vespa",49.99,"red","black");
    }

    @Test
    public void play() {
        assertEquals(0, this.vespa.getOdometer());
        this.vespa.play();
        this.vespa.play();
        this.vespa.play();
        this.vespa.play();
        assertEquals(8, this.vespa.getOdometer());

    }

    @Test
    public void testToString() {
        String str ="Vespa [product code=9000000, MSRP=49.99, condition=MINT, resale value=49.99, color=red, wheels=black, odometer=0]";
        assertEquals(str,this.vespa.toString());
    }
}