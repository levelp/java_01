import mypackage.A;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

/**
 * Comprehensive test class for Main
 * Tests the main method and its behavior
 */
public class MainTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    /**
     * Test that main method executes without throwing exception
     */
    @Test
    public void testMainMethodExecution() {
        try {
            Main.main(new String[]{});
        } catch (Exception e) {
            fail("main() method should execute without throwing exception: " + e.getMessage());
        }
    }

    /**
     * Test main method with null arguments
     */
    @Test
    public void testMainMethodWithNullArgs() {
        try {
            Main.main(null);
        } catch (NullPointerException e) {
            // This is expected if main tries to use args
            // If it doesn't use args, it should pass
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    /**
     * Test main method with empty string array
     */
    @Test
    public void testMainMethodWithEmptyArgs() {
        try {
            String[] args = new String[]{};
            Main.main(args);
        } catch (Exception e) {
            fail("main() should handle empty args array: " + e.getMessage());
        }
    }

    /**
     * Test main method with various arguments
     */
    @Test
    public void testMainMethodWithArgs() {
        try {
            String[] args = new String[]{"arg1", "arg2", "arg3"};
            Main.main(args);
        } catch (Exception e) {
            fail("main() should handle args array: " + e.getMessage());
        }
    }

    /**
     * Test that main method creates an instance of A
     */
    @Test
    public void testMainCreatesAInstance() {
        // We can't directly test the instance creation in main,
        // but we can verify the code pattern works
        A a = new A();
        a.publicField = 1000;
        assertEquals("publicField should be modifiable to 1000",
                     1000, a.publicField);
    }

    /**
     * Test the behavior demonstrated in main method
     */
    @Test
    public void testPublicFieldModification() {
        A a = new A();
        assertEquals("Initial publicField value should be 4", 4, a.publicField);
        a.publicField = 1000;
        assertEquals("publicField should be modifiable to 1000",
                     1000, a.publicField);
    }

    /**
     * Test multiple calls to main method
     */
    @Test
    public void testMultipleMainCalls() {
        try {
            Main.main(new String[]{});
            Main.main(new String[]{});
            Main.main(new String[]{});
        } catch (Exception e) {
            fail("Multiple calls to main() should not cause exceptions");
        }
    }

    /**
     * Test that A instance in main has correct default value before modification
     */
    @Test
    public void testAInstanceDefaultValue() {
        A a = new A();
        assertEquals("A instance should have default publicField value of 4",
                     4, a.publicField);
    }

    /**
     * Test A instantiation as done in main
     */
    @Test
    public void testAInstantiation() {
        A a = new A();
        assertNotNull("A instance should not be null", a);
    }

    /**
     * Test field modification range
     */
    @Test
    public void testFieldModificationRange() {
        A a = new A();
        a.publicField = Integer.MAX_VALUE;
        assertEquals("publicField should handle MAX_VALUE",
                     Integer.MAX_VALUE, a.publicField);

        a.publicField = Integer.MIN_VALUE;
        assertEquals("publicField should handle MIN_VALUE",
                     Integer.MIN_VALUE, a.publicField);

        a.publicField = 0;
        assertEquals("publicField should handle 0", 0, a.publicField);
    }

    /**
     * Test that main method doesn't produce errors
     */
    @Test
    public void testMainMethodNoErrors() {
        Main.main(new String[]{});
        assertEquals("main() should not produce error output",
                     "", errContent.toString());
    }

    /**
     * Test sequential field modifications
     */
    @Test
    public void testSequentialFieldModifications() {
        A a = new A();
        a.publicField = 100;
        assertEquals(100, a.publicField);
        a.publicField = 200;
        assertEquals(200, a.publicField);
        a.publicField = 1000;
        assertEquals(1000, a.publicField);
    }

    /**
     * Test multiple A instances independence
     */
    @Test
    public void testMultipleAInstances() {
        A a1 = new A();
        A a2 = new A();

        a1.publicField = 1000;
        a2.publicField = 2000;

        assertEquals("a1.publicField should be 1000", 1000, a1.publicField);
        assertEquals("a2.publicField should be 2000", 2000, a2.publicField);
    }

    /**
     * Test negative values for publicField
     */
    @Test
    public void testNegativeFieldValues() {
        A a = new A();
        a.publicField = -1000;
        assertEquals("publicField should handle negative values",
                     -1000, a.publicField);
    }

    /**
     * Test zero value for publicField
     */
    @Test
    public void testZeroFieldValue() {
        A a = new A();
        a.publicField = 0;
        assertEquals("publicField should handle zero", 0, a.publicField);
    }

    /**
     * Test that main class can be instantiated (though not typical)
     */
    @Test
    public void testMainClassInstantiation() {
        Main main = new Main();
        assertNotNull("Main instance should not be null", main);
    }
}
