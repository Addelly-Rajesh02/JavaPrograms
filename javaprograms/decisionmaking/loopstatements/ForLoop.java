package decisionmaking.loopstatements;

import java.util.Scanner;

public class ForLoop {
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n=scanner.nextInt();
        for (int i = 0; i <= n; i++)
        {
            System.out.print(i + " ");
        }
    }
}
