package shapes;

import org.junit.Test;

import static org.junit.Assert.*;

public class CircleTest {

    private static final double DELTA = 0.0001;

    @Test
    public void testCircleConstruction() {
        Circle circle = new Circle(5.0);
        assertNotNull(circle);
    }

    @Test
    public void testCircleArea() {
        Circle circle = new Circle(1.0);
        assertEquals(Math.PI, circle.area(), DELTA);
    }

    @Test
    public void testCircleAreaWithDifferentRadius() {
        Circle circle = new Circle(2.0);
        assertEquals(Math.PI * 4, circle.area(), DELTA);
    }

    @Test
    public void testCircleAreaWithZeroRadius() {
        Circle circle = new Circle(0.0);
        assertEquals(0.0, circle.area(), DELTA);
    }

    @Test
    public void testCircleShow() {
        Circle circle = new Circle(3.0);
        String result = circle.show();
        assertTrue(result.contains("3.0"));
        assertTrue(result.contains("" + (Math.PI * 9)));
    }

    @Test
    public void testCircleExtendsShape() {
        Circle circle = new Circle(1.0);
        assertTrue(circle instanceof Shape);
    }

    @Test
    public void testCircleAreaFormula() {
        // Test that area = π * r^2
        Circle circle = new Circle(10.0);
        assertEquals(Math.PI * 100, circle.area(), DELTA);
    }

    @Test
    public void testCircleWithLargeRadius() {
        Circle circle = new Circle(1000.0);
        assertEquals(Math.PI * 1000000, circle.area(), DELTA);
    }

    @Test
    public void testCircleShowFormat() {
        Circle circle = new Circle(5.0);
        String result = circle.show();
        assertNotNull(result);
        assertFalse(result.isEmpty());
    }
}
