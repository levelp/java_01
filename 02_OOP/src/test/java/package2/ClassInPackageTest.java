package package2;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class ClassInPackageTest {

    @Test
    public void testClassInPackageConstruction() {
        ClassInPackage classInPackage = new ClassInPackage();
        assertNotNull(classInPackage);
    }

    @Test
    public void testClassInPackageHasMainMethod() {
        try {
            ClassInPackage.class.getMethod("main", String[].class);
            assertTrue(true);
        } catch (NoSuchMethodException e) {
            fail("main method should exist");
        }
    }

    @Test
    public void testMainMethodOutput() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        ClassInPackage.main(new String[]{});

        System.setOut(originalOut);
        String output = outputStream.toString();
        assertTrue(output.contains("i = 10"));
    }

    @Test
    public void testMainMethodPrintsCorrectValue() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        ClassInPackage.main(null);

        System.setOut(originalOut);
        assertTrue(outputStream.toString().contains("10"));
    }

    @Test
    public void testClassCanBeInstantiated() {
        ClassInPackage instance = new ClassInPackage();
        assertNotNull(instance);
        assertTrue(instance instanceof ClassInPackage);
    }
}
