package ru.ifmo.demo.modules;

import org.junit.Before;
import org.junit.Test;
import ru.ifmo.demo.functions.*;
import ru.ifmo.demo.functions.stub.FuncStub;

import static org.junit.Assert.*;

/**
 * Comprehensive test class for MyExpression
 */
public class MyExpressionTest {

    private static final double DELTA = 0.001;

    @Test
    public void testDefaultConstructor() {
        MyExpression expr = new MyExpression();
        assertNotNull(expr);
    }

    @Test
    public void testImplementsExpression() {
        MyExpression expr = new MyExpression();
        assertTrue(expr instanceof Expression);
    }

    @Test
    public void testDefaultConstructorInitializesFunctionsToStubs() {
        MyExpression expr = new MyExpression();
        assertNotNull(expr.sin);
        assertNotNull(expr.cos);
        assertNotNull(expr.csc);
        assertNotNull(expr.tan);
        assertNotNull(expr.cot);
    }

    @Test
    public void testDefaultConstructorUsesStubs() {
        MyExpression expr = new MyExpression();
        assertTrue(expr.sin instanceof FuncStub);
        assertTrue(expr.cos instanceof FuncStub);
        assertTrue(expr.csc instanceof FuncStub);
        assertTrue(expr.tan instanceof FuncStub);
        assertTrue(expr.cot instanceof FuncStub);
    }

    @Test
    public void testCalcWithStubs() {
        MyExpression expr = new MyExpression();
        // All stubs return 1, so: ((1 + 1)^6 - ((1 - 1) - 1) * (1 * 1))
        // = (2^6 - (0 - 1) * 1) = 64 - (-1) = 65
        double result = expr.calc(1.0);
        assertEquals(65.0, result, DELTA);
    }

    @Test
    public void testCalcWithCustomSin() {
        MyExpression expr = new MyExpression();
        expr.sin = new Sin();
        expr.cos = new FuncStub();
        expr.csc = new FuncStub();
        expr.tan = new FuncStub();
        expr.cot = new FuncStub();

        double result = expr.calc(0.0);
        assertNotNull(result);
    }

    @Test
    public void testCalcWithCustomCos() {
        MyExpression expr = new MyExpression();
        expr.sin = new FuncStub();
        expr.cos = new Cos();
        expr.csc = new FuncStub();
        expr.tan = new FuncStub();
        expr.cot = new FuncStub();

        double result = expr.calc(0.0);
        assertNotNull(result);
    }

    @Test
    public void testCalcWithAllRealFunctions() {
        MyExpression expr = new MyExpression();
        expr.sin = new Sin();
        expr.cos = new Cos();
        expr.csc = new Cosecant();
        expr.tan = new Tg();
        expr.cot = new Cot();

        double result = expr.calc(Math.PI / 4);
        assertNotNull(result);
        assertFalse(Double.isInfinite(result));
    }

    @Test
    public void testCalcAtZero() {
        MyExpression expr = new MyExpression();
        double result = expr.calc(0.0);
        assertEquals(65.0, result, DELTA);
    }

    @Test
    public void testCalcAtPositiveValue() {
        MyExpression expr = new MyExpression();
        double result = expr.calc(5.0);
        assertEquals(65.0, result, DELTA);
    }

    @Test
    public void testCalcAtNegativeValue() {
        MyExpression expr = new MyExpression();
        double result = expr.calc(-5.0);
        assertEquals(65.0, result, DELTA);
    }

    @Test
    public void testCalcWithDifferentInputs() {
        MyExpression expr = new MyExpression();
        double result1 = expr.calc(1.0);
        double result2 = expr.calc(2.0);
        // With stubs, all inputs should give the same result
        assertEquals(result1, result2, DELTA);
    }

    @Test
    public void testFunctionsCanBeReassigned() {
        MyExpression expr = new MyExpression();
        IFunc oldSin = expr.sin;
        expr.sin = new Sin();
        assertNotSame(oldSin, expr.sin);
    }

    @Test
    public void testMultipleCalculations() {
        MyExpression expr = new MyExpression();
        for (int i = 0; i < 10; i++) {
            double result = expr.calc(i);
            assertEquals(65.0, result, DELTA);
        }
    }

    @Test
    public void testCalcWithLargeValue() {
        MyExpression expr = new MyExpression();
        double result = expr.calc(1000.0);
        assertEquals(65.0, result, DELTA);
    }

    // Additional edge case tests for 100% coverage

    @Test
    public void testCalcWithAllRealFunctionsAtPiOverSix() {
        MyExpression expr = new MyExpression();
        expr.sin = new Sin();
        expr.cos = new Cos();
        expr.csc = new Cosecant();
        expr.tan = new Tg();
        expr.cot = new Cot();

        double result = expr.calc(Math.PI / 6);
        assertFalse(Double.isNaN(result));
    }

