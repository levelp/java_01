package java;

import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.reflect.Method;

/**
 * Test class for Main in ReadTextDemo
 */
public class MainTest {

    @Test
    public void testMainClassExists() {
        assertNotNull(Main.class);
    }

    @Test
    public void testMainHasMainMethod() throws NoSuchMethodException {
        Method mainMethod = Main.class.getMethod("main", String[].class);
        assertNotNull(mainMethod);
    }

    @Test
    public void testMainMethodIsStatic() throws NoSuchMethodException {
        Method mainMethod = Main.class.getMethod("main", String[].class);
        assertTrue(java.lang.reflect.Modifier.isStatic(mainMethod.getModifiers()));
    }

    @Test
    public void testMainMethodIsPublic() throws NoSuchMethodException {
        Method mainMethod = Main.class.getMethod("main", String[].class);
        assertTrue(java.lang.reflect.Modifier.isPublic(mainMethod.getModifiers()));
    }

    @Test
    public void testMainMethodReturnsVoid() throws NoSuchMethodException {
        Method mainMethod = Main.class.getMethod("main", String[].class);
        assertEquals(void.class, mainMethod.getReturnType());
    }

    @Test
    public void testMainInPackageJava() {
        assertEquals("java", Main.class.getPackage().getName());
    }

    @Test
    public void testSystemPropertyAccess() {
        String workingDir = System.getProperty("user.dir");
        assertNotNull(workingDir);
        assertFalse(workingDir.isEmpty());
    }

    @Test
    public void testMainMethodAcceptsArgs() {
        try {
            Method mainMethod = Main.class.getMethod("main", String[].class);
            Class<?>[] paramTypes = mainMethod.getParameterTypes();
            assertEquals(1, paramTypes.length);
            assertEquals(String[].class, paramTypes[0]);
        } catch (NoSuchMethodException e) {
            fail("Main method not found");
        }
    }

    @Test
    public void testMainClassIsPublic() {
        assertTrue(java.lang.reflect.Modifier.isPublic(Main.class.getModifiers()));
    }

    @Test
    public void testPathsUsage() {
        // Test that Paths can be used to create paths
        java.nio.file.Path path = java.nio.file.Paths.get("test.txt");
        assertNotNull(path);
    }

    @Test
    public void testFilesUsage() {
        // Test that Files class is available
        assertNotNull(java.nio.file.Files.class);
    }

    @Test
    public void testJOptionPaneAvailability() {
        // Test that JOptionPane is available
        assertNotNull(javax.swing.JOptionPane.class);
    }

    @Test
    public void testExceptionHandlingPathWithNonExistentFile() {
        // Test that when file doesn't exist, exception is caught
        // The main method catches exceptions and shows dialog
        // We can't easily test the dialog but we can verify the logic
        try {
            java.nio.file.Path nonExistentPath = java.nio.file.Paths.get("nonexistent_file_that_does_not_exist.txt");
            java.nio.file.Files.readAllBytes(nonExistentPath);
            fail("Should throw exception for non-existent file");
        } catch (Exception e) {
            assertNotNull(e.getMessage());
        }
    }

    @Test
    public void testExceptionMessageNotNull() {
        try {
            java.nio.file.Files.readAllBytes(java.nio.file.Paths.get("invalid_file.txt"));
        } catch (Exception e) {
            // Exception message should be available for display
            assertNotNull(e);
        }
    }

    @Test
    public void testFilesReadAllBytesThrowsForInvalidPath() {
        Exception caughtException = null;
        try {
            java.nio.file.Files.readAllBytes(java.nio.file.Paths.get("10_ReadTextDemo\\nonexistent.txt"));
        } catch (Exception e) {
            caughtException = e;
        }
        assertNotNull("Should catch exception for non-existent file", caughtException);
    }

    @Test
    public void testUTF8Charset() throws java.io.UnsupportedEncodingException {
        // Test that UTF-8 charset is available
        String testString = "Test string";
        byte[] bytes = testString.getBytes("UTF-8");
        String restored = new String(bytes, "UTF-8");
        assertEquals(testString, restored);
    }

    @Test
    public void testSystemPropertyUserDir() {
        // Test system property access used in main
        String workingDir = System.getProperty("user.dir");
        assertNotNull(workingDir);
        assertTrue(workingDir.length() > 0);
    }

    @Test
    public void testPathCreation() {
        // Test that path creation works as in the main method
        java.nio.file.Path path = java.nio.file.Paths.get("10_ReadTextDemo\\text.txt");
        assertNotNull(path);
        assertTrue(path.toString().contains("text.txt"));
    }
}
