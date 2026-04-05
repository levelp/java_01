package ru.ifmo.demo.modules;

import ru.ifmo.demo.functions.IFunc;
import ru.ifmo.demo.functions.stub.FuncStub;

import static java.lang.Math.pow;

/**
 * Функция из задания
 */
public class MyExpression implements Expression {
    public IFunc sin, cos, csc, tan, cot;

    /**
     * По-умочанию глушим все функции
     */
    public MyExpression() {
        sin = new FuncStub();
        cos = new FuncStub();
        csc = new FuncStub();
        tan = new FuncStub();
        cot = new FuncStub();
    }

    @Override
    public double calc(double x) {
        return ((((pow(cos.get(x) + csc.get(x), 2.0 * 3.0) -
                ((sin.get(x) - tan.get(x)) - cos.get(x)) * (cot.get(x) * tan.get(x))))));
    }
}
