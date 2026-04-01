package oops.abstraction;

abstract class Vehicle
{

    abstract void accelerate();     // Abstract methods (what it can do)
    abstract void brake();          // Abstract methods (what it can do)
    void purchase()
    {
        System.out.println("purchased");   // Concrete method (common to all vehicles)
    }
}

