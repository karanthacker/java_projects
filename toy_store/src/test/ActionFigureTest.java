package test;

import toy.ActionFigure;

import javax.swing.*;

import static org.junit.Assert.*;

public class ActionFigureTest {

    private ActionFigure batman;

    @org.junit.Before
    public void setUp() throws Exception {
        this.batman = new ActionFigure("Batman", 199.99, "Black", "Blue", true);
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @org.junit.Test
    public void isKungFuGrip() {
        assertEquals(true, this.batman.isKungFuGrip());
    }

    @org.junit.Test
    public void testToString() {
        String str = "Batman [product code=5000000, MSRP=199.99, condition=MINT, resale value=199.99, hair color=Black, eye color=Blue, kung-fu grip=true]";
        assertEquals(str, this.batman.toString());
    }
}