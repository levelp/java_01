package p01_datatypes;

import java.util.Scanner;

/**
 * Created by gtee on 28.08.2015.
 */
public class BoolDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int age = scanner.nextInt();
        boolean b = (age >= 18);
        if (b) {
            System.out.println("Я уже взрослый!");
        } else {
            System.out.println("Я ещё ребёнок :)");
        }


    }
}
