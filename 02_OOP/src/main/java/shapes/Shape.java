package shapes;

/**
 * Фигура (интерфейс)
 */
public class Shape {
    String name;

    /**
     * @return Вывести строчку презентации
     */
    public String show() {
        System.out.println("Надо реализовать метод show()");
        return name;
    }

    /**
     * @return Площадь фигуры
     */
    public double area() {
        System.out.println("Надо реализовать метод area()");
        return 0;
    }
}
