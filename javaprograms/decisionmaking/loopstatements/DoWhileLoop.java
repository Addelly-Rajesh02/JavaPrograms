package decisionmaking.loopstatements;

import java.util.Scanner;

public class DoWhileLoop {
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter a number: ");
        int i=scanner.nextInt();
        do
        {
            System.out.print(i + " ");
            i++;
        } while (i <= 10);
    }
}
