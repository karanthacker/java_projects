package test;

import org.junit.Before;
import org.junit.Test;
import toy.Doll;

import static org.junit.Assert.*;

public class DollTest {
    private Doll barbie;
    @Before
    public void setUp() throws Exception {
        barbie = new Doll("Barbie",149.99,"pink", "green");
    }

    @Test
    public void testToString() {
        String str = "Barbie [product code=3000000, MSRP=149.99, condition=MINT, resale value=149.99, hair color=pink, eye color=green]";
        assertEquals(str,barbie.toString());
    }
}