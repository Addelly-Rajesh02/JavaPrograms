package oops.abstraction;

public class Abstraction
{
    public static void main(String[] args)
    {
        Vehicle myCar = new Car();
        myCar.purchase();
        myCar.accelerate();
        myCar.brake();
    }
}
