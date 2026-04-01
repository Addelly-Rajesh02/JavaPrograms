package operators;

public class ArithematicOperators {
    public static void main (String[] args)
    {
        // Arithmetic operators on integers
        int a = 10;
        int b = 3;
        System.out.println("a + b = " + (a + b));
        System.out.println("a - b = " + (a - b));
        System.out.println("a * b = " + (a * b));
        System.out.println("a / b = " + (a / b));
        System.out.println("a % b = " + (a % b));

        // Arithmetic operators on Strings
        String n1 = "15";
        String n2 = "25";
        System.out.println("n1 + n2 = " + (n1 + n2));

        // Convert Strings to integers
        int a1 = Integer.parseInt(n1);
        int b1 = Integer.parseInt(n2);
        System.out.println("a1 + b1 = " + (a1 + b1));



    }
}
