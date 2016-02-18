package p00_helloworld;

public class IdeaLive2 {
    public static void main(String[] args) {
        System.out.println("Hello!");
        int var = 10;
        System.out.println("var = " + var);
        int i1 = 10;
        int i2;
        int i3;
        System.out.println("i1 = " + i1);

        myFunction(10);
    }

    private static String myFunction(double myParam) {
        return "myParam = " + myParam;
    }
}
