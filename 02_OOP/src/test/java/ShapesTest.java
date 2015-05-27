import shapes.Circle;
import shapes.Rectangle;
import shapes.Shape;
import shapes.Square;

/**
 * Абстрактные классы: фигуры
 */
public class ShapesTest {

    public static void main(String[] args) {
        Shape[] shapes = {
                new Circle(2.2),
                new Rectangle(10, 3),
                new Square(4),
        };
        for (Shape s : shapes) {
            System.out.println("s.show() = " + s.show());
            System.out.println("s.area() = " + s.area());
        }
    }
}
