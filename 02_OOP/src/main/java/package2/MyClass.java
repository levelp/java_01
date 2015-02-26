package package2;

/**
 * Объявление моего класса
 */
public class MyClass {
    /**
     * Только внутри класса и его наследников
     */
    protected int protectedField;

    int field1;
    char field2;
    private int privateField;

    void myMethod(int arg1, int arg2, double arg3) {
        // ...
    }

    public void publicMethod() {
        privateField = 11;
        protectedField = 20;
        System.out.println("publicMethod()");
    }
}
