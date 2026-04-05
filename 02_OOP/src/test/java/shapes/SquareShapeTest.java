package shapes;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Comprehensive test class for shapes.Square
 */
public class SquareShapeTest {

    private static final double DELTA = 1e-10;

    @Test
    public void testConstructor() {
        Square square = new Square(5.0);
        assertNotNull("Constructor should create non-null instance", square);
    }

    @Test
    public void testConstructorWithZeroSide() {
        Square square = new Square(0.0);
        assertNotNull("Constructor should create square with zero side", square);
    }

    @Test
    public void testConstructorWithSmallSide() {
        Square square = new Square(0.001);
        assertNotNull("Constructor should create square with small side", square);
    }

    @Test
    public void testConstructorWithLargeSide() {
        Square square = new Square(1000000.0);
        assertNotNull("Constructor should create square with large side", square);
    }

    @Test
    public void testAreaWithUnitSide() {
        Square square = new Square(1.0);
        assertEquals("Area of square with side 1 should be 1", 1.0, square.area(), DELTA);
    }

    @Test
    public void testAreaWithSideTwo() {
        Square square = new Square(2.0);
        assertEquals("Area of square with side 2 should be 4", 4.0, square.area(), DELTA);
    }

    @Test
    public void testAreaWithSideFive() {
        Square square = new Square(5.0);
        assertEquals("Area of square with side 5 should be 25", 25.0, square.area(), DELTA);
    }

    @Test
    public void testAreaWithZeroSide() {
        Square square = new Square(0.0);
        assertEquals("Area of square with zero side should be 0", 0.0, square.area(), DELTA);
    }

    @Test
    public void testAreaWithDecimalSide() {
        Square square = new Square(2.5);
        assertEquals("Area of square with side 2.5 should be 6.25", 6.25, square.area(), DELTA);
    }

    @Test
    public void testShow() {
        Square square = new Square(4.0);
        String result = square.show();
        assertTrue("Show should contain 'Квадрат'", result.contains("Квадрат"));
        assertTrue("Show should contain 'сторона'", result.contains("сторона"));
        assertTrue("Show should contain '4.0'", result.contains("4.0"));
        assertTrue("Show should contain 'площадь'", result.contains("площадь"));
    }

    @Test
    public void testShowWithUnitSide() {
        Square square = new Square(1.0);
        String result = square.show();
        assertTrue("Show should contain side value", result.contains("1.0"));
        assertTrue("Show should contain area value", result.contains("1.0"));
    }

    @Test
    public void testShowFormat() {
        Square square = new Square(3.0);
        String expected = "Квадрат: сторона 3.0 площадь 9.0";
        assertEquals("Show should return formatted string", expected, square.show());
    }

    @Test
    public void testExtendsShape() {
        Square square = new Square(1.0);
        assertTrue("Square should extend Shape", square instanceof Shape);
    }

    @Test
    public void testPolymorphism() {
        Shape shape = new Square(4.0);
        assertEquals("Polymorphic area call should work", 16.0, shape.area(), DELTA);
    }

    @Test
    public void testPolymorphicShow() {
        Shape shape = new Square(4.0);
        String result = shape.show();
        assertTrue("Polymorphic show should work", result.contains("Квадрат"));
    }

    @Test
    public void testMultipleSquares() {
        Square s1 = new Square(1.0);
        Square s2 = new Square(2.0);
        Square s3 = new Square(3.0);

        assertEquals("First square area should be 1", 1.0, s1.area(), DELTA);
        assertEquals("Second square area should be 4", 4.0, s2.area(), DELTA);
        assertEquals("Third square area should be 9", 9.0, s3.area(), DELTA);
    }

    @Test
    public void testAreaFormula() {
        double side = 7.5;
        Square square = new Square(side);
        double expectedArea = Math.pow(side, 2);
        assertEquals("Area should follow side^2 formula", expectedArea, square.area(), DELTA);
    }

    @Test
    public void testVeryLargeSide() {
        Square square = new Square(1e10);
        double expectedArea = Math.pow(1e10, 2);
        assertEquals("Area should work for very large side", expectedArea, square.area(), 1e10);
    }

    @Test
    public void testVerySmallSide() {
        Square square = new Square(1e-5);
        double expectedArea = Math.pow(1e-5, 2);
        assertEquals("Area should work for very small side", expectedArea, square.area(), 1e-15);
    }

    @Test
    public void testShowWithDecimalSide() {
        Square square = new Square(2.5);
        String result = square.show();
        assertTrue("Show should contain decimal side", result.contains("2.5"));
        assertTrue("Show should contain decimal area", result.contains("6.25"));
    }
}
