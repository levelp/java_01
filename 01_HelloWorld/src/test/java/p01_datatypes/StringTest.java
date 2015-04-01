package p01_datatypes;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

//
// Работа со строками
// ------------------
// http://docs.oracle.com/javase/7/docs/api/java/lang/String.html
public class StringTest {

    public static <T> T[] concat(T[] first, T[] second) {
        T[] result = Arrays.copyOf(first, first.length + second.length);
        System.arraycopy(second, 0, result, first.length, second.length);
        return result;
    }

    @Test
    public void testString() {
        char data[] = {'a', 'b', 'c'};
        String str = new String(data);
        assertEquals("abc", str);
        // Подстрока
        assertEquals("c", "abc".substring(2, 3));
        assertEquals("d", "cde".substring(1, 2));
        // Создание пустой строки
        assertEquals("", new String());

        // Returns the char value at the specified index
        assertEquals('a', "abc".charAt(0));
        assertEquals('b', "abc".charAt(1));
        assertEquals('c', "abc".charAt(2));

        // Сравнение строк
        assertEquals("Строки равны", 0, "a".compareTo("a"));
        assertEquals("Меньше", -25, "a".compareTo("z"));
        assertEquals("Больше", 25, "z".compareTo("a"));
        assertEquals("Разница по первому несовпадающему символу", 25, "Test_z".compareTo("Test_a"));
        assertEquals("Или по длине строки, если все символы совпадают", -3, "aa".compareTo("aaaaa"));

        assertEquals("Сравнение с учётом регистра", -32, "A".compareTo("a"));

        // Сравнение без учёта регистра
        assertEquals("Строки равны", 0, "a".compareToIgnoreCase("A"));
        assertEquals("Меньше", -25, "a".compareToIgnoreCase("Z"));
        assertEquals("Больше", 25, "Z".compareToIgnoreCase("a"));
        assertEquals("Разница по первому несовпадающему символу", 25, "TeSt_z".compareToIgnoreCase("tEsT_a"));
        assertEquals("Или по длине строки, если все символы совпадают", -3, "aA".compareToIgnoreCase("AaAAA"));

        assertEquals("Работает для русских букв тоже", 0, "Русский".compareToIgnoreCase("рУссКий"));

        assertTrue("Строка начинается с подстроки", "This is test".startsWith("This"));
        assertTrue("..можно со смещением..", "This is test".startsWith(" is", 4));
        assertTrue("Строка заканчивается на подстроку", "This is test".endsWith("test"));
        assertFalse("..с учётом регистра..", "This is test".endsWith("Test"));

        // Массив символов с символа по символ
        CharSequence charSequence = "This is test".subSequence(2, 4);
        assertEquals(2, charSequence.length());
        assertEquals('i', charSequence.charAt(0));
        assertEquals('s', charSequence.charAt(1));

        // Замена символов
        assertEquals("Не выговариваем букву Р", "Наплимел", "Например".replace('р', 'л'));


    }

    // Шаблоны
    @Test
    public void testStringRegexp() {
        // Шаблон телефонного номера
        String phoneNumber = "\\d\\d\\d-\\d\\d-\\d\\d";
        assertTrue("239-34-44".matches(phoneNumber));
        assertTrue("511-41-40".matches(phoneNumber));
        assertFalse("+7-911-511-41-40".matches(phoneNumber));

    }
    //<--

    // Сравнение строк
    //-->
    @Test
    public void testStrEq() {
        String a = "test 1";
        String b = a.substring(0, 4);
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        assertEquals("test", b);
        String c = "test";
        System.out.println("c = " + c);
        System.out.println("(c == b) = " + (c == b));
        System.out.println("c.equals(b) = " + c.equals(b));
        assertFalse(c == b);
        assertTrue(c.equals(b));
    }
    //<!--

    @Test
    public void testArrayString() {
        String cmd = "sudo -E";
        String[] split = cmd.split("\\s+");
        assertArrayEquals(new String[]{"sudo", "-E", "cmd", "arg"}, concat(split, new String[]{"cmd", "arg"}));
    }
}
