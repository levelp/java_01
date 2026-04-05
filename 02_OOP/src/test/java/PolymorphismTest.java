import org.junit.Assert;
import org.junit.Test;
import shapes.Circle;
import shapes.Rectangle;
import shapes.Shape;
import shapes.Square;

/**
 * Полиморфизм - свойство системы использовать объекты с одинаковым
 * интерфейсом без информации о типе и внутренней структуре объекта.
 */
public class PolymorphismTest extends Assert {

    @Test
    public void testShapes() {
        Shape[] shapes = {new Square(2.0),
                new Rectangle(2.0, 3.5), new Circle(1.0)};

        assertEquals(4.0, shapes[0].area(), 1e-10);
        assertEquals(7.0, shapes[1].area(), 1e-10);
        assertEquals(Math.PI, shapes[2].area(), 1e-10);

        assertEquals("Квадрат: сторона 2.0 площадь 4.0", shapes[0].show());
        assertEquals("Прямоугольник: a = 2.0 b = 3.5 площадь 7.0", shapes[1].show());

        for (Shape shape : shapes) {
            System.out.println(shape.show());
        }
    }

}
