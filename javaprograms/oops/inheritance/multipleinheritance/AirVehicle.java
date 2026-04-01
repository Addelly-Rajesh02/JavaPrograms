package oops.inheritance.multipleinheritance;

public interface AirVehicle
{
    default void airInfo()
    {
        System.out.println("This is a Air Vehicle");
    }
}