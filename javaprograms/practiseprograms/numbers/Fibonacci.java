package practiseprograms.numbers;

import java.util.Scanner;

public class Fibonacci {
    public static void fibonacci(int n){
        int n1=0, n2=1, n3;
        System.out.print(n1+" "+n2);
        for(int i=2;i<n;i++){
            n3=n1+n2;
            System.out.print(" "+n3);
            n1=n2;
            n2=n3;
        }
    }

    public static int nthFibanocci(int n){
        if(n==0)
            return 0;
        else if(n==1)
            return 1;
        return nthFibanocci(n-1)+nthFibanocci(n-2);
    }

    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter a number to find fibanocci series");
        int n=scanner.nextInt();
        System.out.println("Fibanocci series is: ");
        fibonacci(n);
        System.out.println();
        System.out.println("Enter a number to find nth fibanocci series");
        int nthFibonacci=scanner.nextInt();
        System.out.println("Nth fibanocci is: ");
        System.out.println(nthFibanocci(nthFibonacci));
    }
}
