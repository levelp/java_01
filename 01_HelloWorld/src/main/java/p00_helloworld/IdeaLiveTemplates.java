package p00_helloworld;


// Шаблоны Idea для быстрого ввода кода: psvm, sout+v/m, fori...
// -------------------------------------------------------------
public class IdeaLiveTemplates {
    //-->
    // Шаблон: psvm + <tab>
    public static void main(String[] args) {
        // sout
        System.out.println();
        System.out.println("Hello world!");
        // soutv - + вывести значение последней переменной
        int i = 10;
        System.out.println("i = " + i);
        // soutm + <tab> - название метода
        System.out.println("IdeaLiveTemplates.main");

        // fori + <tab> - цикл по целочисленной переменной
        for (int j = 0; j < 10; j++) {
            System.out.println("j = " + j);
        }
        for (int j = 0; j < 10; j++) {
            for (int k = 0; k < 10; k++) {
                System.out.println(i * j);
            }
        }
    }
    //<--
}
