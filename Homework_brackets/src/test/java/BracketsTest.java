import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class BracketsTest extends Assert {
    @Test
    public void test1() {
        Brackets brackets = new Brackets(1);
        ArrayList<String> results = brackets.gen();
        assertEquals("()", results.get(0));
    }

    @Test
    public void test2() {
        Brackets brackets = new Brackets(2);
        ArrayList<String> results = brackets.gen();
        assertEquals("(())", results.get(0));
        assertEquals("()()", results.get(1));
    }

    @Test
    public void test3() {
        Brackets brackets = new Brackets(3);
        ArrayList<String> results = brackets.gen();
        assertEquals("((()))", results.get(0));
        assertEquals("(()())", results.get(1));
        assertEquals("(())()", results.get(2));
        assertEquals("()(())", results.get(3));
        assertEquals("()()()", results.get(4));
    }

    @Test
    public void test4() {
        Brackets brackets = new Brackets(4);
        for (String res : brackets.gen())
            System.out.println(res);
    }
}
