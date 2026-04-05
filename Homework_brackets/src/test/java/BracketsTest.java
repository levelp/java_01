import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class BracketsTest extends Assert {
    @Test
    public void test1() {
        Brackets brackets = new Brackets(1);
        List<String> results = brackets.gen();
        assertEquals(1, results.size());
        assertEquals("()", results.get(0));
    }

    @Test
    public void test2() {
        Brackets brackets = new Brackets(2);
        ArrayList<String> results = brackets.gen();
        assertEquals(2, results.size());
        assertEquals("(())", results.get(0));
        assertEquals("()()", results.get(1));
    }

    @Test
    public void test3() {
        Brackets brackets = new Brackets(3);
        ArrayList<String> results = brackets.gen();
        assertEquals(5, results.size());
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

    // Additional edge case tests for 100% coverage

    /**
     * Test with N = 0 (no brackets)
     */
    @Test
    public void test0() {
        Brackets brackets = new Brackets(0);
        ArrayList<String> results = brackets.gen();
        assertEquals(1, results.size());
        assertEquals("", results.get(0));
    }

    /**
     * Test with N = 5
     */
    @Test
    public void test5() {
        Brackets brackets = new Brackets(5);
        ArrayList<String> results = brackets.gen();
        // Catalan number C(5) = 42
        assertEquals(42, results.size());
    }

    /**
     * Test with N = 6
     */
    @Test
    public void test6() {
        Brackets brackets = new Brackets(6);
        ArrayList<String> results = brackets.gen();
        // Catalan number C(6) = 132
        assertEquals(132, results.size());
    }

    /**
     * Test that all generated sequences are valid
     */
    @Test
    public void testAllSequencesValid() {
        Brackets brackets = new Brackets(3);
        ArrayList<String> results = brackets.gen();

        for (String seq : results) {
            assertTrue("Sequence should be valid: " + seq, isValidBracketSequence(seq));
        }
    }

    /**
     * Test that all sequences have correct length
     */
    @Test
    public void testSequenceLengths() {
        int n = 4;
        Brackets brackets = new Brackets(n);
        ArrayList<String> results = brackets.gen();

        for (String seq : results) {
            assertEquals("Sequence should have length 2*N", 2 * n, seq.length());
        }
    }

    /**
     * Test that sequences are unique
     */
    @Test
    public void testSequencesUnique() {
        Brackets brackets = new Brackets(4);
        ArrayList<String> results = brackets.gen();

        java.util.Set<String> uniqueResults = new java.util.HashSet<>(results);
        assertEquals("All sequences should be unique", results.size(), uniqueResults.size());
    }

    /**
     * Test that first sequence is most nested
     */
    @Test
    public void testFirstSequenceMostNested() {
        Brackets brackets = new Brackets(4);
        ArrayList<String> results = brackets.gen();
        assertEquals("(((())))", results.get(0));
    }

    /**
     * Test that last sequence is least nested
     */
    @Test
    public void testLastSequenceLeastNested() {
        Brackets brackets = new Brackets(4);
        ArrayList<String> results = brackets.gen();
        assertEquals("()()()()", results.get(results.size() - 1));
    }

    /**
     * Test with large N value
     */
    @Test
    public void test7() {
        Brackets brackets = new Brackets(7);
        ArrayList<String> results = brackets.gen();
        // Catalan number C(7) = 429
        assertEquals(429, results.size());
    }

    /**
     * Test constructor stores N correctly
     */
    @Test
    public void testConstructorStoresN() {
        Brackets brackets = new Brackets(5);
        // gen() should produce sequences of length 2*5 = 10
        ArrayList<String> results = brackets.gen();
        for (String seq : results) {
            assertEquals(10, seq.length());
        }
    }

    /**
     * Test multiple calls to gen() return consistent results
     */
    @Test
    public void testMultipleGenCalls() {
        Brackets brackets = new Brackets(3);
        ArrayList<String> results1 = brackets.gen();
        ArrayList<String> results2 = brackets.gen();

        assertEquals(results1.size(), results2.size());
        for (int i = 0; i < results1.size(); i++) {
            assertEquals(results1.get(i), results2.get(i));
        }
    }

    /**
     * Test sequences contain only parentheses
     */
    @Test
    public void testSequencesContainOnlyParentheses() {
        Brackets brackets = new Brackets(4);
        ArrayList<String> results = brackets.gen();

        for (String seq : results) {
            assertTrue("Sequence should only contain ( and )",
                       seq.matches("[()]*"));
        }
    }

    // Helper method to validate bracket sequences
    private boolean isValidBracketSequence(String seq) {
        int balance = 0;
        for (char c : seq.toCharArray()) {
            if (c == '(') {
                balance++;
            } else if (c == ')') {
                balance--;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }
}
