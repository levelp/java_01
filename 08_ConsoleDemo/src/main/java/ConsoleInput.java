import java.util.Scanner;

// Ввод с клавиатуры и вывод на экран
// ----------------------------------
public class ConsoleInput {

    public static void main(String[] args) {
        // Для ввода с клавиатуры используем
        // класс **Scanner**
        // System.in - стандартный поток ввода
        // с клавиатуры
        //-->
        Scanner s = new Scanner(System.in);
        // Два числа с клавиатуры
        int a = s.nextInt();
        int b = s.nextInt();
        // Считаем их сумму
        int sum = a + b;
        System.out.println("Сумма = " + sum);
        //<--
    }
}
