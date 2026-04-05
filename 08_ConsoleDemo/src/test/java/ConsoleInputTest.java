import org.junit.Test;
import org.junit.After;
import org.junit.Before;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

/**
 * Test class for ConsoleInput
 */
public class ConsoleInputTest {

    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;
    private ByteArrayOutputStream testOut;

    @Before
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    @After
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    @Test
    public void testMainWithPositiveNumbers() {
        String input = "5 3\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        ConsoleInput.main(new String[]{});

        String output = testOut.toString();
        assertTrue(output.contains("Сумма = 8"));
    }

    @Test
    public void testMainWithNegativeNumbers() {
        String input = "-5 -3\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        ConsoleInput.main(new String[]{});

        String output = testOut.toString();
        assertTrue(output.contains("Сумма = -8"));
    }

    @Test
    public void testMainWithZero() {
        String input = "0 0\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        ConsoleInput.main(new String[]{});

        String output = testOut.toString();
        assertTrue(output.contains("Сумма = 0"));
    }

    @Test
    public void testMainWithMixedNumbers() {
        String input = "-10 15\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        ConsoleInput.main(new String[]{});

        String output = testOut.toString();
        assertTrue(output.contains("Сумма = 5"));
    }

    @Test
    public void testMainWithLargeNumbers() {
        String input = "1000000 2000000\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        ConsoleInput.main(new String[]{});

        String output = testOut.toString();
        assertTrue(output.contains("Сумма = 3000000"));
    }
}
