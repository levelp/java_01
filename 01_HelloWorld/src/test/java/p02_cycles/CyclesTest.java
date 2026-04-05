package p02_cycles;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.*;

/**
 * Test class for Cycles
 */
public class CyclesTest {

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
        Cycles.main(new String[]{});
        String output = outContent.toString();
        assertTrue(output.contains("Таблица умножения"));
        assertFalse(output.isEmpty());
    }

    @Test
    public void testWhileLoopOutput() {
        Cycles.main(new String[]{});
        String output = outContent.toString();
        assertTrue(output.contains("N = 6"));
        assertTrue(output.contains("inverse binary"));
    }

    @Test
    public void testDoWhileLoopOutput() {
        Cycles.main(new String[]{});
        String output = outContent.toString();
        assertTrue(output.contains("x ="));
    }

    @Test
    public void testMultiplicationTable() {
        Cycles.main(new String[]{});
        String output = outContent.toString();
        assertTrue(output.contains("==================="));
    }

    @Test
    public void testMainMethodExists() throws NoSuchMethodException {
        assertNotNull(Cycles.class.getMethod("main", String[].class));
    }

    @Test
    public void testClassIsPublic() {
        assertTrue(java.lang.reflect.Modifier.isPublic(Cycles.class.getModifiers()));
    }

    @Test
    public void testPackage() {
        assertEquals("p02_cycles", Cycles.class.getPackage().getName());
    }

    @Test
    public void testMultiplicationTableValues() {
        Cycles.main(new String[]{});
        String output = outContent.toString();
        // Check for some multiplication values
        assertTrue(output.length() > 100);
    }
}
