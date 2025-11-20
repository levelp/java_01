import org.junit.Test;

import static org.junit.Assert.*;

public class MyClassTest {

    @Test
    public void testMyClassInstantiation() {
        MyClass myClass = new MyClass();
        assertNotNull(myClass);
    }

    @Test
    public void testMyClassExists() {
        // Test that the class can be loaded
        try {
            Class.forName("MyClass");
            assertTrue(true);
        } catch (ClassNotFoundException e) {
            fail("MyClass should exist");
        }
    }

    @Test
    public void testMyClassHasMainMethod() {
        // Verify that main method exists
        try {
            MyClass.class.getMethod("main", String[].class);
            assertTrue(true);
        } catch (NoSuchMethodException e) {
            fail("main method should exist");
        }
    }
}
