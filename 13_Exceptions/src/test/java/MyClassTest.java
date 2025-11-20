import org.junit.Test;

import static org.junit.Assert.*;

public class MyClassTest {

    @Test(expected = MyRuntimeException.class)
    public void testMethod1ThrowsMyRuntimeException() throws MyException {
        MyClass myClass = new MyClass();
        myClass.method1(1);
    }

    @Test(expected = MyError.class)
    public void testMethod1ThrowsMyError() throws MyException {
        MyClass myClass = new MyClass();
        myClass.method1(2);
    }

    @Test(expected = MyException.class)
    public void testMethod1ThrowsMyException() throws MyException {
        MyClass myClass = new MyClass();
        myClass.method1(3);
    }

    @Test
    public void testMethod1WithOtherNumbers() throws MyException {
        MyClass myClass = new MyClass();
        // Test with numbers that don't throw exceptions (0, 4, -1, etc.)
        myClass.method1(0);  // Should not throw
        myClass.method1(4);  // Should not throw
        myClass.method1(-1); // Should not throw
    }

    @Test
    public void testMyClassInstantiation() {
        MyClass myClass = new MyClass();
        assertNotNull(myClass);
    }
}
