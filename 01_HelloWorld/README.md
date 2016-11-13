<!-- doc.py -->
Лексика языка Java: комментарии, операторы, переменные, литералы, присваивание, операторные скобки
--------------------------------------------------------------------------------------------------
* Переменные
* Литералы
* Условия
* Циклы

Java->class->JVM. Первое приложение Hello World. Package
--------------------------------------------------------

Примитивные типы данных
-----------------------
1. **byte** - целое, один байт со знаком -128..127
2. **short** - целое, два байта со знаком -32.768..32.767
3. **int** - целое, 4 байта со знаком -2^31..2^31-1
4. **long** - целое, 8 байт со знаком -2^63..2^63-1
5. **float** - действительное число (32-bit IEEE 754 floating point)
6. **double** - действительное число двойной точности (8 байт)
7. **boolean** - логический тип (true и false)
8. **char** - символ (2 байта) '\u0000'..'\uffff'

+ класс String

Управляющие конструкции
-----------------------

if, else, while, switch

``` java
public class HelloWorld {
    public static void main(String[] args) {
        /*
             Многострочный комментарий
              */
        // Однострочный комментарий
        System.out.println("Hello, world!");

        //int i; // В стек основного потока main
        //Runtime.getRuntime().gc();
    }
}
```

[src/main/java/p00_helloworld/HelloWorld.java](src/main/java/p00_helloworld/HelloWorld.java)

``` java
    // Шаблон: psvm + <tab>
    // [p]ublic [s]tatic [v]oid [m]ain
    public static void main(String[] args) {
        // sout
        System.out.println();
        System.out.println("Hello world!");
        // soutv - + вывести значение последней переменной
        int ii = 10;
        System.out.println("ii = " + ii);
        int i1 = 1;
        int i2 = 2;
        int i3 = 3;
        System.out.println("i3 = " + i3);
        // soutm + <tab> - название метода
        System.out.println("IdeaLiveTemplates.main");
        System.out.println("args = [" + args + "]");

        // fori + <tab> - цикл по целочисленной переменной
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    for (int l = 0; l < 10; l++) {
                        for (int m = 0; m < 10; m++) {

                        }
                    }
                }
            }
        }

        for (int j = 0; j < 10; j++) {
            System.out.println("j = " + j);
        }
        for (int j = 0; j < 10; j++) {
            for (int k = 0; k < 10; k++) {
                System.out.println(j * k);
            }
        }
    }
```

[src/main/java/p00_helloworld/IdeaLiveTemplates.java](src/main/java/p00_helloworld/IdeaLiveTemplates.java)

``` java
// Ещё один "главный" класс в другом пакете
package p00_helloworld.subpackage;

public class Main {

    public static void main(String[] args) {
        int i = 10;
        System.out.println("Привет всем!");
    }
}
```

[src/main/java/p00_helloworld/subpackage/Main.java](src/main/java/p00_helloworld/subpackage/Main.java)

8 примитивных типов данных: byte, short, int, long, float, double, boolean, char
--------------------------------------------------------------------------------
``` java
        short sh = 32767; // -32768..32767
        System.out.println("short = " + sh + " " +
                Short.MIN_VALUE + ".." + Short.MAX_VALUE);
```

``` java
        int integerBinary = 0b10101010; // Начиная с Java7
        System.out.println("Integer.toBinaryString(integerBinary) = " + Integer.toBinaryString(integerBinary));
        // Java6
        int intBin = Integer.parseInt("1011", 2);
        int intX = Integer.parseInt("23422", 6);
        System.out.println("intBin = " +
                Integer.toBinaryString(intBin));
        int integerHex = 0xFFA9; // Шестнадцатеричная система счисления
        System.out.printf("%d ", integerHex);
        System.out.printf("Hex: %X %n", integerHex); // FFA9
        System.out.printf("Hex: %x %n", integerHex); // ffa9
        System.out.printf("Hex: %08X %n", integerHex); // 0000FFA9
        // CR LF - Windows  13 10
        // LF - Unix 13
        // CR - MacOS 10
        // 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, A, B, C, D, E, F
        int maxInt = 2147483647; // 2^31-1
        System.out.printf("maxInt = %08X %n", maxInt);
        System.out.println("Integer.MAX_VALUE = " + Integer.MAX_VALUE);
```

