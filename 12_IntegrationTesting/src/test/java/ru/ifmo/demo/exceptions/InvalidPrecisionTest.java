package ru.ifmo.demo.exceptions;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Comprehensive test class for InvalidPrecision exception
 */
public class InvalidPrecisionTest {

    @Test
    public void testDefaultConstructor() {
        InvalidPrecision exception = new InvalidPrecision();
        assertNotNull(exception);
    }

    @Test
    public void testExceptionIsRuntimeException() {
        InvalidPrecision exception = new InvalidPrecision();
        assertTrue(exception instanceof RuntimeException);
    }

    @Test
    public void testGetMessage() {
        InvalidPrecision exception = new InvalidPrecision();
        String message = exception.getMessage();
        assertEquals("Invalid precision value", message);
    }

    @Test
    public void testGetMessageNotNull() {
        InvalidPrecision exception = new InvalidPrecision();
        assertNotNull(exception.getMessage());
    }

    @Test
    public void testGetMessageNotEmpty() {
        InvalidPrecision exception = new InvalidPrecision();
        assertFalse(exception.getMessage().isEmpty());
    }

    @Test
    public void testCanBeThrown() {
        try {
            throw new InvalidPrecision();
        } catch (InvalidPrecision e) {
            assertEquals("Invalid precision value", e.getMessage());
        }
    }

    @Test
    public void testCanBeCaught() {
        boolean caught = false;
        try {
            throw new InvalidPrecision();
        } catch (InvalidPrecision e) {
            caught = true;
        }
        assertTrue(caught);
    }

    @Test
    public void testMultipleInstances() {
        InvalidPrecision ex1 = new InvalidPrecision();
        InvalidPrecision ex2 = new InvalidPrecision();
        assertNotSame(ex1, ex2);
        assertEquals(ex1.getMessage(), ex2.getMessage());
    }

    @Test
    public void testExceptionInheritance() {
        InvalidPrecision exception = new InvalidPrecision();
        assertTrue(exception instanceof Exception);
        assertTrue(exception instanceof Throwable);
    }

    @Test
    public void testToStringContainsClassName() {
        InvalidPrecision exception = new InvalidPrecision();
        String toString = exception.toString();
        assertTrue(toString.contains("InvalidPrecision"));
    }
}
