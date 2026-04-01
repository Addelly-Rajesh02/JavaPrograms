package operators;

import java.util.Scanner;

public class TernaryOperators {
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter number for a: ");
        int a=scanner.nextInt();
        System.out.print("Enter number for b: ");
        int b=scanner.nextInt();
        System.out.print("Enter number for c: ");
        int c =scanner.nextInt();
//        int result = ((a > b) ? (a > c) ? a : c : (b > c) ? b : c);
//        result holds max of three

        int result = ((a > b) ? Math.max(a, c) : Math.max(b, c));
        System.out.println("Max of three numbers = "+ result);
    }
}
