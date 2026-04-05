package n_public_private_protected;

import org.junit.Test;

import static org.junit.Assert.*;

public class ATest {

    @Test
    public void testAConstruction() {
        A a = new A();
        assertNotNull(a);
    }

    @Test
    public void testPackageLocalField() {
        A a = new A();
        assertEquals(1, a.packageLocal);
    }

    @Test
    public void testProtectedField() {
        A a = new A();
        assertEquals(3, a.withSubclasses);
    }

    @Test
    public void testPublicField() {
        A a = new A();
        assertEquals(4, a.forAll);
    }

    @Test
    public void testFieldModification() {
        A a = new A();
        a.packageLocal = 10;
        a.withSubclasses = 20;
        a.forAll = 30;

        assertEquals(10, a.packageLocal);
        assertEquals(20, a.withSubclasses);
        assertEquals(30, a.forAll);
    }

    @Test
    public void testPackageLocalAccessibility() {
        A a = new A();
        // Test that packageLocal is accessible within the same package
        a.packageLocal = 100;
        assertEquals(100, a.packageLocal);
    }

    @Test
    public void testProtectedAccessibility() {
        A a = new A();
        // Test that protected field is accessible within the same package
        a.withSubclasses = 200;
        assertEquals(200, a.withSubclasses);
    }

    @Test
    public void testPublicAccessibility() {
        A a = new A();
        // Test that public field is accessible everywhere
        a.forAll = 300;
        assertEquals(300, a.forAll);
    }

    @Test
    public void testInitialValues() {
        A a = new A();
        assertEquals(1, a.packageLocal);
        assertEquals(3, a.withSubclasses);
        assertEquals(4, a.forAll);
    }

    @Test
    public void testMultipleInstances() {
        A a1 = new A();
        A a2 = new A();

        a1.forAll = 100;
        a2.forAll = 200;

        assertEquals(100, a1.forAll);
        assertEquals(200, a2.forAll);
    }
}
