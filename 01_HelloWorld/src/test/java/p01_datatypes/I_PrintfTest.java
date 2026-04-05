package p01_datatypes;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Modifier;
import static org.junit.Assert.*;

/**
 * Test class for I_Printf
 */
public class I_PrintfTest {

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
        I_Printf.main(new String[]{});
        assertNotNull(outContent.toString());
    }

    @Test
    public void testPrintfIntegerFormatting() {
        I_Printf.main(new String[]{});
        String output = outContent.toString();
        // Should contain the integer 13
        assertTrue(output.contains("13"));
    }

    @Test
    public void testPrintfVariableOutput() {
        I_Printf.main(new String[]{});
        String output = outContent.toString();
        // Should contain formatted variable output
        assertTrue(output.contains("myIntVar = 10"));
    }

    @Test
    public void testPrintfHexFormatting() {
        I_Printf.main(new String[]{});
        String output = outContent.toString();
        // 2014 in hex is 7DE (lowercase) and 7DE (uppercase)
        // Actually it's 0x7DE which is 2014
        assertTrue(output.contains("7de") || output.contains("7DE"));
    }

    @Test
    public void testPrintfFloatFormatting() {
        I_Printf.main(new String[]{});
        String output = outContent.toString();
        // Should contain formatted float value 1.10
        assertTrue(output.contains("1.10") || output.contains("1,10"));
    }

    @Test
    public void testMultiplicationTableOutput() {
        I_Printf.main(new String[]{});
        String output = outContent.toString();
        // Should contain multiplication table results
        assertTrue(output.contains("81")); // 9*9
    }

    @Test
    public void testOutputNotEmpty() {
        I_Printf.main(new String[]{});
        assertFalse(outContent.toString().trim().isEmpty());
    }

    @Test
    public void testMainMethodExists() throws NoSuchMethodException {
        assertNotNull(I_Printf.class.getMethod("main", String[].class));
    }

    @Test
    public void testClassIsPublic() {
        assertTrue(Modifier.isPublic(I_Printf.class.getModifiers()));
    }

    @Test
    public void testMainMethodIsStatic() throws NoSuchMethodException {
        assertTrue(Modifier.isStatic(
            I_Printf.class.getMethod("main", String[].class).getModifiers()));
    }

    @Test
    public void testPackage() {
        assertEquals("p01_datatypes", I_Printf.class.getPackage().getName());
    }
}
