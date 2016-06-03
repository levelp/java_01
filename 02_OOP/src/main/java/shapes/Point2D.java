package shapes;

/**
 * Класс: Точка
 */
public class Point2D {
    static int count = 0;
    public int x, y;
    Coordinates coordinates;

    // Конструктор
    // __init__()
    public Point2D() {
        count++;
    }

    public void move(int dx, int dy) {
        x += dx;
        y += dy;
    }

    // Point2D.Coordinates
    public static class Coordinates {
        public int x, y;
    }
}
