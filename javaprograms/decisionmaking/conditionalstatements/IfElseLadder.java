package decisionmaking.conditionalstatements;

import java.util.Scanner;

public class IfElseLadder
{
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter a number: ");
        int i=scanner.nextInt();
        if (i == 10)
            System.out.println("Entered number is 10");
        else if (i == 15)
            System.out.println("Entered number is 15");
        else if (i == 20)
            System.out.println("Entered number is 20");
        else
            System.out.println("Entered number is not present");
    }
}
