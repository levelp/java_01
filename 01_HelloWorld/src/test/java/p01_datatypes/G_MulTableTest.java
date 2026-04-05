package p01_datatypes;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Modifier;
import static org.junit.Assert.*;

/**
 * Test class for G_MulTable
 */
public class G_MulTableTest {

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
        G_MulTable.main(new String[]{});
        assertNotNull(outContent.toString());
    }

    @Test
    public void testMultiplicationTableHasCorrectRows() {
        G_MulTable.main(new String[]{});
        String output = outContent.toString();
        String[] lines = output.split("\n");
        // Should have 12 rows (1 through 12)
        assertEquals(12, lines.length);
    }

    @Test
    public void testMultiplicationTableContainsSmallProducts() {
        G_MulTable.main(new String[]{});
        String output = outContent.toString();
        // Check for some expected products
        assertTrue(output.contains("1")); // 1*1
        assertTrue(output.contains("12")); // 1*12 or others
    }

    @Test
    public void testMultiplicationTableContainsLargeProducts() {
        G_MulTable.main(new String[]{});
        String output = outContent.toString();
        // Check for largest product (12*12 = 144)
        assertTrue(output.contains("144"));
    }

    @Test
    public void testMultiplicationTableContainsMidProducts() {
        G_MulTable.main(new String[]{});
        String output = outContent.toString();
        // Check for some mid-range products
        assertTrue(output.contains("36")); // 6*6
        assertTrue(output.contains("49")); // 7*7
        assertTrue(output.contains("64")); // 8*8
    }

    @Test
    public void testOutputNotEmpty() {
        G_MulTable.main(new String[]{});
        assertFalse(outContent.toString().trim().isEmpty());
    }

    @Test
    public void testMainMethodExists() throws NoSuchMethodException {
        assertNotNull(G_MulTable.class.getMethod("main", String[].class));
    }

    @Test
    public void testClassIsPublic() {
        assertTrue(Modifier.isPublic(G_MulTable.class.getModifiers()));
    }

    @Test
    public void testMainMethodIsStatic() throws NoSuchMethodException {
        assertTrue(Modifier.isStatic(
            G_MulTable.class.getMethod("main", String[].class).getModifiers()));
    }

    @Test
    public void testPackage() {
        assertEquals("p01_datatypes", G_MulTable.class.getPackage().getName());
    }
}
