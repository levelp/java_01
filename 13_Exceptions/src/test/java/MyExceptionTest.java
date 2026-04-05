import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.*;

/**
 * Test class for MyException
 */
public class MyExceptionTest {

    @Test
    public void testMyExceptionCreation() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        MyException exception = new MyException();

        System.setOut(originalOut);

        assertNotNull(exception);
        assertTrue(outContent.toString().contains("MyException.MyException"));
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
        }
        assertTrue(caught);
    }
}
