package ru.ifmo.demo.util;

import ru.ifmo.demo.modules.Expression;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Класс для генерации файлов csv.
 * <p/>
 * По сгененрированному файлу можно построить график в
 * стороннем ПО, например, в gnuplot или Excel.
 */
public class Plotter {

    /**
     * Метод для генерации csv файла
     *
     * @param filename   имя файла
     * @param expression реализованное выражение
     * @param intervals  набор интервалов для вычисления
     * @throws FileNotFoundException
     * @throws UnsupportedEncodingException
     */
    public static void plot(String filename, Expression expression, List<Interval> intervals)
            throws FileNotFoundException, UnsupportedEncodingException {
        try (PrintWriter writer = new PrintWriter(filename, "UTF-8")) {
            for (Interval interval : intervals) {
                plot(writer, expression, interval);
            }
            writer.close();
        }
    }

    /**
     * Метод для генерации csv файла
     *
     * @param filename   имя файла
     * @param expression реализованное выражение
     * @param x0         начальное значение аргумента
     * @param x1         конечное значение аргумента
     * @param d          приращение аргумента
     * @throws FileNotFoundException
     * @throws UnsupportedEncodingException
     */
    public static void plot(String filename, Expression expression, double x0, double x1, double d)
            throws FileNotFoundException, UnsupportedEncodingException {
        try (PrintWriter writer = new PrintWriter(filename, "UTF-8")) {
            Interval interval = new Interval(x0, x1, d);
            plot(writer, expression, interval);
            writer.close();
        }
    }

    private static void plot(PrintWriter writer, Expression expression, Interval interval) {
        double x = interval.getX0();
        while (x <= interval.getX1()) {
            double y;
            try {
                y = expression.calc(x);
            } catch (Exception ex) {
                y = 0D;
            }
            if (!Double.isNaN(x) && !Double.isNaN(y) && y < 10)
                writer.format("%f;%f\n", x, y);
            x += interval.getD();
        }
    }

}
