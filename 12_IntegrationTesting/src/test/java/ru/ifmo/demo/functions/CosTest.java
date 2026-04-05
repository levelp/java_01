package ru.ifmo.demo.functions;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Comprehensive test class for Cos function
 */
public class CosTest {

    private static final double DELTA = 0.0001;

    @Test
    public void testDefaultConstructor() {
        Cos cos = new Cos();
        assertNotNull(cos);
    }

    @Test
    public void testImplementsIFunc() {
        Cos cos = new Cos();
        assertTrue(cos instanceof IFunc);
    }

    @Test
    public void testGetAtZero() {
        Cos cos = new Cos();
        assertEquals(1.0, cos.get(0), DELTA);
    }

    @Test
    public void testGetAtPiOverTwo() {
        Cos cos = new Cos();
        assertEquals(0.0, cos.get(Math.PI / 2), DELTA);
    }

    @Test
    public void testGetAtPi() {
        Cos cos = new Cos();
        assertEquals(-1.0, cos.get(Math.PI), DELTA);
    }

    @Test
    public void testGetAtThreePiOverTwo() {
        Cos cos = new Cos();
        assertEquals(0.0, cos.get(3 * Math.PI / 2), DELTA);
    }

    @Test
    public void testGetAtTwoPi() {
        Cos cos = new Cos();
        assertEquals(1.0, cos.get(2 * Math.PI), DELTA);
    }

    @Test
    public void testGetAtNegativePiOverTwo() {
        Cos cos = new Cos();
        assertEquals(0.0, cos.get(-Math.PI / 2), DELTA);
    }

    @Test
    public void testGetAtNegativePi() {
        Cos cos = new Cos();
        assertEquals(-1.0, cos.get(-Math.PI), DELTA);
    }

    @Test
    public void testGetAtPositiveValue() {
        Cos cos = new Cos();
        double expected = Math.cos(1.5);
        assertEquals(expected, cos.get(1.5), DELTA);
    }

    @Test
    public void testGetAtNegativeValue() {
        Cos cos = new Cos();
        double expected = Math.cos(-1.5);
        assertEquals(expected, cos.get(-1.5), DELTA);
    }

    @Test
    public void testGetWithLargePositiveValue() {
        Cos cos = new Cos();
        double expected = Math.cos(100.0);
        assertEquals(expected, cos.get(100.0), DELTA);
    }

    @Test
    public void testGetWithLargeNegativeValue() {
        Cos cos = new Cos();
        double expected = Math.cos(-100.0);
        assertEquals(expected, cos.get(-100.0), DELTA);
    }

    @Test
    public void testGetWithInfinity() {
        Cos cos = new Cos();
        double result = cos.get(Double.POSITIVE_INFINITY);
        assertTrue(Double.isNaN(result));
    }

    @Test
    public void testGetWithNegativeInfinity() {
        Cos cos = new Cos();
        double result = cos.get(Double.NEGATIVE_INFINITY);
        assertTrue(Double.isNaN(result));
    }

    @Test
    public void testGetWithNaN() {
        Cos cos = new Cos();
        double result = cos.get(Double.NaN);
        assertTrue(Double.isNaN(result));
    }

    // Additional edge case tests for 100% coverage

    @Test
    public void testGetAtPiOverFour() {
        Cos cos = new Cos();
        assertEquals(Math.sqrt(2) / 2, cos.get(Math.PI / 4), DELTA);
    }

    @Test
    public void testGetAtPiOverSix() {
        Cos cos = new Cos();
        assertEquals(Math.sqrt(3) / 2, cos.get(Math.PI / 6), DELTA);
    }

    @Test
    public void testGetAtPiOverThree() {
        Cos cos = new Cos();
        assertEquals(0.5, cos.get(Math.PI / 3), DELTA);
    }

    @Test
    public void testGetAtFivePiOverSix() {
        Cos cos = new Cos();
        assertEquals(-Math.sqrt(3) / 2, cos.get(5 * Math.PI / 6), DELTA);
    }

    @Test
    public void testGetAtSmallValue() {
        Cos cos = new Cos();
        double result = cos.get(0.001);
        assertEquals(Math.cos(0.001), result, DELTA);
    }

    @Test
    public void testGetAtMaxValue() {
        Cos cos = new Cos();
        double result = cos.get(Double.MAX_VALUE);
        // cos of very large value is undefined but shouldn't throw
        assertNotNull(Double.valueOf(result));
    }

    @Test
    public void testGetAtMinValue() {
        Cos cos = new Cos();
        double result = cos.get(Double.MIN_VALUE);
        assertEquals(1.0, result, DELTA); // cos(~0) = 1
    }

    @Test
    public void testCosIsEven() {
        // cos(-x) = cos(x)
        Cos cos = new Cos();
        double x = 1.23;
        assertEquals(cos.get(x), cos.get(-x), DELTA);
    }

    @Test
    public void testMultiplePeriods() {
        Cos cos = new Cos();
        double x = Math.PI / 4;
        double result1 = cos.get(x);
        double result2 = cos.get(x + 2 * Math.PI);
        double result3 = cos.get(x + 4 * Math.PI);
        assertEquals(result1, result2, DELTA);
        assertEquals(result1, result3, DELTA);
    }
}
