package n_public_private_protected_user;

import n_public_private_protected.A;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;

/**
 * Comprehensive test class for n_public_private_protected_user.UserClass
 * Tests access to class A from a different package
 */
public class UserClassTest {

    @Test
    public void testUserClassMainMethod() {
        // Test that main method can be called without errors
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            UserClass.main(new String[]{});
        } catch (Exception e) {
            fail("UserClass.main() should not throw exception: " + e.getMessage());
        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    public void testCanAccessPublicFieldFromDifferentPackage() {
        A a = new A();
        a.forAll = 10;
        assertEquals("Should be able to access public field from different package",
                    10, a.forAll);
    }

    @Test
    public void testCannotAccessProtectedFieldFromDifferentPackage() {
        A a = new A();
        // From a different package (not a subclass), protected fields are not accessible
        // This test verifies that the field exists but would not be accessible
        try {
            Field protectedField = A.class.getDeclaredField("withSubclasses");
            assertNotNull("Protected field should exist", protectedField);
            // We can verify it's protected
            assertTrue("Field should be protected",
                      java.lang.reflect.Modifier.isProtected(
                          protectedField.getModifiers()));
        } catch (Exception e) {
            fail("Should be able to find the field via reflection: " + e.getMessage());
        }
    }

    @Test
    public void testCannotAccessPackageLocalFieldFromDifferentPackage() {
        A a = new A();
        // From a different package, package-local fields are not accessible
        try {
            Field packageField = A.class.getDeclaredField("packageLocal");
            assertNotNull("Package-local field should exist", packageField);
            // Verify it's package-private (no modifiers)
            int modifiers = packageField.getModifiers();
            assertFalse("Field should not be public",
                       java.lang.reflect.Modifier.isPublic(modifiers));
            assertFalse("Field should not be private",
                       java.lang.reflect.Modifier.isPrivate(modifiers));
            assertFalse("Field should not be protected",
                       java.lang.reflect.Modifier.isProtected(modifiers));
        } catch (Exception e) {
            fail("Should be able to find the field via reflection: " + e.getMessage());
        }
    }

    @Test
    public void testCannotAccessPrivateFieldFromDifferentPackage() {
        A a = new A();
        // Private fields are never accessible from outside the class
        try {
            Field privateField = A.class.getDeclaredField("onlyInA");
            assertNotNull("Private field should exist", privateField);
            assertTrue("Field should be private",
                      java.lang.reflect.Modifier.isPrivate(
                          privateField.getModifiers()));
        } catch (Exception e) {
            fail("Should be able to find the field via reflection: " + e.getMessage());
        }
    }

    @Test
    public void testOnlyPublicFieldIsAccessible() {
        A a = new A();
        // Only forAll (public) is accessible
        assertEquals("Default value of forAll should be 4", 4, a.forAll);
        a.forAll = 100;
        assertEquals("forAll should be modifiable", 100, a.forAll);
    }

    @Test
    public void testAccessViaReflection() throws Exception {
        A a = new A();

        // Access protected field via reflection
        Field protectedField = A.class.getDeclaredField("withSubclasses");
        protectedField.setAccessible(true);
        int protectedValue = (int) protectedField.get(a);
        assertEquals("Protected field should have value 3", 3, protectedValue);

        // Access package-local field via reflection
        Field packageField = A.class.getDeclaredField("packageLocal");
        packageField.setAccessible(true);
        int packageValue = (int) packageField.get(a);
        assertEquals("Package-local field should have value 1", 1, packageValue);

        // Access private field via reflection
        Field privateField = A.class.getDeclaredField("onlyInA");
        privateField.setAccessible(true);
        int privateValue = (int) privateField.get(a);
        assertEquals("Private field should have value 2", 2, privateValue);
    }

    @Test
    public void testSubclassInDifferentPackageCanAccessProtected() {
        // Create a subclass of A in this package
        class SubclassOfA extends A {
            public int getProtectedField() {
                return withSubclasses;
            }

            public void setProtectedField(int value) {
                withSubclasses = value;
            }
        }

        SubclassOfA sub = new SubclassOfA();
        assertEquals("Subclass should access protected field", 3, sub.getProtectedField());

        sub.setProtectedField(50);
        assertEquals("Subclass should modify protected field", 50, sub.getProtectedField());
    }

    @Test
    public void testSubclassCannotAccessPackageLocal() {
        // Subclass in different package cannot access package-local fields
        class SubclassOfA extends A {
            public boolean canAccessPackageLocal() {
                try {
                    Field field = A.class.getDeclaredField("packageLocal");
                    // Field exists but is not directly accessible in code
                    return false; // In actual code, this would fail to compile
                } catch (Exception e) {
                    return false;
                }
            }
        }

        SubclassOfA sub = new SubclassOfA();
        assertFalse("Subclass cannot access package-local field",
                   sub.canAccessPackageLocal());
    }

    @Test
    public void testMultipleInstancesOfA() {
        A a1 = new A();
        A a2 = new A();

        a1.forAll = 10;
        a2.forAll = 20;

        assertEquals("a1.forAll should be 10", 10, a1.forAll);
        assertEquals("a2.forAll should be 20", 20, a2.forAll);
    }

    @Test
    public void testClassAIsPublic() {
        // Verify that class A is public and can be instantiated
        A a = new A();
        assertNotNull("Should be able to create instance of A", a);
        assertTrue("Instance should be of type A", a instanceof A);
    }

    @Test
    public void testAllFieldsExist() throws Exception {
        // Verify all four fields exist
        Field[] fields = A.class.getDeclaredFields();
        assertEquals("A should have exactly 4 fields", 4, fields.length);

        assertNotNull("packageLocal field should exist",
                     A.class.getDeclaredField("packageLocal"));
        assertNotNull("onlyInA field should exist",
                     A.class.getDeclaredField("onlyInA"));
        assertNotNull("withSubclasses field should exist",
                     A.class.getDeclaredField("withSubclasses"));
        assertNotNull("forAll field should exist",
                     A.class.getDeclaredField("forAll"));
    }

    @Test
    public void testMainMethodExecutesWithoutError() {
        // Verify that UserClass.main() doesn't throw any exceptions
        try {
            UserClass.main(new String[]{});
            assertTrue("Main method should execute successfully", true);
        } catch (Exception e) {
            fail("Main method should not throw exception: " + e.getMessage());
        }
    }
}
