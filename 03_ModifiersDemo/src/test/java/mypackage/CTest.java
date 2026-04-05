package mypackage;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Comprehensive test class for C
 * Tests inheritance from B (which extends A) and access modifier behavior
 */
public class CTest {

    private C testInstance;

    @Before
    public void setUp() {
        testInstance = new C();
    }

    /**
     * Test that C can be instantiated
     */
    @Test
    public void testInstantiation() {
        assertNotNull("C instance should not be null", testInstance);
    }

    /**
     * Test that C is an instance of B (direct inheritance)
     */
    @Test
    public void testInheritanceFromB() {
        assertTrue("C should be an instance of B", testInstance instanceof B);
    }

    /**
     * Test that C is an instance of A (transitive inheritance)
     */
    @Test
    public void testInheritanceFromA() {
        assertTrue("C should be an instance of A", testInstance instanceof A);
    }

    /**
     * Test that C inherits public field from A
     */
    @Test
    public void testPublicFieldAccess() {
        testInstance.publicField = 100;
        assertEquals("publicField should be accessible and modifiable",
                     100, testInstance.publicField);
    }

    /**
     * Test that public field has correct default value from A
     */
    @Test
    public void testPublicFieldDefaultValue() {
        assertEquals("publicField should have default value from A",
                     4, testInstance.publicField);
    }

    /**
     * Test that protected field is accessible in C
     */
    @Test
    public void testProtectedFieldAccess() {
        testInstance.protectedField = 50;
        assertEquals("protectedField should be accessible in C",
                     50, testInstance.protectedField);
    }

    /**
     * Test that protected field has correct default value
     */
    @Test
    public void testProtectedFieldDefaultValue() {
        assertEquals("protectedField should have default value from A",
                     2, testInstance.protectedField);
    }

    /**
     * Test that package field is accessible in C (same package)
     */
    @Test
    public void testPackageFieldAccess() {
        testInstance.packageField = 75;
        assertEquals("packageField should be accessible in C",
                     75, testInstance.packageField);
    }

    /**
     * Test that package field has correct default value
     */
    @Test
    public void testPackageFieldDefaultValue() {
        assertEquals("packageField should have default value from A",
                     3, testInstance.packageField);
    }

    /**
     * Test mc() method execution
     */
    @Test
    public void testMcMethodExecution() {
        try {
            testInstance.mc();
        } catch (Exception e) {
            fail("mc() method should execute without throwing exception");
        }
    }

    /**
     * Test that mc() modifies protectedField to 1000
     */
    @Test
    public void testMcModifiesProtectedField() {
        testInstance.mc();
        assertEquals("mc() should set protectedField to 1000",
                     1000, testInstance.protectedField);
    }

    /**
     * Test that mc() modifies packageField to 112
     */
    @Test
    public void testMcModifiesPackageField() {
        testInstance.mc();
        assertEquals("mc() should set packageField to 112",
                     112, testInstance.packageField);
    }

    /**
     * Test that mc() modifies both fields correctly
     */
    @Test
    public void testMcModifiesBothFields() {
        testInstance.mc();
        assertEquals("protectedField should be 1000 after mc()",
                     1000, testInstance.protectedField);
        assertEquals("packageField should be 112 after mc()",
                     112, testInstance.packageField);
    }

    /**
     * Test multiple calls to mc()
     */
    @Test
    public void testMultipleMcCalls() {
        testInstance.mc();
        assertEquals(1000, testInstance.protectedField);
        assertEquals(112, testInstance.packageField);

        testInstance.mc();
        assertEquals(1000, testInstance.protectedField);
        assertEquals(112, testInstance.packageField);
    }

    /**
     * Test that inherited m1() method from B is accessible
     */
    @Test
    public void testInheritedM1Method() {
        try {
            testInstance.m1();
        } catch (Exception e) {
            fail("Inherited m1() method should be accessible");
        }
    }

    /**
     * Test field values after calling m1()
     */
    @Test
    public void testFieldsAfterM1Call() {
        testInstance.m1();
        assertEquals("protectedField should be 4 after m1()",
                     4, testInstance.protectedField);
        assertEquals("packageField should be 12 after m1()",
                     12, testInstance.packageField);
    }

    /**
     * Test that inherited ma() method from A is accessible
     */
    @Test
    public void testInheritedMaMethod() {
        try {
            testInstance.ma();
        } catch (Exception e) {
            fail("Inherited ma() method should be accessible");
        }
    }

    /**
     * Test field values after calling ma()
     */
    @Test
    public void testFieldsAfterMaCall() {
        testInstance.ma();
        assertEquals("packageField should be 11 after ma()",
                     11, testInstance.packageField);
    }

    /**
     * Test combined method calls: ma(), m1(), mc()
     */
    @Test
    public void testCombinedMethodCalls() {
        testInstance.ma();
        assertEquals(11, testInstance.packageField);

        testInstance.m1();
        assertEquals(4, testInstance.protectedField);
        assertEquals(12, testInstance.packageField);

        testInstance.mc();
        assertEquals(1000, testInstance.protectedField);
        assertEquals(112, testInstance.packageField);
    }

