package encapsula;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class for SquareArea
 */
public class SquareAreaTest {

    @Test
    public void testSquareAreaCreation() {
        SquareArea square = new SquareArea();
        assertNotNull(square);
    }

    @Test
    public void testDefaultAreaIsZero() {
        SquareArea square = new SquareArea();
        assertEquals(0.0, square.area, 0.0001);
    }

    @Test
    public void testSetArea() {
        SquareArea square = new SquareArea();
        square.area = 25.0;
        assertEquals(25.0, square.area, 0.0001);
    }

    @Test
    public void testSetAreaNegative() {
        SquareArea square = new SquareArea();
        square.area = -10.0;
        assertEquals(-10.0, square.area, 0.0001);
    }

    @Test
    public void testSetAreaLarge() {
        SquareArea square = new SquareArea();
        square.area = 1000000.0;
        assertEquals(1000000.0, square.area, 0.0001);
    }

    @Test
    public void testSetAreaSmall() {
        SquareArea square = new SquareArea();
        square.area = 0.0001;
        assertEquals(0.0001, square.area, 0.00001);
    }

    @Test
    public void testMultipleInstances() {
        SquareArea s1 = new SquareArea();
        SquareArea s2 = new SquareArea();
        s1.area = 100.0;
        s2.area = 200.0;
        assertNotEquals(s1.area, s2.area, 0.0001);
    }

    @Test
    public void testClassIsPublic() {
        assertTrue(java.lang.reflect.Modifier.isPublic(SquareArea.class.getModifiers()));
    }

    @Test
    public void testAreaFieldExists() throws NoSuchFieldException {
        assertNotNull(SquareArea.class.getField("area"));
    }

    @Test
    public void testAreaFieldIsPublic() throws NoSuchFieldException {
        assertTrue(java.lang.reflect.Modifier.isPublic(
            SquareArea.class.getField("area").getModifiers()));
    }
}
