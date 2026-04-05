package p01_datatypes;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import static org.junit.Assert.*;

/**
 * Test class for X_RussianId
 */
public class X_RussianIdTest {

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
        X_RussianId.main(new String[]{});
        assertNotNull(outContent.toString());
    }

    @Test
    public void testMainOutputContainsSum() {
        X_RussianId.main(new String[]{});
        String output = outContent.toString();
        // 10 + 23 = 33
        assertTrue(output.contains("сумма = 33"));
    }

    @Test
    public void testMainCallsRussianMethod() {
        X_RussianId.main(new String[]{});
        String output = outContent.toString();
        assertTrue(output.contains("мойМетод"));
    }

    @Test
    public void testRussianMethodExists() throws NoSuchMethodException {
        Method method = X_RussianId.class.getDeclaredMethod("мойМетод");
        assertNotNull(method);
        assertTrue(Modifier.isPrivate(method.getModifiers()));
        assertTrue(Modifier.isStatic(method.getModifiers()));
    }

    @Test
    public void testOutputNotEmpty() {
        X_RussianId.main(new String[]{});
        assertFalse(outContent.toString().trim().isEmpty());
    }

    @Test
    public void testMainMethodExists() throws NoSuchMethodException {
        assertNotNull(X_RussianId.class.getMethod("main", String[].class));
    }

    @Test
    public void testClassIsPublic() {
        assertTrue(Modifier.isPublic(X_RussianId.class.getModifiers()));
    }

    @Test
    public void testMainMethodIsStatic() throws NoSuchMethodException {
        assertTrue(Modifier.isStatic(
            X_RussianId.class.getMethod("main", String[].class).getModifiers()));
    }

    @Test
    public void testMainMethodIsPublic() throws NoSuchMethodException {
        assertTrue(Modifier.isPublic(
            X_RussianId.class.getMethod("main", String[].class).getModifiers()));
    }

    @Test
    public void testPackage() {
        assertEquals("p01_datatypes", X_RussianId.class.getPackage().getName());
    }

    @Test
    public void testRussianMethodViaReflection() throws Exception {
        // Test the private Russian method via reflection
        Method method = X_RussianId.class.getDeclaredMethod("мойМетод");
        method.setAccessible(true);

        // Invoke the method
        method.invoke(null);

        // Verify the output
        assertTrue(outContent.toString().contains("мойМетод"));
    }

    @Test
    public void testRussianMethodReturnsVoid() throws NoSuchMethodException {
        Method method = X_RussianId.class.getDeclaredMethod("мойМетод");
        assertEquals(void.class, method.getReturnType());
    }
}
