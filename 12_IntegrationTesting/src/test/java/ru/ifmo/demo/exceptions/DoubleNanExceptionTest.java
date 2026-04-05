package ru.ifmo.demo.exceptions;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Comprehensive test class for DoubleNanException
 */
public class DoubleNanExceptionTest {

    @Test
    public void testDefaultConstructor() {
        DoubleNanException exception = new DoubleNanException();
        assertNotNull(exception);
    }

    @Test
    public void testExceptionIsRuntimeException() {
        DoubleNanException exception = new DoubleNanException();
        assertTrue(exception instanceof RuntimeException);
    }

    @Test
    public void testGetMessage() {
        DoubleNanException exception = new DoubleNanException();
        String message = exception.getMessage();
        assertEquals("Precision is too low or X is too high", message);
    }

    @Test
    public void testGetMessageNotNull() {
        DoubleNanException exception = new DoubleNanException();
        assertNotNull(exception.getMessage());
    }

    @Test
    public void testGetMessageNotEmpty() {
        DoubleNanException exception = new DoubleNanException();
        assertFalse(exception.getMessage().isEmpty());
    }

    @Test
    public void testCanBeThrown() {
        try {
            throw new DoubleNanException();
        } catch (DoubleNanException e) {
            assertEquals("Precision is too low or X is too high", e.getMessage());
        }
    }

    @Test
    public void testCanBeCaught() {
        boolean caught = false;
        try {
            throw new DoubleNanException();
        } catch (DoubleNanException e) {
            caught = true;
        }
        assertTrue(caught);
    }

    @Test
    public void testMultipleInstances() {
        DoubleNanException ex1 = new DoubleNanException();
        DoubleNanException ex2 = new DoubleNanException();
        assertNotSame(ex1, ex2);
        assertEquals(ex1.getMessage(), ex2.getMessage());
    }

    @Test
    public void testExceptionInheritance() {
        DoubleNanException exception = new DoubleNanException();
        assertTrue(exception instanceof Exception);
        assertTrue(exception instanceof Throwable);
    }

    @Test
    public void testToStringContainsClassName() {
        DoubleNanException exception = new DoubleNanException();
        String toString = exception.toString();
        assertTrue(toString.contains("DoubleNanException"));
    }
}
