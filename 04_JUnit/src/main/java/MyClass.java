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
        return (n == 0) ? 1 : n * fact(n - 1);
    }
}
