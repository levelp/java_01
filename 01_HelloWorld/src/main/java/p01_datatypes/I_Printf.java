package p01_datatypes;

/**
 * Описание строк форматирования:
 * http://docs.oracle.com/javase/tutorial/java/data/numberformat.html
 * https://docs.oracle.com/javase/7/docs/api/java/util/Formatter.html
 */
public class I_Printf {

    public static void main(String[] args) {
        // %d - целые числа
        int i = 13;
        // %n - перевод строки соответствующий платформе
        // 13,10 - Windows  CRLF
        // 10 - *nix  LF
        // 13 - MacOS (классических, до перехода на ядро BSD) CR
        System.out.printf("%d%n", i);
        // 3 символа на каждое число
        System.out.printf("%3d\n", i);

        int myIntVar = 10;
        System.out.printf("myIntVar = %d%n", myIntVar);

        for (int x = 1; x < 10; x++) {
            for (int y = 1; y < 10; y++) {
                String s = String.format(" %3d", x * y);
                System.out.printf(s);
            }
            System.out.println();
        }
        System.out.println("%n TTH %n");

        // В шестнадцатеричном виде
        // af3d
        System.out.printf("%x\n", 2014);

        // AF3D
        System.out.printf("%X\n", 2014);
        // 0000FE23
        System.out.printf("%08X\n", 2014);

        // Перевод
        // Действительные числа
        float f = 1.1f;
        System.out.printf("%.2f%n", f); // 1.10

        double d = 15.13221;
        System.out.printf("[%-10.3f]%n", d); // [15.132    ] - 10 символов
        System.out.printf("[%10.3f]%n", d);  // [    15.132] - 10 символов

        // 1.1221E+12
        System.out.printf("%e%n", d);

    }
}
