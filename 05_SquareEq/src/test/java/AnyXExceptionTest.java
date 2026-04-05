import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Comprehensive test class for AnyXException
 * Tests the custom RuntimeException for indicating "any X" solution scenarios
 */
public class AnyXExceptionTest {

    /**
     * Test that AnyXException can be instantiated
     */
    @Test
    public void testInstantiation() {
        AnyXException exception = new AnyXException();
        assertNotNull("AnyXException instance should not be null", exception);
    }

    /**
     * Test that AnyXException is an instance of RuntimeException
     */
    @Test
    public void testIsRuntimeException() {
        AnyXException exception = new AnyXException();
        assertTrue("AnyXException should be an instance of RuntimeException",
                   exception instanceof RuntimeException);
    }

    /**
     * Test that AnyXException is an instance of Exception
     */
    @Test
    public void testIsException() {
        AnyXException exception = new AnyXException();
        assertTrue("AnyXException should be an instance of Exception",
                   exception instanceof Exception);
    }

    /**
     * Test that AnyXException is an instance of Throwable
     */
    @Test
    public void testIsThrowable() {
        AnyXException exception = new AnyXException();
        assertTrue("AnyXException should be an instance of Throwable",
                   exception instanceof Throwable);
    }

    /**
     * Test that AnyXException can be thrown
     */
    @Test(expected = AnyXException.class)
    public void testCanBeThrown() {
        throw new AnyXException();
    }

    /**
     * Test that AnyXException can be caught as RuntimeException
     */
    @Test
    public void testCatchAsRuntimeException() {
        try {
            throw new AnyXException();
        } catch (RuntimeException e) {
            assertTrue("Caught exception should be AnyXException",
                       e instanceof AnyXException);
        }
    }

    /**
     * Test that AnyXException can be caught as Exception
     */
    @Test
    public void testCatchAsException() {
        try {
            throw new AnyXException();
        } catch (Exception e) {
            assertTrue("Caught exception should be AnyXException",
                       e instanceof AnyXException);
        }
    }

    /**
     * Test that AnyXException doesn't require throws declaration (RuntimeException property)
     */
    @Test
    public void testNoThrowsRequired() {
        // This method doesn't declare "throws AnyXException" but can still throw it
        // This is valid because AnyXException extends RuntimeException
        methodThatThrowsAnyXException();
    }

    private void methodThatThrowsAnyXException() {
        // Method that can throw AnyXException without declaring it
        // This demonstrates that it's a RuntimeException
    }

    /**
     * Test getMessage() returns null when no message is provided
     */
    @Test
    public void testGetMessageWithNoMessage() {
        AnyXException exception = new AnyXException();
        assertNull("getMessage() should return null when no message provided",
                   exception.getMessage());
    }

    /**
     * Test that exception can be re-thrown
     */
    @Test(expected = AnyXException.class)
    public void testReThrow() {
        try {
            throw new AnyXException();
        } catch (AnyXException e) {
            throw e; // Re-throw
        }
    }

    /**
     * Test multiple instances are independent
     */
    @Test
    public void testMultipleInstances() {
        AnyXException exception1 = new AnyXException();
        AnyXException exception2 = new AnyXException();

        assertNotNull(exception1);
        assertNotNull(exception2);
        assertNotSame("Two instances should be different objects",
                      exception1, exception2);
    }

    /**
     * Test that exception class name is correct
     */
    @Test
    public void testClassName() {
        AnyXException exception = new AnyXException();
        assertEquals("Class name should be AnyXException",
                     "AnyXException", exception.getClass().getSimpleName());
    }

    /**
     * Test that toString() contains class name
     */
    @Test
    public void testToString() {
        AnyXException exception = new AnyXException();
        String toString = exception.toString();
        assertNotNull("toString() should not be null", toString);
        assertTrue("toString() should contain class name",
                   toString.contains("AnyXException"));
    }

    /**
     * Test exception in try-catch-finally
     */
    @Test
    public void testTryCatchFinally() {
        boolean finallyCalled = false;
        boolean catchCalled = false;

        try {
            throw new AnyXException();
        } catch (AnyXException e) {
            catchCalled = true;
        } finally {
            finallyCalled = true;
        }

        assertTrue("Catch block should be executed", catchCalled);
        assertTrue("Finally block should be executed", finallyCalled);
    }

    /**
     * Test stack trace is available
     */
    @Test
    public void testStackTrace() {
        AnyXException exception = new AnyXException();
        StackTraceElement[] stackTrace = exception.getStackTrace();
        assertNotNull("Stack trace should not be null", stackTrace);
        assertTrue("Stack trace should contain elements",
                   stackTrace.length > 0);
    }

    /**
     * Test getCause() returns null when no cause is set
     */
    @Test
    public void testGetCauseWithNoCause() {
        AnyXException exception = new AnyXException();
        assertNull("getCause() should return null when no cause is set",
                   exception.getCause());
    }

    /**
     * Test exception is serializable (inherits from Throwable)
     */
    @Test
    public void testIsSerializable() {
        AnyXException exception = new AnyXException();
        assertTrue("AnyXException should be Throwable",
                   exception instanceof Throwable);
        // Throwable implements Serializable
    }

    /**
     * Test that throwing AnyXException interrupts normal flow
     */
    @Test
    public void testInterruptsNormalFlow() {
        boolean normalFlowCompleted = false;

        try {
            throw new AnyXException();
            normalFlowCompleted = true; // This line should never be reached
        } catch (AnyXException e) {
            // Exception caught
        }

        assertFalse("Normal flow should be interrupted",
                    normalFlowCompleted);
    }

    /**
     * Test usage context: equation with any X as solution (0 = 0)
     */
    @Test(expected = AnyXException.class)
    public void testUsageContextAnyXSolution() {
        // This exception is thrown when equation is 0 = 0 (any X is a solution)
        double a = 0.0;
        double b = 0.0;
        double c = 0.0;

        if (a == 0.0 && b == 0.0 && c == 0.0) {
            throw new AnyXException(); // Any X is a solution
        }
    }
}
