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
        System.out.println("Перед вызовом method1 i = " + i);
        method1(i);
        assertEquals("После вызова method1", 10, i);
        System.out.println("После вызова method1 i = " + i);
        //<--

        //-->
        MyClass object = new MyClass();
        object.i = 10;
        assertEquals("Перед вызовом method2", 10, object.i);
        System.out.println("Перед вызовом method2 object.i = " + object.i);
        myMethod2(object);
        assertEquals("После вызова myMethod2", 30, object.i);
        System.out.println("После вызова method2 object.i = " + object.i);
        //<--
    }

    // i значение копируется
    //-->
    static void method1(int i) {
        i += 20;
        System.out.println("method1: i = " + i);
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
