package inheritance;

public class SubClass extends SuperClass {

    public SubClass() {
        super(10); // Вызываем конструктор суперкласса
        System.out.println("Конструктор Подкласса");
    }

    public static void main(String[] args) {
        SubClass subClass = new SubClass();
    }
}
