import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class DecompositionTest extends Assert {
    @Test
    public void test1() {
        Decomposition t = new Decomposition(1);
        assertEquals(1, t.N);
        // Заменяю System.out на свой объект, который будет печатать в строчку
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));
        t.gen();
        assertEquals("1 = 1\r\n", os.toString());
    }

    @Test
    public void test2() {
        Decomposition t = new Decomposition(2);
        assertEquals(2, t.N);
        // Заменяю System.out на свой объект, который будет печатать в строчку
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));
        t.gen();
        assertEquals("2 = 2\r\n2 = 1 + 1\r\n", os.toString());
    }

    @Test
    public void testPrint() {
        Decomposition t = new Decomposition(2);
        // Заменяю System.out на свой объект, который будет печатать в строчку
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));
        int[] A = {1, 1};
        t.print(A, A.length);
        assertEquals("2 = 1 + 1\r\n", os.toString());
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
    public void test5() {
        Decomposition t = new Decomposition(5);
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));
        t.gen();
        assertEquals("5 = 5\r\n" +
                "5 = 4 + 1\r\n" +
                "5 = 3 + 2\r\n" +
                "5 = 3 + 1 + 1\r\n" +
                "5 = 2 + 2 + 1\r\n" +
                "5 = 2 + 1 + 1 + 1\r\n" +
                "5 = 1 + 1 + 1 + 1 + 1\r\n", os.toString());
    }

    @Test
    @Ignore // Тест производительности (слишком долгий)
    public void test100() {
        Decomposition t = new Decomposition(100);
        t.gen();
    }
}
