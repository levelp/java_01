import org.junit.*;

//import static org.junit.Assert.*;

// Тесты в JUnit
//
// Цель: Либо протестировать уже готовый код.
//
// Либо **регрессионное** тестирование:
// * Один раз проверили что код работает верно
// * Написали тест, который проверяет что код возвращает одни и
//  те же результаты
// * На каждой новой версии продукта запускаем
// эти же тесты.
//
// **TDD (Test Driven Development)** -
// разработка через тестирование.
// Принцип: сначала тест, потом код чтобы тест проходил.
public class MyClassTest extends Assert /*TestCase*/ {

    @BeforeClass
    public static void beforeClass() {
        System.out.println("MyClassTest.beforeClass");
        System.out.println("!!!");
    }
    //<--

    @AfterClass
    public static void afterClass() {
        System.out.println("MyClassTest.afterClass");
    }

    // Первый тест
    // Название метода произвольное для JUnit4
    // Для предыдущих версий важно чтобы метод начинался
    // с "test". Поэтому для совместимости чаще
    // всего называют метод начиная с "test"
    // и добавляют аннотацию
    //-->
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
    //-->
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
    //<--
}
