import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 */
public class InheritanceTest {
    class A {
        public int size = 1;

        public int getSize() {
            System.out.println("A.getSize");
            return size;
        }

        public void setSize(int value) {
            size = value;
        }
    }

    class B extends A {
        public int size = 2;

        public int getSize() {
            System.out.println("B.getSize");
            return size;
        }

        public void setSize(int value) {
            size = value;
        }
    }

    @Test
    public void testInherit() {
        A a = new A();
        a.size = 10;
        assertEquals(10, a.size);
        assertEquals(10, a.getSize());

        A b = new B();
        b.size = 10;
        assertEquals(10, b.size);
        assertEquals(2, b.getSize());

        b.setSize(5);
        assertEquals(5, b.getSize());
    }
}
