// Класс для демонстрации различных видов исключений
public class MyClass {
    public static void main(String[] args)
            throws MyException {
        MyClass myClass = new MyClass();
        try {
            myClass.method1(1);
        } catch (MyRuntimeException e) {
            System.out.println("Поймал: "
                    + e);
        }
        myClass.method1(2);
        myClass.method1(3);
    }

    private void method1(int exceptionNumber) throws MyException {
        switch (exceptionNumber) {
            case 1:
                throw new MyRuntimeException();
            case 2:
                throw new MyError();
            case 3:
                throw new MyException();
        }
    }
}
