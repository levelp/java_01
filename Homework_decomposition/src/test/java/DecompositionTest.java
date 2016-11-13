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
    public void test3() {
        Decomposition t = new Decomposition(3);
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));
        t.gen();
        assertEquals("3 = 3\r\n3 = 2 + 1\r\n3 = 1 + 1 + 1\r\n", os.toString());
    }

    @Test
    public void test4() {
        Decomposition t = new Decomposition(4);
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));
        t.gen();
        assertEquals("4 = 4\r\n4 = 3 + 1\r\n" +
                "4 = 2 + 2\r\n4 = 2 + 1 + 1\r\n" +
                "4 = 1 + 1 + 1 + 1\r\n", os.toString());
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
}
