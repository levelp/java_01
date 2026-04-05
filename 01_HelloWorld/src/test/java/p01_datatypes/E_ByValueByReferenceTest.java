package p01_datatypes;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import static org.junit.Assert.*;

/**
 * Test class for E_ByValueByReference
 */
public class E_ByValueByReferenceTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testMainRunsWithoutErrors() {
        E_ByValueByReference.main(new String[]{});
        assertNotNull(outContent.toString());
    }

    @Test
    public void testMainOutputContainsByValueDemo() {
        E_ByValueByReference.main(new String[]{});
        String output = outContent.toString();
        assertTrue(output.contains("Перед вызовом method1"));
        assertTrue(output.contains("После вызова method1"));
    }

    @Test
    public void testMainOutputContainsByReferenceDemo() {
        E_ByValueByReference.main(new String[]{});
        String output = outContent.toString();
        assertTrue(output.contains("Перед вызовом method2"));
        assertTrue(output.contains("После вызова method2"));
    }

    @Test
    public void testMethod1Exists() throws NoSuchMethodException {
        Method method = E_ByValueByReference.class.getDeclaredMethod("method1", int.class);
        assertNotNull(method);
        assertTrue(Modifier.isStatic(method.getModifiers()));
    }

    @Test
    public void testMyMethod2Exists() throws NoSuchMethodException {
        // Find the inner class MyClass first
        Class<?> myClass = null;
        for (Class<?> innerClass : E_ByValueByReference.class.getDeclaredClasses()) {
            if (innerClass.getSimpleName().equals("MyClass")) {
                myClass = innerClass;
                break;
            }
        }
        assertNotNull(myClass);

        Method method = E_ByValueByReference.class.getDeclaredMethod("myMethod2", myClass);
        assertNotNull(method);
        assertTrue(Modifier.isStatic(method.getModifiers()));
    }

    @Test
    public void testInnerClassMyClassExists() {
        boolean found = false;
        for (Class<?> innerClass : E_ByValueByReference.class.getDeclaredClasses()) {
            if (innerClass.getSimpleName().equals("MyClass")) {
                found = true;
                break;
            }
        }
        assertTrue(found);
    }

    @Test
    public void testMainMethodExists() throws NoSuchMethodException {
        assertNotNull(E_ByValueByReference.class.getMethod("main", String[].class));
    }

    @Test
    public void testClassIsPublic() {
        assertTrue(Modifier.isPublic(E_ByValueByReference.class.getModifiers()));
    }

    @Test
    public void testMainMethodIsStatic() throws NoSuchMethodException {
        assertTrue(Modifier.isStatic(
            E_ByValueByReference.class.getMethod("main", String[].class).getModifiers()));
    }

    @Test
    public void testPackage() {
        assertEquals("p01_datatypes", E_ByValueByReference.class.getPackage().getName());
    }

    @Test
    public void testOutputNotEmpty() {
        E_ByValueByReference.main(new String[]{});
        assertFalse(outContent.toString().trim().isEmpty());
    }
}
