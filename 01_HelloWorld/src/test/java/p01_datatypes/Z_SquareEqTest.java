package p01_datatypes;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.InputStream;
import java.lang.reflect.Modifier;
import static org.junit.Assert.*;

/**
 * Test class for Z_SquareEq
 */
public class Z_SquareEqTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final InputStream originalIn = System.in;

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
    public void testMainWithTwoRealRoots() {
        String input = "1\n0\n-4\n"; // x^2 - 4 = 0, roots: 2 and -2
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Z_SquareEq.main(new String[]{});
        String output = outContent.toString();

        assertTrue(output.contains("Решение квадратного уравнения"));
        assertTrue(output.contains("x1 ="));
        assertTrue(output.contains("x2 ="));
    }

    @Test
    public void testMainWithNoRealRoots() {
        String input = "1\n0\n4\n"; // x^2 + 4 = 0, no real roots
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Z_SquareEq.main(new String[]{});
        String output = outContent.toString();

        assertTrue(output.contains("Решение квадратного уравнения"));
        assertTrue(output.contains("Решений нет!"));
    }

    @Test
    public void testMainWithOneRoot() {
        String input = "1\n-2\n1\n"; // (x-1)^2 = 0, one root: x=1
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Z_SquareEq.main(new String[]{});
        String output = outContent.toString();

        assertTrue(output.contains("Решение квадратного уравнения"));
        assertTrue(output.contains("x ="));
    }

    @Test
    public void testOutputContainsDiscriminant() {
        String input = "1\n5\n6\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Z_SquareEq.main(new String[]{});
        String output = outContent.toString();

        assertTrue(output.contains("Дискриминант"));
    }

    @Test
    public void testOutputContainsPrompts() {
        String input = "1\n2\n3\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Z_SquareEq.main(new String[]{});
        String output = outContent.toString();

        assertTrue(output.contains("a ="));
        assertTrue(output.contains("b ="));
        assertTrue(output.contains("c ="));
    }

    @Test
    public void testMainMethodExists() throws NoSuchMethodException {
        assertNotNull(Z_SquareEq.class.getMethod("main", String[].class));
    }

    @Test
    public void testClassIsPublic() {
        assertTrue(Modifier.isPublic(Z_SquareEq.class.getModifiers()));
    }

    @Test
    public void testMainMethodIsStatic() throws NoSuchMethodException {
        assertTrue(Modifier.isStatic(
            Z_SquareEq.class.getMethod("main", String[].class).getModifiers()));
    }

    @Test
    public void testMainMethodIsPublic() throws NoSuchMethodException {
        assertTrue(Modifier.isPublic(
            Z_SquareEq.class.getMethod("main", String[].class).getModifiers()));
    }

    @Test
    public void testPackage() {
        assertEquals("p01_datatypes", Z_SquareEq.class.getPackage().getName());
    }
}
