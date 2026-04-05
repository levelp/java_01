package ru.ifmo.demo.functions.stub;

/**
 * Заглушка для функции, всегда возвращающая 1
 */
public class FuncStub implements ru.ifmo.demo.functions.IFunc {
    @Override
    public double get(double x) {
        return 1;
    }
}
