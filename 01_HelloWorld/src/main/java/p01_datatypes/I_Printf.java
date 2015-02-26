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
        System.out.printf("%d%n", i);
        // 3 символа на каждое число
        System.out.printf("%3d\n", i);

        for (int x = 1; x < 10; x++) {
            for (int y = 1; y < 10; y++) {
                String s = String.format(" %3d", x * y);
                System.out.printf(s);
            }
            System.out.println();
        }
        System.out.println("%n TTH %n");

        // В шестнадцатеричном виде
        System.out.printf("%x\n", 2014);

        System.out.printf("%X\n", 2014);
        System.out.printf("%04X\n", 2014);

        // Перевод
        // Действительные числа
        float f = 1.1f;
        System.out.printf("%.2f%n", f);

        double d = 1.1;
        System.out.printf("%-10.3f%n", d);

        //
        System.out.printf("%e%n", d);

    }
}
