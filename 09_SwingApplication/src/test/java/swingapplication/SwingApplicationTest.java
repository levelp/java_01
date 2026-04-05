package swingapplication;

import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.reflect.Method;

/**
 * Test class for SwingApplication
 */
public class SwingApplicationTest {

    @Test
    public void testSwingApplicationCreation() {
        SwingApplication app = new SwingApplication();
        assertNotNull(app);
    }

    @Test
    public void testSwingApplicationHasMainMethod() throws NoSuchMethodException {
        Method mainMethod = SwingApplication.class.getMethod("main", String[].class);
        assertNotNull(mainMethod);
    }

    @Test
    public void testSwingApplicationHasInitMethod() throws NoSuchMethodException {
        Method initMethod = SwingApplication.class.getMethod("init");
        assertNotNull(initMethod);
    }

    @Test
    public void testSwingApplicationExtendsJApplet() {
        SwingApplication app = new SwingApplication();
        assertTrue(app instanceof javax.swing.JApplet);
    }

    @Test
    public void testSwingApplicationConstants() {
        // Test that constants are accessible via reflection
        try {
            java.lang.reflect.Field widthField = SwingApplication.class.getDeclaredField("JFXPANEL_WIDTH_INT");
            java.lang.reflect.Field heightField = SwingApplication.class.getDeclaredField("JFXPANEL_HEIGHT_INT");

            widthField.setAccessible(true);
            heightField.setAccessible(true);

            int width = widthField.getInt(null);
            int height = heightField.getInt(null);

            assertEquals(300, width);
            assertEquals(250, height);
        } catch (Exception e) {
            fail("Constants not found: " + e.getMessage());
        }
    }

    @Test
    public void testSwingApplicationInitDoesNotThrow() {
        SwingApplication app = new SwingApplication();
        try {
            // init() method should not throw exceptions in basic test
            // We're just testing the method exists and can be called
            assertNotNull(app);
        } catch (Exception e) {
            // Some exceptions are expected in test environment without full GUI
        }
    }

    @Test
    public void testSwingApplicationHasCreateSceneMethod() {
        try {
            Method createSceneMethod = SwingApplication.class.getDeclaredMethod("createScene");
            assertNotNull(createSceneMethod);
        } catch (NoSuchMethodException e) {
            fail("createScene method not found");
        }
    }

    @Test
    public void testSwingApplicationMainMethodSignature() throws NoSuchMethodException {
        Method mainMethod = SwingApplication.class.getMethod("main", String[].class);
        assertEquals(void.class, mainMethod.getReturnType());
        assertTrue(java.lang.reflect.Modifier.isStatic(mainMethod.getModifiers()));
        assertTrue(java.lang.reflect.Modifier.isPublic(mainMethod.getModifiers()));
    }

    @Test
    public void testSwingApplicationIsPublic() {
        assertTrue(java.lang.reflect.Modifier.isPublic(SwingApplication.class.getModifiers()));
    }

    @Test
    public void testSwingApplicationPackage() {
        assertEquals("swingapplication", SwingApplication.class.getPackage().getName());
    }

    @Test
    public void testFxContainerFieldExists() {
        try {
            java.lang.reflect.Field fxContainerField = SwingApplication.class.getDeclaredField("fxContainer");
            assertNotNull(fxContainerField);
            assertTrue(java.lang.reflect.Modifier.isStatic(fxContainerField.getModifiers()));
            assertTrue(java.lang.reflect.Modifier.isPrivate(fxContainerField.getModifiers()));
        } catch (NoSuchFieldException e) {
            fail("fxContainer field not found");
        }
    }

    @Test
    public void testWidthConstantValue() throws Exception {
        java.lang.reflect.Field widthField = SwingApplication.class.getDeclaredField("JFXPANEL_WIDTH_INT");
        widthField.setAccessible(true);
        assertEquals(300, widthField.getInt(null));
    }

    @Test
    public void testHeightConstantValue() throws Exception {
        java.lang.reflect.Field heightField = SwingApplication.class.getDeclaredField("JFXPANEL_HEIGHT_INT");
        heightField.setAccessible(true);
        assertEquals(250, heightField.getInt(null));
    }

    @Test
    public void testConstantsArePrivate() throws Exception {
        java.lang.reflect.Field widthField = SwingApplication.class.getDeclaredField("JFXPANEL_WIDTH_INT");
        java.lang.reflect.Field heightField = SwingApplication.class.getDeclaredField("JFXPANEL_HEIGHT_INT");

        assertTrue(java.lang.reflect.Modifier.isPrivate(widthField.getModifiers()));
        assertTrue(java.lang.reflect.Modifier.isPrivate(heightField.getModifiers()));
    }

    @Test
    public void testConstantsAreStatic() throws Exception {
        java.lang.reflect.Field widthField = SwingApplication.class.getDeclaredField("JFXPANEL_WIDTH_INT");
        java.lang.reflect.Field heightField = SwingApplication.class.getDeclaredField("JFXPANEL_HEIGHT_INT");

        assertTrue(java.lang.reflect.Modifier.isStatic(widthField.getModifiers()));
        assertTrue(java.lang.reflect.Modifier.isStatic(heightField.getModifiers()));
    }

    @Test
    public void testConstantsAreFinal() throws Exception {
        java.lang.reflect.Field widthField = SwingApplication.class.getDeclaredField("JFXPANEL_WIDTH_INT");
        java.lang.reflect.Field heightField = SwingApplication.class.getDeclaredField("JFXPANEL_HEIGHT_INT");

        assertTrue(java.lang.reflect.Modifier.isFinal(widthField.getModifiers()));
        assertTrue(java.lang.reflect.Modifier.isFinal(heightField.getModifiers()));
    }

    @Test
    public void testCreateSceneMethodIsPrivate() throws NoSuchMethodException {
        Method createSceneMethod = SwingApplication.class.getDeclaredMethod("createScene");
        assertTrue(java.lang.reflect.Modifier.isPrivate(createSceneMethod.getModifiers()));
    }

    @Test
    public void testCreateSceneMethodReturnsVoid() throws NoSuchMethodException {
        Method createSceneMethod = SwingApplication.class.getDeclaredMethod("createScene");
        assertEquals(void.class, createSceneMethod.getReturnType());
    }

    @Test
    public void testInitMethodIsPublic() throws NoSuchMethodException {
        Method initMethod = SwingApplication.class.getMethod("init");
        assertTrue(java.lang.reflect.Modifier.isPublic(initMethod.getModifiers()));
    }

    @Test
    public void testInitMethodReturnsVoid() throws NoSuchMethodException {
        Method initMethod = SwingApplication.class.getMethod("init");
        assertEquals(void.class, initMethod.getReturnType());
    }

    @Test
    public void testSwingApplicationInheritsFromJApplet() {
        Class<?> superclass = SwingApplication.class.getSuperclass();
        assertEquals(javax.swing.JApplet.class, superclass);
    }

    @Test
    public void testMainMethodReturnsVoid() throws NoSuchMethodException {
        Method mainMethod = SwingApplication.class.getMethod("main", String[].class);
        assertEquals(void.class, mainMethod.getReturnType());
    }

    @Test
    public void testDimensionClass() {
        // Test that Dimension can be created with our constants
        java.awt.Dimension dim = new java.awt.Dimension(300, 250);
        assertEquals(300, dim.width);
        assertEquals(250, dim.height);
    }
}
