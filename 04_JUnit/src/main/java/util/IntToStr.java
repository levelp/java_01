package util;

/**
 * Число в строку
 */
public class IntToStr {
    /**
     * Числа от 1 до 19
     */
    static final String[] digits = {
            "", "один", "два", "три",
            "четыре", "пять", "шесть", "семь",
            "восемь", "девять", "десять",
            "одиннадцать", "двенадцать",
            "тринадцать", "четырнадцать",
            "пятнадцать", "шестнадцать", "семьнадцать",
            "восемьнадцать", "девятьнадцать",
    };
    /**
     * Десятки
     */
    static final String[] decs = {
            "", "", "двадцать", "тридцать",
            "сорок", "пятьдесят", "шестьдесят",
            "семьдесят", "восемьдесят",
            "девяносто"
    };
    static final String hundreds[] = {
            "", "сто", "двести", "триста", "четыреста", "пятьсот",
            "шестьсот", "семьсот", "восемьсот", "девятьсот",
    };
    static final String[] digitsFemale;

    // Статический конструктор
    //-->
    static {
        // ... действия по инициализации класса
        //  в общем...
        calls = 0; // Инициализация статической
        // переменной

        // Числительные в женском роде
        digitsFemale = digits.clone();
        digitsFemale[1] = "одна";
        digitsFemale[2] = "две";
    }
    //<--

    static String thousands[] = {"тысяч", "тысяча", "тысячи"};
    static String millions[] = {"миллионов", "миллион", "миллиона"};
    static String milliards[] = {"миллиардов", "миллиард", "миллиарда"};

    static int calls;
    private static int n;
    final String result;

    StringBuffer res = new StringBuffer();

    long N;

    //-->
    public IntToStr(long n) {
        N = n;
        if (N == 0)
            res.append("ноль");

        addClass(1000000000, milliards);
        addClass(1000000, millions);
        addClass(1000, thousands);
        addClass(1, null);

        // Убираем начальные и конечные пробелы
        String r = res.toString().trim();
        // Делаем первую букву большой
        result = r.substring(0, 1).toUpperCase() + r.substring(1);
    }

    // Число в строку
    public static String intToStr(long N) {
        return new IntToStr(N).result;
    }

    // Форма числительного в зависимости от числа
    private static int numForm(int t) {
        if (t == 1)
            return 1;
        if (t >= 2 && t <= 4)
            return 2;
        return 0;
    }

    private void addClass(long base, String[] names) {
        if (N >= base) {
            add(100 * base, 100 * base, hundreds); // Сотни
            add(10 * base, 20 * base, decs); // Десятки
            // Единицы
            int t = (int) (N / base);
            add(base, base, base == 1000 ? digitsFemale : digits);
            if (names != null)
                res.append(" ").append(names[numForm(t)]);
        }
    }

    void add(long tens, long fromN, String[] names) {
        if (N >= fromN) {
            int h = (int) (N / tens);
            res.append(" ").append(names[h]);
            N -= h * tens;
        }
    }
    //<--
}

