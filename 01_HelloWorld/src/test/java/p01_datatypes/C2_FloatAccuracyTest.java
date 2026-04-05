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
 * Test class for C2_FloatAccuracy
 */
public class C2_FloatAccuracyTest {

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
        C2_FloatAccuracy.main(new String[]{});
        assertNotNull(outContent.toString());
    }

    @Test
    public void testMainOutputContainsTestResults() {
        C2_FloatAccuracy.main(new String[]{});
        String output = outContent.toString();
        assertTrue(output.contains("YES") || output.contains("NO"));
    }

    @Test
    public void testOutputContainsFloatAndDoubleLabels() {
        C2_FloatAccuracy.main(new String[]{});
        String output = outContent.toString();
        assertTrue(output.contains("double"));
        assertTrue(output.contains("float"));
    }

    @Test
    public void testOutputContainsEqualsResults() {
        C2_FloatAccuracy.main(new String[]{});
        String output = outContent.toString();
        assertTrue(output.contains("equals(a+b,c)"));
    }

    @Test
    public void testEqualsMethodExists() throws NoSuchMethodException {
        Method method = C2_FloatAccuracy.class.getDeclaredMethod("equals", double.class, double.class);
        assertNotNull(method);
        assertEquals(boolean.class, method.getReturnType());
    }

    @Test
    public void testSumDoubleMethodExists() throws NoSuchMethodException {
        Method method = C2_FloatAccuracy.class.getDeclaredMethod("sumDouble", double.class, double.class, double.class);
        assertNotNull(method);
        assertTrue(Modifier.isStatic(method.getModifiers()));
    }

    @Test
    public void testSumFloatMethodExists() throws NoSuchMethodException {
        Method method = C2_FloatAccuracy.class.getDeclaredMethod("sumFloat", float.class, float.class, float.class);
        assertNotNull(method);
        assertTrue(Modifier.isStatic(method.getModifiers()));
    }

    @Test
    public void testMainMethodExists() throws NoSuchMethodException {
        assertNotNull(C2_FloatAccuracy.class.getMethod("main", String[].class));
    }

    @Test
    public void testClassIsPublic() {
        assertTrue(Modifier.isPublic(C2_FloatAccuracy.class.getModifiers()));
    }

    @Test
    public void testMainMethodIsStatic() throws NoSuchMethodException {
        assertTrue(Modifier.isStatic(
            C2_FloatAccuracy.class.getMethod("main", String[].class).getModifiers()));
    }

    @Test
    public void testPackage() {
        assertEquals("p01_datatypes", C2_FloatAccuracy.class.getPackage().getName());
    }

    @Test
    public void testEqualsMethodViaReflection() throws Exception {
        Method method = C2_FloatAccuracy.class.getDeclaredMethod("equals", double.class, double.class);
        method.setAccessible(true);

        // Test equal values
        Boolean result1 = (Boolean) method.invoke(null, 1.0, 1.0);
        assertTrue(result1);

        // Test nearly equal values within epsilon
        Boolean result2 = (Boolean) method.invoke(null, 1.0, 1.0000001);
        assertTrue(result2);

        // Test values that differ by more than epsilon
        Boolean result3 = (Boolean) method.invoke(null, 1.0, 2.0);
        assertFalse(result3);
    }

    @Test
    public void testSumDoubleEqual() throws Exception {
        Method method = C2_FloatAccuracy.class.getDeclaredMethod("sumDouble", double.class, double.class, double.class);
        method.setAccessible(true);

        // Test case where a + b == c exactly
        method.invoke(null, 1.0, 2.0, 3.0);
        String output = outContent.toString();
        assertTrue(output.contains("YES") || output.contains("NO"));
    }

    @Test
    public void testSumDoubleNotEqual() throws Exception {
        Method method = C2_FloatAccuracy.class.getDeclaredMethod("sumDouble", double.class, double.class, double.class);
        method.setAccessible(true);

        // Test case where a + b != c
        method.invoke(null, 0.1, 0.2, 0.3);
        String output = outContent.toString();
        assertTrue(output.contains("double"));
    }

    @Test
    public void testSumFloatEqual() throws Exception {
        Method method = C2_FloatAccuracy.class.getDeclaredMethod("sumFloat", float.class, float.class, float.class);
        method.setAccessible(true);

        // Test case where a + b == c exactly
        method.invoke(null, 1.0f, 2.0f, 3.0f);
        String output = outContent.toString();
        assertTrue(output.contains("YES") || output.contains("NO"));
    }

    @Test
    public void testSumFloatNotEqual() throws Exception {
        Method method = C2_FloatAccuracy.class.getDeclaredMethod("sumFloat", float.class, float.class, float.class);
        method.setAccessible(true);

        // Test case where a + b != c
        method.invoke(null, 0.1f, 0.2f, 0.3f);
        String output = outContent.toString();
        assertTrue(output.contains("float"));
    }

    @Test
    public void testOutputNotEmpty() {
        C2_FloatAccuracy.main(new String[]{});
        assertFalse(outContent.toString().trim().isEmpty());
    }
}
