import org.junit.Assert;
import org.junit.Test;

import static util.IntToStr.intToStr;

/**
 * Тестирование перевода числа в строку
 */
// Регулярные выражения в Idea IDE:
// assertEquals\(intToStr\((\d+)\), \(?("[^"]+")\)?\
// assertEquals($2, intToStr($1))
// * $1 - первый параметр
// * $2 - второй параметр и т.д.
public class IntToStrTest extends Assert {

    @Test
    public void testIntToStrBefore100() {
        assertEquals("Ноль", intToStr(0));
        assertEquals("Один", intToStr(1));
        assertEquals("Два", intToStr(2));
        assertEquals("Три", intToStr(3));
        assertEquals("Четыре", intToStr(4));
        assertEquals("Пять", intToStr(5));
        assertEquals("Девять", intToStr(9));
        assertEquals("Десять", intToStr(10));
        assertEquals("Одиннадцать", intToStr(11));
        assertEquals("Двенадцать", intToStr(12));
        assertEquals("Тринадцать", intToStr(13));
        assertEquals("Четырнадцать", intToStr(14));
        assertEquals("Пятнадцать", intToStr(15));
        assertEquals("Шестнадцать", intToStr(16));
        assertEquals("Семьнадцать", intToStr(17));
        assertEquals("Восемьнадцать", intToStr(18));
        assertEquals("Девятьнадцать", intToStr(19));
        assertEquals("Двадцать", intToStr(20));
        assertEquals("Двадцать один", intToStr(21));
        assertEquals("Двадцать два", intToStr(22));
        assertEquals("Двадцать шесть", intToStr(26));
        assertEquals("Тридцать", intToStr(30));
        assertEquals("Тридцать один", intToStr(31));
        assertEquals("Тридцать два", intToStr(32));
        assertEquals("Сорок", intToStr(40));
        assertEquals("Сорок один", intToStr(41));
        assertEquals("Пятьдесят два", intToStr(52));
        assertEquals("Шестьдесят три", intToStr(63));
        assertEquals("Семьдесят четыре", intToStr(74));
        assertEquals("Восемьдесят", intToStr(80));
        assertEquals("Девяносто", intToStr(90));
        assertEquals("Девяносто один", intToStr(91));
        assertEquals("Девяносто два", intToStr(92));
    }

    @Test
    public void testIntToStr_100_to_199() {
        assertEquals("Сто", intToStr(100));
        assertEquals("Сто один", intToStr(101));
        assertEquals("Сто два", intToStr(102));
        assertEquals("Сто одиннадцать", intToStr(111));
        assertEquals("Сто двадцать", intToStr(120));
        assertEquals("Сто двадцать один", intToStr(121));
        assertEquals("Сто двадцать два", intToStr(122));
        assertEquals("Сто сорок", intToStr(140));
        assertEquals("Сто сорок один", intToStr(141));
    }

    @Test
    public void testIntToStr_200_to_999() {
        assertEquals("Двести", intToStr(200));
        assertEquals("Двести один", intToStr(201));
        assertEquals("Двести два", intToStr(202));
        assertEquals("Двести одиннадцать", intToStr(211));
        assertEquals("Двести двадцать", intToStr(220));
        assertEquals("Двести двадцать один", intToStr(221));
        assertEquals("Двести двадцать два", intToStr(222));
        assertEquals("Двести сорок", intToStr(240));
        assertEquals("Двести сорок один", intToStr(241));
        assertEquals("Двести сорок пять", intToStr(245));
        assertEquals("Девятьсот девяносто девять", intToStr(999));
    }

    @Test
    public void testIntToStr_1000_to_999999() {
        assertEquals("Одна тысяча", intToStr(1000));
        assertEquals("Две тысячи", intToStr(2000));
        assertEquals("Три тысячи", intToStr(3000));
        assertEquals("Четыре тысячи", intToStr(4000));
        assertEquals("Пять тысяч", intToStr(5000));
        assertEquals("Десять тысяч", intToStr(10000));
        assertEquals("Двадцать тысяч", intToStr(20000));
        assertEquals("Девяносто девять тысяч девятьсот девяносто девять",
                intToStr(99999));
        assertEquals("Девяносто девять тысяч девятьсот двенадцать", intToStr(99912));
        assertEquals("Девятьсот двадцать тысяч девятьсот двенадцать", intToStr(920912));
        assertEquals("Девятьсот одиннадцать тысяч девятьсот двенадцать", intToStr(911912));
    }

    @Test
    public void testIntToStr_bigNumbers() {
        assertEquals("Один миллион", intToStr(1000000));
        assertEquals("Один миллиард", intToStr(1000000000));
        assertEquals("Четыре миллиарда", intToStr(4000000000L));
        assertEquals("Четыре миллиарда три", intToStr(4000000003L));
        assertEquals("Четыре миллиарда " +
                "сто двадцать три миллиона " +
                "четыреста пятьдесят шесть тысяч " +
                "семьсот восемьдесят девять", intToStr(4123456789L));
    }

}
