package decisionmaking.conditionalstatements;

import java.util.Scanner;

public class SwitchCase {
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num=scanner.nextInt();
        switch (num)
        {
            case 5:
                System.out.println("It is 5");
                break;
            case 10:
                System.out.println("It is 10");
                break;
            case 15:
                System.out.println("It is 15");
                break;
            case 20:
                System.out.println("It is 20");
                break;
            default:
                System.out.println("Not present");
        }
    }
}
