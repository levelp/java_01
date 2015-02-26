package ru.ifmo.demo.functions;

import static java.lang.Math.sin;

/**
 * Косеканс
 */
public class Cosecant implements IFunc {
    @Override
    public double get(double x) {
        return 1 / sin(x);
    }
}
