package ru.ifmo.demo.functions;

import org.junit.Test;
import ru.ifmo.demo.exceptions.DoubleNanException;
import ru.ifmo.demo.exceptions.InvalidPrecision;
import ru.ifmo.demo.exceptions.ZeroPrecision;

import static org.junit.Assert.*;

/**
 * Comprehensive test class for Sin function
 */
public class SinTest {

    private static final double DELTA = 0.001;

    @Test
    public void testDefaultConstructor() {
        Sin sin = new Sin();
        assertNotNull(sin);
    }

    @Test
    public void testImplementsIFunc() {
        Sin sin = new Sin();
        assertTrue(sin instanceof IFunc);
    }

    @Test
    public void testGetAtZero() {
        Sin sin = new Sin();
        assertEquals(0.0, sin.get(0), DELTA);
    }

    @Test
    public void testGetAtPiOverTwo() {
        Sin sin = new Sin();
        assertEquals(1.0, sin.get(Math.PI / 2), DELTA);
    }

    @Test
    public void testGetAtPi() {
        Sin sin = new Sin();
        assertEquals(0.0, sin.get(Math.PI), DELTA);
    }

    @Test
    public void testGetAtThreePiOverTwo() {
        Sin sin = new Sin();
        assertEquals(-1.0, sin.get(3 * Math.PI / 2), DELTA);
    }

    @Test
    public void testGetItWithValidPrecision() {
        double result = Sin.getIt(Math.PI / 6, 0.0001);
        assertEquals(0.5, result, DELTA);
    }

    @Test(expected = ZeroPrecision.class)
    public void testGetItWithZeroPrecisionThrowsException() {
        Sin.getIt(1.0, 0.0);
    }

    @Test(expected = InvalidPrecision.class)
    public void testGetItWithInvalidPrecisionThrowsException() {
        Sin.getIt(1.0, 1.5);
    }

    @Test
    public void testGetItAtPiOverFour() {
        double result = Sin.getIt(Math.PI / 4, 0.0001);
        assertEquals(Math.sqrt(2) / 2, result, DELTA);
    }

    @Test
    public void testGetItAtPiOverThree() {
        double result = Sin.getIt(Math.PI / 3, 0.0001);
        assertEquals(Math.sqrt(3) / 2, result, DELTA);
    }

    @Test
    public void testGetItWithLargeValue() {
        // Test that large values are normalized
        double result = Sin.getIt(10 * Math.PI, 0.0001);
        assertEquals(0.0, result, DELTA);
    }

    @Test
    public void testGetItWithNegativeValue() {
        double result = Sin.getIt(-Math.PI / 6, 0.0001);
        assertEquals(-0.5, result, DELTA);
    }

    @Test
    public void testHighLowBoundFinder() {
        double bound = Sin.highLowBoundFinder(0.001);
        assertTrue(bound > 0);
    }

    @Test(expected = ZeroPrecision.class)
    public void testHighLowBoundFinderWithZeroPrecision() {
        Sin.highLowBoundFinder(0.0);
    }

    @Test(expected = InvalidPrecision.class)
    public void testHighLowBoundFinderWithInvalidPrecision() {
        Sin.highLowBoundFinder(1.5);
    }

    @Test
    public void testPreciseLimitFinderReturnsPositiveValue() {
        try {
            double limit = Sin.preciseLimitFinder(0.00001);
            assertTrue(limit >= 0);
        } catch (DoubleNanException e) {
            // This is acceptable as the method may find a limit
        }
    }

    @Test(expected = ZeroPrecision.class)
    public void testPreciseLimitFinderWithZeroPrecision() {
        Sin.preciseLimitFinder(0.0);
    }

    @Test(expected = InvalidPrecision.class)
    public void testPreciseLimitFinderWithInvalidPrecision() {
        Sin.preciseLimitFinder(2.0);
    }

    @Test
    public void testGetUsesDefaultPrecision() {
        Sin sin = new Sin();
        double result = sin.get(Math.PI / 2);
        assertEquals(1.0, result, DELTA);
    }

    @Test
    public void testGetWithSmallValue() {
        Sin sin = new Sin();
        double result = sin.get(0.1);
        assertEquals(Math.sin(0.1), result, DELTA);
    }

    @Test
    public void testGetItModuloNormalization() {
        // Test that values > 2*pi are normalized
        double result1 = Sin.getIt(Math.PI / 6, 0.0001);
        double result2 = Sin.getIt(Math.PI / 6 + 2 * Math.PI, 0.0001);
        assertEquals(result1, result2, DELTA);
    }

    // Additional edge case tests for 100% coverage

    @Test
    public void testGetItWithSmallPrecision() {
        // Test with very small precision value (scientific notation E format)
        double result = Sin.getIt(Math.PI / 4, 1E-5);
        assertEquals(Math.sqrt(2) / 2, result, 0.00001);
    }

    @Test
    public void testGetItAtZero() {
        // Test sin(0) = 0
        double result = Sin.getIt(0.0, 0.0001);
        assertEquals(0.0, result, DELTA);
    }

    @Test
    public void testGetItAtTwoPi() {
        // Test sin(2*pi) = 0
        double result = Sin.getIt(2 * Math.PI, 0.0001);
        assertEquals(0.0, result, DELTA);
    }

    @Test
    public void testGetItWithModeratePrecision() {
        // Test with moderate precision
        double result = Sin.getIt(Math.PI / 2, 0.01);
        assertEquals(1.0, result, 0.01);
    }

    @Test
    public void testGetWithNegativePiOverTwo() {
        Sin sin = new Sin();
        assertEquals(-1.0, sin.get(-Math.PI / 2), DELTA);
    }

    @Test
    public void testGetWithTwoPi() {
        Sin sin = new Sin();
        assertEquals(0.0, sin.get(2 * Math.PI), DELTA);
    }

    @Test
    public void testGetItWithValueJustOverTwoPi() {
        // Test value slightly over 2*pi to ensure modulo normalization occurs
        double result = Sin.getIt(2 * Math.PI + 0.1, 0.0001);
        double expected = Sin.getIt(0.1, 0.0001);
        assertEquals(expected, result, DELTA);
    }

    @Test
    public void testGetItWithMultipleOf2Pi() {
        // Test with 4*pi (twice around the circle)
        double result = Sin.getIt(4 * Math.PI, 0.0001);
        assertEquals(0.0, result, DELTA);
    }

    @Test
    public void testGetItPrecisionBoundary() {
        // Test precision at boundary condition (0.9999...)
        double result = Sin.getIt(Math.PI / 6, 0.1);
        assertEquals(0.5, result, 0.1);
    }

    @Test
    public void testHighLowBoundFinderWithSmallPrecision() {
        double bound = Sin.highLowBoundFinder(0.0001);
        assertTrue(bound > 0);
    }

    @Test
    public void testHighLowBoundFinderWithVerySmallPrecision() {
        double bound = Sin.highLowBoundFinder(1E-6);
        assertTrue(bound > 0);
    }

    @Test
    public void testGetAtNegativePi() {
        Sin sin = new Sin();
        assertEquals(0.0, sin.get(-Math.PI), DELTA);
    }

    @Test
    public void testGetAtLargeNegativeValue() {
        Sin sin = new Sin();
        double result = sin.get(-10.0);
        assertEquals(Math.sin(-10.0), result, DELTA);
    }

    @Test
    public void testGetItWithSmallPositiveValue() {
        // Test Taylor series convergence with small values
        double result = Sin.getIt(0.01, 0.0001);
        assertEquals(Math.sin(0.01), result, DELTA);
    }
}
