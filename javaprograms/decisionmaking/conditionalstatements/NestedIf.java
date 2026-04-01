package decisionmaking.conditionalstatements;

import java.util.Scanner;

public class NestedIf {
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter a number: ");
        int i=scanner.nextInt();
        if (i < 15)
        {
            System.out.println("Entered number is smaller than 15");
            if (i == 10)
            {
                System.out.println("Entered number is exactly 10");
            }
        }
    }
}
