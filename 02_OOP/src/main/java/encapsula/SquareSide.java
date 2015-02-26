package encapsula;

/**
 * Квадрат, который хранит сторону
 */
public class SquareSide implements Square {
    double side;

    /**
     * Изменяем длину стороны
     *
     * @param value новая длина
     */
    @Override
    public void setSide(double value) {
        side = value;
    }

    /**
     * Изменяем площадь квадрата
     *
     * @param value новая длина
     */
    @Override
    public void setArea(double value) {
        side = Math.sqrt(value);
    }

    /**
     * @return длина стороны
     */
    @Override
    public double getSide() {
        return side;
    }

    /**
     * @return получаем площадь
     */
    @Override
    public double getArea() {
        return Math.pow(side, 2);
    }
}
