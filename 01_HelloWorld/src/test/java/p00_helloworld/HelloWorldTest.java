package p00_helloworld;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.*;

/**
 * Test class for HelloWorld
 */
public class HelloWorldTest {

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
        HelloWorld.main(new String[]{});
        assertTrue(outContent.toString().contains("Hello, world!"));
    }

    @Test
    public void testMainMethodExists() throws NoSuchMethodException {
        assertNotNull(HelloWorld.class.getMethod("main", String[].class));
    }

    @Test
    public void testHelloWorldClassIsPublic() {
        assertTrue(java.lang.reflect.Modifier.isPublic(HelloWorld.class.getModifiers()));
    }

    @Test
    public void testMainMethodIsStatic() throws NoSuchMethodException {
        assertTrue(java.lang.reflect.Modifier.isStatic(
            HelloWorld.class.getMethod("main", String[].class).getModifiers()));
    }

    @Test
    public void testMainMethodIsPublic() throws NoSuchMethodException {
        assertTrue(java.lang.reflect.Modifier.isPublic(
            HelloWorld.class.getMethod("main", String[].class).getModifiers()));
    }

    @Test
    public void testPackage() {
        assertEquals("p00_helloworld", HelloWorld.class.getPackage().getName());
    }
}
