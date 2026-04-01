package practiseprograms.numbers;

import java.util.Scanner;

public class Factorial {
    public static long factorial(int n){
        long fact=1;
        for(int i=1;i<=n;i++){
            fact*=i;
        }
        return fact;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter integer to find factorial: ");
        int n = scanner.nextInt();
        System.out.print("Factorial: "+factorial(n));
    }
}
