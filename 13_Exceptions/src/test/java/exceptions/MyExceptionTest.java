package exceptions;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class for exceptions.MyException
 */
public class MyExceptionTest {

    @Test
    public void testMyExceptionCreation() {
        MyException exception = new MyException();
        assertNotNull(exception);
    }

    @Test
    public void testMyExceptionMessage() {
        MyException exception = new MyException();
        assertEquals("MyException", exception.getMessage());
    }

    @Test
    public void testMyExceptionExtendsException() {
        MyException exception = new MyException();
        assertTrue(exception instanceof Exception);
    }

    @Test
    public void testMyExceptionIsThrowable() {
        MyException exception = new MyException();
        assertTrue(exception instanceof Throwable);
    }

    @Test(expected = MyException.class)
    public void testMyExceptionCanBeThrown() throws MyException {
        throw new MyException();
    }

    @Test
    public void testMyExceptionStackTrace() {
        MyException exception = new MyException();
        assertNotNull(exception.getStackTrace());
        assertTrue(exception.getStackTrace().length > 0);
    }

    @Test
    public void testMyExceptionCause() {
        MyException exception = new MyException();
        assertNull(exception.getCause());
    }

    @Test
    public void testMyExceptionInTryCatch() {
        boolean caught = false;
        try {
            throw new MyException();
        } catch (MyException e) {
            caught = true;
            assertEquals("MyException", e.getMessage());
        }
        assertTrue(caught);
    }

    @Test
    public void testMyExceptionFields() {
        MyException exception = new MyException();
        // Test that fields exist (they're public)
        exception.myStringParam = "test";
        exception.intParam = 42;

        assertEquals("test", exception.myStringParam);
        assertEquals(42, exception.intParam);
    }

    @Test
    public void testMyExceptionDefaultFields() {
        MyException exception = new MyException();
        // Fields should be null/0 by default
        assertNull(exception.myStringParam);
        assertEquals(0, exception.intParam);
    }
}
