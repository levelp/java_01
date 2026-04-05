package package2;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Modifier;
import static org.junit.Assert.*;

/**
 * Test class for package2 Main
 */
public class MainTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testMainRunsWithoutErrors() {
        Main.main(new String[]{});
        assertNotNull(outContent.toString());
    }

    @Test
    public void testMainOutputContainsRussianGreeting() {
        Main.main(new String[]{});
        assertTrue(outContent.toString().contains("Привет всем!"));
    }

    @Test
    public void testMainOutputNotEmpty() {
        Main.main(new String[]{});
        assertFalse(outContent.toString().trim().isEmpty());
    }

    @Test
    public void testMainMethodExists() throws NoSuchMethodException {
        assertNotNull(Main.class.getMethod("main", String[].class));
    }

    @Test
    public void testClassIsPublic() {
        assertTrue(Modifier.isPublic(Main.class.getModifiers()));
    }

    @Test
    public void testMainMethodIsStatic() throws NoSuchMethodException {
        assertTrue(Modifier.isStatic(
            Main.class.getMethod("main", String[].class).getModifiers()));
    }

    @Test
    public void testMainMethodIsPublic() throws NoSuchMethodException {
        assertTrue(Modifier.isPublic(
            Main.class.getMethod("main", String[].class).getModifiers()));
    }

    @Test
    public void testPackage() {
        assertEquals("package2", Main.class.getPackage().getName());
    }

    @Test
    public void testMainAcceptsStringArrayArgument() throws NoSuchMethodException {
        Class<?>[] paramTypes = Main.class.getMethod("main", String[].class).getParameterTypes();
        assertEquals(1, paramTypes.length);
        assertEquals(String[].class, paramTypes[0]);
    }

    @Test
    public void testMainReturnTypeIsVoid() throws NoSuchMethodException {
        assertEquals(void.class, Main.class.getMethod("main", String[].class).getReturnType());
    }
}
