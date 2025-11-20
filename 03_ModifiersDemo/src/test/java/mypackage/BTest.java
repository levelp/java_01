package mypackage;

import org.junit.Test;

import static org.junit.Assert.*;

public class BTest {

    @Test
    public void testBConstruction() {
        B b = new B();
        assertNotNull(b);
    }

    @Test
    public void testBExtendsA() {
        B b = new B();
        assertTrue(b instanceof A);
    }

    @Test
    public void testBM1Method() {
        B b = new B();
        b.m1();
        // After calling m1, protectedField should be 4
        assertEquals(4, b.protectedField);
        assertEquals(12, b.packageField);
    }

    @Test
    public void testBInheritsPublicField() {
        B b = new B();
        b.publicField = 100;
        assertEquals(100, b.publicField);
    }

    @Test
    public void testBInheritsProtectedField() {
        B b = new B();
        b.protectedField = 50;
        assertEquals(50, b.protectedField);
    }

    @Test
    public void testBInheritsPackageField() {
        B b = new B();
        b.packageField = 75;
        assertEquals(75, b.packageField);
    }

    @Test
    public void testBCanCallMa() {
        B b = new B();
        b.ma(); // Inherited from A
        assertEquals(11, b.packageField);
    }

    @Test
    public void testBInitialFieldValues() {
        B b = new B();
        assertEquals(4, b.publicField);
        assertEquals(2, b.protectedField);
        assertEquals(3, b.packageField);
    }
}
