package operators;

import java.util.Scanner;

public class RelationalOperators {

    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter number for a: ");
        int a=scanner.nextInt();
        System.out.print("Enter number for b: ");
        int b=scanner.nextInt();
        System.out.print("Enter number for c: ");
        int c =scanner.nextInt();
        System.out.println("a > b: " + (a > b));
        System.out.println("a < b: " + (a < b));
        System.out.println("a >= b: " + (a >= b));
        System.out.println("a <= b: " + (a <= b));
        System.out.println("a == c: " + (a == c));
        System.out.println("a != c: " + (a != c));
    }
}
