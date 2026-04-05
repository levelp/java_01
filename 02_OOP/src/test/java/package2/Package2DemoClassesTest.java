package package2;

import org.junit.Test;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Comprehensive test class for package2.ClassInPackage and package2.TestInSamePackage
 */
public class Package2DemoClassesTest {

    private ByteArrayOutputStream outputStream;
    private PrintStream originalOut;

    // Tests for ClassInPackage

    @Test
    public void testClassInPackageConstructor() {
        ClassInPackage obj = new ClassInPackage();
        assertNotNull("ClassInPackage instance should not be null", obj);
    }

    @Test
    public void testClassInPackageMainMethod() {
        outputStream = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        ClassInPackage.main(new String[]{});

        String output = outputStream.toString();
        assertTrue("Output should contain 'i = 10'", output.contains("i = 10"));

        System.setOut(originalOut);
    }

    @Test
    public void testClassInPackageMainMethodPrintsCorrectValue() {
        outputStream = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        ClassInPackage.main(new String[]{});

        String output = outputStream.toString().trim();
        assertEquals("Main should print 'i = 10'", "i = 10", output);

        System.setOut(originalOut);
    }

    @Test
    public void testClassInPackageMainMethodWithNullArgs() {
        outputStream = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        ClassInPackage.main(null);

        String output = outputStream.toString().trim();
        assertEquals("Main should work with null args", "i = 10", output);

        System.setOut(originalOut);
    }

    @Test
    public void testClassInPackageMainMethodWithEmptyArgs() {
        outputStream = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        ClassInPackage.main(new String[0]);

        String output = outputStream.toString().trim();
        assertEquals("Main should work with empty args", "i = 10", output);

        System.setOut(originalOut);
    }

    @Test
    public void testClassInPackageMainMethodWithArgs() {
        outputStream = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        ClassInPackage.main(new String[]{"arg1", "arg2"});

        String output = outputStream.toString().trim();
        assertEquals("Main should ignore args", "i = 10", output);

        System.setOut(originalOut);
    }

    @Test
    public void testClassInPackageIsPublic() {
        assertTrue("ClassInPackage should be public",
                  java.lang.reflect.Modifier.isPublic(
                      ClassInPackage.class.getModifiers()));
    }

    @Test
    public void testClassInPackageHasMainMethod() throws Exception {
        assertNotNull("ClassInPackage should have main method",
                     ClassInPackage.class.getDeclaredMethod("main",
                                                           String[].class));
    }

    @Test
    public void testClassInPackageMainIsStatic() throws Exception {
        int modifiers = ClassInPackage.class
            .getDeclaredMethod("main", String[].class)
            .getModifiers();
        assertTrue("main should be static",
                  java.lang.reflect.Modifier.isStatic(modifiers));
    }

    @Test
    public void testClassInPackageMainIsPublic() throws Exception {
        int modifiers = ClassInPackage.class
            .getDeclaredMethod("main", String[].class)
            .getModifiers();
        assertTrue("main should be public",
                  java.lang.reflect.Modifier.isPublic(modifiers));
    }

    // Tests for TestInSamePackage

    @Test
    public void testTestInSamePackageConstructor() {
        TestInSamePackage obj = new TestInSamePackage();
        assertNotNull("TestInSamePackage instance should not be null", obj);
    }

    @Test
    public void testTestInSamePackageMainMethod() {
        try {
            TestInSamePackage.main(new String[]{});
            assertTrue("Main method should execute without exception", true);
        } catch (Exception e) {
            fail("Main method should not throw exception: " + e.getMessage());
        }
    }

    @Test
    public void testTestInSamePackageCanAccessMyClass() {
        MyClass myClass = new MyClass();
        myClass.field1 = 10;
        assertEquals("TestInSamePackage should access MyClass.field1",
                    10, myClass.field1);
    }

    @Test
    public void testTestInSamePackageCannotAccessPrivateField() throws Exception {
        MyClass myClass = new MyClass();
        // Private field is not directly accessible
        java.lang.reflect.Field field = MyClass.class.getDeclaredField("privateField");
        assertTrue("privateField should be private",
                  java.lang.reflect.Modifier.isPrivate(field.getModifiers()));
    }

    @Test
    public void testTestInSamePackageIsPublic() {
        assertTrue("TestInSamePackage should be public",
                  java.lang.reflect.Modifier.isPublic(
                      TestInSamePackage.class.getModifiers()));
    }

    @Test
    public void testTestInSamePackageHasMainMethod() throws Exception {
        assertNotNull("TestInSamePackage should have main method",
                     TestInSamePackage.class.getDeclaredMethod("main",
                                                              String[].class));
    }

    @Test
    public void testTestInSamePackageMainIsStatic() throws Exception {
        int modifiers = TestInSamePackage.class
            .getDeclaredMethod("main", String[].class)
            .getModifiers();
        assertTrue("main should be static",
                  java.lang.reflect.Modifier.isStatic(modifiers));
    }

    @Test
    public void testTestInSamePackageMainIsPublic() throws Exception {
        int modifiers = TestInSamePackage.class
            .getDeclaredMethod("main", String[].class)
            .getModifiers();
        assertTrue("main should be public",
                  java.lang.reflect.Modifier.isPublic(modifiers));
    }

    @Test
    public void testTestInSamePackageMainWithNullArgs() {
        try {
            TestInSamePackage.main(null);
            assertTrue("Main should work with null args", true);
        } catch (Exception e) {
            fail("Main should not throw exception with null args: " + e.getMessage());
        }
    }

    @Test
    public void testTestInSamePackageMainWithEmptyArgs() {
        try {
            TestInSamePackage.main(new String[0]);
            assertTrue("Main should work with empty args", true);
        } catch (Exception e) {
            fail("Main should not throw exception with empty args: " + e.getMessage());
        }
    }

    @Test
    public void testBothClassesInSamePackage() {
        assertEquals("Both classes should be in package2",
                    "package2",
                    ClassInPackage.class.getPackage().getName());
        assertEquals("Both classes should be in package2",
                    "package2",
                    TestInSamePackage.class.getPackage().getName());
    }

    @Test
    public void testMultipleInstancesOfClassInPackage() {
        ClassInPackage obj1 = new ClassInPackage();
        ClassInPackage obj2 = new ClassInPackage();

        assertNotNull("obj1 should not be null", obj1);
        assertNotNull("obj2 should not be null", obj2);
        assertNotSame("Different instances should not be same object", obj1, obj2);
    }

    @Test
    public void testMultipleInstancesOfTestInSamePackage() {
        TestInSamePackage obj1 = new TestInSamePackage();
        TestInSamePackage obj2 = new TestInSamePackage();

        assertNotNull("obj1 should not be null", obj1);
        assertNotNull("obj2 should not be null", obj2);
        assertNotSame("Different instances should not be same object", obj1, obj2);
    }
}
