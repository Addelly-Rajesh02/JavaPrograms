package oops.polymorphism;
// Child Class
class Child extends Parent {
    // Overrides Parent.func(int) (runtime polymorphism)
    @Override
    public void func(int a) {
        System.out.println("Child.func(int): " + a);
    }

}
