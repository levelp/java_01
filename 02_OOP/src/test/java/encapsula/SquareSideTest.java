package encapsula;

import org.junit.Test;

import static org.junit.Assert.*;

public class SquareSideTest {

    private static final double DELTA = 0.0001;

    @Test
    public void testSquareSideConstruction() {
        SquareSide square = new SquareSide();
        assertNotNull(square);
    }

    @Test
    public void testSetSide() {
        SquareSide square = new SquareSide();
        square.setSide(5.0);
        assertEquals(5.0, square.getSide(), DELTA);
    }

    @Test
    public void testGetSide() {
        SquareSide square = new SquareSide();
        square.setSide(4.0);
        assertEquals(4.0, square.getSide(), DELTA);
    }

    @Test
    public void testSetArea() {
        SquareSide square = new SquareSide();
        square.setArea(16.0);
        assertEquals(4.0, square.getSide(), DELTA);
    }

    @Test
    public void testGetArea() {
        SquareSide square = new SquareSide();
        square.setSide(5.0);
        assertEquals(25.0, square.getArea(), DELTA);
    }

    @Test
    public void testSetSideCalculatesArea() {
        SquareSide square = new SquareSide();
        square.setSide(10.0);
        assertEquals(100.0, square.getArea(), DELTA);
    }

    @Test
    public void testSetAreaCalculatesSide() {
        SquareSide square = new SquareSide();
        square.setArea(100.0);
        assertEquals(10.0, square.getSide(), DELTA);
        assertEquals(100.0, square.getArea(), DELTA);
    }

    @Test
    public void testImplementsSquareInterface() {
        SquareSide square = new SquareSide();
        assertTrue(square instanceof Square);
    }

    @Test
    public void testZeroSide() {
        SquareSide square = new SquareSide();
        square.setSide(0.0);
        assertEquals(0.0, square.getArea(), DELTA);
    }

    @Test
    public void testZeroArea() {
        SquareSide square = new SquareSide();
        square.setArea(0.0);
        assertEquals(0.0, square.getSide(), DELTA);
    }

    @Test
    public void testConsistencyAfterMultipleOperations() {
        SquareSide square = new SquareSide();
        square.setSide(3.0);
        assertEquals(9.0, square.getArea(), DELTA);
        square.setArea(16.0);
        assertEquals(4.0, square.getSide(), DELTA);
    }

    @Test
    public void testDecimalSide() {
        SquareSide square = new SquareSide();
        square.setSide(2.5);
        assertEquals(6.25, square.getArea(), DELTA);
    }
}
