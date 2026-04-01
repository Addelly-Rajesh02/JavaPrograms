package oops.inheritance.multipleinheritance;

public interface LandVehicle
{
    default void landInfo()
    {
        System.out.println("This is a Land Vehicle");
    }
}