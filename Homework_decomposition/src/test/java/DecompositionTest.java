import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DecompositionTest extends Assert {
    private static String readFile(String path) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, Charset.forName("UTF-8")).trim();
    }

    @Test
    public void test1() {
        Decomposition t = new Decomposition(1);
        assertEquals(1, t.N);
        // Заменяю System.out на свой объект, который будет печатать в строчку
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));
        t.gen();
        assertEquals(String.format("1 = 1%n"), os.toString());
    }

    @Test
    public void test2() {
        Decomposition t = new Decomposition(2);
        assertEquals(2, t.N);
        // Заменяю System.out на свой объект, который будет печатать в строчку
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));
        t.gen();
        assertEquals(String.format("2 = 2%n2 = 1 + 1%n"), os.toString());
    }

    @Test
    public void testPrint() {
        Decomposition t = new Decomposition(2);
        // Заменяю System.out на свой объект, который будет печатать в строчку
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));
        int[] A = {1, 1};
        t.print(A, A.length);
        assertEquals(String.format("2 = 1 + 1%n"), os.toString());
    }

    @Test
    public void test3() throws IOException {
        checkFile(3);
    }

    @Test
    public void test4() throws IOException {
        checkFile(4);
    }

    @Test
    public void test5() throws IOException {
        checkFile(5);
    }

    @Test
    public void test6() throws IOException {
        checkFile(6);
    }

    @Test
    public void test7() throws IOException {
        checkFile(7);
    }

    private void checkFile(int n) throws IOException {
        Decomposition t = new Decomposition(n);
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));
        t.gen();
        assertEquals(readFile(String.format("%02d.a", n)), os.toString().trim());
    }

    @Test
    @Ignore // Тест производительности (слишком долгий)
    public void test40() {
        Decomposition t = new Decomposition(40);
        t.gen();
    }

    // Additional edge case tests for 100% coverage

    /**
     * Test constructor stores N and creates correct sized array
     */
    @Test
    public void testConstructorInitialization() {
        Decomposition t = new Decomposition(5);
        assertEquals(5, t.N);
        assertNotNull(t.A);
        assertEquals(5, t.A.length);
    }

    /**
     * Test print method with single element
     */
    @Test
    public void testPrintSingleElement() {
        Decomposition t = new Decomposition(3);
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));
        int[] A = {3};
        t.print(A, 1);
        assertEquals(String.format("3 = 3%n"), os.toString());
    }

    /**
     * Test print method with three elements
     */
    @Test
    public void testPrintThreeElements() {
        Decomposition t = new Decomposition(4);
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));
        int[] A = {2, 1, 1};
        t.print(A, 3);
        assertEquals(String.format("4 = 2 + 1 + 1%n"), os.toString());
    }

    /**
     * Test print method with all ones
     */
    @Test
    public void testPrintAllOnes() {
        Decomposition t = new Decomposition(4);
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));
        int[] A = {1, 1, 1, 1};
        t.print(A, 4);
        assertEquals(String.format("4 = 1 + 1 + 1 + 1%n"), os.toString());
    }

    /**
     * Test that array is correctly sized for N
     */
    @Test
    public void testArraySize() {
        Decomposition t = new Decomposition(10);
        assertEquals(10, t.A.length);
    }

    /**
     * Test gen method generates correct number of decompositions for N=8
     */
    @Test
    public void test8() throws IOException {
        checkFile(8);
    }

    /**
     * Test gen method generates correct number of decompositions for N=9
     */
    @Test
    public void test9() throws IOException {
        checkFile(9);
    }

    /**
     * Test gen method generates correct number of decompositions for N=10
     */
    @Test
    public void test10() throws IOException {
        checkFile(10);
    }

    /**
     * Test multiple decomposition instances are independent
     */
    @Test
    public void testMultipleInstances() {
        Decomposition t1 = new Decomposition(3);
        Decomposition t2 = new Decomposition(4);

        assertEquals(3, t1.N);
        assertEquals(4, t2.N);
        assertNotSame(t1.A, t2.A);
    }

    /**
     * Test gen can be called multiple times
     */
    @Test
    public void testMultipleGenCalls() {
        Decomposition t = new Decomposition(2);

        ByteArrayOutputStream os1 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os1));
        t.gen();
        String result1 = os1.toString();

        ByteArrayOutputStream os2 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os2));
        t.gen();
        String result2 = os2.toString();

        assertEquals(result1, result2);
    }

    /**
     * Test decomposition contains all expected values
     */
    @Test
    public void testDecompositionContents3() {
        Decomposition t = new Decomposition(3);
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));
        t.gen();

        String output = os.toString();
        assertTrue(output.contains("3 = 3"));
        assertTrue(output.contains("3 = 2 + 1"));
        assertTrue(output.contains("3 = 1 + 1 + 1"));
    }

    /**
     * Test that first decomposition is N itself
     */
    @Test
    public void testFirstDecomposition() {
        Decomposition t = new Decomposition(5);
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));
        t.gen();

        String output = os.toString();
        assertTrue(output.startsWith(String.format("5 = 5%n")));
    }

    /**
     * Test that last decomposition is all ones
     */
    @Test
    public void testLastDecomposition() {
        Decomposition t = new Decomposition(4);
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));
        t.gen();

        String output = os.toString();
        assertTrue(output.endsWith(String.format("4 = 1 + 1 + 1 + 1%n")));
    }
}
