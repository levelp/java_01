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

    /**
     * Отдельный тест когда b != 0
     */
    @Test
    public void twoSolutionsBNotNull() {
        // (x-1)(x-2) = x^2 - 3x + 2
        assertArrayEquals("x^2 - 3x + 2 = 0",
                new double[]{1.0, 2.0},
                SquareEq.solve(1.0, -3.0, 2.0), DELTA);
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
    public void testNoSolutions() {
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
    public void testZeroA() {
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
    public void testZeroAZeroB() {
        assertArrayEquals("1 = 0",
                new double[]{},
                SquareEq.solve(0.0, 0.0, 1.0), DELTA);
    }
    //<--

    // Вырожденный случай: a = 0, b = 0, c = 0
    // Ожидаемое исключение
    //-->
    @Test(expected = AnyXException.class)
    public void testZeroAZeroBZeroC() {
        assertArrayEquals("0 = 0",
                new double[]{},
                SquareEq.solve(0.0, 0.0, 0.0), DELTA);
    }
    //<--

    // Additional edge case tests for 100% coverage

    /**
     * Test DELTA constant is correctly defined
     */
    @Test
    public void testDeltaConstant() {
        assertTrue("DELTA should be a very small positive number",
                SquareEq.DELTA > 0 && SquareEq.DELTA < 0.001);
    }

    /**
     * Test discriminant D > 0 with negative coefficients
     */
    @Test
    public void testTwoSolutionsNegativeCoefficients() {
        // -x^2 + 1 = 0 => x = -1, 1
        assertArrayEquals("-x^2 + 1 = 0",
                new double[]{-1.0, 1.0},
                SquareEq.solve(-1.0, 0.0, 1.0), DELTA);
    }

    /**
     * Test discriminant D = 0 with larger coefficients
     */
    @Test
    public void testOneSolutionLargerCoefficients() {
        // 4x^2 + 4x + 1 = 0 => (2x+1)^2 = 0 => x = -0.5
        assertArrayEquals("4x^2 + 4x + 1 = 0",
                new double[]{-0.5},
                SquareEq.solve(4.0, 4.0, 1.0), DELTA);
    }

    /**
     * Test discriminant D < 0 with negative coefficients
     */
    @Test
    public void testNoSolutionsNegativeCoefficients() {
        // -x^2 - 1 = 0 => no real solutions
        assertArrayEquals("-x^2 - 1 = 0",
                new double[]{},
                SquareEq.solve(-1.0, 0.0, -1.0), DELTA);
    }

    /**
     * Test with very small non-zero a (near DELTA boundary)
     */
    @Test
    public void testVerySmallA() {
        // a is very small but non-zero
        double smallA = SquareEq.DELTA * 10;
        double[] result = SquareEq.solve(smallA, 1.0, 0.0);
        assertTrue(result.length >= 1);
    }

    /**
     * Test with a value just above DELTA threshold
     */
    @Test
    public void testAJustAboveDelta() {
        double a = SquareEq.DELTA * 2;
        double[] result = SquareEq.solve(a, 0.0, -a);
        assertEquals(2, result.length);
    }

    /**
     * Test linear equation with negative b
     */
    @Test
    public void testLinearNegativeB() {
        // -2x + 4 = 0 => x = 2
        assertArrayEquals("-2x + 4 = 0",
                new double[]{2.0},
                SquareEq.solve(0.0, -2.0, 4.0), DELTA);
    }

    /**
     * Test quadratic with all positive coefficients D > 0
     */
    @Test
    public void testAllPositiveCoefficients() {
        // x^2 - 5x + 6 = 0 => (x-2)(x-3) = 0 => x = 2, 3
        assertArrayEquals("x^2 - 5x + 6 = 0",
                new double[]{2.0, 3.0},
                SquareEq.solve(1.0, -5.0, 6.0), DELTA);
    }

    /**
     * Test quadratic with large coefficients
     */
    @Test
    public void testLargeCoefficients() {
        // 100x^2 - 100 = 0 => x^2 = 1 => x = -1, 1
        assertArrayEquals("100x^2 - 100 = 0",
                new double[]{-1.0, 1.0},
                SquareEq.solve(100.0, 0.0, -100.0), DELTA);
    }

    /**
     * Test with fractional coefficients
     */
    @Test
    public void testFractionalCoefficients() {
        // 0.5x^2 - 0.5 = 0 => x = -1, 1
        assertArrayEquals("0.5x^2 - 0.5 = 0",
                new double[]{-1.0, 1.0},
                SquareEq.solve(0.5, 0.0, -0.5), DELTA);
    }

    /**
     * Test discriminant exactly zero (edge case)
     */
    @Test
    public void testDiscriminantExactlyZero() {
        // x^2 - 2x + 1 = 0 => (x-1)^2 = 0 => D = 4 - 4 = 0
        assertArrayEquals("x^2 - 2x + 1 = 0",
                new double[]{1.0},
                SquareEq.solve(1.0, -2.0, 1.0), DELTA);
    }

    /**
     * Test with b = 0 and negative c (D > 0)
     */
    @Test
    public void testBZeroNegativeC() {
        // x^2 - 9 = 0 => x = -3, 3
        assertArrayEquals("x^2 - 9 = 0",
                new double[]{-3.0, 3.0},
                SquareEq.solve(1.0, 0.0, -9.0), DELTA);
    }

    /**
     * Test with c = 0 (one root at 0)
     */
    @Test
    public void testCZero() {
        // x^2 - x = 0 => x(x-1) = 0 => x = 0, 1
        assertArrayEquals("x^2 - x = 0",
                new double[]{0.0, 1.0},
                SquareEq.solve(1.0, -1.0, 0.0), DELTA);
    }

    /**
     * Test with negative a and positive b
     */
    @Test
    public void testNegativeAPositiveB() {
        // -x^2 + 4x - 3 = 0 => -(x-1)(x-3) = 0 => x = 1, 3
        double[] result = SquareEq.solve(-1.0, 4.0, -3.0);
        assertEquals(2, result.length);
    }

    /**
     * Test b near DELTA threshold (treated as zero)
     */
    @Test
    public void testBNearDelta() {
        double smallB = SquareEq.DELTA / 2;
        // 0*x^2 + smallB*x + 1 = 0 where smallB is treated as 0
        double[] result = SquareEq.solve(0.0, smallB, 1.0);
        assertEquals(0, result.length); // No solutions when a=0, b~=0, c!=0
    }
}
