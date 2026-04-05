package p01_datatypes;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.*;

public class B_if_elseTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final java.io.InputStream originalIn = System.in;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    @Test
    public void testMainWith10() {
        System.setIn(new ByteArrayInputStream("10\n".getBytes()));
        B_if_else.main(new String[]{});
        assertTrue(outContent.toString().contains("a равно 10"));
        assertTrue(outContent.toString().contains("a >= 10"));
    }

    @Test
    public void testMainWithNot10() {
        System.setIn(new ByteArrayInputStream("5\n".getBytes()));
        B_if_else.main(new String[]{});
        assertTrue(outContent.toString().contains("a не равно 10"));
    }

    @Test
    public void testMainWithGreaterThan10() {
        System.setIn(new ByteArrayInputStream("15\n".getBytes()));
        B_if_else.main(new String[]{});
        assertTrue(outContent.toString().contains("a >= 10"));
    }

    @Test
    public void testMainMethodExists() throws NoSuchMethodException {
        assertNotNull(B_if_else.class.getMethod("main", String[].class));
    }

    @Test
    public void testMainWithLessThan10() {
        // Test branch where a < 10 (not >= 10)
        System.setIn(new ByteArrayInputStream("5\n".getBytes()));
        B_if_else.main(new String[]{});
        String output = outContent.toString();
        assertTrue(output.contains("a не равно 10"));
        assertFalse(output.contains("a >= 10"));
    }

    @Test
    public void testMainWithExactly10BothBranches() {
        // a == 10 and a >= 10 should both be triggered
        System.setIn(new ByteArrayInputStream("10\n".getBytes()));
        B_if_else.main(new String[]{});
        String output = outContent.toString();
        assertTrue(output.contains("a равно 10"));
        assertTrue(output.contains("a >= 10"));
    }

    @Test
    public void testMainWithNegativeNumber() {
        System.setIn(new ByteArrayInputStream("-5\n".getBytes()));
        B_if_else.main(new String[]{});
        String output = outContent.toString();
        assertTrue(output.contains("a не равно 10"));
        assertFalse(output.contains("a >= 10"));
    }

    @Test
    public void testMainWithZero() {
        System.setIn(new ByteArrayInputStream("0\n".getBytes()));
        B_if_else.main(new String[]{});
        String output = outContent.toString();
        assertTrue(output.contains("a не равно 10"));
        assertFalse(output.contains("a >= 10"));
    }

    @Test
    public void testClassIsPublic() {
        assertTrue(java.lang.reflect.Modifier.isPublic(B_if_else.class.getModifiers()));
    }

    @Test
    public void testMainMethodIsStatic() throws NoSuchMethodException {
        assertTrue(java.lang.reflect.Modifier.isStatic(
            B_if_else.class.getMethod("main", String[].class).getModifiers()));
    }

    @Test
    public void testPackage() {
        assertEquals("p01_datatypes", B_if_else.class.getPackage().getName());
    }
}
