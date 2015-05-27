/**
 * Класс для тестирования
 */
public class MyClass {
    /**
     * Факториал
     *
     * @param n целое число - аргумент функции
     * @return факториал
     */
    public static long fact(int n) {
        // (Условие) ? Значение_если_истина :
        //                Значение_если_ложь
        return (n == 0) ? 1 : n * fact(n - 1);
    }
}
