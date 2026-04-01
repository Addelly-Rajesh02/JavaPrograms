package oops.interfaces;

/**
 * interface InterfaceName {
 *     // Constant fields (public static final by default)
 *     int CONSTANT = 10;
 *     // Abstract method (public abstract by default)
 *     void methodName();
 *     // Default method (JDK 8+)
 *     default void defaultMethod() {
 *         System.out.println("Default implementation");
 *     }
 *     // Static method (JDK 8+)
 *     static void staticMethod() {
 *         System.out.println("Static method in interface");
 *     }
 *     // Private method (JDK 9+)
 *     private void privateMethod() {
 *         System.out.println("Private helper method");
 *     }
 * }
 * */
public class Interfaces
{
    public static void main (String[] args)
    {

        // Instance of Bicycle(Object)
        Bicycle bicycle = new Bicycle();

        bicycle.changeGear(2);
        bicycle.speedUp(3);
        bicycle.applyBrakes(1);

        System.out.print("Bicycle present state : ");
        bicycle.printStates();

        // Instance of Bike (Object)
        Bike bike = new Bike();
        bike.changeGear(1);
        bike.speedUp(4);
        bike.applyBrakes(3);

        System.out.print("Bike present state : ");
        bike.printStates();
    }

}
