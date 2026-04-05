package p01_datatypes;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Modifier;
import static org.junit.Assert.*;

/**
 * Test class for H_Operators
 */
public class H_OperatorsTest {

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
        H_Operators.main(new String[]{});
        assertNotNull(outContent.toString());
    }

    @Test
    public void testMainOutputContainsAddition() {
        H_Operators.main(new String[]{});
        String output = outContent.toString();
        // a=2, b=3, so a+b=5
        assertTrue(output.contains("a + b = 5"));
    }

    @Test
    public void testArithmeticOperations() {
        // Test various arithmetic operations work
        int a = 2;
        int b = 3;
        assertEquals(5, a + b);
        assertEquals(-1, a - b);
        assertEquals(6, a * b);
        assertEquals(0, a / b);
        assertEquals(2, a % b);
    }

    @Test
    public void testBitwiseOperations() {
        // Test various bitwise operations work
        int a = 2;
        int b = 3;
        assertEquals(0, a >> b);
        assertEquals(16, a << b);
        assertEquals(3, a | b);
        assertEquals(2, a & b);
        assertEquals(1, a ^ b);
        assertEquals(-3, ~a);
    }

    @Test
    public void testLogicalOperations() {
        // Test logical operations work
        boolean ab = true;
        boolean bb = false;
        assertFalse(ab && bb);
        assertTrue(ab || bb);
        assertFalse(!ab);
    }

    @Test
    public void testMainMethodExists() throws NoSuchMethodException {
        assertNotNull(H_Operators.class.getMethod("main", String[].class));
    }

    @Test
    public void testClassIsPublic() {
        assertTrue(Modifier.isPublic(H_Operators.class.getModifiers()));
    }

    @Test
    public void testMainMethodIsStatic() throws NoSuchMethodException {
        assertTrue(Modifier.isStatic(
            H_Operators.class.getMethod("main", String[].class).getModifiers()));
    }

    @Test
    public void testMainMethodIsPublic() throws NoSuchMethodException {
        assertTrue(Modifier.isPublic(
            H_Operators.class.getMethod("main", String[].class).getModifiers()));
    }

    @Test
    public void testPackage() {
        assertEquals("p01_datatypes", H_Operators.class.getPackage().getName());
    }
}
