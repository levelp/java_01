package p01_datatypes;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.*;

public class D_ArraysTest {

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
        D_Arrays.main(new String[]{});
        String output = outContent.toString();
        assertTrue(output.contains("intArray1[0] = 1"));
    }

    @Test
    public void testArrayOutput() {
        D_Arrays.main(new String[]{});
        String output = outContent.toString();
        assertTrue(output.contains("1 2 3 10"));
    }

    @Test
    public void testMainMethodExists() throws NoSuchMethodException {
        assertNotNull(D_Arrays.class.getMethod("main", String[].class));
    }

    @Test
    public void testClassIsPublic() {
        assertTrue(java.lang.reflect.Modifier.isPublic(D_Arrays.class.getModifiers()));
    }
}
