/***
 *
 * This is a method reference by static method
 */

public class MethodReference {
    public static void saySomethingHere(){
        System.out.println("Method Ref in action.");
    }

    public static void main(String[] args) {
        Sayable sayable = MethodReference::saySomethingHere;
        sayable.say();
    }
}
interface Sayable{
    void say();
}