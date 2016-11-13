import exceptions.MyException;
import exceptions.MyRuntimeException;

public class ExceptionsDemo {
    public static void main(String[] args) throws MyException {
        if(1 < 2)
            throw new MyRuntimeException("xxx");
        if(1 < 2)
            throw new MyException();
    }
}
