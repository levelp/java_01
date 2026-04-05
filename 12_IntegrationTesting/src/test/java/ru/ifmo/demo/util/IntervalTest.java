package ru.ifmo.demo.util;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Comprehensive test class for Interval
 */
public class IntervalTest {

    private static final double DELTA = 0.0001;

    @Test
    public void testConstructorWithValidParameters() {
        Interval interval = new Interval(0.0, 10.0, 1.0);
        assertNotNull(interval);
    }

    @Test
    public void testGetX0() {
        Interval interval = new Interval(1.5, 10.0, 0.5);
        assertEquals(1.5, interval.getX0(), DELTA);
    }

    @Test
    public void testGetX1() {
        Interval interval = new Interval(0.0, 20.5, 0.5);
        assertEquals(20.5, interval.getX1(), DELTA);
    }

    @Test
    public void testGetD() {
        Interval interval = new Interval(0.0, 10.0, 0.25);
        assertEquals(0.25, interval.getD(), DELTA);
    }

    @Test
    public void testSetX0() {
        Interval interval = new Interval(0.0, 10.0, 1.0);
        interval.setX0(5.5);
        assertEquals(5.5, interval.getX0(), DELTA);
    }

    @Test
    public void testSetX1() {
        Interval interval = new Interval(0.0, 10.0, 1.0);
        interval.setX1(25.5);
        assertEquals(25.5, interval.getX1(), DELTA);
    }

    @Test
    public void testSetD() {
        Interval interval = new Interval(0.0, 10.0, 1.0);
        interval.setD(0.1);
        assertEquals(0.1, interval.getD(), DELTA);
    }

    @Test
    public void testConstructorWithZeroInterval() {
        Interval interval = new Interval(5.0, 5.0, 1.0);
        assertEquals(5.0, interval.getX0(), DELTA);
        assertEquals(5.0, interval.getX1(), DELTA);
    }

    @Test
    public void testConstructorWithNegativeValues() {
        Interval interval = new Interval(-10.0, -5.0, 0.5);
        assertEquals(-10.0, interval.getX0(), DELTA);
        assertEquals(-5.0, interval.getX1(), DELTA);
    }

    @Test
    public void testConstructorWithReversedBounds() {
        Interval interval = new Interval(10.0, 0.0, 1.0);
        assertEquals(10.0, interval.getX0(), DELTA);
        assertEquals(0.0, interval.getX1(), DELTA);
    }

    @Test
    public void testSettersModifyValues() {
        Interval interval = new Interval(0.0, 10.0, 1.0);
        interval.setX0(-5.0);
        interval.setX1(15.0);
        interval.setD(2.0);

        assertEquals(-5.0, interval.getX0(), DELTA);
        assertEquals(15.0, interval.getX1(), DELTA);
        assertEquals(2.0, interval.getD(), DELTA);
    }

    @Test
    public void testConstructorWithInfinity() {
        Interval interval = new Interval(0.0, Double.POSITIVE_INFINITY, 1.0);
        assertEquals(0.0, interval.getX0(), DELTA);
        assertTrue(Double.isInfinite(interval.getX1()));
    }

    @Test
    public void testConstructorWithNaN() {
        Interval interval = new Interval(Double.NaN, 10.0, 1.0);
        assertTrue(Double.isNaN(interval.getX0()));
        assertEquals(10.0, interval.getX1(), DELTA);
    }

    @Test
    public void testSetX0WithNegativeValue() {
        Interval interval = new Interval(0.0, 10.0, 1.0);
        interval.setX0(-100.5);
        assertEquals(-100.5, interval.getX0(), DELTA);
    }

    @Test
    public void testSetDWithVerySmallValue() {
        Interval interval = new Interval(0.0, 10.0, 1.0);
        interval.setD(0.00001);
        assertEquals(0.00001, interval.getD(), DELTA);
    }
}
