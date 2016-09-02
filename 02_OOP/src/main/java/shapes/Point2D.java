package shapes;

/**
 * Класс: Точка
 */
public class Point2D extends Shape {
    static int count = 0;
    public int x, y;
    Coordinates coordinates;

    // Конструктор
    // __init__()
    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
        count++;
    }

    public void move(int dx, int dy) {
        x += dx;
        y += dy;
    }

    @Override
    public String show() {
        return "Точка (" + x + ";" + y + ")";
    }

    @Override
    public double area() {
        return 0.0;
    }

    // Point2D.Coordinates
    public static class Coordinates {
        public int x, y;
    }
}
