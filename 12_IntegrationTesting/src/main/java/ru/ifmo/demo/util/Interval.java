package ru.ifmo.demo.util;

/**
 * Класс, описывающий интервал
 */
public class Interval {

    private double x0;
    private double x1;
    private double d;

    /**
     * @param x0 левая граница интервала
     * @param x1 правая граница интервала
     * @param d  приращение
     */
    public Interval(double x0, double x1, double d) {
        this.x0 = x0;
        this.x1 = x1;
        this.d = d;
    }

    public double getX0() {
        return x0;
    }

    public void setX0(double x0) {
        this.x0 = x0;
    }

    public double getX1() {
        return x1;
    }

    public void setX1(double x1) {
        this.x1 = x1;
    }

    public double getD() {
        return d;
    }

    public void setD(double d) {
        this.d = d;
    }
}
