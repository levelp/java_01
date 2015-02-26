import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Тесты для решения квадратного уравнения
 */
public class SquareEqTest {

    public static final double DELTA = 0.000001;

    // Первый (самый простой) тест
    //-->
    @Test
    public void testSimple() {
        // assertEquals( ожидаемое_значение, вычисленное значение )
        //       сообщение_если_значения_не_равны, ..., ...
        // a*x^2 + b*x + c = 0
        assertArrayEquals("x^2 = 0",
                new double[]{0.0},
                SquareEq.solve(1.0, 0.0, 0.0), DELTA);
    }
    //<--

    // Рассматриваем случай, когда два решения уравнения
    //-->
    @Test
    public void twoSolutions() {
        assertArrayEquals("x^2 - 1 = 0",
                new double[]{-1.0, 1.0},
                SquareEq.solve(1.0, 0.0, -1.0), DELTA);
        assertArrayEquals("x^2 - 4 = 0",
                new double[]{-2.0, 2.0},
                SquareEq.solve(1.0, 0.0, -4.0), DELTA);
    }
    //<--

    /**
     * Квадратные уравнения с одним решением
     */
    @Test
    public void oneSolution() {
        assertArrayEquals("(x+1)^2 = x^2 + 2*x + 1 = 0",
                new double[]{-1.0},
                SquareEq.solve(1.0, 2.0, 1.0), DELTA);
    }

    /**
     * Уравнения с дискриминантом меньше 0
     * у которых нет решений в действ. числах
     */
    @Test
    public void noSolutions() {
        assertArrayEquals("x^2 + 1 = 0",
                new double[]{},
                SquareEq.solve(1.0, 0.0, 1.0), DELTA);

        assertArrayEquals("3x^2 + 10 = 0",
                new double[]{},
                SquareEq.solve(3.0, 0.0, 10.0), DELTA);
    }

    /**
     * Вырожденный случай: a = 0
     * Квадратное уравнение превращается в линейное
     */
    @Test
    public void zeroA() {
        assertArrayEquals("2x + 1 = 0",
                new double[]{-0.5},
                SquareEq.solve(0.0, 2.0, 1.0), DELTA);

        assertArrayEquals("x - 10 = 0",
                new double[]{10.0},
                SquareEq.solve(0.0, 1.0, -10.0), DELTA);
    }

    // Тестируем вырожденный случай: a = 0, b = 0
    //-->
    @Test
    public void zeroAZeroB() {
        assertArrayEquals("1 = 0",
                new double[]{},
                SquareEq.solve(0.0, 0.0, 1.0), DELTA);
    }
    //<--

    // Вырожденный случай: a = 0, b = 0, c = 0
    // Ожидаемое исключение
    //-->
    @Test(expected = AnyXException.class)
    public void zeroAZeroBZeroC() {
        assertArrayEquals("0 = 0",
                new double[]{},
                SquareEq.solve(0.0, 0.0, 0.0), DELTA);
    }
    //<--
}
