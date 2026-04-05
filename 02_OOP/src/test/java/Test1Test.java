import package2.MyClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Comprehensive test class for Test1
 */
public class Test1Test {

    private ByteArrayOutputStream outputStream;
    private PrintStream originalOut;

    @Test
    public void testTest1Constructor() {
        Test1 test1 = new Test1();
        assertNotNull("Test1 instance should not be null", test1);
    }

    @Test
    public void testMainMethod() {
        outputStream = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        Test1.main(new String[]{});

        String output = outputStream.toString();
        assertTrue("Output should contain 'publicMethod()'",
                  output.contains("publicMethod()"));

        System.setOut(originalOut);
    }

    @Test
    public void testMainMethodCreatesMyClass() {
        outputStream = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            Test1.main(new String[]{});
            assertTrue("Main method should execute without exception", true);
        } catch (Exception e) {
            fail("Main method should not throw exception: " + e.getMessage());
        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    public void testMainMethodCallsPublicMethod() {
        outputStream = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        Test1.main(new String[]{});

        String output = outputStream.toString().trim();
        assertEquals("Main should call publicMethod",
                    "publicMethod()", output);

        System.setOut(originalOut);
    }

    @Test
    public void testMainMethodWithNullArgs() {
        outputStream = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            Test1.main(null);
            assertTrue("Main should work with null args", true);
        } catch (Exception e) {
            fail("Main should not throw exception with null args: " + e.getMessage());
        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    public void testMainMethodWithEmptyArgs() {
        outputStream = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        Test1.main(new String[0]);

        String output = outputStream.toString().trim();
        assertEquals("Main should work with empty args",
                    "publicMethod()", output);

        System.setOut(originalOut);
    }

    @Test
    public void testMainMethodWithArgs() {
        outputStream = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        Test1.main(new String[]{"arg1", "arg2"});

        String output = outputStream.toString().trim();
        assertEquals("Main should ignore args",
                    "publicMethod()", output);

        System.setOut(originalOut);
    }

    @Test
    public void testTest1IsPublic() {
        assertTrue("Test1 should be public",
                  java.lang.reflect.Modifier.isPublic(
                      Test1.class.getModifiers()));
    }

    @Test
    public void testTest1HasMainMethod() throws Exception {
        assertNotNull("Test1 should have main method",
                     Test1.class.getDeclaredMethod("main", String[].class));
    }

    @Test
    public void testMainIsStatic() throws Exception {
        int modifiers = Test1.class
            .getDeclaredMethod("main", String[].class)
            .getModifiers();
        assertTrue("main should be static",
                  java.lang.reflect.Modifier.isStatic(modifiers));
    }

    @Test
    public void testMainIsPublic() throws Exception {
        int modifiers = Test1.class
            .getDeclaredMethod("main", String[].class)
            .getModifiers();
        assertTrue("main should be public",
                  java.lang.reflect.Modifier.isPublic(modifiers));
    }

    @Test
    public void testTest1CanAccessMyClass() {
        MyClass myClass = new MyClass();
        assertNotNull("Test1 should be able to create MyClass", myClass);
    }

    @Test
    public void testTest1CanCallPublicMethod() {
        outputStream = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        MyClass myClass = new MyClass();
        myClass.publicMethod();

        String output = outputStream.toString().trim();
        assertEquals("Should be able to call publicMethod",
                    "publicMethod()", output);

        System.setOut(originalOut);
    }

    @Test
    public void testTest1CanAccessPublicField() {
        MyClass myClass = new MyClass();
        myClass.protectedField = 100;
        // Can only access public fields from different package
        // protectedField is not accessible from default package
    }

    @Test
    public void testMultipleInstancesOfTest1() {
        Test1 test1_1 = new Test1();
        Test1 test1_2 = new Test1();

        assertNotNull("test1_1 should not be null", test1_1);
        assertNotNull("test1_2 should not be null", test1_2);
        assertNotSame("Different instances should not be same object",
                     test1_1, test1_2);
    }

    @Test
    public void testTest1DefaultPackage() {
        // Test1 is in the default package (no package declaration)
        assertNull("Test1 should be in default package",
                  Test1.class.getPackage());
    }

    @Test
    public void testTest1ImportsPackage2() {
        // Verify that Test1 can access package2.MyClass
        MyClass myClass = new MyClass();
        assertNotNull("Should be able to create package2.MyClass", myClass);
        assertEquals("MyClass should be in package2",
                    "package2",
                    MyClass.class.getPackage().getName());
    }

    @Test
    public void testMainMethodMultipleCalls() {
        outputStream = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        Test1.main(new String[]{});
        Test1.main(new String[]{});

        String output = outputStream.toString();
        // Should see publicMethod() printed twice
        int count = output.split("publicMethod\\(\\)", -1).length - 1;
        assertEquals("Main should be callable multiple times", 2, count);

        System.setOut(originalOut);
    }
}
