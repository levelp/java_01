import org.junit.Test;

import static java.lang.Math.PI;
import static org.junit.Assert.*;

/**
 * Тестирование вычислений
 */
public class CalcTest {

    /**
     * Проверяем правильность работы факториала
     */
    @Test
    public void factorial() {
        assertEquals(1, Calc.fact(1), 0.0001);
        assertEquals(2, Calc.fact(2), 0.0001);
        assertEquals(2 * 3, Calc.fact(3), 0.0001);
        assertEquals(2 * 3 * 4, Calc.fact(4), 0.0001);
    }

    /**
     * Тест факториала с 0 - базовый случай
     */
    @Test
    public void factorialZero() {
        assertEquals("0! should equal 1", 1, Calc.fact(0), 0.0001);
    }

    /**
     * Тест факториала с большими числами
     */
    @Test
    public void factorialLargeNumbers() {
        assertEquals(3628800, Calc.fact(10), 0.0001);
        assertEquals(479001600, Calc.fact(12), 0.0001);
    }

    /**
     * Тест переполнения факториала - должен выбросить ArithmeticException
     */
    @Test(expected = ArithmeticException.class)
    public void factorialOverflow() {
        // Very large number should cause overflow
        Calc.fact(200);
    }

    /**
     * Тест константы EPS
     */
    @Test
    public void testEpsConstant() {
        assertEquals("EPS should be 1e-10", 1e-10, Calc.EPS, 1e-20);
    }

    @Test
    public void zeroTest() {
        assertEquals(0.0, Calc.riad(0.0, 50), 1e-20);
    }

    /**
     * Проверяем арксинус на линейном участке
     */
    @Test
    public void linearTest() {
        for (double x = -0.3; x < 0.3; x += 0.001) {
            assertEquals(x, Calc.riad(x, 80), 0.01);
        }
    }

    /**
     * Проверим контрольные точки
     */
    @Test
    public void checkPointTest() {
        assertEquals(PI / 2.0, Calc.riad(1), 0.1);
        assertEquals(-PI / 2.0, Calc.riad(-1), 0.1);
    }

    /**
     * Сравним со стандартной реализацией
     */
    @Test
    public void compareWithStandardImplementation() {
        for (double x = 0; x < 1; x += 0.01) {
            assertEquals("x = " + x, Math.asin(x), Calc.riad(x), 0.1);
        }
    }

    @Test
    public void compareWithStandardImplementationArcSin() {
        for (double x = 0; x < 1; x += 0.001) {
            assertEquals("x = " + x, Math.asin(x), Calc.arcSin(x), 0.00001);
        }
    }

    /**
     * Тест riad с различными значениями kol
     */
    @Test
    public void riadWithDifferentKol() {
        double x = 0.5;
        double expected = Math.asin(x);

        // More iterations should give better precision
        double result10 = Calc.riad(x, 10);
        double result50 = Calc.riad(x, 50);
        double result80 = Calc.riad(x, 80);

        assertEquals("riad with kol=10", expected, result10, 0.1);
        assertEquals("riad with kol=50", expected, result50, 0.01);
        assertEquals("riad with kol=80", expected, result80, 0.01);
    }

    /**
     * Тест riad с минимальным kol
     */
    @Test
    public void riadWithZeroKol() {
        double result = Calc.riad(0.5, 0);
        // With kol=0, only the first term is used: x
        assertEquals("riad with kol=0 should be approximately x", 0.5, result, 0.1);
    }

    /**
     * Тест arcSin с положительными значениями
     */
    @Test
    public void arcSinPositiveValues() {
        assertEquals("arcSin(0)", 0.0, Calc.arcSin(0), 1e-10);
        assertEquals("arcSin(0.5)", Math.asin(0.5), Calc.arcSin(0.5), 1e-5);
        assertEquals("arcSin(0.9)", Math.asin(0.9), Calc.arcSin(0.9), 1e-3);
    }

    /**
     * Тест arcSin на границе интервала
     */
    @Test
    public void arcSinBoundary() {
        // Test very small positive value
        assertEquals("arcSin near zero", 0.0, Calc.arcSin(1e-15), 1e-14);
    }

    /**
     * Тест riad wrapper метода (использует kol=80)
     */
    @Test
    public void riadWrapperMethod() {
        double x = 0.3;
        double expected = Calc.riad(x, 80);
        double actual = Calc.riad(x);
        assertEquals("riad(x) should equal riad(x, 80)", expected, actual, 1e-15);
    }

    /**
     * Тест что arcSin работает для малых значений
     */
    @Test
    public void arcSinSmallValues() {
        for (double x = 0.001; x < 0.1; x += 0.01) {
            assertEquals("arcSin for small x=" + x, Math.asin(x), Calc.arcSin(x), 1e-10);
        }
    }

    /**
     * Тест симметрии arcSin - arcsin(-x) = -arcsin(x)
     */
    @Test
    public void arcSinSymmetry() {
        for (double x = 0.1; x < 0.9; x += 0.1) {
            double positive = Calc.arcSin(x);
            double negative = Calc.arcSin(-x);
            assertEquals("arcSin should be symmetric", -positive, negative, 1e-5);
        }
    }
}
