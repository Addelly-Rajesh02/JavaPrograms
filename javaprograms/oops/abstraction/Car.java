package oops.abstraction;

class Car extends Vehicle   // Concrete implementation (hidden details)
{
    @Override
    void accelerate()
    {
        System.out.println("accelerated");        // Hidden complex logic: fuel injection, gear shifting, etc.
    }

    @Override
    void brake()
    {
        System.out.println("applied brake");      // Hidden logic: hydraulic pressure, brake pads, etc.
    }
}