    /**
     * Test reverse order of method calls
     */
    @Test
    public void testReverseMethodCalls() {
        testInstance.mc();
        assertEquals(1000, testInstance.protectedField);
        assertEquals(112, testInstance.packageField);

        testInstance.m1();
        assertEquals(4, testInstance.protectedField);
        assertEquals(12, testInstance.packageField);

        testInstance.ma();
        assertEquals(11, testInstance.packageField);
    }

    /**
     * Test that toString() is inherited from A
     */
    @Test
    public void testToStringMethod() {
        String result = testInstance.toString();
        assertNotNull("toString() should return a non-null value", result);
        assertTrue("toString() should return a string representation",
                   result.length() > 0);
    }

    /**
     * Test multiple instances are independent
     */
    @Test
    public void testMultipleInstances() {
        C instance1 = new C();
        C instance2 = new C();

        instance1.publicField = 100;
        instance2.publicField = 200;

        instance1.protectedField = 10;
        instance2.protectedField = 20;

        instance1.packageField = 30;
        instance2.packageField = 40;

        assertEquals(100, instance1.publicField);
        assertEquals(200, instance2.publicField);
        assertEquals(10, instance1.protectedField);
        assertEquals(20, instance2.protectedField);
        assertEquals(30, instance1.packageField);
        assertEquals(40, instance2.packageField);
    }

    /**
     * Test that C can be assigned to B reference (polymorphism)
     */
    @Test
    public void testPolymorphismWithB() {
        B bReference = new C();
        assertNotNull("C instance should be assignable to B reference", bReference);
        assertTrue("B reference should actually hold C instance", bReference instanceof C);
    }

    /**
     * Test that C can be assigned to A reference (polymorphism)
     */
    @Test
    public void testPolymorphismWithA() {
        A aReference = new C();
        assertNotNull("C instance should be assignable to A reference", aReference);
        assertTrue("A reference should actually hold C instance", aReference instanceof C);
    }

    /**
     * Test field modification through B reference
     */
    @Test
    public void testFieldModificationThroughBReference() {
        B bReference = new C();
        bReference.publicField = 500;
        bReference.protectedField = 600;
        bReference.packageField = 700;

        assertEquals(500, bReference.publicField);
        assertEquals(600, bReference.protectedField);
        assertEquals(700, bReference.packageField);
    }

    /**
     * Test field modification through A reference
     */
    @Test
    public void testFieldModificationThroughAReference() {
        A aReference = new C();
        aReference.publicField = 800;
        assertEquals(800, aReference.publicField);
    }

    /**
     * Test default values consistency across instances
     */
    @Test
    public void testDefaultValuesConsistency() {
        C instance1 = new C();
        C instance2 = new C();

        assertEquals(instance1.publicField, instance2.publicField);
        assertEquals(instance1.protectedField, instance2.protectedField);
        assertEquals(instance1.packageField, instance2.packageField);
    }

    /**
     * Test protectedField edge cases
     */
    @Test
    public void testProtectedFieldEdgeCases() {
        testInstance.protectedField = Integer.MAX_VALUE;
        assertEquals(Integer.MAX_VALUE, testInstance.protectedField);

        testInstance.protectedField = Integer.MIN_VALUE;
        assertEquals(Integer.MIN_VALUE, testInstance.protectedField);

        testInstance.protectedField = 0;
        assertEquals(0, testInstance.protectedField);
    }

    /**
     * Test packageField edge cases
     */
    @Test
    public void testPackageFieldEdgeCases() {
        testInstance.packageField = Integer.MAX_VALUE;
        assertEquals(Integer.MAX_VALUE, testInstance.packageField);

        testInstance.packageField = Integer.MIN_VALUE;
        assertEquals(Integer.MIN_VALUE, testInstance.packageField);

        testInstance.packageField = 0;
        assertEquals(0, testInstance.packageField);
    }

    /**
     * Test publicField edge cases
     */
    @Test
    public void testPublicFieldEdgeCases() {
        testInstance.publicField = Integer.MAX_VALUE;
        assertEquals(Integer.MAX_VALUE, testInstance.publicField);

        testInstance.publicField = Integer.MIN_VALUE;
        assertEquals(Integer.MIN_VALUE, testInstance.publicField);

        testInstance.publicField = 0;
        assertEquals(0, testInstance.publicField);
    }

    /**
     * Test field state preservation
     */
    @Test
    public void testFieldStatePreservation() {
        testInstance.publicField = 999;
        testInstance.mc();
        assertEquals("publicField should be unchanged by mc()",
                     999, testInstance.publicField);
    }

    /**
     * Test method call order independence for publicField
     */
    @Test
    public void testMethodCallOrderIndependence() {
        testInstance.publicField = 555;

        testInstance.mc();
        assertEquals(555, testInstance.publicField);

        testInstance.m1();
        assertEquals(555, testInstance.publicField);

        testInstance.ma();
        assertEquals(555, testInstance.publicField);
    }
}
