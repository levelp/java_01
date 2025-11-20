package ru.ifmo.demo.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class IntervalTest {

    @Test
    public void testIntervalConstruction() {
        Interval interval = new Interval(0.0, 10.0, 0.1);
        assertNotNull(interval);
        assertEquals(0.0, interval.getX0(), 0.0);
        assertEquals(10.0, interval.getX1(), 0.0);
        assertEquals(0.1, interval.getD(), 0.0);
    }

    @Test
    public void testGetX0() {
        Interval interval = new Interval(1.0, 5.0, 0.5);
        assertEquals(1.0, interval.getX0(), 0.0);
    }

    @Test
    public void testSetX0() {
        Interval interval = new Interval(1.0, 5.0, 0.5);
        interval.setX0(2.0);
        assertEquals(2.0, interval.getX0(), 0.0);
    }

    @Test
    public void testGetX1() {
        Interval interval = new Interval(1.0, 5.0, 0.5);
        assertEquals(5.0, interval.getX1(), 0.0);
    }

    @Test
    public void testSetX1() {
        Interval interval = new Interval(1.0, 5.0, 0.5);
        interval.setX1(10.0);
        assertEquals(10.0, interval.getX1(), 0.0);
    }

    @Test
    public void testGetD() {
        Interval interval = new Interval(1.0, 5.0, 0.5);
        assertEquals(0.5, interval.getD(), 0.0);
    }

    @Test
    public void testSetD() {
        Interval interval = new Interval(1.0, 5.0, 0.5);
        interval.setD(0.25);
        assertEquals(0.25, interval.getD(), 0.0);
    }

    @Test
    public void testNegativeInterval() {
        Interval interval = new Interval(-5.0, -1.0, 0.1);
        assertEquals(-5.0, interval.getX0(), 0.0);
        assertEquals(-1.0, interval.getX1(), 0.0);
    }

    @Test
    public void testZeroIncrement() {
        Interval interval = new Interval(0.0, 10.0, 0.0);
        assertEquals(0.0, interval.getD(), 0.0);
    }

    @Test
    public void testMultipleSettersAndGetters() {
        Interval interval = new Interval(0.0, 0.0, 0.0);
        interval.setX0(1.5);
        interval.setX1(7.5);
        interval.setD(0.75);

        assertEquals(1.5, interval.getX0(), 0.0);
        assertEquals(7.5, interval.getX1(), 0.0);
        assertEquals(0.75, interval.getD(), 0.0);
    }
}
