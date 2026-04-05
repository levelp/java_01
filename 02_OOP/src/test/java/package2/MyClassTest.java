package package2;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Comprehensive test class for package2.MyClass and MyClassSubclass
 */
public class MyClassTest {

    private MyClass myClass;
    private MyClassSubclass subclass;
    private ByteArrayOutputStream outputStream;
    private PrintStream originalOut;

    @Before
    public void setUp() {
        myClass = new MyClass();
        subclass = new MyClassSubclass();
        outputStream = new ByteArrayOutputStream();
        originalOut = System.out;
    }

    // Tests for MyClass

    @Test
    public void testMyClassConstructor() {
        MyClass obj = new MyClass();
        assertNotNull("MyClass instance should not be null", obj);
    }

    @Test
    public void testProtectedFieldExists() throws Exception {
        Field field = MyClass.class.getDeclaredField("protectedField");
        assertNotNull("protectedField should exist", field);
        assertTrue("protectedField should be protected",
                  Modifier.isProtected(field.getModifiers()));
    }

    @Test
    public void testProtectedFieldDefaultValue() throws Exception {
        Field field = MyClass.class.getDeclaredField("protectedField");
        field.setAccessible(true);
        int value = (int) field.get(myClass);
        assertEquals("protectedField should default to 0", 0, value);
    }

    @Test
    public void testProtectedFieldAccess() {
        // Can access protected field from same package
        myClass.protectedField = 100;
        assertEquals("protectedField should be 100", 100, myClass.protectedField);
    }

    @Test
    public void testField1Access() {
        // Package-private field accessible from same package
        myClass.field1 = 42;
        assertEquals("field1 should be 42", 42, myClass.field1);
    }

    @Test
    public void testField1DefaultValue() {
        assertEquals("field1 should default to 0", 0, myClass.field1);
    }

    @Test
    public void testField2Access() {
        myClass.field2 = 'A';
        assertEquals("field2 should be 'A'", 'A', myClass.field2);
    }

    @Test
    public void testField2DefaultValue() {
        assertEquals("field2 should default to '\\0'", '\0', myClass.field2);
    }

    @Test
    public void testPrivateFieldExists() throws Exception {
        Field field = MyClass.class.getDeclaredField("privateField");
        assertNotNull("privateField should exist", field);
        assertTrue("privateField should be private",
                  Modifier.isPrivate(field.getModifiers()));
    }

    @Test
    public void testPrivateFieldDefaultValue() throws Exception {
        Field field = MyClass.class.getDeclaredField("privateField");
        field.setAccessible(true);
        int value = (int) field.get(myClass);
        assertEquals("privateField should default to 0", 0, value);
    }

    @Test
    public void testPrivateFieldSetByPublicMethod() throws Exception {
        myClass.publicMethod();

        Field field = MyClass.class.getDeclaredField("privateField");
        field.setAccessible(true);
        int value = (int) field.get(myClass);
        assertEquals("privateField should be set to 11 by publicMethod", 11, value);
    }

    @Test
    public void testPublicMethod() {
        System.setOut(new PrintStream(outputStream));
        myClass.publicMethod();
        String output = outputStream.toString().trim();

        assertEquals("publicMethod should print 'publicMethod()'",
                    "publicMethod()", output);
        System.setOut(originalOut);
    }

    @Test
    public void testPublicMethodSetsProtectedField() {
        myClass.publicMethod();
        assertEquals("publicMethod should set protectedField to 20",
                    20, myClass.protectedField);
    }

    @Test
    public void testMyMethodExists() throws Exception {
        Method method = MyClass.class.getDeclaredMethod("myMethod",
                                                        int.class, int.class, double.class);
        assertNotNull("myMethod should exist", method);
        assertFalse("myMethod should not be public",
                   Modifier.isPublic(method.getModifiers()));
    }

    @Test
    public void testMyMethodIsPackagePrivate() throws Exception {
        Method method = MyClass.class.getDeclaredMethod("myMethod",
                                                        int.class, int.class, double.class);
        int modifiers = method.getModifiers();
        assertFalse("myMethod should not be private",
                   Modifier.isPrivate(modifiers));
        assertFalse("myMethod should not be protected",
                   Modifier.isProtected(modifiers));
        assertFalse("myMethod should not be public",
                   Modifier.isPublic(modifiers));
    }

