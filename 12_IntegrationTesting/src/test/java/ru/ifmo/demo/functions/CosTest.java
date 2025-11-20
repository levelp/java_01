package ru.ifmo.demo.functions;

import org.junit.Test;

import static org.junit.Assert.*;

public class CosTest {

    private static final double DELTA = 0.0001;

    @Test
    public void testGetBasicValues() {
        Cos cos = new Cos();
        assertEquals(1.0, cos.get(0), DELTA);
        assertEquals(0.0, cos.get(Math.PI / 2), DELTA);
        assertEquals(-1.0, cos.get(Math.PI), DELTA);
    }

    @Test
    public void testGetNegativeValues() {
        Cos cos = new Cos();
        assertEquals(0.0, cos.get(-Math.PI / 2), DELTA);
        assertEquals(1.0, cos.get(-Math.PI * 2), DELTA);
    }

    @Test
    public void testGetZero() {
        Cos cos = new Cos();
        assertEquals(1.0, cos.get(0), DELTA);
    }

    @Test
    public void testCosImplementsIFunc() {
        Cos cos = new Cos();
        assertTrue(cos instanceof IFunc);
    }

    @Test
    public void testCosPeriodicity() {
        Cos cos = new Cos();
        double value1 = cos.get(Math.PI / 4);
        double value2 = cos.get(Math.PI / 4 + 2 * Math.PI);
        assertEquals(value1, value2, DELTA);
    }

    @Test
    public void testCosSymmetry() {
        Cos cos = new Cos();
        double value1 = cos.get(Math.PI / 3);
        double value2 = cos.get(-Math.PI / 3);
        assertEquals(value1, value2, DELTA);
    }
}
