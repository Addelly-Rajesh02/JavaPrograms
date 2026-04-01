package decisionmaking.jumpstatements;

import java.util.Scanner;

public class Continue {
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n=scanner.nextInt();
        int[] arr=new int[n];
        System.out.print("Enter array elements: ");
        for(int i=0;i<n;i++){
            arr[i]=scanner.nextInt();
        }
        for (int i = 0; i < 10; i++) {
            if (arr[i] % 2 == 0) {
                continue;
            }
            System.out.print(arr[i] + " ");

        }
    }
}
