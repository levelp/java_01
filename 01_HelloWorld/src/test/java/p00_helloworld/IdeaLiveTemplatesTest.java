package p00_helloworld;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.*;

/**
 * Test class for IdeaLiveTemplates
 */
public class IdeaLiveTemplatesTest {

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
        IdeaLiveTemplates.main(new String[]{});
        assertNotNull(outContent.toString());
    }

    @Test
    public void testMainOutputContainsHelloWorld() {
        IdeaLiveTemplates.main(new String[]{});
        assertTrue(outContent.toString().contains("Hello world!"));
    }

    @Test
    public void testMainOutputContainsVariableValues() {
        IdeaLiveTemplates.main(new String[]{});
        String output = outContent.toString();
        assertTrue(output.contains("ii = 10"));
        assertTrue(output.contains("i3 = 3"));
    }

    @Test
    public void testMainOutputContainsMethodName() {
        IdeaLiveTemplates.main(new String[]{});
        assertTrue(outContent.toString().contains("IdeaLiveTemplates.main"));
    }

    @Test
    public void testMainOutputContainsLoopResults() {
        IdeaLiveTemplates.main(new String[]{});
        String output = outContent.toString();
        // Check for loop output j = 0 through j = 9
        assertTrue(output.contains("j = 0"));
        assertTrue(output.contains("j = 9"));
    }

    @Test
    public void testMainMethodExists() throws NoSuchMethodException {
        assertNotNull(IdeaLiveTemplates.class.getMethod("main", String[].class));
    }

    @Test
    public void testClassIsPublic() {
        assertTrue(java.lang.reflect.Modifier.isPublic(IdeaLiveTemplates.class.getModifiers()));
    }

    @Test
    public void testMainMethodIsStatic() throws NoSuchMethodException {
        assertTrue(java.lang.reflect.Modifier.isStatic(
            IdeaLiveTemplates.class.getMethod("main", String[].class).getModifiers()));
    }

    @Test
    public void testMainMethodIsPublic() throws NoSuchMethodException {
        assertTrue(java.lang.reflect.Modifier.isPublic(
            IdeaLiveTemplates.class.getMethod("main", String[].class).getModifiers()));
    }

    @Test
    public void testPackage() {
        assertEquals("p00_helloworld", IdeaLiveTemplates.class.getPackage().getName());
    }
}
