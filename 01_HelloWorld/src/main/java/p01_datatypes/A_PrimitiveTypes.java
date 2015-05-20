package p01_datatypes;

import java.util.Random;

/// 8 примитивных типов данных: byte, short, int, long, float, double, boolean, char
/// --------------------------------------------------------------------------------
public class A_PrimitiveTypes {
    public static void main(String args[]) {
        /*
          Многострочный...
            ...комментарий
        */
        System.out.println("Hello, group!");

        // **Целочисленные типы:**
        //  1. 8 битное целое - **byte**: -128..127.
        // Подробнее: http://ru.wikipedia.org/wiki/Дополнительный_код_(представление_числа)
        byte varWithoutValue;
        varWithoutValue = 3; // Значение присваиваем позже
        varWithoutValue = (byte) (varWithoutValue + 2);
        System.out.println("varWithoutValue = " + varWithoutValue);

        byte b = -128; // -128..127
        System.out.println("b = " + b);
        //
        // | Двоичное  |Дополнительный код | Байт |
        // |-----------|:-----------------:|:----:|
        // | 00000000  |    0              |   0  |
        // | 00000001  |    1              |   1  |
        // | 00000010  |    2              |   2  |
        // | 00000011  |    3              |   3  |
        // | 00000100  |    4              |   4  |
        // |  ...      |   ...             | ...  |
        // | 01111111  |   127             | 127  |
        // | 10000000  |   -128            | 128  |
        // |  ...      |   ...             | ...  |
        // | 11111111  |   -1              | 255  |
        //

        // 2. 16-битное целое **short**: -2^15..2^15-1  -32768..32767
        //-->
        short sh = 32767; // -32768..32767
        System.out.println("short = " + sh + " " + Short.MIN_VALUE + ".." + Short.MAX_VALUE);
        //<--

        // 3. 32-битное целое **int**
        //-->
        int integerBinary = 0b10101010; // Начиная с Java7
        System.out.println("Integer.toBinaryString(integerBinary) = " + Integer.toBinaryString(integerBinary));
        // Java6
        int intBin = Integer.parseInt("1011", 2);
        System.out.println("intBin = " + Integer.toBinaryString(intBin));
        int integerHex = 0xFFA9; // Шестнадцатеричная система счисления
        System.out.printf("Hex: %04X %n", integerHex);
        // 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, A, B, C, D, E, F
        int maxInt = 2147483647; // 2^31-1
        System.out.printf("maxInt = %08X %n", maxInt);
        //<--

        // 4. 64-битное целое **long**
        long l = 2147483648L; // 64-битное целое
        System.out.println("l = " + l);

        byte b1 = (byte) 0xff;
        System.out.println("b1 = " + b1);
        int bb = 0xff & b1; // & - побитовое И
        System.out.println("bb = " + bb);
        //
        // & - побитовое И
        // 0011
        // 0101
        // 0001
        //
        // | - побитовое ИЛИ
        // 0011
        // 0101
        // 0111
        //
        // ~ - побитовое НЕ
        // 01
        // 10
        //
        // ^ - XOR - исключающее ИЛИ
        // 0011
        // 0101
        // 0110
        //

        // Вещественные типы (действительные)
        // 5. **float** - 4 байта
        float floatValue = 1.0f;
        System.out.printf("floatValue = %f%n", floatValue);

        // 6. **double** - 8 байт
        double doubleValue = 1123.22 * 1.0 / 2.3;
        System.out.printf("doubleValue = %s%n", doubleValue);
        System.out.println(Double.MIN_VALUE + ".." +
                Double.MAX_VALUE);

        // 7. Логический тип
        Random random = new Random();
        boolean bool = random.nextBoolean();
        boolean bool2 = random.nextBoolean();
        boolean bool3 = bool && bool2;
        System.out.printf("bool3 = %s%n", bool3);

        //
        // && - логическое И
        // || - логическое ИЛИ
        boolean bool4 = !bool; // ! - логическое НЕ
        System.out.println("bool4 = " + bool4);

        // 8. Символьный тип **char**
        char c1 = 'П', c2 = 'Р', c3 = 'И', c4 = 'В', c5 = 'Е', c6 = 'Т';
        System.out.println(c1 + c2 + c3 + c4 + c5 + c6);

        //
        // Переменные, методы, классы можно
        // называть по-русски, имена в кодировке Unicode
        char мояСимвольнаяПеременная = 'Д';
        System.out.println(мояСимвольнаяПеременная);

        // И это лучше чем в транслите
        int moyaPremennaya = 10;
        System.out.println("moyaPremennaya = " + moyaPremennaya);

        int a = random.nextInt(10);
        System.out.println("a = " + a);
        // Условный оператор **if**
        //-->
        if (a > 1) { // Когда условие истинно
            System.out.println("a большая :)");
        } else { // в противоположном случае
            System.out.println("a маленькая :)");
        }
        //<--

        // Цикл с предусловием - While
        while (a > 1/* условие */) { // Пока выполняется условие
            a = a - 2;
        }

        // Цикл с постусловием - Repeat Until
        do {
            a = a * 3;
        } while (a < 3);

        // Цикл for
        for (int j = 0; j < 10; j++)
            System.out.println("j = " + j);

        // Вывод аргументов командной строки
        for (String s : args) {
            System.out.println(s);
        }

        //
        // Сокращённая форма: +=, -=..., инкремент/декремент, префиксный/постфиксный 
        // -------------------------------------------------------------------------
        //-->
        // Сложение
        a = a + 10;
        a += 10;
        // Вычитание
        a = a - 11;
        a -= 11;
        // Умножение
        a = a * 3;
        a *= 3;
        // Деление
        a = a / 2;
        a /= 2;
        // Инкремент
        a = a + 1;
        a++; // Постфиксная форма
        System.out.println("a = " + a);
        a = 2;
        int aa = a++; // aa = 2
        System.out.println("aa = " + aa);
        // a = 3
        int a1 = ++a; // a1 = 4, a = 4
        System.out.println("a1 = " + a1);
        ++a; // Префиксная форма
        // Декремент
        a = a - 1;
        a--;
        --a;
        //<--
    }
}
