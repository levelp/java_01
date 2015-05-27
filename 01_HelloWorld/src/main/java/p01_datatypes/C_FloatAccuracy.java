package p01_datatypes;

// Точность вычислений в действительных числах
// -------------------------------------------
public class C_FloatAccuracy {

    public static void main(String[] args) {
        //-->
        double a = 0.3;
        double b = 0.6;
        double c = 0.9;
        // Корректная проверка что a + b == c
        if  (Math.abs(a + b - c) < 1e-15) {
            System.out.println("Равно");
        } else {
            System.out.println("Не равно!");
            System.out.println("c - (a+b) = " +
                    (c - (a + b)));
        }
        //<--
    }
}
