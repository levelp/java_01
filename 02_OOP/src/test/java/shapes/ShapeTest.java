package shapes;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class for Shape abstract class
 */
public class ShapeTest {

    @Test
    public void testShapeIsAbstract() {
        assertTrue(java.lang.reflect.Modifier.isAbstract(Shape.class.getModifiers()));
    }

    @Test
    public void testShapeIsPublic() {
        assertTrue(java.lang.reflect.Modifier.isPublic(Shape.class.getModifiers()));
    }

    @Test
    public void testHasAreaMethod() throws NoSuchMethodException {
        assertNotNull(Shape.class.getMethod("area"));
    }

    @Test
    public void testAreaMethodIsAbstract() throws NoSuchMethodException {
        assertTrue(java.lang.reflect.Modifier.isAbstract(
            Shape.class.getMethod("area").getModifiers()));
    }

    @Test
    public void testAreaMethodReturnsDouble() throws NoSuchMethodException {
        assertEquals(double.class, Shape.class.getMethod("area").getReturnType());
    }

    @Test
    public void testHasShowMethod() throws NoSuchMethodException {
        assertNotNull(Shape.class.getMethod("show"));
    }

    @Test
    public void testShowMethodIsAbstract() throws NoSuchMethodException {
        assertTrue(java.lang.reflect.Modifier.isAbstract(
            Shape.class.getMethod("show").getModifiers()));
    }

    @Test
    public void testShowMethodReturnsVoid() throws NoSuchMethodException {
        assertEquals(void.class, Shape.class.getMethod("show").getReturnType());
    }

    @Test
    public void testHasCountField() throws NoSuchFieldException {
        assertNotNull(Shape.class.getField("count"));
    }

    @Test
    public void testCountFieldIsStatic() throws NoSuchFieldException {
        assertTrue(java.lang.reflect.Modifier.isStatic(
            Shape.class.getField("count").getModifiers()));
    }

    @Test
    public void testCircleExtendsShape() {
        assertTrue(Shape.class.isAssignableFrom(Circle.class));
    }

    @Test
    public void testRectangleExtendsShape() {
        assertTrue(Shape.class.isAssignableFrom(Rectangle.class));
    }

    @Test
    public void testSquareExtendsShape() {
        assertTrue(Shape.class.isAssignableFrom(Square.class));
    }

    @Test
    public void testPoint2DExtendsShape() {
        assertTrue(Shape.class.isAssignableFrom(Point2D.class));
    }

    @Test
    public void testPolymorphicArea() {
        Shape circle = new Circle(5.0);
        Shape rectangle = new Rectangle(3.0, 4.0);
        Shape square = new Square(2.0);

        assertEquals(Math.PI * 25, circle.area(), 0.0001);
        assertEquals(12.0, rectangle.area(), 0.0001);
        assertEquals(4.0, square.area(), 0.0001);
    }

    @Test
    public void testPackageName() {
        assertEquals("shapes", Shape.class.getPackage().getName());
    }
}
