package n_public_private_protected;

// Пользовательский класс внутри того же пакета
public class UserClassInSamePackage {

    public static void main(String[] args) {
        A a = new A();
        a.forAll = 10;
        a.withSubclasses = 10;
        System.out.println("a.withSubclasses = " + a.withSubclasses);
        a.packageLocal = 11;
    }
}
