package encapsula;

/**
 * Квадрат
 */
public interface Square {

    /**
     * Изменяем длину стороны
     * @param value новая длина
     */
    void setSide(double value);

    /**
     * Изменяем площадь квадрата
     * @param value новая длина
     */
    void setArea(double value);

    /**
     * @return длина стороны
     */
    double getSide();

    /**
     * @return получаем площадь
     */
    double getArea();
}
