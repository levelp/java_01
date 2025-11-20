package mypackage;

import org.junit.Test;

import static org.junit.Assert.*;

public class CTest {

    @Test
    public void testCConstruction() {
        C c = new C();
        assertNotNull(c);
    }

    @Test
    public void testCExtendsB() {
        C c = new C();
        assertTrue(c instanceof B);
    }

    @Test
    public void testCExtendsA() {
        C c = new C();
        assertTrue(c instanceof A);
    }

    @Test
    public void testCMcMethod() {
        C c = new C();
        c.mc();
        // After calling mc, protectedField should be 1000
        assertEquals(1000, c.protectedField);
        assertEquals(112, c.packageField);
    }

    @Test
    public void testCInheritsPublicField() {
        C c = new C();
        c.publicField = 200;
        assertEquals(200, c.publicField);
    }

    @Test
    public void testCInheritsProtectedField() {
        C c = new C();
        c.protectedField = 150;
        assertEquals(150, c.protectedField);
    }

    @Test
    public void testCInheritsPackageField() {
        C c = new C();
        c.packageField = 99;
        assertEquals(99, c.packageField);
    }

    @Test
    public void testCCanCallM1() {
        C c = new C();
        c.m1(); // Inherited from B
        assertEquals(4, c.protectedField);
        assertEquals(12, c.packageField);
    }

    @Test
    public void testCCanCallMa() {
        C c = new C();
        c.ma(); // Inherited from A
        assertEquals(11, c.packageField);
    }

    @Test
    public void testCInitialFieldValues() {
        C c = new C();
        assertEquals(4, c.publicField);
        assertEquals(2, c.protectedField);
        assertEquals(3, c.packageField);
    }
}
