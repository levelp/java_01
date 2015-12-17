package encapsula;

/**
 * Квадрат
 */
public interface Square {

    /**
     * @return длина стороны
     */
    double getSide();

    /**
     * Изменяем длину стороны
     *
     * @param value новая длина
     */
    void setSide(double value);

    /**
     * @return получаем площадь
     */
    double getArea();

    /**
     * Изменяем площадь квадрата
     *
     * @param value новая длина
     */
    void setArea(double value);
}
