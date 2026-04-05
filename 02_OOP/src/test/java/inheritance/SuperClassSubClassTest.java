package inheritance;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

/**
 * Comprehensive test class for inheritance.SuperClass and inheritance.SubClass
 * Tests constructor chaining and inheritance behavior
 */
public class SuperClassSubClassTest {

    private ByteArrayOutputStream outputStream;
    private PrintStream originalOut;

    @Before
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        originalOut = System.out;
    }

    // Tests for SuperClass

    @Test
    public void testSuperClassDefaultConstructor() {
        System.setOut(new PrintStream(outputStream));

        SuperClass superClass = new SuperClass();

        String output = outputStream.toString().trim();
        assertEquals("Default constructor should print message",
                    "Конструктор Суперкласса", output);

        System.setOut(originalOut);
        assertNotNull("SuperClass instance should not be null", superClass);
    }

    @Test
    public void testSuperClassParameterizedConstructor() {
        System.setOut(new PrintStream(outputStream));

        SuperClass superClass = new SuperClass(10);

        String output = outputStream.toString().trim();
        assertEquals("Parameterized constructor should print message",
                    "Другой конструктор суперкласса", output);

        System.setOut(originalOut);
        assertNotNull("SuperClass instance should not be null", superClass);
    }

    @Test
    public void testSuperClassHasTwoConstructors() {
        Constructor<?>[] constructors = SuperClass.class.getDeclaredConstructors();
        assertEquals("SuperClass should have 2 constructors",
                    2, constructors.length);
    }

    @Test
    public void testSuperClassDefaultConstructorIsPublic() throws Exception {
        Constructor<SuperClass> constructor = SuperClass.class.getDeclaredConstructor();
        assertTrue("Default constructor should be public",
                  Modifier.isPublic(constructor.getModifiers()));
    }

    @Test
    public void testSuperClassParameterizedConstructorIsPublic() throws Exception {
        Constructor<SuperClass> constructor =
            SuperClass.class.getDeclaredConstructor(int.class);
        assertTrue("Parameterized constructor should be public",
                  Modifier.isPublic(constructor.getModifiers()));
    }

    @Test
    public void testMultipleSuperClassInstances() {
        System.setOut(new PrintStream(outputStream));

        SuperClass sc1 = new SuperClass();
        SuperClass sc2 = new SuperClass(5);

        String output = outputStream.toString();
        assertTrue("Output should contain both constructor messages",
                  output.contains("Конструктор Суперкласса") &&
                  output.contains("Другой конструктор суперкласса"));

        System.setOut(originalOut);
    }

    @Test
    public void testSuperClassIsPublic() {
        assertTrue("SuperClass should be public",
                  Modifier.isPublic(SuperClass.class.getModifiers()));
    }

    // Tests for SubClass

    @Test
    public void testSubClassConstructor() {
        System.setOut(new PrintStream(outputStream));

        SubClass subClass = new SubClass();

        String output = outputStream.toString();
        assertTrue("Output should contain superclass constructor message",
                  output.contains("Другой конструктор суперкласса"));
        assertTrue("Output should contain subclass constructor message",
                  output.contains("Конструктор Подкласса"));

        System.setOut(originalOut);
        assertNotNull("SubClass instance should not be null", subClass);
    }

    @Test
    public void testSubClassExtendsSuper() {
        SubClass subClass = new SubClass();
        assertTrue("SubClass should extend SuperClass",
                  subClass instanceof SuperClass);
    }

    @Test
    public void testSubClassConstructorChaining() {
        System.setOut(new PrintStream(outputStream));

        SubClass subClass = new SubClass();

        String output = outputStream.toString();
        String[] lines = output.trim().split("\n");

        assertEquals("Should print 2 lines", 2, lines.length);
        assertEquals("First line should be superclass constructor",
                    "Другой конструктор суперкласса", lines[0].trim());
        assertEquals("Second line should be subclass constructor",
                    "Конструктор Подкласса", lines[1].trim());

        System.setOut(originalOut);
    }

    @Test
    public void testSubClassCallsSuperWithParameter() {
        System.setOut(new PrintStream(outputStream));

        SubClass subClass = new SubClass();

        String output = outputStream.toString();
        // SubClass calls super(10), which should call the parameterized constructor
        assertTrue("Should call parameterized superclass constructor",
                  output.contains("Другой конструктор суперкласса"));
        assertFalse("Should not call default superclass constructor",
                   output.contains("Конструктор Суперкласса"));

        System.setOut(originalOut);
    }

    @Test
    public void testSubClassHasMainMethod() throws Exception {
        assertNotNull("SubClass should have main method",
                     SubClass.class.getDeclaredMethod("main", String[].class));
    }

    @Test
    public void testSubClassMainMethod() {
        System.setOut(new PrintStream(outputStream));

        SubClass.main(new String[]{});

        String output = outputStream.toString();
        assertTrue("Main should create SubClass instance",
                  output.contains("Другой конструктор суперкласса"));
        assertTrue("Main should create SubClass instance",
                  output.contains("Конструктор Подкласса"));

        System.setOut(originalOut);
    }

    @Test
    public void testSubClassMainIsStatic() throws Exception {
        int modifiers = SubClass.class
            .getDeclaredMethod("main", String[].class)
            .getModifiers();
        assertTrue("main should be static",
                  Modifier.isStatic(modifiers));
    }

    @Test
    public void testSubClassMainIsPublic() throws Exception {
        int modifiers = SubClass.class
            .getDeclaredMethod("main", String[].class)
            .getModifiers();
        assertTrue("main should be public",
                  Modifier.isPublic(modifiers));
    }

    @Test
    public void testSubClassIsPublic() {
        assertTrue("SubClass should be public",
                  Modifier.isPublic(SubClass.class.getModifiers()));
    }

    @Test
    public void testMultipleSubClassInstances() {
        System.setOut(new PrintStream(outputStream));

        SubClass sub1 = new SubClass();
        SubClass sub2 = new SubClass();

        String output = outputStream.toString();
        // Should see constructor messages twice
        int count = output.split("Конструктор Подкласса", -1).length - 1;
        assertEquals("Should create 2 instances", 2, count);

        System.setOut(originalOut);
    }

    @Test
    public void testPolymorphicReference() {
        System.setOut(new PrintStream(outputStream));

        SuperClass superRef = new SubClass();

        assertNotNull("Polymorphic reference should work", superRef);
        assertTrue("Reference should point to SubClass instance",
                  superRef instanceof SubClass);

        System.setOut(originalOut);
    }

    @Test
    public void testConstructorOrder() {
        System.setOut(new PrintStream(outputStream));

        SubClass subClass = new SubClass();

        String output = outputStream.toString();
        int superIndex = output.indexOf("Другой конструктор суперкласса");
        int subIndex = output.indexOf("Конструктор Подкласса");

        assertTrue("Superclass constructor should be called first",
                  superIndex < subIndex);

        System.setOut(originalOut);
    }

    @Test
    public void testSubClassHasOneConstructor() {
        Constructor<?>[] constructors = SubClass.class.getDeclaredConstructors();
        assertEquals("SubClass should have 1 constructor",
                    1, constructors.length);
    }

    @Test
    public void testSubClassConstructorIsPublic() throws Exception {
        Constructor<SubClass> constructor = SubClass.class.getDeclaredConstructor();
        assertTrue("SubClass constructor should be public",
                  Modifier.isPublic(constructor.getModifiers()));
    }

    @Test
    public void testInheritanceHierarchy() {
        SubClass subClass = new SubClass();
        assertTrue("SubClass should be instance of SubClass",
                  subClass instanceof SubClass);
        assertTrue("SubClass should be instance of SuperClass",
                  subClass instanceof SuperClass);
        assertTrue("SubClass should be instance of Object",
                  subClass instanceof Object);
    }

    @Test
    public void testSuperClassCanBeInstantiatedDirectly() {
        System.setOut(new PrintStream(outputStream));

        SuperClass sc1 = new SuperClass();
        SuperClass sc2 = new SuperClass(99);

        assertNotNull("SuperClass with no args should be instantiable", sc1);
        assertNotNull("SuperClass with int arg should be instantiable", sc2);

        System.setOut(originalOut);
    }
}
