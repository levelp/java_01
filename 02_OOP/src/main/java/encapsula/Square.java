package encapsula;

/**
 * Квадрат
 * - сторона side
 * - прощадь area
 * side^2 = area
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
