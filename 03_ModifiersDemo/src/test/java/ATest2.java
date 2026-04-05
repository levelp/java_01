import mypackage.A;

/**
 *
 */
public class ATest2 {

    public static void main(String[] args) {
        A a = new A();
        // Нет доступа из другого пакета
        //a.packageField = 10;
    }
}
