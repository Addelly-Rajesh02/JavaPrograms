package decisionmaking.conditionalstatements;

import java.util.Scanner;

public class If
{
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter a number: ");
        int i=scanner.nextInt();
        if (i < 15)
            System.out.println("Inside If block");
        System.out.println("Entered number is less than 15");
        System.out.println("I am Not in if");
    }
}
