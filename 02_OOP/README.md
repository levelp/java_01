<!-- doc.py -->
Основы объектно-ориентированного программирования: Класс. Экземпляр класса (объект)
-----------------------------------------------------------------------------------

**ООП** - Объектно-ориентированное программирование


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

Не может содержать реализации методов
int implementation(){
int i = 2;
}
Не может содержать полей
int x;
[src/main/java/MyInterface.java](src/main/java/MyInterface.java)

myClass.privateField - нет доступа
[src/main/java/Test1.java](src/main/java/Test1.java)

super(); // Вызываем конструктор суперкласса
[src/main/java/inheritance/SubClass.java](src/main/java/inheritance/SubClass.java)

public int a;
[src/main/java/multi/B.java](src/main/java/multi/B.java)

AbstractClass
[src/main/java/multi/Demo.java](src/main/java/multi/Demo.java)

Первый интерфейс
``` java
public interface I {
    void m1();
}
```

[src/main/java/multi/I.java](src/main/java/multi/I.java)

``` java
    // Без модификатора
    // Поле доступно в текущем пакете
    int packageLocal = 1;

    // Только внутри класса A
    private int onlyInA = 2;

    // Внутри класса A и всех наследников A
    protected int withSubclasses = 3;

    // Доступно всем
    public int forAll = 4;
```

[src/main/java/n_public_private_protected/A.java](src/main/java/n_public_private_protected/A.java)

Класс B - наследник класса A (в том же пакете)
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

[src/main/java/n_public_private_protected/B.java](src/main/java/n_public_private_protected/B.java)

Пользовательский класс внутри того же пакета
[src/main/java/n_public_private_protected/UserClassInSamePackage.java](src/main/java/n_public_private_protected/UserClassInSamePackage.java)

a.withSubclasses = 10;
System.out.println("a.withSubclasses = " + a.withSubclasses);
[src/main/java/n_public_private_protected_user/UserClass.java](src/main/java/n_public_private_protected_user/UserClass.java)

...
[src/main/java/package2/MyClass.java](src/main/java/package2/MyClass.java)

privateField = 11;
[src/main/java/package2/MyClassSubclass.java](src/main/java/package2/MyClassSubclass.java)

Поле в том же пакете
Не работает: myClass.privateField
[src/main/java/package2/TestInSamePackage.java](src/main/java/package2/TestInSamePackage.java)

