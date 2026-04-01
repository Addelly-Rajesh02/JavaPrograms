package decisionmaking.conditionalstatements;

import java.util.Scanner;

public class IfElse {
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter a number: ");
        int i=scanner.nextInt();
        if (i < 15)
            System.out.println("Entered number is smaller than 15");
        else
            System.out.println("Entered is greater than 15");
    }
}
