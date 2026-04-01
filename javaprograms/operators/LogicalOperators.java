package operators;

import java.util.Scanner;

public class LogicalOperators
{
    public static void main (String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter Boolean values True or False");
        System.out.print("Enter x: ");
        boolean x = scanner.nextBoolean();
        System.out.print("Enter y: ");
        boolean y = scanner.nextBoolean();
        System.out.println("x && y: " + (x && y));
        System.out.println("x || y: " + (x || y));
        System.out.println("!x: " + (!x));
    }
}