``` java
        //if(2 && 3){
        //
        //}
        if (a > 1 && a < 10 || !(a == 11)) { // Когда условие истинно
            System.out.println("a большая :)");
        } else { // в противоположном случае
            System.out.println("a маленькая или очень большая");
        }
```

``` java
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
        // Взять по модулю
        a = a % 5;
        a %= 5;
        // Инкремент
        a = a + 1;
        a++; // Постфиксная форма
        ++a; // Префиксная форма
        int int2 = 0; int2--; --int2;
        System.out.println("a = " + a);
        a = 2;
        int aa = a++ + a++; // aa = 4
        System.out.println("aa = " + aa);
        int a1 = ++a;
        System.out.println("a1 = " + a1);
        ++a; // Префиксная форма
        // Декремент
        a = a - 1;
        a--;
        --a;
```

[src/main/java/p01_datatypes/A_PrimitiveTypes.java](src/main/java/p01_datatypes/A_PrimitiveTypes.java)

``` java
        Scanner scanner = new Scanner(System.in);

        // Читаем целое число с клавиатуры
        int a = scanner.nextInt();

        if (a == 10) {
            System.out.println("a равно 10");
        } else {
            System.out.println("a не равно 10");
        }
        if (a >= 10) {
            System.out.println("a >= 10");
        }
```

[src/main/java/p01_datatypes/B_if_else.java](src/main/java/p01_datatypes/B_if_else.java)

``` java
        double a = 0.3;
        double b = 0.6;
        double c = 0.9;
        // Корректная проверка что a + b == c
        if  (Math.abs(a + b - c) < 1e-15) {
            System.out.println("Равно");
        } else {
            System.out.println("Не равно!");
            System.out.println("c - (a+b) = " +
                    (c - (a + b)));
        }
```

[src/main/java/p01_datatypes/C_FloatAccuracy.java](src/main/java/p01_datatypes/C_FloatAccuracy.java)

``` java
        // Инициализация
        int[] intArray1 = new int[]{1, 2, 3, 10};

        // Сокращённая форма инициализации
        int[] intArray2 = {1, 2, 3, 10};
        // Массив - можно сразу не инициализировать
        int[] intArray3;
        intArray3 = new int[100];
```

``` java
        for (int i = 0; i < intArray2.length; i++) {
            System.out.println("intArray1[" + i + "] = " +
                    intArray1[i]);
        }
        // Если нам не важны индексы,
        // то мы можем использовать цикл "foreach"
        for (int i : intArray1) {
            System.out.print(i + " ");
        }
        System.out.println(); // Просто перевод строки
```

``` java
        int[][] array2D = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int x = array2D[0][1]; // Элемент массива с индексом 0 1
        array2D[1][1] = 231; // Новое значение
```

[src/main/java/p01_datatypes/D_Arrays.java](src/main/java/p01_datatypes/D_Arrays.java)

``` java
        int i = 10;
        // Integer
        Integer ii = i; // Boxing
        int iii = ii; // Unboxing
        assertEquals("Перед вызовом method1", 10, i);
        System.out.println("Перед вызовом method1 i = " + i);

        method1(i);

        assertEquals("После вызова method1", 10, i);
        System.out.println("После вызова method1 i = " + i);
```

``` java
        MyClass object = new MyClass();
        object.i = 10;
        assertEquals("Перед вызовом method2", 10, object.i);
        System.out.println("Перед вызовом method2 object.i = " + object.i);

        myMethod2(object);

        assertEquals("После вызова myMethod2", 30, object.i);
        System.out.println("После вызова method2 object.i = " + object.i);
```

``` java
    static void method1(int i) {
        i += 20;
        System.out.println("method1: i = " + i);
        assertEquals("method1: ", 30, i);
    }
```

``` java
    static void myMethod2(MyClass i) {
        //i = new MyClass();
        i.i += 20;
        assertEquals("myMethod2: ", 30, i.i);
    }
```

``` java
    static class MyClass {
        int i;
    }
```

[src/main/java/p01_datatypes/E_ByValueByReference.java](src/main/java/p01_datatypes/E_ByValueByReference.java)

