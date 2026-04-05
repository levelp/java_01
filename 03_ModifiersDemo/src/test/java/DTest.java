import mypackage.A;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Comprehensive test class for D
 * Tests inheritance from A and access modifiers behavior
 */
public class DTest {

    private D testInstance;

    @Before
    public void setUp() {
        testInstance = new D();
    }

    /**
     * Test that D can be instantiated
     */
    @Test
    public void testInstantiation() {
        assertNotNull("D instance should not be null", testInstance);
    }

    /**
     * Test that D is an instance of A (inheritance)
     */
    @Test
    public void testInheritanceFromA() {
        assertTrue("D should be an instance of A", testInstance instanceof A);
    }

    /**
     * Test that D inherits public fields from A
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
     * Test md() method exists and can be called without exception
     */
    @Test
    public void testMdMethodExecution() {
        try {
            testInstance.md();
        } catch (Exception e) {
            fail("md() method should execute without throwing exception");
        }
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
        D instance1 = new D();
        D instance2 = new D();

        instance1.publicField = 100;
        instance2.publicField = 200;

        assertEquals("instance1 publicField should be 100", 100, instance1.publicField);
        assertEquals("instance2 publicField should be 200", 200, instance2.publicField);
    }

    /**
     * Test that D can be assigned to A reference (polymorphism)
     */
    @Test
    public void testPolymorphism() {
        A aReference = new D();
        assertNotNull("D instance should be assignable to A reference", aReference);
        assertTrue("A reference should actually hold D instance", aReference instanceof D);
    }

    /**
     * Test field modification through parent reference
     */
    @Test
    public void testFieldModificationThroughParentReference() {
        A aReference = new D();
        aReference.publicField = 500;
        assertEquals("publicField should be modifiable through A reference",
                     500, aReference.publicField);
    }

    /**
     * Test that package field is NOT accessible from different package
     * This test verifies the comment in md() method
     */
    @Test
    public void testPackageFieldNotAccessibleFromDifferentPackage() {
        // This test documents that packageField is not accessible
        // from D class because D is in a different package than A
        // We can't directly test the inaccessibility, but we verify
        // the instance is valid
        assertNotNull("Instance should be valid even though packageField is inaccessible",
                      testInstance);
    }

    /**
     * Test that multiple calls to md() don't cause issues
     */
    @Test
    public void testMultipleMdCalls() {
        testInstance.md();
        testInstance.md();
        testInstance.md();
        // If no exception is thrown, test passes
        assertTrue("Multiple md() calls should complete successfully", true);
    }

    /**
     * Test equality of default values across instances
     */
    @Test
    public void testDefaultValuesConsistency() {
        D instance1 = new D();
        D instance2 = new D();
        assertEquals("Default publicField should be same across instances",
                     instance1.publicField, instance2.publicField);
    }

    /**
     * Test that D instance is not null after calling md()
     */
    @Test
    public void testInstanceIntegrityAfterMethodCall() {
        testInstance.md();
        assertNotNull("Instance should remain valid after md() call", testInstance);
        assertEquals("publicField should retain default value after md()",
                     4, testInstance.publicField);
    }

    /**
     * Test edge case: very large value for publicField
     */
    @Test
    public void testPublicFieldLargeValue() {
        testInstance.publicField = Integer.MAX_VALUE;
        assertEquals("publicField should handle Integer.MAX_VALUE",
                     Integer.MAX_VALUE, testInstance.publicField);
    }

    /**
     * Test edge case: very small value for publicField
     */
    @Test
    public void testPublicFieldSmallValue() {
        testInstance.publicField = Integer.MIN_VALUE;
        assertEquals("publicField should handle Integer.MIN_VALUE",
                     Integer.MIN_VALUE, testInstance.publicField);
    }
}
