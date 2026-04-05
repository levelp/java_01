package n_public_private_protected;

/**
 *
 */
public class A {
    //-->
    // Без модификатора
    // Поле доступно в текущем пакете
    int packageLocal = 1;

    // Только внутри класса A
    private int onlyInA = 2;

    // Внутри класса A и всех наследников A
    // + внутри пакета
    protected int withSubclasses = 3;

    // Доступно всем
    public int forAll = 4;
    //<--
}
