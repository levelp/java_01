package p01_datatypes;

import static java.lang.Math.abs;
import static java.lang.System.out;

public class C2_FloatAccuracy {

    /**
     * Тесты
     */
    public static void main(String[] args) {
        sumDouble(0.4, 0.7, 1.1);
        sumDouble(0.5, 0.7, 1.2);
        sumFloat(0.5f, 0.7f, 1.2f);
        sumDouble(.6, 0.7, 1.3);
        sumFloat(0.6f, 0.7f, 1.3f);
        out.println("Но не думайте что float без потери точности...");
        sumFloat(0.9f, 0.7f, 1.6f);
    }

    // Проверяем что a+b = c в double
    static void sumDouble(double a,
                          double b,
                          double c) {
        if (a + b == c) {
            out.printf("YES ;)  %s + %s == %s - double", a, b, c);
        } else {
            double diff = a + b - c; // Разница
            out.printf("NO :( %s + %s != %s (разница: %s) - double", a, b, c, diff);
        }
        out.println("  equals(a+b,c) -> " + equals(a + b, c));
    }

    // Обработка погрешности
    static boolean equals(double a, double b) {
        return abs(a - b) < 1e-6; // Разность меньше EPS
    }

    // Проверяем что a+b = c в float
    static void sumFloat(float a, float b, float c) {
        if (a + b == c) {
            out.printf("YES ;)  %s + %s == %s - float", a, b, c);
        } else {
            float diff = a + b - c; // Разница
            out.printf("NO :( %s + %s != %s (разница: %s) - float", a, b, c, diff);
        }
        out.println("  equals(a+b,c) -> " + equals(a + b, c));
    }
}
