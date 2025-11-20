package ru.ifmo.demo.functions;

import org.junit.Test;
import ru.ifmo.demo.exceptions.DoubleNanException;
import ru.ifmo.demo.exceptions.InvalidPrecision;
import ru.ifmo.demo.exceptions.ZeroPrecision;

import static org.junit.Assert.*;

public class SinTest {

    private static final double DELTA = 0.001;

    @Test
    public void testGetBasicValues() throws DoubleNanException, ZeroPrecision, InvalidPrecision {
        assertEquals(0.0, Sin.getIt(0, 0.0001), DELTA);
        assertEquals(1.0, Sin.getIt(Math.PI / 2, 0.0001), DELTA);
        assertEquals(0.0, Sin.getIt(Math.PI, 0.0001), DELTA);
    }

    @Test
    public void testGetMethod() {
        Sin sin = new Sin();
        assertEquals(0.0, sin.get(0), DELTA);
        assertEquals(1.0, sin.get(Math.PI / 2), DELTA);
    }

    @Test(expected = ZeroPrecision.class)
    public void testZeroPrecisionThrowsException() throws DoubleNanException, ZeroPrecision, InvalidPrecision {
        Sin.getIt(0, 0);
    }

    @Test(expected = InvalidPrecision.class)
    public void testInvalidPrecisionThrowsException() throws DoubleNanException, ZeroPrecision, InvalidPrecision {
        Sin.getIt(0, 1.5);
    }

    @Test
    public void testGetItWithDifferentPrecisions() throws DoubleNanException, ZeroPrecision, InvalidPrecision {
        double result1 = Sin.getIt(Math.PI / 4, 0.001);
        double result2 = Sin.getIt(Math.PI / 4, 0.0001);
        assertTrue(Math.abs(result1 - result2) < 0.01);
    }

    @Test
    public void testGetItWithNegativeValues() throws DoubleNanException, ZeroPrecision, InvalidPrecision {
        double result = Sin.getIt(-Math.PI / 2, 0.0001);
        assertEquals(-1.0, result, DELTA);
    }

    @Test
    public void testGetItWithLargeValues() throws DoubleNanException, ZeroPrecision, InvalidPrecision {
        double result = Sin.getIt(Math.PI * 3, 0.0001);
        assertEquals(0.0, result, DELTA);
    }

    @Test
    public void testHighLowBoundFinder() throws InvalidPrecision, ZeroPrecision {
        double bound = Sin.highLowBoundFinder(0.1);
        assertTrue(bound > 0);
    }

    @Test(expected = ZeroPrecision.class)
    public void testHighLowBoundFinderWithZeroPrecision() throws InvalidPrecision, ZeroPrecision {
        Sin.highLowBoundFinder(0);
    }

    @Test
    public void testSinImplementsIFunc() {
        Sin sin = new Sin();
        assertTrue(sin instanceof IFunc);
    }
}
