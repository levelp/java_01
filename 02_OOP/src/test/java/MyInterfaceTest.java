import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class for MyInterface
 */
public class MyInterfaceTest {

    @Test
    public void testInterfaceExists() {
        assertNotNull(MyInterface.class);
    }

    @Test
    public void testIsInterface() {
        assertTrue(MyInterface.class.isInterface());
    }

    @Test
    public void testHasMethodA() throws NoSuchMethodException {
        assertNotNull(MyInterface.class.getMethod("a"));
    }

    @Test
    public void testMethodAReturnsVoid() throws NoSuchMethodException {
        assertEquals(void.class, MyInterface.class.getMethod("a").getReturnType());
    }

    @Test
    public void testMethodAIsPublic() throws NoSuchMethodException {
        assertTrue(java.lang.reflect.Modifier.isPublic(
            MyInterface.class.getMethod("a").getModifiers()));
    }

    @Test
    public void testMethodAIsAbstract() throws NoSuchMethodException {
        assertTrue(java.lang.reflect.Modifier.isAbstract(
            MyInterface.class.getMethod("a").getModifiers()));
    }

    @Test
    public void testInterfaceIsPublic() {
        assertTrue(java.lang.reflect.Modifier.isPublic(MyInterface.class.getModifiers()));
    }

    @Test
    public void testImplementationWorks() {
        MyInterface impl = new MyInterfaceImplementation();
        assertNotNull(impl);
        impl.a(); // Should not throw
    }

    @Test
    public void testPolymorphism() {
        MyInterface impl = new MyInterfaceImplementation();
        assertTrue(impl instanceof MyInterface);
    }

    @Test
    public void testMethodCount() {
        // Interface should have exactly 1 declared method
        assertEquals(1, MyInterface.class.getDeclaredMethods().length);
    }
}
