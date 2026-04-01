package decisionmaking.loopstatements;

import java.util.Scanner;

public class WhileLoop {

    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter a number: ");
        int i=scanner.nextInt();
        while (i <= 10) {
            System.out.print(i + " ");
            i++;
        }
    }
}
