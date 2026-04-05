package exceptions;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class for exceptions.MyRuntimeException
 */
public class MyRuntimeExceptionTest {

    @Test
    public void testMyRuntimeExceptionWithMessage() {
        String message = "Test error message";
        MyRuntimeException exception = new MyRuntimeException(message);
        assertEquals(message, exception.getMessage());
    }

    @Test
    public void testMyRuntimeExceptionExtendsRuntimeException() {
        MyRuntimeException exception = new MyRuntimeException("test");
        assertTrue(exception instanceof RuntimeException);
    }

    @Test
    public void testMyRuntimeExceptionIsException() {
        MyRuntimeException exception = new MyRuntimeException("test");
        assertTrue(exception instanceof Exception);
    }

    @Test
    public void testMyRuntimeExceptionIsThrowable() {
        MyRuntimeException exception = new MyRuntimeException("test");
        assertTrue(exception instanceof Throwable);
    }

    @Test(expected = MyRuntimeException.class)
    public void testMyRuntimeExceptionCanBeThrown() {
        throw new MyRuntimeException("error");
    }

    @Test
    public void testMyRuntimeExceptionWithEmptyMessage() {
        MyRuntimeException exception = new MyRuntimeException("");
        assertEquals("", exception.getMessage());
    }

    @Test
    public void testMyRuntimeExceptionWithNullMessage() {
        MyRuntimeException exception = new MyRuntimeException(null);
        assertNull(exception.getMessage());
    }

    @Test
    public void testMyRuntimeExceptionStackTrace() {
        MyRuntimeException exception = new MyRuntimeException("test");
        assertNotNull(exception.getStackTrace());
        assertTrue(exception.getStackTrace().length > 0);
    }

    @Test
    public void testMyRuntimeExceptionCause() {
        MyRuntimeException exception = new MyRuntimeException("test");
        assertNull(exception.getCause());
    }

    @Test
    public void testMyRuntimeExceptionInTryCatch() {
        boolean caught = false;
        String testMessage = "Test exception";
        try {
            throw new MyRuntimeException(testMessage);
        } catch (MyRuntimeException e) {
            caught = true;
            assertEquals(testMessage, e.getMessage());
        }
        assertTrue(caught);
    }
}
