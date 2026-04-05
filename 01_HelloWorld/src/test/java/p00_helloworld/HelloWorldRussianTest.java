package p00_helloworld;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.*;

/**
 * Test class for HelloWorldRussian
 */
public class HelloWorldRussianTest {

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
    public void testMain() {
        HelloWorldRussian.main(new String[]{});
        String output = outContent.toString();
        assertTrue(output.contains("Здравствуй, Мир!"));
        assertTrue(output.contains("мояПеременная = 10"));
    }

    @Test
    public void testMainMethodExists() throws NoSuchMethodException {
        assertNotNull(HelloWorldRussian.class.getMethod("main", String[].class));
    }

    @Test
    public void testClassIsPublic() {
        assertTrue(java.lang.reflect.Modifier.isPublic(HelloWorldRussian.class.getModifiers()));
    }

    @Test
    public void testPackage() {
        assertEquals("p00_helloworld", HelloWorldRussian.class.getPackage().getName());
    }

    @Test
    public void testOutputContainsRussianText() {
        HelloWorldRussian.main(new String[]{});
        assertTrue(outContent.toString().contains("Мир"));
    }
}
