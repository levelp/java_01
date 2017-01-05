package p01_datatypes;

import java.util.Scanner;

///
/// Условный оператор if.. else..
/// -----------------------------
public class B_if_else {

    public static void main(String[] args) {
        //-->
        Scanner scanner = new Scanner(System.in);

        // Читаем целое число с клавиатуры
        int a = scanner.nextInt();

        if (a == 10) {
            System.out.println("a равно 10");
        } else {
            System.out.println("a не равно 10");
        }
        if (a >= 10) {
            System.out.println("a >= 10");
        }
        //<--
    }
}
