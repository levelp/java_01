package ru.ifmo.demo.functions;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Comprehensive test class for Cosecant function (csc(x) = 1/sin(x))
 */
public class CosecantTest {

    private static final double DELTA = 0.0001;

    @Test
    public void testDefaultConstructor() {
        Cosecant csc = new Cosecant();
        assertNotNull(csc);
    }

    @Test
    public void testImplementsIFunc() {
        Cosecant csc = new Cosecant();
        assertTrue(csc instanceof IFunc);
    }

    @Test
    public void testGetAtPiOverSix() {
        Cosecant csc = new Cosecant();
        // csc(pi/6) = 1/sin(pi/6) = 1/0.5 = 2
        assertEquals(2.0, csc.get(Math.PI / 6), DELTA);
    }

    @Test
    public void testGetAtPiOverFour() {
        Cosecant csc = new Cosecant();
        // csc(pi/4) = 1/sin(pi/4) = sqrt(2)
        assertEquals(Math.sqrt(2), csc.get(Math.PI / 4), DELTA);
    }

    @Test
    public void testGetAtPiOverThree() {
        Cosecant csc = new Cosecant();
        // csc(pi/3) = 1/sin(pi/3) = 2/sqrt(3)
        assertEquals(2.0 / Math.sqrt(3), csc.get(Math.PI / 3), DELTA);
    }

    @Test
    public void testGetAtPiOverTwo() {
        Cosecant csc = new Cosecant();
        // csc(pi/2) = 1/sin(pi/2) = 1/1 = 1
        assertEquals(1.0, csc.get(Math.PI / 2), DELTA);
    }

    @Test
    public void testGetAtThreePiOverTwo() {
        Cosecant csc = new Cosecant();
        // csc(3*pi/2) = 1/sin(3*pi/2) = 1/(-1) = -1
        assertEquals(-1.0, csc.get(3 * Math.PI / 2), DELTA);
    }

    @Test
    public void testGetAtZeroIsInfinite() {
        Cosecant csc = new Cosecant();
        // csc(0) = 1/sin(0) = 1/0 = infinity
        double result = csc.get(0);
        assertTrue(Double.isInfinite(result));
    }

    @Test
    public void testGetAtPiIsInfinite() {
        Cosecant csc = new Cosecant();
        // csc(pi) = 1/sin(pi) = 1/0 = infinity
        double result = csc.get(Math.PI);
        assertTrue(Double.isInfinite(result));
    }

    @Test
    public void testGetAtTwoPiIsInfinite() {
        Cosecant csc = new Cosecant();
        // csc(2*pi) = 1/sin(2*pi) = 1/0 = infinity
        double result = csc.get(2 * Math.PI);
        assertTrue(Double.isInfinite(result));
    }

    @Test
    public void testGetWithPositiveValue() {
        Cosecant csc = new Cosecant();
        double expected = 1.0 / Math.sin(1.5);
        assertEquals(expected, csc.get(1.5), DELTA);
    }

    @Test
    public void testGetWithNegativeValue() {
        Cosecant csc = new Cosecant();
        double expected = 1.0 / Math.sin(-1.5);
        assertEquals(expected, csc.get(-1.5), DELTA);
    }

    @Test
    public void testGetWithInfinity() {
        Cosecant csc = new Cosecant();
        double result = csc.get(Double.POSITIVE_INFINITY);
        assertTrue(Double.isNaN(result));
    }

    @Test
    public void testGetWithNegativeInfinity() {
        Cosecant csc = new Cosecant();
        double result = csc.get(Double.NEGATIVE_INFINITY);
        assertTrue(Double.isNaN(result));
    }

    @Test
    public void testGetWithNaN() {
        Cosecant csc = new Cosecant();
        double result = csc.get(Double.NaN);
        assertTrue(Double.isNaN(result));
    }

    @Test
    public void testGetNegativeAngles() {
        Cosecant csc = new Cosecant();
        double expected = 1.0 / Math.sin(-Math.PI / 4);
        assertEquals(expected, csc.get(-Math.PI / 4), DELTA);
    }

    // Additional edge case tests for 100% coverage

    @Test
    public void testGetAtSmallPositiveValue() {
        Cosecant csc = new Cosecant();
        double x = 0.01;
        double expected = 1.0 / Math.sin(x);
        assertEquals(expected, csc.get(x), DELTA);
    }

    @Test
    public void testGetAtSmallNegativeValue() {
        Cosecant csc = new Cosecant();
        double x = -0.01;
        double expected = 1.0 / Math.sin(x);
        assertEquals(expected, csc.get(x), DELTA);
    }

    @Test
    public void testGetAtMaxValue() {
        Cosecant csc = new Cosecant();
        double result = csc.get(Double.MAX_VALUE);
        // csc of very large value may be undefined but shouldn't throw
        assertNotNull(Double.valueOf(result));
    }

    @Test
    public void testGetAtMinValue() {
        Cosecant csc = new Cosecant();
        double result = csc.get(Double.MIN_VALUE);
        // csc(~0) = 1/sin(~0) = very large
        assertTrue(Math.abs(result) > 1000);
    }

    @Test
    public void testCscIsOdd() {
        // csc(-x) = -csc(x)
        Cosecant csc = new Cosecant();
        double x = 1.0;
        assertEquals(-csc.get(x), csc.get(-x), DELTA);
    }

    @Test
    public void testCscPeriod() {
        // csc(x + 2*pi) = csc(x)
        Cosecant csc = new Cosecant();
        double x = Math.PI / 4;
        assertEquals(csc.get(x), csc.get(x + 2 * Math.PI), DELTA);
    }

    @Test
    public void testGetAtNegativePiOverTwo() {
        Cosecant csc = new Cosecant();
        // csc(-pi/2) = 1/sin(-pi/2) = 1/(-1) = -1
        assertEquals(-1.0, csc.get(-Math.PI / 2), DELTA);
    }

    @Test
    public void testGetAtFivePiOverSix() {
        Cosecant csc = new Cosecant();
        // csc(5*pi/6) = 1/sin(5*pi/6) = 1/0.5 = 2
        assertEquals(2.0, csc.get(5 * Math.PI / 6), DELTA);
    }

    @Test
    public void testDivisionByZeroNearZero() {
        Cosecant csc = new Cosecant();
        // Values very close to 0 should produce very large results (division by ~0)
        double nearZero = 0.0001;
        double result = csc.get(nearZero);
        assertTrue(Math.abs(result) > 1000);
    }

    @Test
    public void testDivisionByZeroNearPi() {
        Cosecant csc = new Cosecant();
        // Values very close to pi should produce very large results
        double nearPi = Math.PI + 0.0001;
        double result = csc.get(nearPi);
        assertTrue(Math.abs(result) > 100);
    }

    @Test
    public void testGetWithLargePositiveValue() {
        Cosecant csc = new Cosecant();
        double expected = 1.0 / Math.sin(100.0);
        assertEquals(expected, csc.get(100.0), DELTA);
    }

    @Test
    public void testGetWithLargeNegativeValue() {
        Cosecant csc = new Cosecant();
        double expected = 1.0 / Math.sin(-100.0);
        assertEquals(expected, csc.get(-100.0), DELTA);
    }
}
