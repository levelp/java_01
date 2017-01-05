<!-- doc.py -->
﻿Виды тестирования: ручное, отладчик (debugger), логи, unit-тесты
----------------------------------------------------------------

Тестирование тем важнее для проекта, чем проект сложнее, чем большее программистов над ним работает и чем больше времени занимает разработка.
Тем не менее и для олимпиадных задач (из-за их сложности и нестандатности) тестирование очень актуально.

Тестирование отнимает много времени на олимпиадах, и часто "почти правильные" решения не получается доделать и сдать из-за сложностей с отладкой.

**Виды тестирования:**

* **Ручное** тестирование. Программист (или тестировщик) вводят в программу исходные данные и
            сравнивают полученный от программы результат с тем что они ожидали получить (т.е. у них есть некоторое
            представление о конечном результате и они сравнивают своё представление с реальными реакциями программы на
            их
            действия).

* **Логгирование** Запись происходящих в программе событий в файл (ведение лог-файлов,
            протоколирование работы программы).  Это единственный доступный способ когда программа работает у конечного
            пользователя.
        </li>

* **Использование отладчика (debugger&rsquo;а)**. Позволяет внимательно проанализировать
            как  работает некоторый небольшой участок кода, выполняя его по шагам (отдельным операторам) и отслеживания
            изменение переменных на каждом шаге.

* **Unit-тесты** Автоматическое тестирование (модульные unit-тесты, интеграционное тестирование, регрессионное тестирование).

Тесты: модульные, интеграционные, функциональные, регрессионные, приёмочные
---------------------------------------------------------------------------

Модульное тестирование в JUnit4 (+JUnit3)
-----------------------------------------

Сейчас ипользуется JUnit4.
Раньше JUnit3 и более ранние.

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

```

``` java
    @Test // Аннотация (начиная с JUnit4)
    // указывает что это тест
    public void testSimplest() { // startWith("test") - JUnit3 и ранее
        // assertEquals(expected, actual)
        // assertEquals(message, expected, actual)
        int calc = 2 * 2;
        assertEquals("Дважды два четыре", 4, calc);
        // Действительные числа сравниваются с погрешностью
        assertEquals("Дважды два четыре", 4.0, 2.0 * 2.0,
                1e-15);
        // Сокращённая форма без message
        assertEquals(4, 2 * 2);
        // Конкатенация строк
        assertEquals("test123", "test" + "123");
        // Сравнение массивов
        assertArrayEquals(new byte[]{1, 2, 3}, new byte[]{1, 2, 3});

        // Специальная форма для Boolean
        assertTrue(1 < 2);
        assertFalse(3 > 4);
    }

    // Пример: тестируем вычисление факториала
    // Важен баланс между:
    //  - временем выполнения тестов
    //  - покрытием (рассмотреть все варианты)
``` java
    @Test
    public void testFactorial() {
        assertEquals("1! = ", 1, MyClass.fact(1));
        assertEquals(2, MyClass.fact(2));
        assertEquals(6, MyClass.fact(3));
        assertEquals(2 * 3 * 4, MyClass.fact(4));
        assertEquals(2 * 3 * 4 * 5, MyClass.fact(5));
        assertEquals(2 * 3 * 4 * 5 * 6, MyClass.fact(6));
        assertEquals(2 * 3 * 4 * 5 * 6 * 7, MyClass.fact(7));
        assertEquals(2 * 3 * 4 * 5 * 6 * 7 * 8, MyClass.fact(8));
        assertEquals(2 * 3 * 4 * 5 * 6 * 7 * 8 * 9, MyClass.fact(9));
        assertEquals(2 * 3 * 4 * 5 * 6 * 7 * 8 * 9 * 10, MyClass.fact(10));
        assertEquals(2 * 3 * 4 * 5 * 6 * 7 * 8 * 9 * 10 * 11, MyClass.fact(11));
    }

    /**
     * Тест с ожидаемым исключением
     *
     * @see Test
     */
    @Ignore // Исправим в версии 5.2
    @Test(expected = IllegalArgumentException.class)
    public void testExpectedException() {
        //System.out.println("Test: " + getName());
        System.out.println("MyClassTest.testExpectedException");
        throw new IllegalArgumentException("Test");
    }

    @Test
    public void testFail() {
        System.out.println("MyClassTest.testFail: start");
        try {
            if (1 < 2)
                throw new IllegalArgumentException("Error description");
            // ...
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            assertEquals("Error description", e.getMessage());
        }

        assertNotNull(new MyClassTest());
        assertNull(null);

        assertTrue(1 < 2);
        assertFalse(1 > 2);
        System.out.println("MyClassTest.testFail: finish");
    }

    @Before
    public void setUp() {
        System.out.println("MyClassTest.setUp");
    }

    @Before
    public void setUp2() {
        System.out.println("MyClassTest.setUp2");
    }

    @After
    public void tearDown() {
        System.out.println("MyClassTest.tearDown");
    }
```

[src/test/java/MyClassTest.java](src/test/java/MyClassTest.java)

