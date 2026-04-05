package p01_datatypes;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.*;

public class F_IncDecTest {

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
        F_IncDec.main(new String[]{});
        String output = outContent.toString();
        assertTrue(output.contains("i = 3"));
        assertTrue(output.contains("j = 2"));
        assertTrue(output.contains("a = 4"));
    }

    @Test
    public void testMainMethodExists() throws NoSuchMethodException {
        assertNotNull(F_IncDec.class.getMethod("main", String[].class));
    }

    @Test
    public void testClassIsPublic() {
        assertTrue(java.lang.reflect.Modifier.isPublic(F_IncDec.class.getModifiers()));
    }
}
