package shapes;

/**
 * Фигура (интерфейс)
 */
public abstract class Shape {
    String name;

    /**
     * @return Вывести строчку презентации
     */
    abstract public String show();

    /**
     * @return Площадь фигуры
     */
    abstract public double area();
}
