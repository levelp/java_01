import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

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
public class MyClassTest {

    // Первый тест
    // Название метода произвольное для JUnit4
    // Для предыдущих версий важно чтобы метод начинался
    // с "test". Поэтому для совместимости чаще
    // всего называют метод начиная с "test"
    // и добавляют аннотацию
    //-->
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
    //<--

    // Пример: тестируем вычисление факториала
    //-->
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
    //<--
}
