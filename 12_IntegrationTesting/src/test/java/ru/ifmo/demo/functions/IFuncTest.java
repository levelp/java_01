package ru.ifmo.demo.functions;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class for IFunc interface
 */
public class IFuncTest {

    @Test
    public void testIFuncIsInterface() {
        assertTrue(IFunc.class.isInterface());
    }

    @Test
    public void testIFuncIsPublic() {
        assertTrue(java.lang.reflect.Modifier.isPublic(IFunc.class.getModifiers()));
    }

    @Test
    public void testHasGetMethod() throws NoSuchMethodException {
        assertNotNull(IFunc.class.getMethod("get", double.class));
    }

    @Test
    public void testGetMethodReturnsDouble() throws NoSuchMethodException {
        assertEquals(double.class, IFunc.class.getMethod("get", double.class).getReturnType());
    }

    @Test
    public void testGetMethodIsPublic() throws NoSuchMethodException {
        assertTrue(java.lang.reflect.Modifier.isPublic(
            IFunc.class.getMethod("get", double.class).getModifiers()));
    }

    @Test
    public void testGetMethodIsAbstract() throws NoSuchMethodException {
        assertTrue(java.lang.reflect.Modifier.isAbstract(
            IFunc.class.getMethod("get", double.class).getModifiers()));
    }

    @Test
    public void testMethodCount() {
        // Interface should have exactly 1 declared method
        assertEquals(1, IFunc.class.getDeclaredMethods().length);
    }

    @Test
    public void testSinImplementsIFunc() {
        assertTrue(IFunc.class.isAssignableFrom(Sin.class));
    }

    @Test
    public void testCosImplementsIFunc() {
        assertTrue(IFunc.class.isAssignableFrom(Cos.class));
    }

    @Test
    public void testTgImplementsIFunc() {
        assertTrue(IFunc.class.isAssignableFrom(Tg.class));
    }

    @Test
    public void testCotImplementsIFunc() {
        assertTrue(IFunc.class.isAssignableFrom(Cot.class));
    }

    @Test
    public void testCosecantImplementsIFunc() {
        assertTrue(IFunc.class.isAssignableFrom(Cosecant.class));
    }

    @Test
    public void testPolymorphicCall() {
        IFunc sin = new Sin(0.001);
        IFunc cos = new Cos(new Sin(0.001));

        double sinValue = sin.get(Math.PI / 2);
        double cosValue = cos.get(0);

        assertEquals(1.0, sinValue, 0.01);
        assertEquals(1.0, cosValue, 0.01);
    }

    @Test
    public void testPackageName() {
        assertEquals("ru.ifmo.demo.functions", IFunc.class.getPackage().getName());
    }
}
