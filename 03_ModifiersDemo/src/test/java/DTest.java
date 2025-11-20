import mypackage.A;
import org.junit.Test;

import static org.junit.Assert.*;

public class DTest {

    @Test
    public void testDConstruction() {
        D d = new D();
        assertNotNull(d);
    }

    @Test
    public void testDExtendsA() {
        D d = new D();
        assertTrue(d instanceof A);
    }

    @Test
    public void testDMdMethod() {
        D d = new D();
        d.md();
        // md() doesn't do anything since packageField is not accessible
    }

    @Test
    public void testDCanAccessPublicField() {
        D d = new D();
        d.publicField = 500;
        assertEquals(500, d.publicField);
    }

    @Test
    public void testDCanAccessProtectedField() {
        D d = new D();
        d.protectedField = 300;
        assertEquals(300, d.protectedField);
    }

    @Test
    public void testDCanCallMa() {
        D d = new D();
        d.ma(); // Inherited from A
        // Note: packageField is not accessible from D since it's in a different package
    }

    @Test
    public void testDInitialPublicField() {
        D d = new D();
        assertEquals(4, d.publicField);
    }

    @Test
    public void testDInitialProtectedField() {
        D d = new D();
        assertEquals(2, d.protectedField);
    }
}
