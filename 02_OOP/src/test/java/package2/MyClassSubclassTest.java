package package2;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyClassSubclassTest {

    @Test
    public void testMyClassSubclassConstruction() {
        MyClassSubclass subclass = new MyClassSubclass();
        assertNotNull(subclass);
    }

    @Test
    public void testMyClassSubclassExtendsMyClass() {
        MyClassSubclass subclass = new MyClassSubclass();
        assertTrue(subclass instanceof MyClass);
    }

    @Test
    public void testMyMethodModifiesProtectedField() {
        MyClassSubclass subclass = new MyClassSubclass();
        subclass.myMethod();
        assertEquals(10, subclass.protectedField);
    }

    @Test
    public void testInheritsPublicMethod() {
        MyClassSubclass subclass = new MyClassSubclass();
        subclass.publicMethod();
        assertEquals(20, subclass.protectedField);
    }

    @Test
    public void testInheritsFields() {
        MyClassSubclass subclass = new MyClassSubclass();
        subclass.field1 = 100;
        subclass.field2 = 'Z';
        subclass.protectedField = 50;

        assertEquals(100, subclass.field1);
        assertEquals('Z', subclass.field2);
        assertEquals(50, subclass.protectedField);
    }

    @Test
    public void testInheritsMyMethodWithParameters() {
        MyClassSubclass subclass = new MyClassSubclass();
        // Inherited myMethod from MyClass
        subclass.myMethod(5, 10, 15.5);
    }

    @Test
    public void testProtectedFieldAccessibility() {
        MyClassSubclass subclass = new MyClassSubclass();
        // Protected field is accessible in subclass
        subclass.protectedField = 99;
        assertEquals(99, subclass.protectedField);
    }

    @Test
    public void testMultipleMethodCalls() {
        MyClassSubclass subclass = new MyClassSubclass();
        subclass.myMethod();
        assertEquals(10, subclass.protectedField);

        subclass.publicMethod();
        assertEquals(20, subclass.protectedField);
    }

    @Test
    public void testPolymorphism() {
        MyClass myClass = new MyClassSubclass();
        assertNotNull(myClass);
        assertTrue(myClass instanceof MyClassSubclass);
    }
}
