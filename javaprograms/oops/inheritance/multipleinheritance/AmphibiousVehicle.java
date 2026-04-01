package oops.inheritance.multipleinheritance;

class AmphibiousVehicle implements LandVehicle, AirVehicle
{
    AmphibiousVehicle()
    {
        System.out.println("This is an Amphibious Vehicle");
    }
}