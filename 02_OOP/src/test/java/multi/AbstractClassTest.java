package multi;

import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.reflect.Modifier;

/**
 * Comprehensive test class for multi.AbstractClass
 */
public class AbstractClassTest {

    /**
     * Concrete implementation for testing purposes
     */
    private static class ConcreteImplementation extends AbstractClass {
        private boolean methodCalled = false;

        @Override
        public void abstractMethod() {
            methodCalled = true;
        }

        public boolean wasMethodCalled() {
            return methodCalled;
        }
    }

    @Test
    public void testAbstractClassCannotBeInstantiated() {
        // Verify the class is abstract
        assertTrue("AbstractClass should be abstract",
                  Modifier.isAbstract(AbstractClass.class.getModifiers()));
    }

    @Test
    public void testConcreteImplementationCanBeInstantiated() {
        ConcreteImplementation impl = new ConcreteImplementation();
        assertNotNull("Concrete implementation should be instantiable", impl);
    }

    @Test
    public void testConcreteImplementationExtendsAbstractClass() {
        ConcreteImplementation impl = new ConcreteImplementation();
        assertTrue("ConcreteImplementation should extend AbstractClass",
                  impl instanceof AbstractClass);
    }

    @Test
    public void testAbstractMethodExists() throws Exception {
        // Verify that abstractMethod exists
        assertNotNull("abstractMethod should exist",
                     AbstractClass.class.getDeclaredMethod("abstractMethod"));
    }

    @Test
    public void testAbstractMethodIsAbstract() throws Exception {
        int modifiers = AbstractClass.class
            .getDeclaredMethod("abstractMethod")
            .getModifiers();
        assertTrue("abstractMethod should be abstract",
                  Modifier.isAbstract(modifiers));
    }

    @Test
    public void testAbstractMethodIsPublic() throws Exception {
        int modifiers = AbstractClass.class
            .getDeclaredMethod("abstractMethod")
            .getModifiers();
        assertTrue("abstractMethod should be public",
                  Modifier.isPublic(modifiers));
    }

    @Test
    public void testConcreteImplementationCallsAbstractMethod() {
        ConcreteImplementation impl = new ConcreteImplementation();
        assertFalse("Method should not be called initially",
                   impl.wasMethodCalled());

        impl.abstractMethod();
        assertTrue("Method should be called after invocation",
                  impl.wasMethodCalled());
    }

    @Test
    public void testMultipleConcreteImplementations() {
        ConcreteImplementation impl1 = new ConcreteImplementation();
        ConcreteImplementation impl2 = new ConcreteImplementation();

        impl1.abstractMethod();

        assertTrue("impl1 should have method called", impl1.wasMethodCalled());
        assertFalse("impl2 should not have method called", impl2.wasMethodCalled());
    }

    @Test
    public void testPolymorphismWithAbstractClass() {
        AbstractClass abstractRef = new ConcreteImplementation();
        assertNotNull("Polymorphic reference should work", abstractRef);

        // Should be able to call the method through the abstract reference
        abstractRef.abstractMethod();
        assertTrue("Method should be callable through abstract reference",
                  ((ConcreteImplementation) abstractRef).wasMethodCalled());
    }

    @Test
    public void testAbstractClassHasNoFields() {
        assertEquals("AbstractClass should have no declared fields",
                    0, AbstractClass.class.getDeclaredFields().length);
    }

    @Test
    public void testAbstractClassHasOneMethod() {
        assertEquals("AbstractClass should have exactly 1 declared method",
                    1, AbstractClass.class.getDeclaredMethods().length);
    }

    @Test
    public void testAbstractMethodHasNoParameters() throws Exception {
        assertEquals("abstractMethod should have no parameters",
                    0,
                    AbstractClass.class
                        .getDeclaredMethod("abstractMethod")
                        .getParameterCount());
    }

    @Test
    public void testAbstractMethodReturnsVoid() throws Exception {
        assertEquals("abstractMethod should return void",
                    void.class,
                    AbstractClass.class
                        .getDeclaredMethod("abstractMethod")
                        .getReturnType());
    }

    /**
     * Another concrete implementation with different behavior
     */
    private static class AnotherImplementation extends AbstractClass {
        private int callCount = 0;

        @Override
        public void abstractMethod() {
            callCount++;
        }

        public int getCallCount() {
            return callCount;
        }
    }

    @Test
    public void testDifferentConcreteImplementations() {
        ConcreteImplementation impl1 = new ConcreteImplementation();
        AnotherImplementation impl2 = new AnotherImplementation();

        impl1.abstractMethod();
        impl2.abstractMethod();
        impl2.abstractMethod();

        assertTrue("First implementation should have method called",
                  impl1.wasMethodCalled());
        assertEquals("Second implementation should have been called twice",
                    2, impl2.getCallCount());
    }

    @Test
    public void testAbstractClassInArray() {
        AbstractClass[] implementations = {
            new ConcreteImplementation(),
            new AnotherImplementation(),
            new ConcreteImplementation()
        };

        assertEquals("Array should have 3 elements", 3, implementations.length);

        for (AbstractClass impl : implementations) {
            assertNotNull("Each implementation should not be null", impl);
            impl.abstractMethod();
        }
    }
}
