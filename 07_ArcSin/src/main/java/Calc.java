import static java.lang.Math.pow;

/**
 * Вычисления
 */
public class Calc {

    /**
     * Точность вычислений
     */
    public static final double EPS = 1e-10;

    public static double fact(int num) {
        double res = (num == 0) ? 1 : num * fact(num - 1);
        if (Double.isNaN(res) || Double.isInfinite(res))
            throw new ArithmeticException("Переполнение: " + num);
        return res;
    }

    /**
     * Вычисление арксинуса через разложение в ряд
     *
     * @param x   аргумент
     * @param kol количество членов ряда
     * @return результат - значение арксинуса
     */
    public static double riad(double x, int kol) {
        double fan = 0;
        double arg1;
        double arg2;
        double arg3;

        for (int n = 0; n <= kol; n++) {
            arg1 = fact(2 * n);
            arg2 = pow(4, n) * pow(fact(n), 2) * (2 * n + 1);
            arg3 = pow(x, 2 * n + 1);
            fan += (arg1 / arg2) * arg3;
        }
        return fan;
    }

    /**
     * Вычисление арксинуса через разложение в ряд
     * Оптимизированная по точности версия
     *
     * @param x аргумент
     * @return результат - значение арксинуса
     */
    public static double arcSin(double x) {
        double t = x; // Очередной член ряда (основная часть)
        double add = t; // Член ряда целиком
        double sum = add; // Результат (сумма ряда)

        // Если слишком маленькие изменения => выходим
        for (long n = 1; add >= EPS; n++) {
            double arg1 = (2 * n - 1) * (2 * n); // Факториал
            double arg2 = 4.0 * pow(n, 2);
            double arg3 = pow(x, 2);
            // Получаем новый член ряда из предыдущего
            t *= (arg1 * arg3) / arg2;
            // Добавляем к ряду
            add = t / (2 * n + 1);
            sum += add;
        }
        return sum;
    }

    public static double riad(double x) {
        return riad(x, 80);
    }
}
