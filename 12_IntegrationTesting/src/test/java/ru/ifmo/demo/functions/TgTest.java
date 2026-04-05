package ru.ifmo.demo.functions;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Comprehensive test class for Tg function (tangent)
 */
public class TgTest {

    private static final double DELTA = 0.0001;

    @Test
    public void testDefaultConstructor() {
        Tg tg = new Tg();
        assertNotNull(tg);
    }

    @Test
    public void testImplementsIFunc() {
        Tg tg = new Tg();
        assertTrue(tg instanceof IFunc);
    }

    @Test
    public void testGetAtZero() {
        Tg tg = new Tg();
        assertEquals(0.0, tg.get(0), DELTA);
    }

    @Test
    public void testGetAtPiOverFour() {
        Tg tg = new Tg();
        // tan(pi/4) = 1
        assertEquals(1.0, tg.get(Math.PI / 4), DELTA);
    }

    @Test
    public void testGetAtPiOverSix() {
        Tg tg = new Tg();
        // tan(pi/6) = 1/sqrt(3)
        assertEquals(1.0 / Math.sqrt(3), tg.get(Math.PI / 6), DELTA);
    }

    @Test
    public void testGetAtPiOverThree() {
        Tg tg = new Tg();
        // tan(pi/3) = sqrt(3)
        assertEquals(Math.sqrt(3), tg.get(Math.PI / 3), DELTA);
    }

    @Test
    public void testGetAtPi() {
        Tg tg = new Tg();
        // tan(pi) = 0
        assertEquals(0.0, tg.get(Math.PI), DELTA);
    }

    @Test
    public void testGetAtPiOverTwoIsLarge() {
        Tg tg = new Tg();
        // tan(pi/2) should be very large (approaches infinity)
        double result = tg.get(Math.PI / 2);
        assertTrue(Math.abs(result) > 1000);
    }

    @Test
    public void testGetAtThreePiOverTwoIsLarge() {
        Tg tg = new Tg();
        // tan(3*pi/2) should be very large (approaches infinity)
        double result = tg.get(3 * Math.PI / 2);
        assertTrue(Math.abs(result) > 1000);
    }

    @Test
    public void testGetWithPositiveValue() {
        Tg tg = new Tg();
        double expected = Math.tan(1.5);
        assertEquals(expected, tg.get(1.5), DELTA);
    }

    @Test
    public void testGetWithNegativeValue() {
        Tg tg = new Tg();
        double expected = Math.tan(-1.5);
        assertEquals(expected, tg.get(-1.5), DELTA);
    }

    @Test
    public void testGetWithLargePositiveValue() {
        Tg tg = new Tg();
        double expected = Math.tan(100.0);
        assertEquals(expected, tg.get(100.0), DELTA);
    }

    @Test
    public void testGetWithLargeNegativeValue() {
        Tg tg = new Tg();
        double expected = Math.tan(-100.0);
        assertEquals(expected, tg.get(-100.0), DELTA);
    }

    @Test
    public void testGetWithInfinity() {
        Tg tg = new Tg();
        double result = tg.get(Double.POSITIVE_INFINITY);
        assertTrue(Double.isNaN(result));
    }

    @Test
    public void testGetWithNegativeInfinity() {
        Tg tg = new Tg();
        double result = tg.get(Double.NEGATIVE_INFINITY);
        assertTrue(Double.isNaN(result));
    }

    @Test
    public void testGetWithNaN() {
        Tg tg = new Tg();
        double result = tg.get(Double.NaN);
        assertTrue(Double.isNaN(result));
    }

    @Test
    public void testGetNegativePiOverFour() {
        Tg tg = new Tg();
        assertEquals(-1.0, tg.get(-Math.PI / 4), DELTA);
    }

    // Additional edge case tests for 100% coverage

    @Test
    public void testGetAtSmallValue() {
        Tg tg = new Tg();
        double result = tg.get(0.001);
        assertEquals(Math.tan(0.001), result, DELTA);
    }

    @Test
    public void testGetAtMaxValue() {
        Tg tg = new Tg();
        double result = tg.get(Double.MAX_VALUE);
        // tan of very large value may be undefined but shouldn't throw
        assertNotNull(Double.valueOf(result));
    }

    @Test
    public void testGetAtMinValue() {
        Tg tg = new Tg();
        double result = tg.get(Double.MIN_VALUE);
        assertEquals(Double.MIN_VALUE, result, DELTA); // tan(~0) = ~0
    }

    @Test
    public void testTanIsOdd() {
        // tan(-x) = -tan(x)
        Tg tg = new Tg();
        double x = 0.5;
        assertEquals(-tg.get(x), tg.get(-x), DELTA);
    }

    @Test
    public void testTanPeriod() {
        // tan(x + pi) = tan(x)
        Tg tg = new Tg();
        double x = 0.3;
        assertEquals(tg.get(x), tg.get(x + Math.PI), DELTA);
    }

    @Test
    public void testGetAtNegativePi() {
        Tg tg = new Tg();
        assertEquals(0.0, tg.get(-Math.PI), DELTA);
    }

    @Test
    public void testGetAtTwoPi() {
        Tg tg = new Tg();
        assertEquals(0.0, tg.get(2 * Math.PI), DELTA);
    }

    @Test
    public void testGetNegativePiOverSix() {
        Tg tg = new Tg();
        assertEquals(-1.0 / Math.sqrt(3), tg.get(-Math.PI / 6), DELTA);
    }

    @Test
    public void testGetNegativePiOverThree() {
        Tg tg = new Tg();
        assertEquals(-Math.sqrt(3), tg.get(-Math.PI / 3), DELTA);
    }

    @Test
    public void testDivisionByZeroNearPiOverTwo() {
        Tg tg = new Tg();
        // Values very close to pi/2 should produce very large results
        double nearPiOverTwo = Math.PI / 2 - 0.0001;
        double result = tg.get(nearPiOverTwo);
        assertTrue(Math.abs(result) > 1000);
    }
}
