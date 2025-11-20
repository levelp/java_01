import org.junit.Test;

import static org.junit.Assert.*;

public class MyErrorTest {

    @Test
    public void testMyErrorInstantiation() {
        MyError error = new MyError();
        assertNotNull(error);
        assertTrue(error instanceof Error);
    }

    @Test
    public void testMyErrorExtendsError() {
        MyError error = new MyError();
        // Verify it extends Error
        assertTrue(error instanceof Error);
        assertTrue(error instanceof Throwable);
    }

    @Test
    public void testMyErrorCanBeThrown() {
        try {
            throw new MyError();
        } catch (MyError e) {
            // Successfully caught
            assertNotNull(e);
        }
    }
}
