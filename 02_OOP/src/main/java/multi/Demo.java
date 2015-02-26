package multi;

/**
 *
 */
public class Demo {

    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        b.a = 1;
        b.b = 2;

        C c = new C();
        c.m1();
        c.m2();

        I i1 = c;
        i1.m1();

        I2 i2 = c;
        i2.m2();

        //AbstractClass
    }
}