``` java
        // 8 базовых (примитивных) типов
        // 4 целочисленных типа (знаковые)
        byte myByte = -100; // 1 байт
        short myShort = -1231; // 2 байта
        int myInt = 24346363; // 4 байта
        long myLong = 469523695623L; // 8 байт

        // 2 вещественных типа
        float myFloat = 23234.0f; // 4 байта
        double myDouble = 12425.523; // 8 байт

        // символьный тип
        char myChar = 'a';

        // логический тип
        boolean myBoolean1 = true;
        myBoolean1 = false;
```

``` java
        int c = a + b; // сложение
        //   - - вычитание
        c = a - b;
        //   * - умножение
        c = a * b;
        //   / - деление
        c = a / b;
        //   % - по модулю
        c = a % b;
        // Побитовые операции:
        //  >> - сдвиг вправо
        c = a >> b;
        //  << - сдвиг влево
        c = a << b;
        // | - ИЛИ (OR)
        c = a | b;
        // & - И (AND)
        c = a & b;
        // ^ - ИСКЛЮЧАЮЩЕЕ ИЛИ - XOR
        c = a ^ b;
        // ~ - Побитовое отрицание (NOT)
        c = ~a;

        // Логические операции:
        // && - И (AND)
        boolean cb, ab = true, bb = false;
        cb = ab && bb;
        // || - ИЛИ (OR)
        cb = ab || bb;
        // ! - НЕ (NOT)
        cb = !ab;

        // Сокращённая форма
        c += a;
        c -= a;
        c *= a;
        c /= a;
        c %= a;

        // Инкремент и декремент
        ++a;
        a++; // Увеличение на единицу
        --a;
        a--; // Уменьшение на единицу
```

[src/main/java/p01_datatypes/H_Operators.java](src/main/java/p01_datatypes/H_Operators.java)

``` java
        double a, b, c;
        Scanner s = new Scanner(System.in);
        System.out.println("== Решение квадратного уравнения ==");
        System.out.println("Введите коэффициенты");
        System.out.print("a = ");
        a = s.nextDouble(); // 1.2213
        System.out.print("b = ");
        b = s.nextDouble();
        System.out.print("c = ");
        c = s.nextDouble();
```

``` java
        double D = pow(b, 2) - 4 * a * c; // pow - power
```

``` java
        if (abs(D) < 1e-16) {
            double x = -b / (2 * a);
            System.out.println("x = " + x);
            return;
        }
        if (D < 0.0) {
            System.out.println("Решений нет!");
        } else {
            double x1 = (-b + sqrt(D)) / (2 * a);
            double x2 = (-b - sqrt(D)) / (2 * a);
            System.out.println("x1 = " + x1 + "   x2 = " + x2);
        }
```

[src/main/java/p01_datatypes/Z_SquareEq.java](src/main/java/p01_datatypes/Z_SquareEq.java)

Циклы: while, do while, for
---------------------------
``` java
        int N = 6;
        System.out.print("N = " + N + " = (inverse binary) = ");
        while (N > 0) {
            System.out.print("" + N % 2);
            N /= 2;
        }
        System.out.println();
```

``` java
        int x = 1000;
        do {
            x -= 99;
            System.out.println("x = " + x);
        } while (x > 10);
```

``` java
        System.out.println(" Таблица умножения ");
        System.out.println("===================");
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                System.out.printf("%3d", i * j);
            }
            System.out.println();
        }
        //     Таблица умножения
        //    ===================
        //  1  2  3  4  5  6  7  8  9
        //  2  4  6  8 10 12 14 16 18
        //  3  6  9 12 15 18 21 24 27
        //  4  8 12 16 20 24 28 32 36
        //  5 10 15 20 25 30 35 40 45
        //  6 12 18 24 30 36 42 48 54
        //  7 14 21 28 35 42 49 56 63
        //  8 16 24 32 40 48 56 64 72
        //  9 18 27 36 45 54 63 72 81
```

[src/main/java/p02_cycles/Cycles.java](src/main/java/p02_cycles/Cycles.java)

<<<<<<< HEAD
Markdown файл
=============
=======
Использование Markdown-разметки для документации
------------------------------------------------
>>>>>>> 7968b25127064f5457bc24be25031cc6d9552a93

```

``` java
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
[src/test/java/p01_datatypes/StringTest.java](src/test/java/p01_datatypes/StringTest.java)

<<<<<<< HEAD
Markdown файл
=============
=======
Использование Markdown-разметки для документации
------------------------------------------------
>>>>>>> 7968b25127064f5457bc24be25031cc6d9552a93

