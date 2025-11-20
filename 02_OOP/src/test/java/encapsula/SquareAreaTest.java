package encapsula;

import org.junit.Test;

import static org.junit.Assert.*;

public class SquareAreaTest {

    private static final double DELTA = 0.0001;

    @Test
    public void testSquareAreaConstruction() {
        SquareArea square = new SquareArea();
        assertNotNull(square);
    }

    @Test
    public void testSetSide() {
        SquareArea square = new SquareArea();
        square.setSide(5.0);
        assertEquals(25.0, square.getArea(), DELTA);
    }

    @Test
    public void testGetSide() {
        SquareArea square = new SquareArea();
        square.setSide(4.0);
        assertEquals(4.0, square.getSide(), DELTA);
    }

    @Test
    public void testSetArea() {
        SquareArea square = new SquareArea();
        square.setArea(16.0);
        assertEquals(16.0, square.getArea(), DELTA);
    }

    @Test
    public void testGetArea() {
        SquareArea square = new SquareArea();
        square.setArea(25.0);
        assertEquals(25.0, square.getArea(), DELTA);
    }

    @Test
    public void testSetSideCalculatesArea() {
        SquareArea square = new SquareArea();
        square.setSide(10.0);
        assertEquals(100.0, square.getArea(), DELTA);
        assertEquals(10.0, square.getSide(), DELTA);
    }

    @Test
    public void testSetAreaCalculatesSide() {
        SquareArea square = new SquareArea();
        square.setArea(100.0);
        assertEquals(10.0, square.getSide(), DELTA);
    }

    @Test
    public void testImplementsSquareInterface() {
        SquareArea square = new SquareArea();
        assertTrue(square instanceof Square);
    }

    @Test
    public void testZeroSide() {
        SquareArea square = new SquareArea();
        square.setSide(0.0);
        assertEquals(0.0, square.getArea(), DELTA);
    }

    @Test
    public void testZeroArea() {
        SquareArea square = new SquareArea();
        square.setArea(0.0);
        assertEquals(0.0, square.getSide(), DELTA);
    }

    @Test
    public void testConsistencyAfterMultipleOperations() {
        SquareArea square = new SquareArea();
        square.setSide(3.0);
        assertEquals(9.0, square.getArea(), DELTA);
        square.setArea(16.0);
        assertEquals(4.0, square.getSide(), DELTA);
    }
}
