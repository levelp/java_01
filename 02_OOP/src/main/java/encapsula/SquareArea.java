package encapsula;

/**
 * Квадрат, который хранит площадь
 */
public class SquareArea implements Square {
    double area;

    /**
     * Изменяем длину стороны
     *
     * @param value новая длина
     */
    @Override
    public void setSide(double value) {
        area = Math.pow(value, 2);
    }

    /**
     * Изменяем площадь квадрата
     *
     * @param value новая длина
     */
    @Override
    public void setArea(double value) {
        area = value;
    }

    /**
     * @return длина стороны
     */
    @Override
    public double getSide() {
        return Math.sqrt(area);
    }

    /**
     * @return получаем площадь
     */
    @Override
    public double getArea() {
        return area;
    }
}
