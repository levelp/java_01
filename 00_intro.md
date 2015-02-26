ООП. Первое Java приложение
===========================

Знакомство
----------

Степулёнок Денис Олегович - Stden@mail.ru

Для скачивания
--------------
* Скачать Java SE: http://www.oracle.com/technetwork/java/javase/downloads/index.html
* https://www.jetbrains.com/idea/download/ - Idea Ultimate Edition + серийный номер

Почему Java?
------------
* http://www.tiobe.com/index.php/content/paperinfo/tpci/index.html - TIOBE Index
* http://readwrite.com/2014/01/08/in-demand-tech-skills-of-2013-java - Популярность Java

Обзор сайтов и литературы по Java и ООП
---------------------------------------

**Сайты**
* http://vk.com/java_course - группа для участников курса
* http://levelp.ru/courses/programmirovanie/java-junior-developer/ - 
курс Java Junior Developer на сайте LevelUp
* http://levelp.ru/courses/programmirovanie/basics-of-programming-java/ - 
курс "Основы программирования и алгоритмизации на языке Java" на на сайте LevelUp
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
* Effective Java, автор Joshua Bloch. 
* Программист Прагматик (The Pragmatic Programmer) - подробно раскрыты общие методики программирования (книга похожа на сборник полезных советов)
* Java concurrency in practice. - Многопоточность в Java.
http://www.amazon.com/Java-Concurrency-Practice-Brian-Goetz/dp/0321349601
* Книга: Экстремальное программирование: разработка через тестирование
http://www.booksgid.com/programmer/4686-jekstremalnoe-programmirovanie.html
* Джошуа Блох "Java. Эффективное программирование" http://www.ozon.ru/context/detail/id/21724143/
TODO: Навести порядок в книгах
+ добавить ссылку на группу в альюом с внешним видом

Установка и настройка Java
--------------------------
* Скачать Java-plugin (выполнение Java-апплетов, Java Web Start): https://java.com/ru/download
* Скачать Java SE: http://www.oracle.com/technetwork/java/javase/downloads/index.html

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

Для Windows x64:
----------------
* Java 64 устанавливается в: **C:\Program Files\Java** 
* Java x86 устанавливается в: **C:\Program Files (x86)\Java**

Платформа Java. JVM, сборка мусора, оптимизация, прогрев. JDK, JRE, ME, SE, EE
------------------------------------------------------------------------------
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

Варианты поставки Java
----------------------
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

Установка и настройка IntelliJ IDEA
-----------------------------------
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

Установка и настройка Apache Maven 
----------------------------------
* http://maven.apache.org/ - скачивание maven
* Распаковать в папку на диске, например в C:\apache-maven-3.2.3\
* Устанавливаем переменную окружения: M2_HOME=C:\apache-maven-3.2.3


Установка и настройка Git + GitHub
----------------------------------
* http://habrahabr.ru/post/125799/ - Как начать работать с GitHub: быстрый старт
* http://habrahabr.ru/post/147192/ - Изучить Github за 15 минут: https://try.github.io

Установка и настройка Apache Tomcat
-----------------------------------
* http://archive.apache.org/dist/tomcat/tomcat-8/v8.0.9/bin/apache-tomcat-8.0.9.zip - скачивание Apache Tomcat
* Распаковать в папку на диске, например в 

