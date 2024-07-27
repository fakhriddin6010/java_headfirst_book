package chapter010;

// public class Foo {
//     static int x; // This should compile . But the only doubt is, very static variable has to be initialized right?
//     public void go() {
//     System.out.println(x);
//     }
//     }
    // public class Foo2 {
    // int x;
    // public static void go(){
    // System.out.println(x); // Cannot compile as a static method is trying to access a non static variable.
    // }
    // }
    // public class Foo3{
    // final int x;
    // public void go () { // everything seems to be fine, except , again, the final variable is not initialized.
    // System.out.println(x);
    // }
    // }
    public class Foo6{
    static final int X = 12; // This will compile
    public static void go( final int x) {
    System.out.println(X);
    }
    }
    // public class Foo5{
    // static final int X = 12;
    // public void go (final int x ){ // will compile
    // System.out.println(X);
    // }
    // }
    // public class Foo6 {
    // int x = 12;
    // public static void go (final int x){ // static method trying to access non static variable.
    // System.out.println(x);
    // }
    // }