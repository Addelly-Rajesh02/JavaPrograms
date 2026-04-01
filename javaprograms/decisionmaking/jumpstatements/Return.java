package decisionmaking.jumpstatements;

import java.util.Scanner;

public class Return {
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter true or false");
        boolean t = scanner.nextBoolean();
        System.out.println("Before the return.");
        if (t)
            return;
        System.out.println("Entered false.");
    }
}
