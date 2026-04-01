package decisionmaking.jumpstatements;

import java.util.Scanner;

public class Break {
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n=scanner.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scanner.nextInt();
        }
        for (int i=0; i < n; i++)
        {
            if (arr[i] % 2 == 0)
                break;
            System.out.print(i + " ");
        }
    }
}
