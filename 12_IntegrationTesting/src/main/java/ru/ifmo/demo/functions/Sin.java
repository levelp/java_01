package ru.ifmo.demo.functions;

import ru.ifmo.demo.exceptions.DoubleNanException;
import ru.ifmo.demo.exceptions.InvalidPrecision;
import ru.ifmo.demo.exceptions.ZeroPrecision;
import ru.ifmo.demo.util.RoundUtil;

/**
 * Реализация синуса
 */
public class Sin implements IFunc {
    // Get Sin(x) with Precision of e
    public static double getIt(double x, double e) throws DoubleNanException, ZeroPrecision, InvalidPrecision {
        checkPrecision(e);
        if (x > Math.PI * 2) {
            x = x % (Math.PI * 2);
        }
        double item = x;
        double sum = item;
        int n = 1;

        while (Math.abs(item) >= e || n < 100) {
            item = (Math.pow(-1, n) * Math.pow(x, 2 * n + 1)) / fact(2 * n + 1);
            if (Double.isNaN(item)) throw new DoubleNanException();
            sum += item;
            n += 1;
        }
        return sum;
    }

    // Find factorial
    private static double fact(int num) {
        return (num == 0) ? 1 : num * fact(num - 1);
    }

    private static void checkPrecision(double e) throws ZeroPrecision, InvalidPrecision {
        if (e == 0) throw new ZeroPrecision();
        if (e >= 1. & e / 10 != 0) throw new InvalidPrecision();
    }

    // Find high/low bound
    public static double highLowBoundFinder(double e) throws InvalidPrecision, ZeroPrecision {
        checkPrecision(e);
        double x = 0;
        try {
            while (true) {
                getIt(x, e);
                x += e;
            }
        } catch (DoubleNanException ex) {
        }
        return x;
    }

    // Find precision limit
    public static double preciseLimitFinder(double e) throws InvalidPrecision, ZeroPrecision, DoubleNanException {
        checkPrecision(e);
        String ee = Double.toString(e);
        StringBuilder sb = new StringBuilder();
        for (int i = ee.indexOf('E') + 1; i < ee.length(); i++) {
            sb.append(ee.charAt(i));
        }
        int c = Math.abs(Integer.parseInt(sb.toString()));
        double x, juiA, juiB;

        x = 0;
        while (true) {
            juiA = getIt(x, e);
            juiA = RoundUtil.roundUP(juiA, c);
            juiB = Math.sin(x);
            juiB = RoundUtil.roundUP(juiB, c);
            if (juiA != juiB)
                return x;
            x += e;
        }
    }

    @Override
    public double get(double x) {
        return getIt(x, 0.0001);
    }
}
