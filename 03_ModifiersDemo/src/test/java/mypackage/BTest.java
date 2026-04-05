package mypackage;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Comprehensive test class for B
 * Tests inheritance from A and access modifier behavior
 */
public class BTest {

    private B testInstance;

    @Before
    public void setUp() {
        testInstance = new B();
    }

    /**
     * Test that B can be instantiated
     */
    @Test
    public void testInstantiation() {
        assertNotNull("B instance should not be null", testInstance);
    }

    /**
     * Test that B is an instance of A (inheritance)
     */
    @Test
    public void testInheritanceFromA() {
        assertTrue("B should be an instance of A", testInstance instanceof A);
    }

    /**
     * Test that B inherits public field from A
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
     * Test that protected field is accessible in B (same package and subclass)
     */
    @Test
    public void testProtectedFieldAccess() {
        testInstance.protectedField = 50;
        assertEquals("protectedField should be accessible in B",
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
     * Test that package field is accessible in B (same package)
     */
    @Test
    public void testPackageFieldAccess() {
        testInstance.packageField = 75;
        assertEquals("packageField should be accessible in B",
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
     * Test m1() method execution
     */
    @Test
    public void testM1MethodExecution() {
        try {
            testInstance.m1();
        } catch (Exception e) {
            fail("m1() method should execute without throwing exception");
        }
    }

    /**
     * Test that m1() modifies protectedField to 4
     */
    @Test
    public void testM1ModifiesProtectedField() {
        testInstance.m1();
        assertEquals("m1() should set protectedField to 4",
                     4, testInstance.protectedField);
    }

    /**
     * Test that m1() modifies packageField to 12
     */
    @Test
    public void testM1ModifiesPackageField() {
        testInstance.m1();
        assertEquals("m1() should set packageField to 12",
                     12, testInstance.packageField);
    }

    /**
     * Test that m1() modifies both fields correctly
     */
    @Test
    public void testM1ModifiesBothFields() {
        testInstance.m1();
        assertEquals("protectedField should be 4 after m1()",
                     4, testInstance.protectedField);
        assertEquals("packageField should be 12 after m1()",
                     12, testInstance.packageField);
    }

    /**
     * Test multiple calls to m1()
     */
    @Test
    public void testMultipleM1Calls() {
        testInstance.m1();
        assertEquals(4, testInstance.protectedField);
        assertEquals(12, testInstance.packageField);

        testInstance.m1();
        assertEquals(4, testInstance.protectedField);
        assertEquals(12, testInstance.packageField);
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
     * Test combined ma() and m1() calls
     */
    @Test
    public void testCombinedMaAndM1Calls() {
        testInstance.ma();
        assertEquals(11, testInstance.packageField);

        testInstance.m1();
        assertEquals(12, testInstance.packageField);
        assertEquals(4, testInstance.protectedField);
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
        B instance1 = new B();
        B instance2 = new B();

        instance1.publicField = 100;
        instance2.publicField = 200;

        instance1.protectedField = 10;
        instance2.protectedField = 20;

        assertEquals(100, instance1.publicField);
        assertEquals(200, instance2.publicField);
        assertEquals(10, instance1.protectedField);
        assertEquals(20, instance2.protectedField);
    }

    /**
     * Test that B can be assigned to A reference (polymorphism)
     */
    @Test
    public void testPolymorphism() {
        A aReference = new B();
        assertNotNull("B instance should be assignable to A reference", aReference);
        assertTrue("A reference should actually hold B instance", aReference instanceof B);
    }

    /**
     * Test field modification through parent reference
     */
    @Test
    public void testFieldModificationThroughParentReference() {
        A aReference = new B();
        aReference.publicField = 500;
        assertEquals("publicField should be modifiable through A reference",
                     500, aReference.publicField);
    }

    /**
     * Test default values consistency across instances
     */
    @Test
    public void testDefaultValuesConsistency() {
        B instance1 = new B();
        B instance2 = new B();

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
     * Test field state preservation after method calls
     */
    @Test
    public void testFieldStatePreservation() {
        testInstance.publicField = 999;
        testInstance.m1();
        assertEquals("publicField should be unchanged by m1()",
                     999, testInstance.publicField);
    }
}
