package ru.ifmo.demo.exceptions;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Comprehensive test class for ZeroPrecision exception
 */
public class ZeroPrecisionTest {

    @Test
    public void testDefaultConstructor() {
        ZeroPrecision exception = new ZeroPrecision();
        assertNotNull(exception);
    }

    @Test
    public void testExceptionIsRuntimeException() {
        ZeroPrecision exception = new ZeroPrecision();
        assertTrue(exception instanceof RuntimeException);
    }

    @Test
    public void testGetMessage() {
        ZeroPrecision exception = new ZeroPrecision();
        String message = exception.getMessage();
        assertEquals("Precision can not be zero", message);
    }

    @Test
    public void testGetMessageNotNull() {
        ZeroPrecision exception = new ZeroPrecision();
        assertNotNull(exception.getMessage());
    }

    @Test
    public void testGetMessageNotEmpty() {
        ZeroPrecision exception = new ZeroPrecision();
        assertFalse(exception.getMessage().isEmpty());
    }

    @Test
    public void testCanBeThrown() {
        try {
            throw new ZeroPrecision();
        } catch (ZeroPrecision e) {
            assertEquals("Precision can not be zero", e.getMessage());
        }
    }

    @Test
    public void testCanBeCaught() {
        boolean caught = false;
        try {
            throw new ZeroPrecision();
        } catch (ZeroPrecision e) {
            caught = true;
        }
        assertTrue(caught);
    }

    @Test
    public void testMultipleInstances() {
        ZeroPrecision ex1 = new ZeroPrecision();
        ZeroPrecision ex2 = new ZeroPrecision();
        assertNotSame(ex1, ex2);
        assertEquals(ex1.getMessage(), ex2.getMessage());
    }

    @Test
    public void testExceptionInheritance() {
        ZeroPrecision exception = new ZeroPrecision();
        assertTrue(exception instanceof Exception);
        assertTrue(exception instanceof Throwable);
    }

    @Test
    public void testToStringContainsClassName() {
        ZeroPrecision exception = new ZeroPrecision();
        String toString = exception.toString();
        assertTrue(toString.contains("ZeroPrecision"));
    }
}
