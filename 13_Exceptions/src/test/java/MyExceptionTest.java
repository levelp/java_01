import org.junit.Test;

import static org.junit.Assert.*;

public class MyExceptionTest {

    @Test
    public void testMyExceptionInstantiation() {
        MyException exception = new MyException();
        assertNotNull(exception);
        assertTrue(exception instanceof Exception);
    }

    @Test
    public void testMyExceptionIsCheckedException() {
        MyException exception = new MyException();
        // Verify it extends Exception (checked exception)
        assertTrue(exception instanceof Exception);
        assertFalse(exception instanceof RuntimeException);
    }
}
