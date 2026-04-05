package package2;

/**
 * Тест в том же пакете
 */
public class TestInSamePackage {
    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        // Поле в том же пакете
        myClass.field1 = 10;

        // Не работает: myClass.privateField
    }
}
