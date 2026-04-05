import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.*;

/**
 * Test class for MyRuntimeException
 */
public class MyRuntimeExceptionTest {

    @Test
    public void testMyRuntimeExceptionCreation() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        MyRuntimeException exception = new MyRuntimeException();

        System.setOut(originalOut);

        assertNotNull(exception);
        assertTrue(outContent.toString().contains("MyRuntimeException.MyRuntimeException"));
    }

    @Test
    public void testMyRuntimeExceptionExtendsRuntimeException() {
        MyRuntimeException exception = new MyRuntimeException();
        assertTrue(exception instanceof RuntimeException);
    }

    @Test
    public void testMyRuntimeExceptionIsException() {
        MyRuntimeException exception = new MyRuntimeException();
        assertTrue(exception instanceof Exception);
    }

    @Test
    public void testMyRuntimeExceptionIsThrowable() {
        MyRuntimeException exception = new MyRuntimeException();
        assertTrue(exception instanceof Throwable);
    }

    @Test(expected = MyRuntimeException.class)
    public void testMyRuntimeExceptionCanBeThrown() {
        throw new MyRuntimeException();
    }

    @Test
    public void testMyRuntimeExceptionStackTrace() {
        MyRuntimeException exception = new MyRuntimeException();
        assertNotNull(exception.getStackTrace());
        assertTrue(exception.getStackTrace().length > 0);
    }

    @Test
    public void testMyRuntimeExceptionCause() {
        MyRuntimeException exception = new MyRuntimeException();
        assertNull(exception.getCause());
    }

    @Test
    public void testMyRuntimeExceptionInTryCatch() {
        boolean caught = false;
        try {
            throw new MyRuntimeException();
        } catch (MyRuntimeException e) {
            caught = true;
        }
        assertTrue(caught);
    }

    @Test
    public void testMyRuntimeExceptionMessage() {
        MyRuntimeException exception = new MyRuntimeException();
        // Message should be null as constructor doesn't set one
        assertNull(exception.getMessage());
    }
}
