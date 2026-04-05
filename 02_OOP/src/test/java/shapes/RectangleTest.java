package shapes;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Comprehensive test class for Rectangle
 */
public class RectangleTest {

    private static final double DELTA = 1e-10;

    @Test
    public void testConstructor() {
        Rectangle rect = new Rectangle(5.0, 10.0);
        assertNotNull("Constructor should create non-null instance", rect);
    }

    @Test
    public void testConstructorWithZeroSides() {
        Rectangle rect = new Rectangle(0.0, 0.0);
        assertNotNull("Constructor should create rectangle with zero sides", rect);
    }

    @Test
    public void testConstructorWithOneSideZero() {
        Rectangle rect1 = new Rectangle(0.0, 5.0);
        Rectangle rect2 = new Rectangle(5.0, 0.0);
        assertNotNull("Constructor should create rectangle with one zero side", rect1);
        assertNotNull("Constructor should create rectangle with one zero side", rect2);
    }

    @Test
    public void testAreaBasic() {
        Rectangle rect = new Rectangle(5.0, 10.0);
        assertEquals("Area should be 50.0", 50.0, rect.area(), DELTA);
    }

    @Test
    public void testAreaUnitSquare() {
        Rectangle rect = new Rectangle(1.0, 1.0);
        assertEquals("Area of 1x1 rectangle should be 1", 1.0, rect.area(), DELTA);
    }

    @Test
    public void testAreaWithZeroSides() {
        Rectangle rect = new Rectangle(0.0, 0.0);
        assertEquals("Area of 0x0 rectangle should be 0", 0.0, rect.area(), DELTA);
    }

    @Test
    public void testAreaWithOneSideZero() {
        Rectangle rect = new Rectangle(5.0, 0.0);
        assertEquals("Area of 5x0 rectangle should be 0", 0.0, rect.area(), DELTA);
    }

    @Test
    public void testAreaWithDecimalSides() {
        Rectangle rect = new Rectangle(2.5, 3.5);
        assertEquals("Area of 2.5x3.5 rectangle should be 8.75", 8.75, rect.area(), DELTA);
    }

    @Test
    public void testAreaWithEqualSides() {
        Rectangle rect = new Rectangle(5.0, 5.0);
        assertEquals("Area of 5x5 rectangle should be 25", 25.0, rect.area(), DELTA);
    }

    @Test
    public void testShow() {
        Rectangle rect = new Rectangle(10.0, 3.0);
        String result = rect.show();
        assertTrue("Show should contain 'Прямоугольник'", result.contains("Прямоугольник"));
        assertTrue("Show should contain 'a ='", result.contains("a ="));
        assertTrue("Show should contain 'b ='", result.contains("b ="));
        assertTrue("Show should contain 'площадь'", result.contains("площадь"));
    }

    @Test
    public void testShowContainsSideValues() {
        Rectangle rect = new Rectangle(2.0, 3.5);
        String result = rect.show();
        assertTrue("Show should contain first side value", result.contains("2.0"));
        assertTrue("Show should contain second side value", result.contains("3.5"));
    }

    @Test
    public void testShowFormat() {
        Rectangle rect = new Rectangle(2.0, 3.5);
        String expected = "Прямоугольник: a = 2.0 b = 3.5 площадь 7.0";
        assertEquals("Show should return formatted string", expected, rect.show());
    }

    @Test
    public void testExtendsShape() {
        Rectangle rect = new Rectangle(1.0, 1.0);
        assertTrue("Rectangle should extend Shape", rect instanceof Shape);
    }

    @Test
    public void testPolymorphism() {
        Shape shape = new Rectangle(4.0, 5.0);
        assertEquals("Polymorphic area call should work", 20.0, shape.area(), DELTA);
    }

    @Test
    public void testPolymorphicShow() {
        Shape shape = new Rectangle(4.0, 5.0);
        String result = shape.show();
        assertTrue("Polymorphic show should work", result.contains("Прямоугольник"));
    }

    @Test
    public void testMultipleRectangles() {
        Rectangle r1 = new Rectangle(1.0, 2.0);
        Rectangle r2 = new Rectangle(3.0, 4.0);
        Rectangle r3 = new Rectangle(5.0, 6.0);

        assertEquals("First rectangle area", 2.0, r1.area(), DELTA);
        assertEquals("Second rectangle area", 12.0, r2.area(), DELTA);
        assertEquals("Third rectangle area", 30.0, r3.area(), DELTA);
    }

    @Test
    public void testLargeSides() {
        Rectangle rect = new Rectangle(1000000.0, 2000000.0);
        assertEquals("Area with large sides", 2e12, rect.area(), 1e5);
    }

    @Test
    public void testSmallSides() {
        Rectangle rect = new Rectangle(0.001, 0.002);
        assertEquals("Area with small sides", 0.000002, rect.area(), 1e-12);
    }

    @Test
    public void testAreaFormula() {
        double a = 7.5;
        double b = 3.25;
        Rectangle rect = new Rectangle(a, b);
        assertEquals("Area should follow a*b formula", a * b, rect.area(), DELTA);
    }
}
