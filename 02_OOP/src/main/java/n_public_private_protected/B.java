package n_public_private_protected;

// Класс B - наследник класса A (в том же пакете)
//-->
public class B extends A {

    void methodB(){
        packageLocal = 10; // Видна везде внутри пакета
        withSubclasses = 20; // Видна так как B - потомок A
        forAll = 30;  // Видна всем
       // onlyInA = 10; // Не видна, т.к. с модификатором public в A
    }
}
//<--
