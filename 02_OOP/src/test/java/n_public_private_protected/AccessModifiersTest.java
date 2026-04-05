package n_public_private_protected;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Comprehensive test class for n_public_private_protected classes A, B, and UserClassInSamePackage
 * Tests visibility modifiers and access control
 */
public class AccessModifiersTest {

    private A instanceA;
    private B instanceB;

    @Before
    public void setUp() {
        instanceA = new A();
        instanceB = new B();
    }

    // Tests for class A

    @Test
    public void testClassAConstructor() {
        A a = new A();
        assertNotNull("A instance should not be null", a);
    }

    @Test
    public void testClassAPublicField() {
        assertEquals("forAll should default to 4", 4, instanceA.forAll);
        instanceA.forAll = 100;
        assertEquals("forAll should be settable", 100, instanceA.forAll);
    }

    @Test
    public void testClassAProtectedField() {
        assertEquals("withSubclasses should default to 3", 3, instanceA.withSubclasses);
        instanceA.withSubclasses = 30;
        assertEquals("withSubclasses should be settable", 30, instanceA.withSubclasses);
    }

    @Test
    public void testClassAPackageLocalField() {
        // Should be accessible from same package
        assertEquals("packageLocal should default to 1", 1, instanceA.packageLocal);
        instanceA.packageLocal = 10;
        assertEquals("packageLocal should be settable", 10, instanceA.packageLocal);
    }

    @Test
    public void testClassAPrivateFieldExists() throws Exception {
        Field privateField = A.class.getDeclaredField("onlyInA");
        assertNotNull("onlyInA field should exist", privateField);
        assertTrue("onlyInA should be private",
                  Modifier.isPrivate(privateField.getModifiers()));
    }

    @Test
    public void testClassAPrivateFieldAccessWithReflection() throws Exception {
        Field privateField = A.class.getDeclaredField("onlyInA");
        privateField.setAccessible(true);
        int value = (int) privateField.get(instanceA);
        assertEquals("onlyInA should default to 2", 2, value);
    }

    @Test
    public void testClassAFieldModifiers() throws Exception {
        Field packageLocal = A.class.getDeclaredField("packageLocal");
        Field onlyInA = A.class.getDeclaredField("onlyInA");
        Field withSubclasses = A.class.getDeclaredField("withSubclasses");
        Field forAll = A.class.getDeclaredField("forAll");

        // packageLocal should have no modifier (package-private)
        int plModifiers = packageLocal.getModifiers();
        assertFalse("packageLocal should not be private",
                   Modifier.isPrivate(plModifiers));
        assertFalse("packageLocal should not be protected",
                   Modifier.isProtected(plModifiers));
        assertFalse("packageLocal should not be public",
                   Modifier.isPublic(plModifiers));

        // onlyInA should be private
        assertTrue("onlyInA should be private",
                  Modifier.isPrivate(onlyInA.getModifiers()));

        // withSubclasses should be protected
        assertTrue("withSubclasses should be protected",
                  Modifier.isProtected(withSubclasses.getModifiers()));

        // forAll should be public
        assertTrue("forAll should be public",
                  Modifier.isPublic(forAll.getModifiers()));
    }

    // Tests for class B

    @Test
    public void testClassBConstructor() {
        B b = new B();
        assertNotNull("B instance should not be null", b);
    }

    @Test
    public void testClassBExtendsA() {
        assertTrue("B should extend A", instanceB instanceof A);
    }

    @Test
    public void testClassBMethodB() {
        // Test that methodB can be called
        instanceB.methodB();
        assertEquals("methodB should set packageLocal to 10",
                    10, instanceB.packageLocal);
        assertEquals("methodB should set withSubclasses to 20",
                    20, instanceB.withSubclasses);
        assertEquals("methodB should set forAll to 30",
                    30, instanceB.forAll);
    }

    @Test
    public void testClassBInheritsFields() {
        // B inherits fields from A
        assertEquals("B should inherit forAll = 4", 4, instanceB.forAll);
        assertEquals("B should inherit withSubclasses = 3", 3, instanceB.withSubclasses);
        assertEquals("B should inherit packageLocal = 1", 1, instanceB.packageLocal);
    }

    @Test
    public void testClassBCanAccessProtectedField() {
        // B can access protected field from A
        instanceB.withSubclasses = 50;
        assertEquals("B should access protected field", 50, instanceB.withSubclasses);
    }

    @Test
    public void testClassBCanAccessPackageLocalField() {
        // B can access package-local field from A (same package)
        instanceB.packageLocal = 60;
        assertEquals("B should access package-local field", 60, instanceB.packageLocal);
    }

    @Test
    public void testClassBCannotAccessPrivateField() throws Exception {
        // B cannot access private field from A directly
        // But it exists via inheritance
        Field privateField = A.class.getDeclaredField("onlyInA");
        privateField.setAccessible(true);
        int value = (int) privateField.get(instanceB);
        assertEquals("Private field should exist in B instance", 2, value);
    }

    @Test
    public void testClassBMethodBModifiesInheritedFields() {
        B b = new B();
        assertEquals("Initial packageLocal should be 1", 1, b.packageLocal);
        assertEquals("Initial withSubclasses should be 3", 3, b.withSubclasses);
        assertEquals("Initial forAll should be 4", 4, b.forAll);

        b.methodB();

        assertEquals("After methodB, packageLocal should be 10", 10, b.packageLocal);
        assertEquals("After methodB, withSubclasses should be 20", 20, b.withSubclasses);
        assertEquals("After methodB, forAll should be 30", 30, b.forAll);
    }

    // Tests for UserClassInSamePackage

    @Test
    public void testUserClassInSamePackageMainMethod() {
        // Test that main method can be called
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        UserClassInSamePackage.main(new String[]{});

        String output = outputStream.toString();
        assertTrue("Output should contain withSubclasses",
                  output.contains("a.withSubclasses"));

        System.setOut(originalOut);
    }

    @Test
    public void testUserClassInSamePackageCanAccessPublicField() {
        A a = new A();
        a.forAll = 10;
        assertEquals("UserClass should access public field", 10, a.forAll);
    }

    @Test
    public void testUserClassInSamePackageCanAccessProtectedField() {
        // In the same package, protected fields are accessible
        A a = new A();
        a.withSubclasses = 10;
        assertEquals("UserClass should access protected field", 10, a.withSubclasses);
    }

    @Test
    public void testUserClassInSamePackageCanAccessPackageLocalField() {
        // In the same package, package-local fields are accessible
        A a = new A();
        a.packageLocal = 11;
        assertEquals("UserClass should access package-local field", 11, a.packageLocal);
    }

    @Test
    public void testPolymorphismWithBAsA() {
        A aRef = new B();
        assertEquals("Polymorphic reference should access fields", 4, aRef.forAll);

        aRef.forAll = 100;
        assertEquals("Polymorphic reference should modify fields", 100, aRef.forAll);
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
    public void testMultipleInstancesOfB() {
        B b1 = new B();
        B b2 = new B();

        b1.methodB();

        assertEquals("b1 should have modified values", 10, b1.packageLocal);
        assertEquals("b2 should have default values", 1, b2.packageLocal);
    }
}
