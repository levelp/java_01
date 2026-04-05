package ru.ifmo.demo.util;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Comprehensive test class for RoundUtil
 */
public class RoundUtilTest {

    private static final double DELTA = 0.000001;

    @Test
    public void testRoundUPWithZeroPlaces() {
        double result = RoundUtil.roundUP(3.14159, 0);
        assertEquals(3.0, result, DELTA);
    }

    @Test
    public void testRoundUPWithOnePlaces() {
        double result = RoundUtil.roundUP(3.14159, 1);
        assertEquals(3.1, result, DELTA);
    }

    @Test
    public void testRoundUPWithTwoPlaces() {
        double result = RoundUtil.roundUP(3.14159, 2);
        assertEquals(3.14, result, DELTA);
    }

    @Test
    public void testRoundUPWithThreePlaces() {
        double result = RoundUtil.roundUP(3.14159, 3);
        assertEquals(3.142, result, DELTA);
    }

    @Test
    public void testRoundUPWithFivePlaces() {
        double result = RoundUtil.roundUP(3.14159265, 5);
        assertEquals(3.14159, result, DELTA);
    }

    @Test
    public void testRoundUPHalfUp() {
        // Test HALF_UP rounding mode: 2.5 rounds to 3
        double result = RoundUtil.roundUP(2.5, 0);
        assertEquals(3.0, result, DELTA);
    }

    @Test
    public void testRoundUPHalfUpNegative() {
        // Test HALF_UP rounding mode: -2.5 rounds to -3
        double result = RoundUtil.roundUP(-2.5, 0);
        assertEquals(-3.0, result, DELTA);
    }

    @Test
    public void testRoundUPWithNegativeValue() {
        double result = RoundUtil.roundUP(-3.14159, 2);
        assertEquals(-3.14, result, DELTA);
    }

    @Test
    public void testRoundUPWithZeroValue() {
        double result = RoundUtil.roundUP(0.0, 2);
        assertEquals(0.0, result, DELTA);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRoundUPWithNegativePlaces() {
        RoundUtil.roundUP(3.14159, -1);
    }

    @Test
    public void testRoundUPWithLargeValue() {
        double result = RoundUtil.roundUP(123456.789, 2);
        assertEquals(123456.79, result, DELTA);
    }

    @Test
    public void testRoundUPWithSmallValue() {
        double result = RoundUtil.roundUP(0.00012345, 5);
        assertEquals(0.00012, result, DELTA);
    }

    @Test
    public void testRoundUPWithVeryLargePlaces() {
        double result = RoundUtil.roundUP(3.14159, 10);
        assertEquals(3.14159, result, DELTA);
    }

    @Test
    public void testRoundUPBoundaryCase() {
        double result = RoundUtil.roundUP(1.445, 2);
        assertEquals(1.45, result, DELTA);
    }

    @Test
    public void testRoundUPWithInfinity() {
        double result = RoundUtil.roundUP(Double.POSITIVE_INFINITY, 2);
        assertTrue(Double.isInfinite(result));
    }

    @Test
    public void testRoundUPWithNaN() {
        double result = RoundUtil.roundUP(Double.NaN, 2);
        assertTrue(Double.isNaN(result));
    }
}
