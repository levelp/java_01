package ru.ifmo.demo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import ru.ifmo.demo.functions.*;
import ru.ifmo.demo.modules.MyExpression;
import ru.ifmo.demo.util.Interval;
import ru.ifmo.demo.util.Plotter;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.*;
import static org.junit.Assert.assertEquals;

/**
 * Sample test.
 * Do not use any classes in junit.framework or junit.extensions
 */
@RunWith(JUnit4.class)
public class SampleTest {

    List<Interval> intervals;

    @Before
    public void initStubsIntervals() {
        intervals = new ArrayList<>();
        intervals.add(new Interval(0, PI / 2 - 0.1, 0.1));
        intervals.add(new Interval(PI / 2 + 0.1, PI, 0.1));
        intervals.add(new Interval(PI, 3 * PI / 2 - 0.1, 0.1));
        intervals.add(new Interval(3 * PI / 2 + 0.1, 2 * PI, 0.1));
        intervals.add(new Interval(-PI, -PI / 2 - 0.1, 0.1));
        intervals.add(new Interval(-PI / 2 + 0.1, 0, 0.1));
    }

    @Test
    public void testAllStub() throws FileNotFoundException, UnsupportedEncodingException {
        MyExpression expression = new MyExpression();
        for (Interval i : intervals) {
            for (double x = i.getX0(); x <= i.getX1(); x += i.getD())
                assertEquals(pow(2.0, 6.0) + 1, expression.calc(x), 0.01);
        }

        Plotter.plot("/Users/Scotch/graph_all_stub.csv", expression, intervals);
    }

    @Test
    public void testAllReal() throws FileNotFoundException, UnsupportedEncodingException {
        MyExpression expression = new MyExpression();
        expression.cos = new Cos();
        expression.sin = new Sin();
        expression.cot = new Cot();
        expression.tan = new Tg();
        expression.csc = new Cosecant();
        for (Interval i : intervals) {
            for (double x = i.getX0(); x <= i.getX1(); x += i.getD())
                assertEquals(((((pow(cos(x) + csc(x), 2.0 * 3.0) -
                                ((sin(x) - tan(x)) - cos(x)) * (cot(x) * tan(x)))))),
                        expression.calc(x), 0.01
                );
        }

        Plotter.plot("/Users/Scotch/graph_all_real.csv", expression, intervals);
    }

    private double csc(double x) {
        return 1.0 / sin(x);
    }

    private double cot(double x) {
        return 1.0 / tan(x);
    }

    /**
     * Косеканс - заменим все функции кроме косеканса на заглушки и будем тестировать только его
     */
    @Test
    public void cosec() throws FileNotFoundException, UnsupportedEncodingException {
        MyExpression expression = new MyExpression();
        expression.csc = new Cosecant();
        for (Interval i : intervals) {
            for (double x = i.getX0(); x <= i.getX1(); x += i.getD()) {
                System.out.printf(" x = %.1f%n", x);
                assertEquals(pow(1.0 + 1 / sin(x), 6.0) - (-1), expression.calc(x), 0.01);
            }
        }
        Plotter.plot("/Users/Scotch/graph_csc.csv", expression, intervals);
    }

    /**
     * Синус - заменим все функции кроме косеканса на заглушки и будем тестировать только его
     */
    @Test
    public void sinus() throws FileNotFoundException, UnsupportedEncodingException {
        MyExpression expression = new MyExpression();
        expression.sin = new Sin();
        for (Interval i : intervals) {
            for (double x = i.getX0(); x <= i.getX1(); x += i.getD())
                assertEquals(((((pow(1 + 1, 2.0 * 3.0) -
                                ((sin(x) - 1) - 1) * (1))))),
                        expression.calc(x), 0.01
                );
        }
        Plotter.plot("/Users/Scotch/graph_sin.csv", expression, intervals);
    }

    @Test
    public void cosinus() throws FileNotFoundException, UnsupportedEncodingException {
        MyExpression expression = new MyExpression();
        expression.cos = new Cos();
        for (Interval i : intervals) {
            for (double x = i.getX0(); x <= i.getX1(); x += i.getD())
                assertEquals(((((pow(cos(x) + 1, 2.0 * 3.0) -
                                (-cos(x)))))),
                        expression.calc(x), 0.01
                );
        }
        Plotter.plot("/Users/Scotch/graph_cos.csv", expression, intervals);
    }

    @Test
    public void tangens() throws FileNotFoundException, UnsupportedEncodingException {
        MyExpression expression = new MyExpression();
        expression.tan = new Tg();
        for (Interval i : intervals) {
            for (double x = i.getX0(); x <= i.getX1(); x += i.getD())
                assertEquals(((((pow(2, 2.0 * 3.0) -
                                ((1 - tan(x)) - 1) * (tan(x)))))),
                        expression.calc(x), 0.01
                );
        }
        Plotter.plot("/Users/Scotch/graph_tan.csv", expression, intervals);
    }

    @Test
    public void cotangens() throws FileNotFoundException, UnsupportedEncodingException {
        MyExpression expression = new MyExpression();
        expression.cot = new Cot();
        for (Interval i : intervals) {
            for (double x = i.getX0(); x <= i.getX1(); x += i.getD())
                assertEquals(((((pow(2, 2.0 * 3.0) -
                                (-1) * (1 / tan(x)))))),
                        expression.calc(x), 0.01
                );
        }
        Plotter.plot("/Users/Scotch/graph_ctg.csv", expression, intervals);
    }

}
