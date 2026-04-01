package oops.polymorphism;

public class Polymorphism {
    public static void main(String[] args)
    {
        Parent parent = new Parent();
        Child child = new Child();
        // Dynamic dispatch
        Parent polymorphicObj = new Child();

        // Method Overloading (compile-time)
        parent.func();
        parent.func(10);

        // Method Overriding (runtime)
        child.func(20);

        // Polymorphism in action
        polymorphicObj.func(30);
    }
}
