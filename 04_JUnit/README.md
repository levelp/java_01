<!-- doc.py -->
﻿Модульное тестирование в JUnit
------------------------------

Сейчас ипользуется JUnit4.
Раньше JUnit3 и более ранние.

Статический конструктор
``` java
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
```

``` java
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
```

[src/main/java/util/IntToStr.java](src/main/java/util/IntToStr.java)

Регулярные выражения в Idea IDE:
assertEquals\(intToStr\((\d+)\), \(?("[^"]+")\)?\
assertEquals($2, intToStr($1))
* $1 - первый параметр
* $2 - второй параметр и т.д.
[src/test/java/IntToStrTest.java](src/test/java/IntToStrTest.java)

Тесты в JUnit
-------------
Цель: Либо протестировать уже готовый код.

Либо **регрессионное** тестирование:
* Один раз проверили что код работает верно
* Написали тест, который проверяет что код возвращает одни и
те же результаты
* На каждой новой версии продукта запускаем
эти же тесты.

**TDD (Test Driven Development)** -
разработка через тестирование.
Принцип: сначала тест, потом код чтобы тест проходил.
Первый тест
Название метода произвольное для JUnit4
Для предыдущих версий важно чтобы метод начинался
с "test". Поэтому для совместимости чаще
всего называют метод начиная с "test"
и добавляют аннотацию
``` java
    @Test // Аннотация (начиная с JUnit4)
    // указывает что это тест
    public void simplest() {
        // assertEquals(message, expected, actual)
        assertEquals("Дважды два четыре", 4, 2 * 2);
        // Действительные числа сравниваются с погрешностью
        assertEquals("Дважды два четыре", 4.0, 2.0 * 2.0, 1e-15);
        // Сокращённая форма без message
        assertEquals(4, 2 * 2);
        // Конкатенация строк
        assertEquals("test123", "test" + "123");
        // Сравнение массивов
        assertArrayEquals(new byte[]{1, 2, 3}, new byte[]{1, 2, 3});
    }
```

Пример: тестируем вычисление факториала
``` java
    @Test
    public void factorial() {
        assertEquals(1, MyClass.fact(1));
        assertEquals(2, MyClass.fact(2));
        assertEquals(2 * 3, MyClass.fact(3));
        assertEquals(2 * 3 * 4, MyClass.fact(4));
        assertEquals(2 * 3 * 4 * 5, MyClass.fact(5));
        assertEquals(2 * 3 * 4 * 5 * 6, MyClass.fact(6));
        assertEquals(2 * 3 * 4 * 5 * 6 * 7, MyClass.fact(7));
        assertEquals(2 * 3 * 4 * 5 * 6 * 7 * 8, MyClass.fact(8));
        assertEquals(2 * 3 * 4 * 5 * 6 * 7 * 8 * 9, MyClass.fact(9));
        assertEquals(2 * 3 * 4 * 5 * 6 * 7 * 8 * 9 * 10, MyClass.fact(10));
        assertEquals(2 * 3 * 4 * 5 * 6 * 7 * 8 * 9 * 10 * 11, MyClass.fact(11));
    }
```

[src/test/java/MyClassTest.java](src/test/java/MyClassTest.java)

