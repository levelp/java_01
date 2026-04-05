import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class for MyError
 */
public class MyErrorTest {

    @Test
    public void testMyErrorCreation() {
        MyError error = new MyError();
        assertNotNull(error);
    }

    @Test
    public void testMyErrorExtendsError() {
        MyError error = new MyError();
        assertTrue(error instanceof Error);
    }

    @Test
    public void testMyErrorIsThrowable() {
        MyError error = new MyError();
        assertTrue(error instanceof Throwable);
    }

    @Test(expected = MyError.class)
    public void testMyErrorCanBeThrown() throws MyError {
        throw new MyError();
    }

    @Test
    public void testMyErrorMessage() {
        MyError error = new MyError();
        // Default message should be null
        assertNull(error.getMessage());
    }

    @Test
    public void testMyErrorStackTrace() {
        MyError error = new MyError();
        assertNotNull(error.getStackTrace());
        assertTrue(error.getStackTrace().length > 0);
    }

    @Test
    public void testMyErrorCause() {
        MyError error = new MyError();
        assertNull(error.getCause());
    }
}
