package n_public_private_protected_user;

import n_public_private_protected.A;

/**
 *
 */
public class UserClass {

    public static void main(String[] args) {
        A a = new A();
        a.forAll = 10;
        //a.withSubclasses = 10;
        //System.out.println("a.withSubclasses = " + a.withSubclasses);
    }
}
