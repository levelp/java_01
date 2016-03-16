package p00_helloworld;


// Шаблоны Idea для быстрого ввода кода: psvm, sout+v/m, fori...
// -------------------------------------------------------------
public class IdeaLiveTemplates {
    //-->
    // Шаблон: psvm + <tab>
    // [p]ublic [s]tatic [v]oid [m]ain
    public static void main(String[] args) {
        // sout
        System.out.println();
        System.out.println("Hello world!");
        // soutv - + вывести значение последней переменной
        int ii = 10;
        System.out.println("ii = " + ii);
        int i1 = 1;
        int i2 = 2;
        int i3 = 3;
        System.out.println("i3 = " + i3);
        // soutm + <tab> - название метода
        System.out.println("IdeaLiveTemplates.main");
        System.out.println("args = [" + args + "]");

        // fori + <tab> - цикл по целочисленной переменной
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    for (int l = 0; l < 10; l++) {
                        for (int m = 0; m < 10; m++) {
                            for (int n = 0; n < 10; n++) {
                                for (int o = 0; o < 10; o++) {
                                    for (int p = 0; p < 10; p++) {
                                        for (int q = 0; q < 10; q++) {

                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        for (int j = 0; j < 10; j++) {
            System.out.println("j = " + j);
        }
        for (int j = 0; j < 10; j++) {
            for (int k = 0; k < 10; k++) {
                System.out.println(j * k);
            }
        }
    }
    //<--
}
