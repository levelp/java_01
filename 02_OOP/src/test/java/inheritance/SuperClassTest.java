package inheritance;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class SuperClassTest {

    @Test
    public void testSuperClassDefaultConstructor() {
        SuperClass superClass = new SuperClass();
        assertNotNull(superClass);
    }

    @Test
    public void testSuperClassParameterizedConstructor() {
        SuperClass superClass = new SuperClass(5);
        assertNotNull(superClass);
    }

    @Test
    public void testDefaultConstructorOutput() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        new SuperClass();

        System.setOut(originalOut);
        assertTrue(outputStream.toString().contains("Конструктор Суперкласса"));
    }

    @Test
    public void testParameterizedConstructorOutput() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        new SuperClass(10);

        System.setOut(originalOut);
        assertTrue(outputStream.toString().contains("Другой конструктор суперкласса"));
    }

    @Test
    public void testMultipleInstances() {
        SuperClass s1 = new SuperClass();
        SuperClass s2 = new SuperClass(1);
        SuperClass s3 = new SuperClass(100);

        assertNotNull(s1);
        assertNotNull(s2);
        assertNotNull(s3);
    }

    @Test
    public void testConstructorWithZero() {
        SuperClass superClass = new SuperClass(0);
        assertNotNull(superClass);
    }

    @Test
    public void testConstructorWithNegative() {
        SuperClass superClass = new SuperClass(-5);
        assertNotNull(superClass);
    }
}
