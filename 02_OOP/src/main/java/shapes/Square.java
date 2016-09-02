package shapes;

import static java.lang.Math.*;

/**
 * Квадрат
 */
public class Square extends Shape {
    private final double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public String show() {
        return String.format(
                "Квадрат: сторона %s площадь %s",
                side, area());
    }

    @Override
    public double area() {
        return pow(side, 2);
    }
}
