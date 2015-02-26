package p01_datatypes;

/**
 * Вывод таблицы умножения на экран
 */
public class G_MulTable {

    public static void main(String[] args) {
        for (int i = 1; i < 13; i++) {
            for (int j = 1; j < 13; j++) {
                System.out.printf("%4d", i * j);
            }
            System.out.println();
        }
    }
}
