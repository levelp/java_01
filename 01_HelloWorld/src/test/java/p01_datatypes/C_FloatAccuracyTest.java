package p01_datatypes;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Modifier;
import static org.junit.Assert.*;

/**
 * Test class for C_FloatAccuracy
 */
public class C_FloatAccuracyTest {

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
        C_FloatAccuracy.main(new String[]{});
        assertNotNull(outContent.toString());
    }

    @Test
    public void testFloatAccuracyComparison() {
        C_FloatAccuracy.main(new String[]{});
        String output = outContent.toString();
        // The program should output either "Равно" or "Не равно!"
        assertTrue(output.contains("Равно") || output.contains("Не равно!"));
    }

    @Test
    public void testOutputShowsDifference() {
        C_FloatAccuracy.main(new String[]{});
        String output = outContent.toString();
        // Should show the difference calculation if not equal
        if (output.contains("Не равно!")) {
            assertTrue(output.contains("c - (a+b)"));
        }
    }

    @Test
    public void testFloatingPointPrecisionDemonstration() {
        // Test that 0.3 + 0.6 is not exactly 0.9 due to floating point precision
        double a = 0.3;
        double b = 0.6;
        double c = 0.9;
        double diff = Math.abs(a + b - c);
        assertTrue(diff > 0); // There should be some difference
        assertTrue(diff < 1e-15); // But it should be very small
    }

    @Test
    public void testMainMethodExists() throws NoSuchMethodException {
        assertNotNull(C_FloatAccuracy.class.getMethod("main", String[].class));
    }

    @Test
    public void testClassIsPublic() {
        assertTrue(Modifier.isPublic(C_FloatAccuracy.class.getModifiers()));
    }

    @Test
    public void testMainMethodIsStatic() throws NoSuchMethodException {
        assertTrue(Modifier.isStatic(
            C_FloatAccuracy.class.getMethod("main", String[].class).getModifiers()));
    }

    @Test
    public void testMainMethodIsPublic() throws NoSuchMethodException {
        assertTrue(Modifier.isPublic(
            C_FloatAccuracy.class.getMethod("main", String[].class).getModifiers()));
    }

    @Test
    public void testPackage() {
        assertEquals("p01_datatypes", C_FloatAccuracy.class.getPackage().getName());
    }

    @Test
    public void testOutputNotEmpty() {
        C_FloatAccuracy.main(new String[]{});
        assertFalse(outContent.toString().trim().isEmpty());
    }
}
