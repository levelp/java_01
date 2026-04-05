import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class for ExceptionsDemo
 */
public class ExceptionsDemoTest {

    @Test(expected = exceptions.MyRuntimeException.class)
    public void testMainThrowsMyRuntimeException() throws exceptions.MyException {
        ExceptionsDemo.main(new String[]{});
    }

    @Test
    public void testExceptionsDemoHasMainMethod() throws NoSuchMethodException {
        assertNotNull(ExceptionsDemo.class.getMethod("main", String[].class));
    }

    @Test
    public void testMainMethodThrowsMyException() {
        try {
            java.lang.reflect.Method method = ExceptionsDemo.class.getMethod("main", String[].class);
            Class<?>[] exceptionTypes = method.getExceptionTypes();

            boolean throwsMyException = false;
            for (Class<?> exceptionType : exceptionTypes) {
                if (exceptionType.getName().equals("exceptions.MyException")) {
                    throwsMyException = true;
                    break;
                }
            }
            assertTrue(throwsMyException);
        } catch (NoSuchMethodException e) {
            fail("main method not found");
        }
    }

    @Test
    public void testMyRuntimeExceptionWithMessage() {
        exceptions.MyRuntimeException exception = new exceptions.MyRuntimeException("xxx");
        assertEquals("xxx", exception.getMessage());
    }

    @Test(expected = exceptions.MyRuntimeException.class)
    public void testThrowMyRuntimeException() {
        throw new exceptions.MyRuntimeException("test message");
    }

    @Test(expected = exceptions.MyException.class)
    public void testThrowMyException() throws exceptions.MyException {
        throw new exceptions.MyException();
    }

    @Test
    public void testConditionalLogic() {
        boolean condition = 1 < 2;
        assertTrue(condition);
    }
}
