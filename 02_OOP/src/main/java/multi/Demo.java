package multi;

/**
 *
 */
public class Demo {
    static public class A {
        public int a = 1;

        public int getA() {
            return a;
        }
    }

    // B - наследник A
    static public class B extends A {
        public int a = 2;
        public int b;
    }

    // Первый интерфейс
    //-->
    public interface I1 {
        void m1();
    }
    //<--

    //   A
    //  / \
    //  B C
    //  \ /
    //   D
    public interface I2 {
        void m1();

        default void m2(){
            System.out.println("Default implementation");
        }
    }

    static public class C extends A implements I1, I2 {
        @Override
        public void m1() {
            System.out.println("C.m1");
        }

        @Override
        public void m2() {
            System.out.println("C.m2");
        }
    }

    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        System.out.println("b.a = " + b.a);
        System.out.println("b.getA() = " + b.getA());
        b.a = 1;
        b.b = 2;

        C c = new C();
        c.m1();
        c.m2();

        I1 i1 = c;
        i1.m1();

        I2 i2 = c;
        i2.m1();
        i2.m2();

        //AbstractClass
    }
}
