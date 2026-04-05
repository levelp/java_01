package p01_datatypes;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.*;

/**
 * Test class for A_PrimitiveTypes
 */
public class A_PrimitiveTypesTest {

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
        A_PrimitiveTypes.main(new String[]{});
        String output = outContent.toString();
        assertTrue(output.contains("Hello, group!"));
    }

    @Test
    public void testMainWithArgs() {
        A_PrimitiveTypes.main(new String[]{"arg1", "arg2"});
        String output = outContent.toString();
        assertTrue(output.contains("arg1"));
        assertTrue(output.contains("arg2"));
    }

    @Test
    public void testMainMethodExists() throws NoSuchMethodException {
        assertNotNull(A_PrimitiveTypes.class.getMethod("main", String[].class));
    }

    @Test
    public void testByteOutput() {
        A_PrimitiveTypes.main(new String[]{});
        String output = outContent.toString();
        assertTrue(output.contains("Byte.MIN_VALUE"));
        assertTrue(output.contains("Byte.MAX_VALUE"));
    }

    @Test
    public void testShortOutput() {
        A_PrimitiveTypes.main(new String[]{});
        String output = outContent.toString();
        assertTrue(output.contains("short ="));
    }

    @Test
    public void testIntegerOutput() {
        A_PrimitiveTypes.main(new String[]{});
        String output = outContent.toString();
        assertTrue(output.contains("Integer.MAX_VALUE"));
    }

    @Test
    public void testLongOutput() {
        A_PrimitiveTypes.main(new String[]{});
        String output = outContent.toString();
        assertTrue(output.contains("Диапазон:"));
    }

    @Test
    public void testFloatOutput() {
        A_PrimitiveTypes.main(new String[]{});
        String output = outContent.toString();
        assertTrue(output.contains("Float.MIN_VALUE"));
    }

    @Test
    public void testBooleanOutput() {
        A_PrimitiveTypes.main(new String[]{});
        String output = outContent.toString();
        assertTrue(output.contains("bool"));
    }

    @Test
    public void testClassIsPublic() {
        assertTrue(java.lang.reflect.Modifier.isPublic(A_PrimitiveTypes.class.getModifiers()));
    }
}
