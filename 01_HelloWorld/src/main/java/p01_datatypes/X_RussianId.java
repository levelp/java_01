package p01_datatypes;

/**
 * Идентификаторы по-русски
 */
public class X_RussianId {

    public static void main(String[] args) {
        int перваяПеременная = 10;
        int втораяПеременная = 23;
        int сумма = перваяПеременная + втораяПеременная;
        System.out.println("сумма = " + сумма);

        мойМетод();
    }

    private static void мойМетод() {
        System.out.println("мойМетод");
    }
}
