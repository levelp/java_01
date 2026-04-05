package multi;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Comprehensive test class for multi.Demo and its nested classes
 */
public class DemoTest {

    private ByteArrayOutputStream outputStream;
    private PrintStream originalOut;

    @Before
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void testClassAConstructor() {
        Demo.A a = new Demo.A();
        assertNotNull("A instance should not be null", a);
    }

    @Test
    public void testClassAFieldDefault() {
        Demo.A a = new Demo.A();
        assertEquals("Field a should default to 1", 1, a.a);
    }

    @Test
    public void testClassAGetA() {
        Demo.A a = new Demo.A();
        assertEquals("getA() should return 1", 1, a.getA());
    }

    @Test
    public void testClassASetField() {
        Demo.A a = new Demo.A();
        a.a = 10;
        assertEquals("Field a should be 10", 10, a.a);
        assertEquals("getA() should return 10", 10, a.getA());
    }

    @Test
    public void testClassBConstructor() {
        Demo.B b = new Demo.B();
        assertNotNull("B instance should not be null", b);
    }

    @Test
    public void testClassBInheritsFromA() {
        Demo.B b = new Demo.B();
        assertTrue("B should be instance of A", b instanceof Demo.A);
    }

    @Test
    public void testClassBFieldA() {
        Demo.B b = new Demo.B();
        assertEquals("B's field a should be 2", 2, b.a);
    }

    @Test
    public void testClassBInheritedGetA() {
        Demo.B b = new Demo.B();
        // getA() is inherited from A and accesses A's field a which is 1
        assertEquals("B's getA() should return 1 (from inherited field)",
                    1, b.getA());
    }

    @Test
    public void testClassBFieldB() {
        Demo.B b = new Demo.B();
        b.b = 20;
        assertEquals("Field b should be 20", 20, b.b);
    }

    @Test
    public void testClassCConstructor() {
        Demo.C c = new Demo.C();
        assertNotNull("C instance should not be null", c);
    }

    @Test
    public void testClassCImplementsI1() {
        Demo.C c = new Demo.C();
        assertTrue("C should implement I1", c instanceof Demo.I1);
    }

    @Test
    public void testClassCImplementsI2() {
        Demo.C c = new Demo.C();
        assertTrue("C should implement I2", c instanceof Demo.I2);
    }

    @Test
    public void testClassCExtendsA() {
        Demo.C c = new Demo.C();
        assertTrue("C should extend A", c instanceof Demo.A);
    }

    @Test
    public void testClassCM1Method() {
        Demo.C c = new Demo.C();
        outputStream.reset();
        c.m1();
        String output = outputStream.toString().trim();
        assertEquals("m1() should print 'C.m1'", "C.m1", output);
    }

    @Test
    public void testClassCM2Method() {
        Demo.C c = new Demo.C();
        outputStream.reset();
        c.m2();
        String output = outputStream.toString().trim();
        assertEquals("m2() should print 'C.m2'", "C.m2", output);
    }

    @Test
    public void testI1InterfaceReference() {
        Demo.C c = new Demo.C();
        Demo.I1 i1 = c;
        outputStream.reset();
        i1.m1();
        String output = outputStream.toString().trim();
        assertEquals("I1 reference should call C.m1()", "C.m1", output);
    }

    @Test
    public void testI2InterfaceReference() {
        Demo.C c = new Demo.C();
        Demo.I2 i2 = c;
        outputStream.reset();
        i2.m1();
        String output = outputStream.toString().trim();
        assertEquals("I2 reference should call C.m1()", "C.m1", output);
    }

    @Test
    public void testI2DefaultMethod() {
        Demo.C c = new Demo.C();
        Demo.I2 i2 = c;
        outputStream.reset();
        i2.m2();
        String output = outputStream.toString().trim();
        // C overrides m2(), so it should print "C.m2"
        assertEquals("I2.m2() should be overridden by C", "C.m2", output);
    }

    @Test
    public void testMainMethod() {
        outputStream.reset();
        Demo.main(new String[]{});
        String output = outputStream.toString();

        assertTrue("Output should contain 'b.a ='", output.contains("b.a ="));
        assertTrue("Output should contain 'b.getA() ='", output.contains("b.getA() ="));
        assertTrue("Output should contain 'C.m1'", output.contains("C.m1"));
        assertTrue("Output should contain 'C.m2'", output.contains("C.m2"));
    }

    @Test
    public void testMultipleInheritanceViaInterfaces() {
        Demo.C c = new Demo.C();

        // C implements both I1 and I2
        Demo.I1 asI1 = c;
        Demo.I2 asI2 = c;
        Demo.A asA = c;

        assertNotNull("C as I1 should not be null", asI1);
        assertNotNull("C as I2 should not be null", asI2);
        assertNotNull("C as A should not be null", asA);
    }

    @Test
    public void testPolymorphismWithClassB() {
        Demo.A a = new Demo.B();
        assertEquals("Polymorphic reference should access A's field",
                    1, a.a);
        assertEquals("Polymorphic getA() should return 1",
                    1, a.getA());
    }

    @Test
    public void testClassBFieldShadowing() {
        Demo.B b = new Demo.B();
        // B has its own field 'a' which shadows A's field 'a'
        assertEquals("B's field a should be 2", 2, b.a);

        // But when accessed as A, we see A's field
        Demo.A aRef = b;
        assertEquals("A reference should see A's field a = 1", 1, aRef.a);
    }

    @Test
    public void testClassCInheritsFieldA() {
        Demo.C c = new Demo.C();
        assertEquals("C should inherit field a = 1 from A", 1, c.a);
    }

    @Test
    public void testInterfaceI1HasOnlyM1() throws Exception {
        // Check that I1 has the m1 method
        assertEquals("I1 should have exactly 1 method",
                    1, Demo.I1.class.getDeclaredMethods().length);
    }

    @Test
    public void testInterfaceI2HasM1AndM2() throws Exception {
        // I2 has m1 (abstract) and m2 (default)
        int methodCount = Demo.I2.class.getDeclaredMethods().length;
        assertTrue("I2 should have at least 2 methods", methodCount >= 2);
    }

    public void tearDown() {
        System.setOut(originalOut);
    }
}
