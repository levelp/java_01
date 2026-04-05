package shapes;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

/**
 * Comprehensive test class for Point2D
 */
public class Point2DTest {

    @Before
    public void resetCounter() {
        // Reset static counter before each test
        Point2D.count = 0;
    }

    @Test
    public void testConstructor() {
        Point2D point = new Point2D(5, 10);
        assertNotNull("Constructor should create non-null instance", point);
    }

    @Test
    public void testConstructorSetsX() {
        Point2D point = new Point2D(5, 10);
        assertEquals("X coordinate should be 5", 5, point.x);
    }

    @Test
    public void testConstructorSetsY() {
        Point2D point = new Point2D(5, 10);
        assertEquals("Y coordinate should be 10", 10, point.y);
    }

    @Test
    public void testConstructorIncrementsCount() {
        assertEquals("Initial count should be 0", 0, Point2D.count);
        Point2D point1 = new Point2D(0, 0);
        assertEquals("Count should be 1 after first point", 1, Point2D.count);
        Point2D point2 = new Point2D(1, 1);
        assertEquals("Count should be 2 after second point", 2, Point2D.count);
    }

    @Test
    public void testConstructorWithZeroCoordinates() {
        Point2D point = new Point2D(0, 0);
        assertEquals("X should be 0", 0, point.x);
        assertEquals("Y should be 0", 0, point.y);
    }

    @Test
    public void testConstructorWithNegativeCoordinates() {
        Point2D point = new Point2D(-5, -10);
        assertEquals("X should be -5", -5, point.x);
        assertEquals("Y should be -10", -10, point.y);
    }

    @Test
    public void testMove() {
        Point2D point = new Point2D(5, 10);
        point.move(3, 4);
        assertEquals("X should be 8 after move", 8, point.x);
        assertEquals("Y should be 14 after move", 14, point.y);
    }

    @Test
    public void testMoveNegative() {
        Point2D point = new Point2D(5, 10);
        point.move(-3, -4);
        assertEquals("X should be 2 after move", 2, point.x);
        assertEquals("Y should be 6 after move", 6, point.y);
    }

    @Test
    public void testMoveZero() {
        Point2D point = new Point2D(5, 10);
        point.move(0, 0);
        assertEquals("X should remain 5", 5, point.x);
        assertEquals("Y should remain 10", 10, point.y);
    }

    @Test
    public void testShow() {
        Point2D point = new Point2D(5, 10);
        String result = point.show();
        assertEquals("Show should return correct string", "Точка (5;10)", result);
    }

    @Test
    public void testShowWithZeroCoordinates() {
        Point2D point = new Point2D(0, 0);
        String result = point.show();
        assertEquals("Show should return correct string for origin", "Точка (0;0)", result);
    }

    @Test
    public void testShowWithNegativeCoordinates() {
        Point2D point = new Point2D(-5, -10);
        String result = point.show();
        assertEquals("Show should return correct string for negative coords", "Точка (-5;-10)", result);
    }

    @Test
    public void testArea() {
        Point2D point = new Point2D(5, 10);
        double area = point.area();
        assertEquals("Point area should be 0.0", 0.0, area, 1e-10);
    }

    @Test
    public void testAreaAlwaysZero() {
        Point2D point1 = new Point2D(0, 0);
        Point2D point2 = new Point2D(100, 100);
        Point2D point3 = new Point2D(-100, -100);

        assertEquals("Area should always be 0", 0.0, point1.area(), 1e-10);
        assertEquals("Area should always be 0", 0.0, point2.area(), 1e-10);
        assertEquals("Area should always be 0", 0.0, point3.area(), 1e-10);
    }

    @Test
    public void testExtendsShape() {
        Point2D point = new Point2D(0, 0);
        assertTrue("Point2D should extend Shape", point instanceof Shape);
    }

    @Test
    public void testStaticCount() {
        Point2D p1 = new Point2D(1, 1);
        Point2D p2 = new Point2D(2, 2);
        Point2D p3 = new Point2D(3, 3);
        assertEquals("Static count should track all instances", 3, Point2D.count);
    }

    @Test
    public void testCoordinatesFieldExists() {
        Point2D point = new Point2D(0, 0);
        // coordinates field may be null by default
        assertNull("Coordinates should be null by default", point.coordinates);
    }

    @Test
    public void testInnerClassCoordinates() {
        Point2D.Coordinates coords = new Point2D.Coordinates();
        assertNotNull("Coordinates inner class should be instantiable", coords);

        coords.x = 10;
        coords.y = 20;

        assertEquals("Coordinates x should be 10", 10, coords.x);
        assertEquals("Coordinates y should be 20", 20, coords.y);
    }

    @Test
    public void testInnerClassCoordinatesDefaultValues() {
        Point2D.Coordinates coords = new Point2D.Coordinates();
        assertEquals("Default x should be 0", 0, coords.x);
        assertEquals("Default y should be 0", 0, coords.y);
    }

    @Test
    public void testMultipleMoves() {
        Point2D point = new Point2D(0, 0);
        point.move(5, 5);
        point.move(3, -2);
        point.move(-1, 1);
        assertEquals("X should be 7 after multiple moves", 7, point.x);
        assertEquals("Y should be 4 after multiple moves", 4, point.y);
    }

    @Test
    public void testMoveWithLargeValues() {
        Point2D point = new Point2D(0, 0);
        point.move(Integer.MAX_VALUE / 2, Integer.MAX_VALUE / 2);
        assertEquals("X should handle large values", Integer.MAX_VALUE / 2, point.x);
        assertEquals("Y should handle large values", Integer.MAX_VALUE / 2, point.y);
    }
}
