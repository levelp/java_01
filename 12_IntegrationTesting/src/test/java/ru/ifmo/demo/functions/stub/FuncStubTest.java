package ru.ifmo.demo.functions.stub;

import org.junit.Test;
import ru.ifmo.demo.functions.IFunc;

import static org.junit.Assert.*;

/**
 * Comprehensive test class for FuncStub
 */
public class FuncStubTest {

    @Test
    public void testDefaultConstructor() {
        FuncStub stub = new FuncStub();
        assertNotNull(stub);
    }

    @Test
    public void testImplementsIFunc() {
        FuncStub stub = new FuncStub();
        assertTrue(stub instanceof IFunc);
    }

    @Test
    public void testGetAlwaysReturnsOne() {
        FuncStub stub = new FuncStub();
        assertEquals(1.0, stub.get(0), 0.0);
    }

    @Test
    public void testGetWithPositiveValue() {
        FuncStub stub = new FuncStub();
        assertEquals(1.0, stub.get(10.5), 0.0);
    }

    @Test
    public void testGetWithNegativeValue() {
        FuncStub stub = new FuncStub();
        assertEquals(1.0, stub.get(-10.5), 0.0);
    }

    @Test
    public void testGetWithZero() {
        FuncStub stub = new FuncStub();
        assertEquals(1.0, stub.get(0.0), 0.0);
    }

    @Test
    public void testGetWithLargePositiveValue() {
        FuncStub stub = new FuncStub();
        assertEquals(1.0, stub.get(Double.MAX_VALUE), 0.0);
    }

    @Test
    public void testGetWithLargeNegativeValue() {
        FuncStub stub = new FuncStub();
        assertEquals(1.0, stub.get(-Double.MAX_VALUE), 0.0);
    }

    @Test
    public void testGetWithInfinity() {
        FuncStub stub = new FuncStub();
        assertEquals(1.0, stub.get(Double.POSITIVE_INFINITY), 0.0);
    }

    @Test
    public void testGetWithNegativeInfinity() {
        FuncStub stub = new FuncStub();
        assertEquals(1.0, stub.get(Double.NEGATIVE_INFINITY), 0.0);
    }

    @Test
    public void testGetWithNaN() {
        FuncStub stub = new FuncStub();
        assertEquals(1.0, stub.get(Double.NaN), 0.0);
    }

    @Test
    public void testMultipleCalls() {
        FuncStub stub = new FuncStub();
        for (int i = 0; i < 100; i++) {
            assertEquals(1.0, stub.get(i), 0.0);
        }
    }

    @Test
    public void testConsistency() {
        FuncStub stub = new FuncStub();
        double result1 = stub.get(5.5);
        double result2 = stub.get(5.5);
        assertEquals(result1, result2, 0.0);
    }

    @Test
    public void testMultipleInstances() {
        FuncStub stub1 = new FuncStub();
        FuncStub stub2 = new FuncStub();
        assertEquals(stub1.get(10), stub2.get(10), 0.0);
    }
}
