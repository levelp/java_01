package ru.ifmo.demo.modules;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class for Expression interface
 */
public class ExpressionTest {

    @Test
    public void testExpressionIsInterface() {
        assertTrue(Expression.class.isInterface());
    }

    @Test
    public void testExpressionIsPublic() {
        assertTrue(java.lang.reflect.Modifier.isPublic(Expression.class.getModifiers()));
    }

    @Test
    public void testHasCalcMethod() throws NoSuchMethodException {
        assertNotNull(Expression.class.getMethod("calc", double.class));
    }

    @Test
    public void testCalcMethodReturnsDouble() throws NoSuchMethodException {
        assertEquals(double.class, Expression.class.getMethod("calc", double.class).getReturnType());
    }

    @Test
    public void testCalcMethodIsPublic() throws NoSuchMethodException {
        assertTrue(java.lang.reflect.Modifier.isPublic(
            Expression.class.getMethod("calc", double.class).getModifiers()));
    }

    @Test
    public void testCalcMethodIsAbstract() throws NoSuchMethodException {
        assertTrue(java.lang.reflect.Modifier.isAbstract(
            Expression.class.getMethod("calc", double.class).getModifiers()));
    }

    @Test
    public void testMethodCount() {
        // Interface should have exactly 1 declared method
        assertEquals(1, Expression.class.getDeclaredMethods().length);
    }

    @Test
    public void testMyExpressionImplementsExpression() {
        assertTrue(Expression.class.isAssignableFrom(MyExpression.class));
    }

    @Test
    public void testPolymorphicCall() {
        // Create a MyExpression with stub functions
        ru.ifmo.demo.functions.stub.FuncStub stub = new ru.ifmo.demo.functions.stub.FuncStub();
        stub.add(1.0, 0.5);

        MyExpression expr = new MyExpression();
        Expression polyExpr = expr;

        assertNotNull(polyExpr);
    }

    @Test
    public void testAnonymousImplementation() {
        Expression expr = new Expression() {
            @Override
            public double calc(double x) {
                return x * 2;
            }
        };

        assertEquals(10.0, expr.calc(5.0), 0.0001);
    }

    @Test
    public void testLambdaStyle() {
        // Since we're on Java 8, can use lambda for functional interface
        Expression expr = x -> x * x;

        assertEquals(25.0, expr.calc(5.0), 0.0001);
        assertEquals(0.0, expr.calc(0.0), 0.0001);
        assertEquals(4.0, expr.calc(-2.0), 0.0001);
    }

    @Test
    public void testPackageName() {
        assertEquals("ru.ifmo.demo.modules", Expression.class.getPackage().getName());
    }
}
