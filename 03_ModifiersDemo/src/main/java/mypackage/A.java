package mypackage;

/**
 *
 */
public class A {
    // Доступно везде
    public int publicField = 4;
    // Внутри класса A и во всех наследниках
    protected int protectedField = 2;
    // Внутри класса A
    // во всех классах внутри этого пакета
    int packageField = 3;
    // Только внутри класса A
    private int privateField = 1;

    public void ma() {
        privateField = 2130;
        packageField = 11;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
