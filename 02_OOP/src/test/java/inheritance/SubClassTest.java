package inheritance;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class SubClassTest {

    @Test
    public void testSubClassConstruction() {
        SubClass subClass = new SubClass();
        assertNotNull(subClass);
    }

    @Test
    public void testSubClassExtendsSuperClass() {
        SubClass subClass = new SubClass();
        assertTrue(subClass instanceof SuperClass);
    }

    @Test
    public void testSubClassConstructorCallsSuperConstructor() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        new SubClass();

        System.setOut(originalOut);
        String output = outputStream.toString();
        assertTrue(output.contains("Другой конструктор суперкласса"));
        assertTrue(output.contains("Конструктор Подкласса"));
    }

    @Test
    public void testSubClassConstructorOrder() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        new SubClass();

        System.setOut(originalOut);
        String output = outputStream.toString();
        // Verify super constructor is called before subclass constructor
        int superIndex = output.indexOf("Другой конструктор суперкласса");
        int subIndex = output.indexOf("Конструктор Подкласса");
        assertTrue(superIndex < subIndex);
    }

    @Test
    public void testSubClassHasMainMethod() {
        try {
            SubClass.class.getMethod("main", String[].class);
            assertTrue(true);
        } catch (NoSuchMethodException e) {
            fail("main method should exist");
        }
    }

    @Test
    public void testMultipleSubClassInstances() {
        SubClass sub1 = new SubClass();
        SubClass sub2 = new SubClass();

        assertNotNull(sub1);
        assertNotNull(sub2);
        assertNotSame(sub1, sub2);
    }
}
