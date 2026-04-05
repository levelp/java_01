package p01_datatypes;

/**
 * Инкремент и декремент
 */
public class F_IncDec {

    public static void main(String[] args) {
        int i = 0;
        i++;
        ++i;
        int j = i++;
        System.out.println("i = " + i);
        System.out.println("j = " + j);

        int a = 2;

        ++a; // Префиксная форма инкремента
        a++; // Постфиксная

        System.out.println("a = " + a);
    }
}
