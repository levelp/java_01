package shapes;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Comprehensive test class for Circle
 */
public class CircleTest {

    private static final double DELTA = 1e-10;

    @Test
    public void testConstructor() {
        Circle circle = new Circle(5.0);
        assertNotNull("Constructor should create non-null instance", circle);
    }

    @Test
    public void testConstructorWithZeroRadius() {
        Circle circle = new Circle(0.0);
        assertNotNull("Constructor should create circle with zero radius", circle);
    }

    @Test
    public void testConstructorWithSmallRadius() {
        Circle circle = new Circle(0.001);
        assertNotNull("Constructor should create circle with small radius", circle);
    }

    @Test
    public void testConstructorWithLargeRadius() {
        Circle circle = new Circle(1000000.0);
        assertNotNull("Constructor should create circle with large radius", circle);
    }

    @Test
    public void testAreaWithUnitRadius() {
        Circle circle = new Circle(1.0);
        double expectedArea = Math.PI;
        assertEquals("Area of circle with radius 1 should be PI", expectedArea, circle.area(), DELTA);
    }

    @Test
    public void testAreaWithRadiusTwo() {
        Circle circle = new Circle(2.0);
        double expectedArea = Math.PI * 4;
        assertEquals("Area of circle with radius 2 should be 4*PI", expectedArea, circle.area(), DELTA);
    }

    @Test
    public void testAreaWithRadiusFive() {
        Circle circle = new Circle(5.0);
        double expectedArea = Math.PI * 25;
        assertEquals("Area of circle with radius 5 should be 25*PI", expectedArea, circle.area(), DELTA);
    }

    @Test
    public void testAreaWithZeroRadius() {
        Circle circle = new Circle(0.0);
        assertEquals("Area of circle with zero radius should be 0", 0.0, circle.area(), DELTA);
    }

    @Test
    public void testAreaWithDecimalRadius() {
        Circle circle = new Circle(2.5);
        double expectedArea = Math.PI * 6.25;
        assertEquals("Area of circle with radius 2.5 should be 6.25*PI", expectedArea, circle.area(), DELTA);
    }

    @Test
    public void testShow() {
        Circle circle = new Circle(2.2);
        String result = circle.show();
        assertTrue("Show should contain 'Круг'", result.contains("Круг"));
        assertTrue("Show should contain 'радиус'", result.contains("радиус"));
        assertTrue("Show should contain '2.2'", result.contains("2.2"));
        assertTrue("Show should contain 'площадь'", result.contains("площадь"));
    }

    @Test
    public void testShowWithUnitRadius() {
        Circle circle = new Circle(1.0);
        String result = circle.show();
        assertTrue("Show should contain radius", result.contains("1.0"));
        assertTrue("Show should contain area", result.contains(String.valueOf(Math.PI)));
    }

    @Test
    public void testShowFormat() {
        Circle circle = new Circle(3.0);
        String result = circle.show();
        String expected = "Круг: радиус 3.0 площадь " + (Math.PI * 9);
        assertEquals("Show should return formatted string", expected, result);
    }

    @Test
    public void testExtendsShape() {
        Circle circle = new Circle(1.0);
        assertTrue("Circle should extend Shape", circle instanceof Shape);
    }

    @Test
    public void testPolymorphism() {
        Shape shape = new Circle(2.0);
        assertEquals("Polymorphic area call should work", Math.PI * 4, shape.area(), DELTA);
    }

    @Test
    public void testPolymorphicShow() {
        Shape shape = new Circle(2.0);
        String result = shape.show();
        assertTrue("Polymorphic show should work", result.contains("Круг"));
    }

    @Test
    public void testMultipleCircles() {
        Circle c1 = new Circle(1.0);
        Circle c2 = new Circle(2.0);
        Circle c3 = new Circle(3.0);

        assertEquals("First circle area should be PI", Math.PI, c1.area(), DELTA);
        assertEquals("Second circle area should be 4*PI", 4 * Math.PI, c2.area(), DELTA);
        assertEquals("Third circle area should be 9*PI", 9 * Math.PI, c3.area(), DELTA);
    }

    @Test
    public void testAreaFormula() {
        double radius = 7.5;
        Circle circle = new Circle(radius);
        double expectedArea = Math.PI * Math.pow(radius, 2);
        assertEquals("Area should follow PI*r^2 formula", expectedArea, circle.area(), DELTA);
    }

    @Test
    public void testVeryLargeRadius() {
        Circle circle = new Circle(1e10);
        double expectedArea = Math.PI * Math.pow(1e10, 2);
        assertEquals("Area should work for very large radius", expectedArea, circle.area(), 1e10);
    }

    @Test
    public void testVerySmallRadius() {
        Circle circle = new Circle(1e-10);
        double expectedArea = Math.PI * Math.pow(1e-10, 2);
        assertEquals("Area should work for very small radius", expectedArea, circle.area(), 1e-30);
    }
}
