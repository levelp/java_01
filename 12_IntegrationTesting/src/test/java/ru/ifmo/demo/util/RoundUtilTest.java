package ru.ifmo.demo.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class RoundUtilTest {

    @Test
    public void testRoundUPBasic() {
        assertEquals(1.23, RoundUtil.roundUP(1.234, 2), 0.001);
        assertEquals(1.24, RoundUtil.roundUP(1.235, 2), 0.001);
    }

    @Test
    public void testRoundUPZeroPlaces() {
        assertEquals(1.0, RoundUtil.roundUP(1.234, 0), 0.001);
        assertEquals(2.0, RoundUtil.roundUP(1.5, 0), 0.001);
    }

    @Test
    public void testRoundUPOnePlaces() {
        assertEquals(1.2, RoundUtil.roundUP(1.23, 1), 0.001);
        assertEquals(1.3, RoundUtil.roundUP(1.25, 1), 0.001);
    }

    @Test
    public void testRoundUPThreePlaces() {
        assertEquals(1.235, RoundUtil.roundUP(1.2345, 3), 0.0001);
    }

    @Test
    public void testRoundUPNegativeValue() {
        assertEquals(-1.23, RoundUtil.roundUP(-1.234, 2), 0.001);
        assertEquals(-1.24, RoundUtil.roundUP(-1.235, 2), 0.001);
    }

    @Test
    public void testRoundUPZeroValue() {
        assertEquals(0.0, RoundUtil.roundUP(0.0, 2), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRoundUPNegativePlaces() {
        RoundUtil.roundUP(1.234, -1);
    }

    @Test
    public void testRoundUPLargeValue() {
        assertEquals(1234.57, RoundUtil.roundUP(1234.5678, 2), 0.001);
    }

    @Test
    public void testRoundUPSmallValue() {
        assertEquals(0.001, RoundUtil.roundUP(0.0012, 3), 0.0001);
    }

    @Test
    public void testRoundUPHalfUp() {
        // Test that it rounds half up (0.5 rounds to 1, not 0)
        assertEquals(1.0, RoundUtil.roundUP(0.5, 0), 0.001);
        assertEquals(2.0, RoundUtil.roundUP(1.5, 0), 0.001);
    }
}
