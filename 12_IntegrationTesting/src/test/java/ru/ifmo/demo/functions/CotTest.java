package ru.ifmo.demo.functions;

import org.junit.Test;

import static org.junit.Assert.*;

public class CotTest {

    private static final double DELTA = 0.0001;

    @Test
    public void testGetBasicValues() {
        Cot cot = new Cot();
        assertEquals(1.0, cot.get(Math.PI / 4), DELTA);
    }

    @Test
    public void testGetNegativeValues() {
        Cot cot = new Cot();
        assertEquals(-1.0, cot.get(-Math.PI / 4), DELTA);
    }

    @Test
    public void testCotImplementsIFunc() {
        Cot cot = new Cot();
        assertTrue(cot instanceof IFunc);
    }

    @Test
    public void testCotPeriodicity() {
        Cot cot = new Cot();
        double value1 = cot.get(Math.PI / 3);
        double value2 = cot.get(Math.PI / 3 + Math.PI);
        assertEquals(value1, value2, DELTA);
    }

    @Test
    public void testCotIsReciprocalOfTan() {
        Cot cot = new Cot();
        Tg tg = new Tg();
        double x = Math.PI / 3;
        assertEquals(1.0 / tg.get(x), cot.get(x), DELTA);
    }
}
