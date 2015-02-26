package p01_datatypes;

import static org.junit.Assert.assertEquals;

//
// Передача параметров по ссылке и значению
// ----------------------------------------
public class E_ByValueByReference {

    public static void main(String[] args) {
        // i примитивного типа - передаётся по значению
        //-->
        int i = 10;
        assertEquals("Перед вызовом method1", 10, i);
        method1(i);
        assertEquals("После вызова method1", 10, i);
        //<--

        //-->
        MyClass object = new MyClass();
        object.i = 10;
        myMethod2(object);
        assertEquals("После вызова myMethod2", 30, object.i);
        //<--
    }

    // i значение копируется
    //-->
    static void method1(int i) {
        i += 20;
        assertEquals("method1: ", 30, i);
    }
    //<--

    // i передаётся по ссылке
    //-->
    static void myMethod2(MyClass i) {
        i.i += 20;
        assertEquals("myMethod2: ", 30, i.i);
    }
    //<--

    //-->
    static class MyClass {
        int i;
    }
    //<--
}
