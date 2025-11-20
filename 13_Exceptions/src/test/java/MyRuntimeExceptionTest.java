import org.junit.Test;

import static org.junit.Assert.*;

public class MyRuntimeExceptionTest {

    @Test
    public void testMyRuntimeExceptionInstantiation() {
        MyRuntimeException exception = new MyRuntimeException();
        assertNotNull(exception);
        assertTrue(exception instanceof RuntimeException);
    }

    @Test
    public void testMyRuntimeExceptionIsUncheckedException() {
        MyRuntimeException exception = new MyRuntimeException();
        // Verify it extends RuntimeException (unchecked exception)
        assertTrue(exception instanceof RuntimeException);
        assertTrue(exception instanceof Exception);
    }

    @Test
    public void testMyRuntimeExceptionCanBeThrown() {
        try {
            throw new MyRuntimeException();
        } catch (MyRuntimeException e) {
            // Successfully caught
            assertNotNull(e);
        }
    }
}
