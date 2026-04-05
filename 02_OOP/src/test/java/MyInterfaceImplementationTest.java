import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

/**
 * Comprehensive test class for MyInterfaceImplementation
 */
public class MyInterfaceImplementationTest {

    private MyInterfaceImplementation implementation;

    @Before
    public void setUp() {
        implementation = new MyInterfaceImplementation();
    }

    @Test
    public void testConstructor() {
        MyInterfaceImplementation impl = new MyInterfaceImplementation();
        assertNotNull("Constructor should create non-null instance", impl);
    }

    @Test
    public void testImplementsMyInterface() {
        assertTrue("MyInterfaceImplementation should implement MyInterface",
                   implementation instanceof MyInterface);
    }

    @Test
    public void testMyMethodExists() {
        // Test that myMethod can be called without throwing an exception
        try {
            implementation.myMethod();
        } catch (Exception e) {
            fail("myMethod() should not throw an exception: " + e.getMessage());
        }
    }

    @Test
    public void testMyMethodMultipleCalls() {
        // Test that myMethod can be called multiple times
        implementation.myMethod();
        implementation.myMethod();
        implementation.myMethod();
        // If we get here without exception, test passes
        assertTrue("Multiple calls to myMethod should succeed", true);
    }

    @Test
    public void testMethod2Returns() {
        int result = implementation.method2();
        assertEquals("method2() should return 0", 0, result);
    }

    @Test
    public void testMethod2Idempotent() {
        int result1 = implementation.method2();
        int result2 = implementation.method2();
        assertEquals("method2() should return same value on multiple calls",
                     result1, result2);
    }

    @Test
    public void testMethod2ReturnType() {
        Object result = implementation.method2();
        assertTrue("method2() should return an Integer",
                   result instanceof Integer);
    }

    @Test
    public void testInterfaceMethodsAccessible() {
        MyInterface myInterface = implementation;
        myInterface.myMethod();
        int result = myInterface.method2();
        assertEquals("Interface reference should work correctly", 0, result);
    }

    @Test
    public void testMultipleInstances() {
        MyInterfaceImplementation impl1 = new MyInterfaceImplementation();
        MyInterfaceImplementation impl2 = new MyInterfaceImplementation();

        assertNotNull("First instance should not be null", impl1);
        assertNotNull("Second instance should not be null", impl2);
        assertNotSame("Different instances should not be the same object",
                      impl1, impl2);
    }

    @Test
    public void testPolymorphism() {
        MyInterface myInterface = new MyInterfaceImplementation();
        assertNotNull("Polymorphic reference should work", myInterface);

        int result = myInterface.method2();
        assertEquals("Polymorphic call should return correct value", 0, result);
    }
}
