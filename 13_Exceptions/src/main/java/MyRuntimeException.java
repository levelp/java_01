/**
 * Неконтроллируемое исключение
 */
public class MyRuntimeException extends RuntimeException {
    public MyRuntimeException() {
        System.out.println("MyRuntimeException.MyRuntimeException");
    }
}
