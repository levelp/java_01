package shapes;

import org.junit.Test;

import static org.junit.Assert.*;

public class Point2DTest {

    @Test
    public void testPoint2DConstruction() {
        Point2D point = new Point2D(5, 10);
        assertNotNull(point);
        assertEquals(5, point.x);
        assertEquals(10, point.y);
    }

    @Test
    public void testPoint2DMove() {
        Point2D point = new Point2D(0, 0);
        point.move(5, 10);
        assertEquals(5, point.x);
        assertEquals(10, point.y);
    }

    @Test
    public void testPoint2DMoveMultipleTimes() {
        Point2D point = new Point2D(1, 1);
        point.move(2, 3);
        assertEquals(3, point.x);
        assertEquals(4, point.y);
        point.move(-1, -2);
        assertEquals(2, point.x);
        assertEquals(2, point.y);
    }

    @Test
    public void testPoint2DShow() {
        Point2D point = new Point2D(7, 8);
        String result = point.show();
        assertTrue(result.contains("7"));
        assertTrue(result.contains("8"));
    }

    @Test
    public void testPoint2DArea() {
        Point2D point = new Point2D(5, 10);
        assertEquals(0.0, point.area(), 0.0);
    }

    @Test
    public void testPoint2DExtendsShape() {
        Point2D point = new Point2D(1, 2);
        assertTrue(point instanceof Shape);
    }

    @Test
    public void testPoint2DWithNegativeCoordinates() {
        Point2D point = new Point2D(-5, -10);
        assertEquals(-5, point.x);
        assertEquals(-10, point.y);
    }

    @Test
    public void testPoint2DMoveWithNegativeValues() {
        Point2D point = new Point2D(10, 10);
        point.move(-5, -5);
        assertEquals(5, point.x);
        assertEquals(5, point.y);
    }

    @Test
    public void testPoint2DCoordinatesClass() {
        Point2D.Coordinates coords = new Point2D.Coordinates();
        coords.x = 15;
        coords.y = 20;
        assertEquals(15, coords.x);
        assertEquals(20, coords.y);
    }

    @Test
    public void testPoint2DShowFormat() {
        Point2D point = new Point2D(0, 0);
        String result = point.show();
        assertNotNull(result);
        assertFalse(result.isEmpty());
    }

    @Test
    public void testMultiplePoints() {
        Point2D point1 = new Point2D(1, 2);
        Point2D point2 = new Point2D(3, 4);

        assertNotEquals(point1.x, point2.x);
        assertNotEquals(point1.y, point2.y);
    }
}
