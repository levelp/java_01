package java;

import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void testMainClassExists() {
        Main main = new Main();
        assertNotNull(main);
    }

    @Test
    public void testMainHasMainMethod() {
        // Verify that main method exists
        try {
            Main.class.getMethod("main", String[].class);
            assertTrue(true);
        } catch (NoSuchMethodException e) {
            fail("main method should exist");
        }
    }

    @Test
    public void testMainCanBeInstantiated() {
        Main main = new Main();
        assertNotNull(main);
    }
}
