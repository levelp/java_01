package n_public_private_protected;

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
    public void testMethodB() {
        B b = new B();
        b.methodB();

        assertEquals(10, b.packageLocal);
        assertEquals(20, b.withSubclasses);
        assertEquals(30, b.forAll);
    }

    @Test
    public void testInheritedFields() {
        B b = new B();
        // Test that B inherits fields from A
        assertEquals(1, b.packageLocal);
        assertEquals(3, b.withSubclasses);
        assertEquals(4, b.forAll);
    }

    @Test
    public void testFieldAccessibility() {
        B b = new B();
        // Test direct field access
        b.packageLocal = 100;
        b.withSubclasses = 200;
        b.forAll = 300;

        assertEquals(100, b.packageLocal);
        assertEquals(200, b.withSubclasses);
        assertEquals(300, b.forAll);
    }

    @Test
    public void testMethodBModifiesFields() {
        B b = new B();
        int origPackage = b.packageLocal;
        int origProtected = b.withSubclasses;
        int origPublic = b.forAll;

        b.methodB();

        assertNotEquals(origPackage, b.packageLocal);
        assertNotEquals(origProtected, b.withSubclasses);
        assertNotEquals(origPublic, b.forAll);
    }

    @Test
    public void testInheritanceHierarchy() {
        B b = new B();
        assertTrue(b instanceof B);
        assertTrue(b instanceof A);
        assertTrue(b instanceof Object);
    }

    @Test
    public void testMultipleBInstances() {
        B b1 = new B();
        B b2 = new B();

        b1.methodB();

        // b2 should still have original values
        assertEquals(1, b2.packageLocal);
        assertEquals(3, b2.withSubclasses);
        assertEquals(4, b2.forAll);
    }
}
