package p01_datatypes;

import java.util.Locale;
import java.util.Scanner;

import static java.lang.Math.*;

//
// **Решение квадратного уравнения**
//
public class Z_SquareEq {
    public static void main(String args[]) {
        Locale.setDefault(Locale.US);
        // Считываем коэффициенты с клавиатуры
        //-->
        double a, b, c;
        Scanner s = new Scanner(System.in);
        System.out.println("== Решение квадратного уравнения ==");
        System.out.println("Введите коэффициенты");
        System.out.print("a = ");
        a = s.nextDouble();
        System.out.print("b = ");
        b = s.nextDouble();
        System.out.print("c = ");
        c = s.nextDouble();
        //<--

        // Вычисляем дискриминант:
        // double D = b * b - 4 * a * c;
        //-->
        double D = pow(b, 2) - 4 * a * c; // pow - power
        //<--
        System.out.println("Дискриминант = " + D);

        // Теперь проверяем знак дискриминанта
        //-->
        if (abs(D) < 1e-16) {
            double x = -b / (2 * a);
            System.out.println("x = " + x);
            return;
        }
        if (D < 0.0) {
            System.out.println("Решений нет!");
        } else {
            double x1 = (-b + sqrt(D)) / (2 * a);
            double x2 = (-b - sqrt(D)) / (2 * a);
            System.out.println("x1 = " + x1 + "   x2 = " + x2);
        }
        //<--
    }
}