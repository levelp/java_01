package swingapplication;

import org.junit.Test;

import static org.junit.Assert.*;

public class SwingApplicationTest {

    @Test
    public void testSwingApplicationExists() {
        // Test that the class can be loaded
        try {
            Class.forName("swingapplication.SwingApplication");
            assertTrue(true);
        } catch (ClassNotFoundException e) {
            fail("SwingApplication class should exist");
        }
    }

    @Test
    public void testSwingApplicationHasMainMethod() {
        // Verify that main method exists
        try {
            SwingApplication.class.getMethod("main", String[].class);
            assertTrue(true);
        } catch (NoSuchMethodException e) {
            fail("main method should exist");
        }
    }

    @Test
    public void testSwingApplicationHasInitMethod() {
        // Verify that init method exists
        try {
            SwingApplication.class.getMethod("init");
            assertTrue(true);
        } catch (NoSuchMethodException e) {
            fail("init method should exist");
        }
    }

    @Test
    public void testSwingApplicationConstants() {
        // Test that constants are accessible via reflection
        try {
            java.lang.reflect.Field widthField = SwingApplication.class.getDeclaredField("JFXPANEL_WIDTH_INT");
            widthField.setAccessible(true);
            assertEquals(300, widthField.getInt(null));

            java.lang.reflect.Field heightField = SwingApplication.class.getDeclaredField("JFXPANEL_HEIGHT_INT");
            heightField.setAccessible(true);
            assertEquals(250, heightField.getInt(null));
        } catch (Exception e) {
            fail("Constants should be accessible: " + e.getMessage());
        }
    }

    @Test
    public void testSwingApplicationInstantiation() {
        SwingApplication app = new SwingApplication();
        assertNotNull(app);
    }
}
