package encapsula;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class for SquareSide
 */
public class SquareSideTest {

    @Test
    public void testSquareSideCreation() {
        SquareSide square = new SquareSide();
        assertNotNull(square);
    }

    @Test
    public void testDefaultSideIsZero() {
        SquareSide square = new SquareSide();
        assertEquals(0.0, square.side, 0.0001);
    }

    @Test
    public void testSetSide() {
        SquareSide square = new SquareSide();
        square.side = 5.0;
        assertEquals(5.0, square.side, 0.0001);
    }

    @Test
    public void testSetSideNegative() {
        SquareSide square = new SquareSide();
        square.side = -3.0;
        assertEquals(-3.0, square.side, 0.0001);
    }

    @Test
    public void testSetSideLarge() {
        SquareSide square = new SquareSide();
        square.side = 999999.0;
        assertEquals(999999.0, square.side, 0.0001);
    }

    @Test
    public void testSetSideSmall() {
        SquareSide square = new SquareSide();
        square.side = 0.001;
        assertEquals(0.001, square.side, 0.0001);
    }

    @Test
    public void testMultipleInstances() {
        SquareSide s1 = new SquareSide();
        SquareSide s2 = new SquareSide();
        s1.side = 10.0;
        s2.side = 20.0;
        assertNotEquals(s1.side, s2.side, 0.0001);
    }

    @Test
    public void testClassIsPublic() {
        assertTrue(java.lang.reflect.Modifier.isPublic(SquareSide.class.getModifiers()));
    }

    @Test
    public void testSideFieldExists() throws NoSuchFieldException {
        assertNotNull(SquareSide.class.getField("side"));
    }

    @Test
    public void testSideFieldIsPublic() throws NoSuchFieldException {
        assertTrue(java.lang.reflect.Modifier.isPublic(
            SquareSide.class.getField("side").getModifiers()));
    }
}
