package shapes;

/**
 * Фигура (абстрактный класс)
 */
public abstract class Shape {
    /**
     * Имя фигуры
     */
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
