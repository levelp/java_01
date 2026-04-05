package p00_helloworld;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import static org.junit.Assert.*;

/**
 * Test class for IdeaLive2
 */
public class IdeaLive2Test {

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
        IdeaLive2.main(new String[]{});
        assertNotNull(outContent.toString());
    }

    @Test
    public void testMainOutputContainsHello() {
        IdeaLive2.main(new String[]{});
        assertTrue(outContent.toString().contains("Hello!"));
    }

    @Test
    public void testMainOutputContainsVariableValue() {
        IdeaLive2.main(new String[]{});
        String output = outContent.toString();
        assertTrue(output.contains("var = 10"));
        assertTrue(output.contains("i1 = 10"));
    }

    @Test
    public void testMainCallsMyFunction() {
        IdeaLive2.main(new String[]{});
        // The function is called but doesn't print, we verify main runs successfully
        assertFalse(outContent.toString().isEmpty());
    }

    @Test
    public void testMyFunctionExists() throws NoSuchMethodException {
        Method method = IdeaLive2.class.getDeclaredMethod("myFunction", double.class);
        assertNotNull(method);
        assertEquals(String.class, method.getReturnType());
    }

    @Test
    public void testMyFunctionIsPrivate() throws NoSuchMethodException {
        Method method = IdeaLive2.class.getDeclaredMethod("myFunction", double.class);
        assertTrue(Modifier.isPrivate(method.getModifiers()));
    }

    @Test
    public void testMainMethodExists() throws NoSuchMethodException {
        assertNotNull(IdeaLive2.class.getMethod("main", String[].class));
    }

    @Test
    public void testClassIsPublic() {
        assertTrue(Modifier.isPublic(IdeaLive2.class.getModifiers()));
    }

    @Test
    public void testMainMethodIsStatic() throws NoSuchMethodException {
        assertTrue(Modifier.isStatic(
            IdeaLive2.class.getMethod("main", String[].class).getModifiers()));
    }

    @Test
    public void testPackage() {
        assertEquals("p00_helloworld", IdeaLive2.class.getPackage().getName());
    }

    @Test
    public void testMyFunctionReturnsCorrectString() throws Exception {
        // Test private method via reflection
        Method method = IdeaLive2.class.getDeclaredMethod("myFunction", double.class);
        method.setAccessible(true);

        String result = (String) method.invoke(null, 10.0);
        assertEquals("myParam = 10.0", result);
    }

    @Test
    public void testMyFunctionWithZero() throws Exception {
        Method method = IdeaLive2.class.getDeclaredMethod("myFunction", double.class);
        method.setAccessible(true);

        String result = (String) method.invoke(null, 0.0);
        assertEquals("myParam = 0.0", result);
    }

    @Test
    public void testMyFunctionWithNegative() throws Exception {
        Method method = IdeaLive2.class.getDeclaredMethod("myFunction", double.class);
        method.setAccessible(true);

        String result = (String) method.invoke(null, -5.5);
        assertEquals("myParam = -5.5", result);
    }

    @Test
    public void testMyFunctionWithLargeNumber() throws Exception {
        Method method = IdeaLive2.class.getDeclaredMethod("myFunction", double.class);
        method.setAccessible(true);

        String result = (String) method.invoke(null, 1000000.0);
        assertEquals("myParam = 1000000.0", result);
    }

    @Test
    public void testMyFunctionIsStatic() throws NoSuchMethodException {
        Method method = IdeaLive2.class.getDeclaredMethod("myFunction", double.class);
        assertTrue(Modifier.isStatic(method.getModifiers()));
    }
}
