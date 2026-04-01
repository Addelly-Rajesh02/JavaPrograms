package practiseprograms.numbers;

import java.util.Scanner;

public class PerfectSquares {
    public static Boolean perfectSquares(int n) {
        if (n < 0) return false;
        if (n < 2) return true; // 0 and 1 are perfect squares

        long x = n;
        while (x * x > n) {
            x = (x + n / x) / 2;
        }
        return x * x == n;
    }
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n=scanner.nextInt();
        if(perfectSquares(n)){
            System.out.println("Perfect Square");
        }
        else {
            System.out.println("Not perfect square");
        }
    }
}
