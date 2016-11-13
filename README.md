<!-- doc.py -->
Синтаксис Java. ООП. Тестирование и отладка
===========================================

[![Build Status](https://travis-ci.org/levelp/java_01.svg?branch=master)](https://travis-ci.org/levelp/java_01)
[![Coverage Status](https://coveralls.io/repos/github/levelp/java_01/badge.svg?branch=master)](https://coveralls.io/github/levelp/java_01?branch=master)

TODO:
-----
* Зарегистироваться на github.com
* Подать заявку на вступление в: https://github.com/levelp
* Скачать JavaSE: http://www.oracle.com/technetwork/java/javase/downloads/index.html
* https://www.jetbrains.com/idea/download/ - Idea Ultimate Edition
* Зарегистироваться на https://account.jetbrains.com/login
* https://meet93023175.adobeconnect.com - вебинар

Знакомство
----------

* Степулёнок Денис Олегович - super.denis@gmail.com / denis.stepulenok@oracle.com
* Солодкая Анастасия Сергеевна - a.s.solodkaya@gmail.com
* Громов Илья Анварович - igromovbox@gmail.com

Работаем в Oracle

Обзор сайтов и литературы по Java и ООП
---------------------------------------

**Сайты**
* http://vk.com/java_course - группа для участников курса
* http://levelp.ru/courses/programmirovanie/java-junior-developer/ -
курс Java Junior Developer на сайте LevelUp
* http://levelp.ru/courses/programmirovanie/basics-of-programming-in-the-java-language-level-1/ -
курс "Основы программирования на языке Java. Уровень 1" на на сайте LevelUp
* http://levelp.ru/courses/programmirovanie/basics-of-programming-in-the-java-language-level-2/ -
курс "Основы программирования на языке Java. Уровень 2" на на сайте LevelUp
* http://javarush.ru - курс Java для начинающих (http://info.javarush.ru/page/learning_plan/ - план обучения)
* http://www.intuit.ru/studies/courses/16/16/info - "Программирование на Java" курс лекций на ИНТУИТ
* http://levelp.ru/knowledge-base/ - форум на сайте LevelUp (задавать вопросы по д.з.)
* http://hashcode.ru/ - ответы на вопросы

**Книги по Java**
* Программирование на Java и C# для студента, О. Герман, Ю. Герман: http://www.bookvoed.ru/book?id=3819902
* Head First Java (Java, A Beginner's Guide) - http://rutracker.org/forum/viewtopic.php?t=4212262
* Java. The Complete Reference. 8th Edition / Java. Полное руководство. 8-е издание - http://rutracker.org/forum/viewtopic.php?t=4164907 -
* Test Driven Development (Kent Beck) - http://www.ozon.ru/context/detail/id/1501671/
* Thinking in Java (Философия Java) Брюс Эккель: http://www.bookvoed.ru/book?id=422984
* Искусство программирования на Java, Герберт Шилдт, Джеймс Холмс: http://www.bookvoed.ru/book?id=3483133
* Java EE 7. Основы, Гупта А.: http://www.bookvoed.ru/book?id=6093759
* Effective Java, автор Joshua Bloch (Джошуа Блох) - http://www.ozon.ru/context/detail/id/1259354/
* Программист Прагматик (The Pragmatic Programmer) - подробно раскрыты общие методики программирования (книга похожа на сборник полезных советов)
* Java concurrency in practice. - Многопоточность в Java.
http://www.amazon.com/Java-Concurrency-Practice-Brian-Goetz/dp/0321349601
* Книга: Экстремальное программирование: разработка через тестирование
http://www.booksgid.com/programmer/4686-jekstremalnoe-programmirovanie.html
* Джошуа Блох "Java. Эффективное программирование" http://www.ozon.ru/context/detail/id/21724143/

TODO: Навести порядок в книгах
+ добавить ссылку на группу в альбом с внешним видом

Скачивание, установка и настройка Java
--------------------------------------
* Скачать Java SE: http://www.oracle.com/technetwork/java/javase/downloads/index.html
* https://www.jetbrains.com/idea/download/ - Idea Ultimate Edition
* Зарегистироваться на https://account.jetbrains.com/login
* Скачать Java-plugin (выполнение Java-апплетов, Java Web Start): https://java.com/ru/download

* Для удобства нужно задать переменную окружения JAVA_HOME - путь к Java, например: C:\Program Files\Java\jdk1.8.0_20
* И добавить: C:\Program Files\Java\jdk1.8.0_20\bin в пути (переменную PATH).

**install_java.cmd**

``` bat
REM Командный файл для "тихой" установки Java под Windows
REM /s - silent mode (не задавая вопросов)
REM INSTALLDIR - куда ставить JDK
REM INSTALLDIRPUBJRE - куда ставить JRE
jdk-8u20-windows-x64.exe /s INSTALLDIR=D:\JDK /INSTALLDIRPUBJRE=D:\JRE
```

**Для Windows x64:**
* Java 64 устанавливается в: **C:\Program Files\Java**
* Java x86 устанавливается в: **C:\Program Files (x86)\Java**

Почему именно Java?
-------------------
* http://www.tiobe.com/index.php/content/paperinfo/tpci/index.html - TIOBE Index
* http://readwrite.com/2014/01/08/in-demand-tech-skills-of-2013-java - Популярность Java
* http://habrahabr.ru/post/201612/ - Java навсегда! 12 причин длительного доминирования Java

Что такое Java? История создания
--------------------------------
История Java началась в 1991 году, когда группа инженеров из компании Sun под руководством Патрика Нотона (Patrick Naughton)
и члена Совета директоров Джеймса Гослинга (James Gosling) занялась разработкой небольшого языка,
который можно было бы использовать для программирования бытовых устройств, например,
контроллеров для переключения каналов кабельного телевидения (cable TV switchboxes).

Поскольку такие устройства не потребляют много энергии и не имеют больших микросхем памяти,
язык должен был быть маленьким и генерировать очень компактные программы.
Кроме того, поскольку разные производители могут
выбирать разные центральные процессоры (Central Processor Unit - CPU),
было важно не завязнуть в какой-то одной архитектуре компьютеров.
Проект получил кодовое название "Green".

Стремясь изобрести небольшой, компактный и машинонезависимый код,
разработчики возродили модель, использованную при реализации первых версий языка Pascal на заре эры персональных компьютеров.
Никлаус Вирт, создатель языка Pascal, в свое время разработал машинонезависимый язык,
генерирующий промежуточный код для некоей гипотетической машины.
Этот язык стал коммерческим продуктом под названием UCSD Pascal.
Такие гипотетические машины часто называются виртуальными - например, виртуальная машина языка Java, или JVM.
Этот промежуточный код можно выполнять на любой машине,
имеющей соответствующий интерпретатор.
Инженеры, работавшие над проектом "Green", также использовали виртуальную машину, что решило их основную проблему.

Однако большинство сотрудников компании Sun имели опыт работы с операционной системой UNIX,
поэтому в основу разрабатываемого ими языка бь л положен язык C++, а не Pascal.
В частности, они сделали язык объектно-, а не процедурно-ориентированным.

Как сказал Гослинг в своем интервью: "Язык — это всегда средство, а не цель".
Сначала Гослинг решил назвать его "Oak" ("Дуб").
(Возможно потому, что он любил смотреть на дуб, растущий прямо под окнами его офиса в компании Sun.)
Потом сотрудники компании Sun узнали, что слово Oak уже используется в качестве имени ранее созданного языка программирования, и изменили название Java.

В 1992 году в рамках проекта Green была выпущена первая продукция,
названная "*7".
Это было средство для чрезвычайно интеллектуального дистанционного управления.
(Оно имело мощность рабочей станции SPARK, помещаясь в коробочке размером 6x4x4 дюйма.)
К сожалению, ни одна из компаний-производителей электронной техники не заинтересовалась этим изобретением.

Затем группа стала заниматься разработкой устройства для кабельного телевидения,
которое могло бы осуществлять новые виды услуг, например, включать видеосистему по требованию. И снова они не получили ни одного контракта. (Забавно, что одной из компаний, отказавшихся подписать с ними контракт, руководил Джим Кларк (Jim Clark) — основатель компании Netscape, впоследствии сделавшей очень много для успеха языка Java.)



Весь 1993 год и половину 1994 года продолжались безрезультатные поиски покупателей продукции, разработанной в рамках проекта "Green" (под новым названием "First Person, Inc."). (Патрик Нотон, один из основателей группы, впоследствии в основном занимавшийся маркетингом, налетал в общей сложности более 300 тысяч миль, пытаясь продать разработанную технологию.) Проект "First Person, Inc." был прекращен в 1994 году.

Тем временем в рамках Интернет разрасталась сеть World Wide Web. Ключом к этой сети является броузер, превращающий гипертекст в изображение на экране.
В 1994 году большинство людей пользовалось броузером Mosaic, некоммерческим Web-броузером, разработанным в суперкомпьютерном центре Университета штата Иллинойс (University of Illinois) в 1993 году. (Частично этот броузер был написан Марком Андреессеном (Mark Andreessen) за 6,85 доллара в час. В то время Марк заканчивал университет и броузер был его дипломной работой. Затем он стал одним из основателей и главным программистом компании Netscape, и к нему пришли слава и богатство.)



В своем интервью журналу Sun World Гослинг сказал, что в середине 1994 года разработчики языка поняли: "Нам нужно создать действительно крутой броузер. Такой броузер должен представлять собой одно из немногих приложений модной клиент-серверной технологии, в которой жизненно важным было бы именно то, что мы сделали: архитектурная независимость, выполнение в реальном времени, надежность, безопасность — вопросы, не являвшиеся чрезвычайно важными для рабочих станций. И мы создали такой броузер".



На самом деле броузер был разработан Патриком Нотоном и Джонатаном Пэйном (Johnatan Payne). Позднее он превратился в современный броузер HotJava. Этот броузер был написан на языке Java, чтобы продемонстрировать всю его мощь. Однако разработчики не забывали о мощных средствах, которые теперь называются апплетами, наделив свой броузер способностью выполнять код внутри Web-страниц. "Демонстрация технологии" была представлена на выставке Sun World '95 23 мая 1995 года и вызвала всеобщее помешательство на почве язака Java, продолжающееся и поныне.



Компания Sun выпустила первую версию языка Java в начале 1996 года. Через несколько месяцев после нее появилась версия Java 1.02. Люди быстро поняли, что версия Java 1.02 не подходит для разработки серьезных приложений. Конечно, эту версию можно применять для разработки Web-страниц с пляшущими человечками, однако в версии Java 1.02 ничего нельзя даже напечатать.

Честно говоря, версия Java 1.02 была еще сырой. Ее преемница, версия Java 1.1, заполнила большинство зияющих провалов, намного улучшив возможность отражения и добавив новую модель событий для программирования графического пользовательского интерфейса. Несмотря на это, она все еще была довольно ограниченной.

Выпуск версии Java 1.2 стал основной новостью конференции JavaOne в 1998 году.
В новой версии слабые средства для создания графического пользовательского интерфейса и графических приложений были заменены сложным и масштабным инструментарием. Это был шаг вперед, к реализации лозунга "Write Once, Run Anywhere" ™ ("Один раз напиши— и везде выполняй"), выдвинутого при разработке предыдущих версий.

В декабре 1998 года через три дня (!) после выхода в свет название новой версии было изменено на громоздкое словосочетание Java 2 Standart Edition Software Development Kit Version 1.2 (Стандартное издание пакета инструментальных средств для разработки программного обеспечения на языке Java 2, версия 1.2).

Кроме стандартного издания пакета ("Standart Edition") были предложены еще два варианта:
"микроиздание" ("Micro Edition") для портативных устройств, например, для мобильных телефонов,
 "промышленное издание" ("Enterprise Edition") для создания серверных приложений.

Версии 1.3 и 1.4 стандартного издания пакета инструментальных средств
намного совершеннее первоначального выпуска языка Java 2.
Они обладают новыми возможностями и, разумеется, содержат намного меньше ошибок.



Платформа Java. JVM, сборка мусора, оптимизация, прогрев. JDK, JRE
------------------------------------------------------------------
**JVM** - Java Virtual Machine.

* **MyClass.java** - файл с исходным кодом.
* **javac MyClass.java** - Java Compiler - компилятор.
* Байт-код: **MyClass.class**.
* **java MyClass** - выполняем программу.
* Запуск **JVM**
* Внутри **JVM** запускается наша программа.

* **JDK** - Java Development Kit (для компиляции)
* **JRE** - Java Runtime Environment (для выполнения Java-программ)

Принцип: Write once, run anywhere (WORA)

* **Сборка мусора** - new - создание нового объекта
**Сборщик мусора** (GC) удаляет все объекты
на которые не ссылается программа при следующем цикле
сборки мусора.

**Память:**
* **Стек** - локальные переменные
* **Куча** (динамическая память, heap) - new / Garbage Collector
* **Статическая память** - при загрузке классов.

**Оптимизация, прогрев**

* Перейти в папку JDK (например: D:\JDK\bin).
* Создать файл **HW.java**
``` java
public class HW {
    public static void main(String[] args) {
        System.out.println("Hello, world!");
    }
}
```
* Откомпилировать **javac HW.java**
* Убедиться, что появился файл: **java.class**
* Запустить: **java HW**
* Посмотреть на результаты выполнения программы.

https://lisiynos.googlecode.com/git/java/java_1.html

Варианты поставки Java: ME, SE, EE
----------------------------------

http://docs.oracle.com/javase/8/docs/

**Java ME (Java 2 Micro Edition, J2ME)** -
подмножество платформы Java для устройств,
ограниченных в ресурсах, например:
сотовых телефонов,
карманных персональных компьютеров,
ресиверов цифрового телевидения,
проигрывателей дисков Blu-ray и т.д.
Язык Java тот же, минимум библиотек.

**Java SE (Java Platform,
Standard Edition, Java 2 Standard Edition, J2SE)** -
стандартная версия платформы Java 2,
предназначенная для создания и исполнения
апплетов и приложений,
рассчитанных на индивидуальное пользование
или на использование в масштабах малого предприятия.

**Java EE (Java Platform, Enterprise Edition, Java 2 Enterprise Edition, J2EE)**
- набор спецификаций и соответствующей документации
для языка Java,
описывающей архитектуру серверной платформы
для задач средних и крупных предприятий.

**Перспективы: Java 9** - модульная Java
http://openjdk.java.net/jeps/200

Установка и настройка IntelliJ IDEA, создание проекта
-----------------------------------------------------
* http://habrahabr.ru/post/112749/ - Почему IDEA лучше Eclipse
* https://www.jetbrains.com/idea/download/ - Idea Ultimate Edition + серийный номер
* Указать **JDK** в настройках проекта (обычно каталог:
**C:\Program Files\Java\jdk1.8.0_20**).
* Запустить **Idea**

Первый проект:
``` java
public class Main {
    // psvm
    public static void main(String[] args) {
        System.out.println("Hello, world!");
    }
}
```

**.iml** - расширение для Idea проектов.

Установка и настройка Apache Maven. Центральный репозиторий. POM (project object model)
---------------------------------------------------------------------------------------
* http://maven.apache.org/ - скачивание maven
* Распаковать в папку на диске, например в **C:\apache-maven-3.2.3**
* Добавить в пути (в переменную окружения PATH) - **C:\apache-maven-3.2.3\bin**
* Устанавливаем переменную окружения: **M2_HOME=C:\apache-maven-3.2.3**


Установка и настройка Git + GitHub. Клиент git для Windows
----------------------------------------------------------
* http://habrahabr.ru/post/125799/ - Как начать работать с GitHub: быстрый старт
* http://habrahabr.ru/post/147192/ - Изучить Github за 15 минут: https://try.github.io

Установка и настройка Apache Tomcat
-----------------------------------
* http://archive.apache.org/dist/tomcat/tomcat-8/v8.0.9/bin/apache-tomcat-8.0.9.zip - скачивание Apache Tomcat
* Распаковать в папку на диске, например в D:\tomcat

JavaDoc
-------
**Javadoc** - генератор документации в HTML-формате из комментариев исходного кода на Java от Sun Microsystems.
Стандарт для документирования классов Java.
Большинство сред разработки программного обеспечения автоматически генерируют HTML-документацию, используя Javadoc.

Javadoc также предоставляет API для создания доклетов и тэглетов,
которые позволяют программисту анализировать структуру Java-приложения.

**Применяют для документирования:**
* классов
* интерфейсов
* полей (переменных)
* конструкторов
* методов
* пакетов

В каждом случае комментарий должен находиться перед документируемым элементом.

Настройки памяти при запуске JVM
================================
java -Xss
 - Xss - размер стека
Куча:
 - Xmx - размер кучи (heap)
java -Xms6291456 -cp my.jar MainClass  - запуск приложения 6291456 байт
java -Xms6144k  -- 6144k
java -Xms6m  - 6 мегабайт
java -Xms2G  - 2 гигабайта
-Xmx83886080
-Xmx81920k
-Xmx80m
-XX:MaxPermSize=128M

Что делать если получаем StackOverflowException?
------------------------------------------------
* Реально нужно больше стека: увеличить с помощью -Xss
* Избавится от бесконечной рекурсии

Какие переменные хранятся в стеке?
----------------------------------
* Все локальные переменные метода
* Все параметры метода


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

[01_HelloWorld/src/main/java/p00_helloworld/HelloWorld.java](01_HelloWorld/src/main/java/p00_helloworld/HelloWorld.java)

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

[01_HelloWorld/src/main/java/p00_helloworld/IdeaLiveTemplates.java](01_HelloWorld/src/main/java/p00_helloworld/IdeaLiveTemplates.java)

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

[01_HelloWorld/src/main/java/p00_helloworld/subpackage/Main.java](01_HelloWorld/src/main/java/p00_helloworld/subpackage/Main.java)

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

[01_HelloWorld/src/main/java/p01_datatypes/A_PrimitiveTypes.java](01_HelloWorld/src/main/java/p01_datatypes/A_PrimitiveTypes.java)

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

[01_HelloWorld/src/main/java/p01_datatypes/B_if_else.java](01_HelloWorld/src/main/java/p01_datatypes/B_if_else.java)

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

[01_HelloWorld/src/main/java/p01_datatypes/C_FloatAccuracy.java](01_HelloWorld/src/main/java/p01_datatypes/C_FloatAccuracy.java)

Массивы. Arrays: foreach, многомерные
-------------------------------------
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

[01_HelloWorld/src/main/java/p01_datatypes/D_Arrays.java](01_HelloWorld/src/main/java/p01_datatypes/D_Arrays.java)

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

[01_HelloWorld/src/main/java/p01_datatypes/E_ByValueByReference.java](01_HelloWorld/src/main/java/p01_datatypes/E_ByValueByReference.java)

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

[01_HelloWorld/src/main/java/p01_datatypes/H_Operators.java](01_HelloWorld/src/main/java/p01_datatypes/H_Operators.java)

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

[01_HelloWorld/src/main/java/p01_datatypes/Z_SquareEq.java](01_HelloWorld/src/main/java/p01_datatypes/Z_SquareEq.java)

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

[01_HelloWorld/src/main/java/p02_cycles/Cycles.java](01_HelloWorld/src/main/java/p02_cycles/Cycles.java)

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
[01_HelloWorld/src/test/java/p01_datatypes/StringTest.java](01_HelloWorld/src/test/java/p01_datatypes/StringTest.java)

ООП
===

Основы объектно-ориентированного программирования: Класс. Экземпляр класса (объект)
-----------------------------------------------------------------------------------

**ООП** - Объектно-ориентированное программирование

**Класс** -

**Метод** -

Инкапсуляция. Полиморфизм. Интерфейсы. Абстрактные классы
---------------------------------------------------------

**Абстракция** - для создания класса нужно выделить
 из объектов (сущностей) предметной области важные
 с точки зрения решения конкретной (нашей) задачи
 характеристики (отбрасывая остальные).
 **Абстрагирование**.

**Инкапсуляция** (латинский: en capsula) - упаковка данных и функций в единый компонент.
В объектно-ориентированных языках инкапсуляция, как правило, реализуется посредством механизма классов.

**Наследование** - свойство системы, позволяющее описать новый класс на основе уже существующего
с частично или полностью заимствующейся функциональностью (данными и методами).
Класс, от которого производится наследование, называется **базовым**, **родительским** или **суперклассом**.
Новый класс - **потомком**, **наследником** или **производным** классом.

**Полиморфизм** - свойство системы использовать объекты с одинаковым интерфейсом без информации о
типе и внутренней структуре объекта.

Модификаторы public, protected, private, package local
------------------------------------------------------


Объектная модель. Состояние, поведение, индивидуальность (Гради Буч)
--------------------------------------------------------------------

Типы отношений между классами: наследование, аггрегация, ассоциация
-------------------------------------------------------------------

Множественное наследование. Делегирование
-----------------------------------------

Java не поддерживает множественное наследование реализаций (классов).
Это объясняется тем, что такое наследование порождает проблемы.
Чаще всего указываются неоднозначности, возникающие при так называемом "ромбовидном" наследовании,
когда один класс **A** является предком двух других классов **B** и **C**, причем и тот и другой являются предками класса **D**.

Вместо множественного наследования классов в Java есть множественное наследование интерфейсов,
при котором, как утверждается, никаких проблем не возникает.

``` java
    public interface I1 {
        void m1();
    }
```

[02_OOP/src/main/java/multi/Demo.java](02_OOP/src/main/java/multi/Demo.java)

``` java
    // Без модификатора
    // Поле доступно в текущем пакете
    int packageLocal = 1;

    // Только внутри класса A
    private int onlyInA = 2;

    // Внутри класса A и всех наследников A
    // + внутри пакета
    protected int withSubclasses = 3;

    // Доступно всем
    public int forAll = 4;
```

[02_OOP/src/main/java/n_public_private_protected/A.java](02_OOP/src/main/java/n_public_private_protected/A.java)

``` java
public class B extends A {

    void methodB(){
        packageLocal = 10; // Видна везде внутри пакета
        withSubclasses = 20; // Видна так как B - потомок A
        forAll = 30;  // Видна всем
       // onlyInA = 10; // Не видна, т.к. с модификатором public в A
    }
}
```

[02_OOP/src/main/java/n_public_private_protected/B.java](02_OOP/src/main/java/n_public_private_protected/B.java)

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

[04_JUnit/src/main/java/util/IntToStr.java](04_JUnit/src/main/java/util/IntToStr.java)

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

[04_JUnit/src/test/java/MyClassTest.java](04_JUnit/src/test/java/MyClassTest.java)

``` java
// Любое значение X
public class AnyXException extends RuntimeException {
}
```

[05_SquareEq/src/main/java/AnyXException.java](05_SquareEq/src/main/java/AnyXException.java)

``` java
    // Точность вычислений
    public static final double DELTA = 0.000000001;

    /**
     * Решение квадратного уравнения: ax^2 + bx + c = 0
     *
     * @param a коэффициент уравнения a
     * @param b коэффициент уравнения b
     * @param c коэффициент уравнения c
     * @return массив решений уравнения
     */
    public static double[] solve(double a, double b, double c) throws AnyXException {
        // Обработка вырожденных случаев
        if (abs(a) < DELTA) {
            if (abs(b) < DELTA) {
                if (abs(c) < DELTA)
                    throw new AnyXException();
                return new double[]{};
            }
            return new double[]{-c / b};
        }

        // Вычислим дискриминант
        double D = pow(b, 2) - 4 * a * c;

        // Если D = 0 => одно решение
        if (abs(D) < DELTA) {
            return new double[]{-b / (2 * a)};
        }

        // Если D > 0 => 2 решения
        if (D > 0) {
            return new double[]{
                    (-b - sqrt(D)) / (2 * a),
                    (-b + sqrt(D)) / (2 * a)
            };
        }
        // Нет решений
        return new double[]{};
    }
```

[05_SquareEq/src/main/java/SquareEq.java](05_SquareEq/src/main/java/SquareEq.java)

``` java
    @Test
    public void testSimple() {
        // assertEquals( ожидаемое_значение, вычисленное значение )
        //       сообщение_если_значения_не_равны, ..., ...
        // a*x^2 + b*x + c = 0
        assertArrayEquals("x^2 = 0",
                new double[]{0.0},
                SquareEq.solve(1.0, 0.0, 0.0), DELTA);
    }
```

``` java
    @Test
    public void twoSolutions() {
        assertArrayEquals("x^2 - 1 = 0",
                new double[]{-1.0, 1.0},
                SquareEq.solve(1.0, 0.0, -1.0), DELTA);
        assertArrayEquals("x^2 - 4 = 0",
                new double[]{-2.0, 2.0},
                SquareEq.solve(1.0, 0.0, -4.0), DELTA);
    }

    /**
     * Отдельный тест когда b != 0
     */
    @Test
    public void twoSolutionsBNotNull() {
        // (x-1)(x-2) = x^2 - 3x + 2
        assertArrayEquals("x^2 - 3x + 2 = 0",
                new double[]{1.0, 2.0},
                SquareEq.solve(1.0, -3.0, 2.0), DELTA);
    }
```

``` java
    @Test
    public void testZeroAZeroB() {
        assertArrayEquals("1 = 0",
                new double[]{},
                SquareEq.solve(0.0, 0.0, 1.0), DELTA);
    }
```

``` java
    @Test(expected = AnyXException.class)
    public void testZeroAZeroBZeroC() {
        assertArrayEquals("0 = 0",
                new double[]{},
                SquareEq.solve(0.0, 0.0, 0.0), DELTA);
    }
```

[05_SquareEq/src/test/java/SquareEqTest.java](05_SquareEq/src/test/java/SquareEqTest.java)

``` java
        Scanner s = new Scanner(System.in);
        // Два числа с клавиатуры
        int a = s.nextInt();
        int b = s.nextInt();
        // Считаем их сумму
        int sum = a + b;
        System.out.println("Сумма = " + sum);
```

[08_ConsoleDemo/src/main/java/ConsoleInput.java](08_ConsoleDemo/src/main/java/ConsoleInput.java)

Домашнее задание: Придумать объектную модель резюме
---------------------------------------------------

Что хранить о пользователе?
Что хранить о работодателе?

1. Зарегистрироваться на http://github.com + присоединиться к организации levelp.
2. Создать проект. JobSite. ResumeModel.
3. Создать текстовый файл с описанием информации
которую мы будем хранить о пользователе.
4. Прислать ссылку на StDen@mail.ru





﻿Графические библиотеки (обзор): AWT, Swing, JavaFX
--------------------------------------------------
* AWT (Abstract Window Toolkit) - исходная платформо-независимая оконная библиотека графического интерфейса
 (Widget toolkit) языка Java
* Swing - библиотека для создания графического интерфейса для программ на языке Java.
* JavaFX - платформа для создания RIA, позволяет строить унифицированные приложения
с насыщенным графическим интерфейсом пользователя для непосредственного запуска из-под операционных систем,
работы в браузерах и на мобильных телефонах, в том числе, работающих с мультимедийным содержимым.

﻿Домашнее задание
-----------------
* Зарегистироваться на github.com
* Отправить свой логин на почту: super.denis@gmail.com denis.stepulenok@oracle.com
Я добавлю вас в группу: https://github.com/levelp
* Этот файл: https://github.com/levelp/java_01/homework.md
* Скачать и установить себе JavaSE:
http://www.oracle.com/technetwork/java/javase/downloads/index.html
* https://www.jetbrains.com/idea/download/ - Idea Ultimate Edition
* Зарегистироваться на https://account.jetbrains.com/login
и активировать Idea

Подумать о проекте, о предметной области
----------------------------------------
* Классы, поля, методы
* Алгоритмы
* Сценарии использования

Решение квадратного уравнения a*x^2 + b*x + c = 0
-------------------------------------------------
 * Вводим с клавиатуры или из файла a, b, c
 * Выводим весь процесс решения и результаты на экран (в консоль) или в файл
 * a = 0, b = 0, c = 0  =>  x - любое


Разложение на слагаемые (рекурсия, массивы)
-------------------------------------------
Пользователь вводит натуральное число N
Надо вывести все разложения на слагаемые.
Разложения отличающиеся порядком слагаемых считаются одинаковыми.
```
N = 4
4 = 4
4 = 3 + 1
4 = 2 + 2
4 = 2 + 1 + 1
4 = 1 + 1 + 1 + 1
```
N <= 100

Скобочные последовательности
----------------------------
N - количество открывающих скобок = количество закрывающих скобок
Вывести в лексикографическом порядке все правильные скобочные последовательности из N пар скобок.
```
N = 1
()
```
```
N = 2
(())
()()
```
```
N = 3
((()))
(()())
(())()
()(())
()()()
```
```
N = 4
(((())))
((()()))
((())())
((()))()
(()(()))
(()()())
(()())()
(())(())
(())()()
()((()))
()(()())
()(())()
()()(())
()()()()
```




Добавить себя в список
----------------------
https://github.com/levelp/ToDoList



Проекты для совместной разработки
=================================

JobSite - сайт с резюме (для поиска работы)
------------------------------------------
*

ToDoList - список задач + синхронизация
---------------------------------------
* Олег
* Сергей Х.
* Дмитрий Ч.
* Иван З.
* Виталий Королёв


Ваши проекты....
*


Web-приложение для управления банковскими счетами
(применяемые технологии: Spring, Hibernate, Maven, Tomcat, Git,...; DB: Postgresql;
м.б. многопоточность, масштабируемость (???) ...):
- хранить данные о клиентах банка (id, name, address,...), счетах(id, id владельца, сумма);
- транзакции и переводы денег м/д счетами или их поступления/списания;
- приложение должно содержать формы: список клиентов банка, при щелчке по имени открываются счета выбранного клиента;
- список счетов заданного клиента (+ форма для добавления нового счета);
- форма для перевода денег м/д счетами и для пополнения/списания денег: затраты, покупки ...;
- страница со списком транзакций (+ форма фильтра, чтобы можно было выбрать за период и/или по заданному клиенту;
- дополнения на вкус.

--------------------------------------------------------------------
* Вячеслав С.