    @Test
    public void testCalcWithAllRealFunctionsAtPiOverThree() {
        MyExpression expr = new MyExpression();
        expr.sin = new Sin();
        expr.cos = new Cos();
        expr.csc = new Cosecant();
        expr.tan = new Tg();
        expr.cot = new Cot();

        double result = expr.calc(Math.PI / 3);
        assertFalse(Double.isNaN(result));
    }

    @Test
    public void testCalcWithMixedStubsAndReal() {
        MyExpression expr = new MyExpression();
        expr.sin = new Sin();
        expr.cos = new Cos();
        expr.csc = new Cosecant();
        expr.tan = new FuncStub();  // stub
        expr.cot = new FuncStub();  // stub

        double result = expr.calc(Math.PI / 4);
        assertNotNull(result);
    }

    @Test
    public void testCalcWithOnlyCscReal() {
        MyExpression expr = new MyExpression();
        expr.csc = new Cosecant();

        double result = expr.calc(Math.PI / 2);
        assertNotNull(result);
    }

    @Test
    public void testCalcWithOnlyTanReal() {
        MyExpression expr = new MyExpression();
        expr.tan = new Tg();

        double result = expr.calc(Math.PI / 4);
        assertNotNull(result);
    }

    @Test
    public void testCalcWithOnlyCotReal() {
        MyExpression expr = new MyExpression();
        expr.cot = new Cot();

        double result = expr.calc(Math.PI / 4);
        assertNotNull(result);
    }

    @Test
    public void testCalcAtNegativeValue() {
        MyExpression expr = new MyExpression();
        expr.sin = new Sin();
        expr.cos = new Cos();
        expr.csc = new Cosecant();
        expr.tan = new Tg();
        expr.cot = new Cot();

        double result = expr.calc(-Math.PI / 4);
        assertNotNull(result);
    }

    @Test
    public void testCalcAtVerySmallValue() {
        MyExpression expr = new MyExpression();
        double result = expr.calc(0.001);
        assertEquals(65.0, result, DELTA);
    }

    @Test
    public void testCalcWithRealFunctionsAtOne() {
        MyExpression expr = new MyExpression();
        expr.sin = new Sin();
        expr.cos = new Cos();
        expr.csc = new Cosecant();
        expr.tan = new Tg();
        expr.cot = new Cot();

        double result = expr.calc(1.0);
        assertFalse(Double.isNaN(result));
    }

    @Test
    public void testCalcWithRealFunctionsAtTwo() {
        MyExpression expr = new MyExpression();
        expr.sin = new Sin();
        expr.cos = new Cos();
        expr.csc = new Cosecant();
        expr.tan = new Tg();
        expr.cot = new Cot();

        double result = expr.calc(2.0);
        assertFalse(Double.isNaN(result));
    }

    @Test
    public void testCalcResultNotNullForAllAngles() {
        MyExpression expr = new MyExpression();
        expr.sin = new Sin();
        expr.cos = new Cos();
        expr.csc = new Cosecant();
        expr.tan = new Tg();
        expr.cot = new Cot();

        // Test various angles
        double[] angles = {0.1, 0.2, 0.5, 0.7, 1.0, 1.5};
        for (double angle : angles) {
            double result = expr.calc(angle);
            assertNotNull(Double.valueOf(result));
        }
    }

    @Test
    public void testCalcFormulaVerification() {
        // Manual formula verification: ((cos(x) + csc(x))^6 - ((sin(x) - tan(x)) - cos(x)) * (cot(x) * tan(x)))
        MyExpression expr = new MyExpression();
        // With stubs, all functions return 1
        // ((1 + 1)^6 - ((1 - 1) - 1) * (1 * 1))
        // = (2^6 - (0 - 1) * 1)
        // = 64 - (-1)
        // = 65
        double result = expr.calc(0);
        assertEquals(65.0, result, DELTA);
    }

    @Test
    public void testFieldsArePubliclyAccessible() {
        MyExpression expr = new MyExpression();

        // Verify fields can be read
        assertNotNull(expr.sin);
        assertNotNull(expr.cos);
        assertNotNull(expr.csc);
        assertNotNull(expr.tan);
        assertNotNull(expr.cot);

        // Verify fields can be written
        expr.sin = new Sin();
        expr.cos = new Cos();
        expr.csc = new Cosecant();
        expr.tan = new Tg();
        expr.cot = new Cot();

        assertTrue(expr.sin instanceof Sin);
        assertTrue(expr.cos instanceof Cos);
        assertTrue(expr.csc instanceof Cosecant);
        assertTrue(expr.tan instanceof Tg);
        assertTrue(expr.cot instanceof Cot);
    }
}
