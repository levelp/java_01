package shapes;

import static java.lang.Math.PI;
import static java.lang.Math.pow;

/**
 * Круг
 */
public class Circle extends Shape {
    private double r;

    /**
     * Констуктор
     *
     * @param r Радиус круга
     */
    public Circle(double r) {
        this.r = r;
    }

    @Override
    public String show() {
        return "Круг: радиус " + r;
    }

    @Override
    public double area() {
        return PI * pow(r, 2);
    }
}
