package ru.ifmo.demo.functions;

import org.junit.Test;

import static org.junit.Assert.*;

public class TgTest {

    private static final double DELTA = 0.0001;

    @Test
    public void testGetBasicValues() {
        Tg tg = new Tg();
        assertEquals(0.0, tg.get(0), DELTA);
        assertEquals(1.0, tg.get(Math.PI / 4), DELTA);
        assertEquals(0.0, tg.get(Math.PI), DELTA);
    }

    @Test
    public void testGetNegativeValues() {
        Tg tg = new Tg();
        assertEquals(-1.0, tg.get(-Math.PI / 4), DELTA);
    }

    @Test
    public void testTgImplementsIFunc() {
        Tg tg = new Tg();
        assertTrue(tg instanceof IFunc);
    }

    @Test
    public void testTgPeriodicity() {
        Tg tg = new Tg();
        double value1 = tg.get(Math.PI / 6);
        double value2 = tg.get(Math.PI / 6 + Math.PI);
        assertEquals(value1, value2, DELTA);
    }

    @Test
    public void testTgAsymmetry() {
        Tg tg = new Tg();
        double value1 = tg.get(Math.PI / 6);
        double value2 = tg.get(-Math.PI / 6);
        assertEquals(value1, -value2, DELTA);
    }
}
