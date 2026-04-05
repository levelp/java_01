package p01_datatypes;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.*;

/**
 * Test class for BoolDemo
 */
public class BoolDemoTest {

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
    public void testMainWithAdultAge() {
        String input = "18\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        BoolDemo.main(new String[]{});
        assertTrue(outContent.toString().contains("Я уже взрослый!"));
    }

    @Test
    public void testMainWithChildAge() {
        String input = "10\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        BoolDemo.main(new String[]{});
        assertTrue(outContent.toString().contains("Я ещё ребёнок"));
    }

    @Test
    public void testMainWithExactly18() {
        String input = "18\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        BoolDemo.main(new String[]{});
        assertTrue(outContent.toString().contains("взрослый"));
    }

    @Test
    public void testMainWith17() {
        String input = "17\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        BoolDemo.main(new String[]{});
        assertTrue(outContent.toString().contains("ребёнок"));
    }

    @Test
    public void testMainWith25() {
        String input = "25\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        BoolDemo.main(new String[]{});
        assertTrue(outContent.toString().contains("взрослый"));
    }

    @Test
    public void testMainMethodExists() throws NoSuchMethodException {
        assertNotNull(BoolDemo.class.getMethod("main", String[].class));
    }

    @Test
    public void testClassIsPublic() {
        assertTrue(java.lang.reflect.Modifier.isPublic(BoolDemo.class.getModifiers()));
    }
}
