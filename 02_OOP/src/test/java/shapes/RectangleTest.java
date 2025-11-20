package shapes;

import org.junit.Test;

import static org.junit.Assert.*;

public class RectangleTest {

    private static final double DELTA = 0.0001;

    @Test
    public void testRectangleConstruction() {
        Rectangle rectangle = new Rectangle(5.0, 10.0);
        assertNotNull(rectangle);
    }

    @Test
    public void testRectangleArea() {
        Rectangle rectangle = new Rectangle(5.0, 10.0);
        assertEquals(50.0, rectangle.area(), DELTA);
    }

    @Test
    public void testRectangleAreaWithEqualSides() {
        Rectangle rectangle = new Rectangle(7.0, 7.0);
        assertEquals(49.0, rectangle.area(), DELTA);
    }

    @Test
    public void testRectangleAreaWithZero() {
        Rectangle rectangle = new Rectangle(0.0, 10.0);
        assertEquals(0.0, rectangle.area(), DELTA);
    }

    @Test
    public void testRectangleShow() {
        Rectangle rectangle = new Rectangle(3.0, 4.0);
        String result = rectangle.show();
        assertTrue(result.contains("3.0"));
        assertTrue(result.contains("4.0"));
        assertTrue(result.contains("12.0"));
    }

    @Test
    public void testRectangleExtendsShape() {
        Rectangle rectangle = new Rectangle(1.0, 2.0);
        assertTrue(rectangle instanceof Shape);
    }

    @Test
    public void testRectangleAreaFormula() {
        // Test that area = a * b
        Rectangle rectangle = new Rectangle(12.5, 8.0);
        assertEquals(100.0, rectangle.area(), DELTA);
    }

    @Test
    public void testRectangleWithLargeSides() {
        Rectangle rectangle = new Rectangle(1000.0, 2000.0);
        assertEquals(2000000.0, rectangle.area(), DELTA);
    }

    @Test
    public void testRectangleWithDecimalSides() {
        Rectangle rectangle = new Rectangle(2.5, 3.5);
        assertEquals(8.75, rectangle.area(), DELTA);
    }

    @Test
    public void testRectangleShowFormat() {
        Rectangle rectangle = new Rectangle(5.0, 6.0);
        String result = rectangle.show();
        assertNotNull(result);
        assertFalse(result.isEmpty());
    }
}
