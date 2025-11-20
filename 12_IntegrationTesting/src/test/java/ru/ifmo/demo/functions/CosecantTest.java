package ru.ifmo.demo.functions;

import org.junit.Test;

import static org.junit.Assert.*;

public class CosecantTest {

    private static final double DELTA = 0.0001;

    @Test
    public void testGetBasicValues() {
        Cosecant cosecant = new Cosecant();
        assertEquals(1.0, cosecant.get(Math.PI / 2), DELTA);
        assertEquals(2.0, cosecant.get(Math.PI / 6), DELTA);
    }

    @Test
    public void testGetNegativeValues() {
        Cosecant cosecant = new Cosecant();
        assertEquals(-1.0, cosecant.get(-Math.PI / 2), DELTA);
    }

    @Test
    public void testCosecantImplementsIFunc() {
        Cosecant cosecant = new Cosecant();
        assertTrue(cosecant instanceof IFunc);
    }

    @Test
    public void testCosecantPeriodicity() {
        Cosecant cosecant = new Cosecant();
        double value1 = cosecant.get(Math.PI / 3);
        double value2 = cosecant.get(Math.PI / 3 + 2 * Math.PI);
        assertEquals(value1, value2, DELTA);
    }

    @Test
    public void testCosecantIsReciprocalOfSin() {
        Cosecant cosecant = new Cosecant();
        double x = Math.PI / 3;
        assertEquals(1.0 / Math.sin(x), cosecant.get(x), DELTA);
    }
}