    @Test
    public void testMyMethodCallable() {
        // Should be callable from same package
        myClass.myMethod(1, 2, 3.0);
        assertTrue("myMethod should be callable", true);
    }

    // Tests for MyClassSubclass

    @Test
    public void testMyClassSubclassConstructor() {
        MyClassSubclass obj = new MyClassSubclass();
        assertNotNull("MyClassSubclass instance should not be null", obj);
    }

    @Test
    public void testMyClassSubclassExtendsMyClass() {
        assertTrue("MyClassSubclass should extend MyClass",
                  subclass instanceof MyClass);
    }

    @Test
    public void testMyClassSubclassInheritsFields() {
        subclass.field1 = 10;
        subclass.field2 = 'B';
        subclass.protectedField = 30;

        assertEquals("Subclass should inherit field1", 10, subclass.field1);
        assertEquals("Subclass should inherit field2", 'B', subclass.field2);
        assertEquals("Subclass should inherit protectedField", 30, subclass.protectedField);
    }

    @Test
    public void testMyClassSubclassMyMethod() {
        subclass.myMethod();
        assertEquals("myMethod should set protectedField to 10",
                    10, subclass.protectedField);
    }

    @Test
    public void testMyClassSubclassCanAccessProtectedField() {
        subclass.myMethod();
        assertEquals("Subclass should access protected field",
                    10, subclass.protectedField);
    }

    @Test
    public void testMyClassSubclassInheritsPublicMethod() {
        System.setOut(new PrintStream(outputStream));
        subclass.publicMethod();
        String output = outputStream.toString().trim();

        assertEquals("Subclass should inherit publicMethod",
                    "publicMethod()", output);
        System.setOut(originalOut);
    }

    @Test
    public void testMyClassSubclassCannotAccessPrivateField() throws Exception {
        // Private field exists but is not directly accessible
        subclass.publicMethod(); // This sets the private field

        Field field = MyClass.class.getDeclaredField("privateField");
        field.setAccessible(true);
        int value = (int) field.get(subclass);
        assertEquals("Private field should be set by inherited method",
                    11, value);
    }

    @Test
    public void testPolymorphism() {
        MyClass polymorphicRef = new MyClassSubclass();
        assertNotNull("Polymorphic reference should work", polymorphicRef);

        polymorphicRef.protectedField = 50;
        assertEquals("Polymorphic reference should access fields",
                    50, polymorphicRef.protectedField);
    }

    @Test
    public void testMultipleSubclassInstances() {
        MyClassSubclass sub1 = new MyClassSubclass();
        MyClassSubclass sub2 = new MyClassSubclass();

        sub1.myMethod();
        sub1.protectedField = 100;

        sub2.protectedField = 200;

        assertEquals("sub1 should have protectedField = 100",
                    100, sub1.protectedField);
        assertEquals("sub2 should have protectedField = 200",
                    200, sub2.protectedField);
    }

    @Test
    public void testFieldCount() {
        Field[] fields = MyClass.class.getDeclaredFields();
        assertEquals("MyClass should have 4 fields", 4, fields.length);
    }

    @Test
    public void testMethodCount() {
        Method[] methods = MyClass.class.getDeclaredMethods();
        assertEquals("MyClass should have 2 methods", 2, methods.length);
    }

    @Test
    public void testSubclassMethodCount() {
        Method[] methods = MyClassSubclass.class.getDeclaredMethods();
        assertEquals("MyClassSubclass should have 1 declared method",
                    1, methods.length);
    }

    @Test
    public void testMyClassIsPublic() {
        assertTrue("MyClass should be public",
                  Modifier.isPublic(MyClass.class.getModifiers()));
    }

    @Test
    public void testMyClassSubclassIsPublic() {
        assertTrue("MyClassSubclass should be public",
                  Modifier.isPublic(MyClassSubclass.class.getModifiers()));
    }
}
