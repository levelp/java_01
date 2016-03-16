package exceptions;

public class MyException extends Exception {
    String myStringParam;
    int intParam;

    public MyException(){
        super("MyException");
    }
}
