package inheritance;

public class SubClass extends SuperClass {

    public SubClass() {
        //super(); // Вызываем конструктор суперкласса
        System.out.println("Подкласс");
    }

    public static void main(String[] args) {
        SubClass subClass = new SubClass();
    }
}
