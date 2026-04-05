package ru.ifmo.demo.functions;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Comprehensive test class for Cot function (cot(x) = 1/tan(x))
 */
public class CotTest {

    private static final double DELTA = 0.0001;

    @Test
    public void testDefaultConstructor() {
        Cot cot = new Cot();
        assertNotNull(cot);
    }

    @Test
    public void testImplementsIFunc() {
        Cot cot = new Cot();
        assertTrue(cot instanceof IFunc);
    }

    @Test
    public void testGetAtPiOverFour() {
        Cot cot = new Cot();
        // cot(pi/4) = 1/tan(pi/4) = 1/1 = 1
        assertEquals(1.0, cot.get(Math.PI / 4), DELTA);
    }

    @Test
    public void testGetAtPiOverSix() {
        Cot cot = new Cot();
        // cot(pi/6) = 1/tan(pi/6) = sqrt(3)
        assertEquals(Math.sqrt(3), cot.get(Math.PI / 6), DELTA);
    }

    @Test
    public void testGetAtPiOverThree() {
        Cot cot = new Cot();
        // cot(pi/3) = 1/tan(pi/3) = 1/sqrt(3)
        assertEquals(1.0 / Math.sqrt(3), cot.get(Math.PI / 3), DELTA);
    }

    @Test
    public void testGetAtZeroIsInfinite() {
        Cot cot = new Cot();
        // cot(0) = 1/tan(0) = 1/0 = infinity
        double result = cot.get(0);
        assertTrue(Double.isInfinite(result));
    }

    @Test
    public void testGetAtPiOverTwoNearZero() {
        Cot cot = new Cot();
        // cot(pi/2) = 1/tan(pi/2) should be near zero
        double result = cot.get(Math.PI / 2);
        assertTrue(Math.abs(result) < 0.01);
    }

    @Test
    public void testGetAtPiIsInfinite() {
        Cot cot = new Cot();
        // cot(pi) = 1/tan(pi) = 1/0 = infinity
        double result = cot.get(Math.PI);
        assertTrue(Double.isInfinite(result));
    }

    @Test
    public void testGetAtThreePiOverTwoNearZero() {
        Cot cot = new Cot();
        // cot(3*pi/2) = 1/tan(3*pi/2) should be near zero
        double result = cot.get(3 * Math.PI / 2);
        assertTrue(Math.abs(result) < 0.01);
    }

    @Test
    public void testGetWithPositiveValue() {
        Cot cot = new Cot();
        double expected = 1.0 / Math.tan(1.5);
        assertEquals(expected, cot.get(1.5), DELTA);
    }

    @Test
    public void testGetWithNegativeValue() {
        Cot cot = new Cot();
        double expected = 1.0 / Math.tan(-1.5);
        assertEquals(expected, cot.get(-1.5), DELTA);
    }

    @Test
    public void testGetWithLargePositiveValue() {
        Cot cot = new Cot();
        double expected = 1.0 / Math.tan(100.0);
        assertEquals(expected, cot.get(100.0), DELTA);
    }

    @Test
    public void testGetWithInfinity() {
        Cot cot = new Cot();
        double result = cot.get(Double.POSITIVE_INFINITY);
        assertTrue(Double.isNaN(result));
    }

    @Test
    public void testGetWithNegativeInfinity() {
        Cot cot = new Cot();
        double result = cot.get(Double.NEGATIVE_INFINITY);
        assertTrue(Double.isNaN(result));
    }

    @Test
    public void testGetWithNaN() {
        Cot cot = new Cot();
        double result = cot.get(Double.NaN);
        assertTrue(Double.isNaN(result));
    }

    @Test
    public void testGetNegativeAngle() {
        Cot cot = new Cot();
        double expected = 1.0 / Math.tan(-Math.PI / 4);
        assertEquals(expected, cot.get(-Math.PI / 4), DELTA);
    }

    // Additional edge case tests for 100% coverage

    @Test
    public void testGetAtSmallPositiveValue() {
        Cot cot = new Cot();
        double x = 0.01;
        double expected = 1.0 / Math.tan(x);
        assertEquals(expected, cot.get(x), DELTA);
    }

    @Test
    public void testGetAtSmallNegativeValue() {
        Cot cot = new Cot();
        double x = -0.01;
        double expected = 1.0 / Math.tan(x);
        assertEquals(expected, cot.get(x), DELTA);
    }

    @Test
    public void testGetAtMaxValue() {
        Cot cot = new Cot();
        double result = cot.get(Double.MAX_VALUE);
        // cot of very large value may be undefined but shouldn't throw
        assertNotNull(Double.valueOf(result));
    }

    @Test
    public void testGetAtMinValue() {
        Cot cot = new Cot();
        double result = cot.get(Double.MIN_VALUE);
        // cot(~0) = 1/tan(~0) = very large
        assertTrue(Math.abs(result) > 1000);
    }

    @Test
    public void testCotIsOdd() {
        // cot(-x) = -cot(x)
        Cot cot = new Cot();
        double x = 1.0;
        assertEquals(-cot.get(x), cot.get(-x), DELTA);
    }

    @Test
    public void testCotPeriod() {
        // cot(x + pi) = cot(x)
        Cot cot = new Cot();
        double x = 0.5;
        assertEquals(cot.get(x), cot.get(x + Math.PI), DELTA);
    }

    @Test
    public void testGetAtTwoPiIsInfinite() {
        Cot cot = new Cot();
        double result = cot.get(2 * Math.PI);
        assertTrue(Double.isInfinite(result));
    }

    @Test
    public void testGetAtNegativePiIsInfinite() {
        Cot cot = new Cot();
        double result = cot.get(-Math.PI);
        assertTrue(Double.isInfinite(result));
    }

    @Test
    public void testGetAtNegativePiOverTwo() {
        Cot cot = new Cot();
        // cot(-pi/2) should be near zero
        double result = cot.get(-Math.PI / 2);
        assertTrue(Math.abs(result) < 0.01);
    }

    @Test
    public void testDivisionByZeroNearZero() {
        Cot cot = new Cot();
        // Values very close to 0 should produce very large results (division by ~0)
        double nearZero = 0.0001;
        double result = cot.get(nearZero);
        assertTrue(Math.abs(result) > 1000);
    }

    @Test
    public void testGetWithLargeNegativeValue() {
        Cot cot = new Cot();
        double expected = 1.0 / Math.tan(-100.0);
        assertEquals(expected, cot.get(-100.0), DELTA);
    }
}
