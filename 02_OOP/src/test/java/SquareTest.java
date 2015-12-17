import encapsula.Square;
import encapsula.SquareArea;
import encapsula.SquareSide;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 */
public class SquareTest {

    @Test
    public void testSideArea() {
        Square square = new SquareSide();
        testSquare(square);
        testSquare(new SquareArea());
    }

    private void testSquare(Square square) {
        square.setSide(10);
        System.out.println("square.getSide() = " +
                square.getSide());
        System.out.println("square.getArea() = " +
                square.getArea());
        assertEquals(10.0, square.getSide(), 1e-16);
        assertEquals(100.0, square.getArea(), 1e-16);

        square.setArea(144);
        System.out.println("square.getSide() = " +
                square.getSide());
        System.out.println("square.getArea() = " +
                square.getArea());
        assertEquals(12.0, square.getSide(), 1e-16);
        assertEquals(144.0, square.getArea(), 1e-16);
    }
}
