package ru.ifmo.demo.functions;

import static java.lang.Math.tan;

/**
 * Котангенс
 */
public class Cot implements IFunc {
    @Override
    public double get(double x) {
        return 1.0 / tan(x);
    }

}
