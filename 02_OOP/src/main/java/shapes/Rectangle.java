package shapes;

/**
 * Прямоугольник
 */
public class Rectangle extends Shape {
    /**
     * Стороны прямоугольника
     */
    private final double a, b;

    /**
     * Констуктор
     *
     * @param a Первая сторона
     * @param b Вторая сторона
     */
    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String show() {
        return "Прямоугольник: " +
                "a = " + a + " b = " + b + " площадь " + area();
    }

    @Override
    public double area() {
        return a * b;
    }
}
