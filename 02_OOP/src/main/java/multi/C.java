package multi;

/**
 *
 */
public class C extends A implements I, I2 {

    @Override
    public void m1() {
        System.out.println("C.m1");
    }

    @Override
    public void m2() {
        System.out.println("C.m2");
    }
}
