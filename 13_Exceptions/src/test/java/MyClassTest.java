import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.*;

/**
 * Test class for MyClass (exceptions demo)
 */
public class MyClassTest {

    @Test(expected = MyRuntimeException.class)
    public void testMainThrowsMyRuntimeExceptionForCase1() throws MyException {
        MyClass.main(new String[]{});
    }

    @Test
    public void testMyRuntimeExceptionIsCaught() throws MyException {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        try {
            MyClass myClass = new MyClass();
            // This should catch MyRuntimeException
        } catch (MyRuntimeException e) {
            // Expected
        } finally {
            System.setOut(originalOut);
        }
    }

    @Test(expected = MyError.class)
    public void testMethod1ThrowsMyErrorForCase2() throws Exception {
        MyClass myClass = new MyClass();
        java.lang.reflect.Method method = MyClass.class.getDeclaredMethod("method1", int.class);
        method.setAccessible(true);
        method.invoke(myClass, 2);
    }

    @Test(expected = MyException.class)
    public void testMethod1ThrowsMyExceptionForCase3() throws Exception {
        MyClass myClass = new MyClass();
        java.lang.reflect.Method method = MyClass.class.getDeclaredMethod("method1", int.class);
        method.setAccessible(true);
        try {
            method.invoke(myClass, 3);
        } catch (java.lang.reflect.InvocationTargetException e) {
            if (e.getCause() instanceof MyException) {
                throw (MyException) e.getCause();
            }
            throw e;
        }
    }

    @Test
    public void testMyClassCreation() {
        MyClass myClass = new MyClass();
        assertNotNull(myClass);
    }

    @Test
    public void testMyClassHasMainMethod() throws NoSuchMethodException {
        assertNotNull(MyClass.class.getMethod("main", String[].class));
    }

    @Test
    public void testMyClassHasMethod1() throws NoSuchMethodException {
        assertNotNull(MyClass.class.getDeclaredMethod("method1", int.class));
    }

    @Test
    public void testExceptionHandling() {
        boolean runtimeExceptionCaught = false;
        try {
            throw new MyRuntimeException();
        } catch (MyRuntimeException e) {
            runtimeExceptionCaught = true;
        }
        assertTrue(runtimeExceptionCaught);
    }

    @Test
    public void testMyRuntimeExceptionPrintsMessage() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        MyRuntimeException exception = new MyRuntimeException();

        System.setOut(originalOut);

        assertTrue(outContent.toString().contains("MyRuntimeException.MyRuntimeException"));
    }

    @Test
    public void testMethod1ThrowsMyRuntimeExceptionForCase1() throws Exception {
        MyClass myClass = new MyClass();
        java.lang.reflect.Method method = MyClass.class.getDeclaredMethod("method1", int.class);
        method.setAccessible(true);

        try {
            method.invoke(myClass, 1);
            fail("Expected MyRuntimeException");
        } catch (java.lang.reflect.InvocationTargetException e) {
            assertTrue(e.getCause() instanceof MyRuntimeException);
        }
    }

    @Test
    public void testMethod1DefaultCaseNoException() throws Exception {
        // Test that passing a value other than 1, 2, or 3 doesn't throw any exception
        MyClass myClass = new MyClass();
        java.lang.reflect.Method method = MyClass.class.getDeclaredMethod("method1", int.class);
        method.setAccessible(true);

        // Should not throw any exception for case 0
        method.invoke(myClass, 0);

        // Should not throw any exception for case 4
        method.invoke(myClass, 4);

        // Should not throw any exception for negative numbers
        method.invoke(myClass, -1);
    }

    @Test
    public void testMethod1AllCases() throws Exception {
        MyClass myClass = new MyClass();
        java.lang.reflect.Method method = MyClass.class.getDeclaredMethod("method1", int.class);
        method.setAccessible(true);

        // Test case 1 - MyRuntimeException
        try {
            method.invoke(myClass, 1);
            fail("Expected MyRuntimeException for case 1");
        } catch (java.lang.reflect.InvocationTargetException e) {
            assertTrue("Case 1 should throw MyRuntimeException", e.getCause() instanceof MyRuntimeException);
        }

        // Test case 2 - MyError
        try {
            method.invoke(myClass, 2);
            fail("Expected MyError for case 2");
        } catch (java.lang.reflect.InvocationTargetException e) {
            assertTrue("Case 2 should throw MyError", e.getCause() instanceof MyError);
        }

        // Test case 3 - MyException
        try {
            method.invoke(myClass, 3);
            fail("Expected MyException for case 3");
        } catch (java.lang.reflect.InvocationTargetException e) {
            assertTrue("Case 3 should throw MyException", e.getCause() instanceof MyException);
        }
    }

    @Test
    public void testMethod1IsPrivate() throws NoSuchMethodException {
        java.lang.reflect.Method method = MyClass.class.getDeclaredMethod("method1", int.class);
        assertTrue(java.lang.reflect.Modifier.isPrivate(method.getModifiers()));
    }

    @Test
    public void testMainMethodDeclaresMyException() throws NoSuchMethodException {
        java.lang.reflect.Method mainMethod = MyClass.class.getMethod("main", String[].class);
        Class<?>[] exceptionTypes = mainMethod.getExceptionTypes();

        boolean declaresMyException = false;
        for (Class<?> exceptionType : exceptionTypes) {
            if (exceptionType == MyException.class) {
                declaresMyException = true;
                break;
            }
        }
        assertTrue("main method should declare MyException", declaresMyException);
    }
}
