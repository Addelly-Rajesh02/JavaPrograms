package operators;

public class UnaryOperators {
    public static void main(String[] args)
    {
        // Integer declared
        int a = 10;
        int b = 10;
        // Using unary operators
        System.out.println("Post increment : " + (a++));
        System.out.println("Pre increment : " + (++a));

        System.out.println("Post decrement : " + (b--));
        System.out.println("Pre decrement : " + (--b));
    }
}
