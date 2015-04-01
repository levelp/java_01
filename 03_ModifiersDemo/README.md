<!-- doc.py -->
Поле недоступно, т.к. другой пакет
packageField = 10;
[src/main/java/D.java](src/main/java/D.java)

Доступно везде
Внутри класса A и во всех наследниках
Внутри класса A
во всех классах внутри этого пакета
Только внутри класса A
[src/main/java/mypackage/A.java](src/main/java/mypackage/A.java)

privateField = 2;
[src/main/java/mypackage/B.java](src/main/java/mypackage/B.java)

Нет доступа из другого пакета
a.packageField = 10;
[src/test/java/ATest2.java](src/test/java/ATest2.java)

