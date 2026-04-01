package practiseprograms.numbers;

import java.util.Scanner;

public class DigitsSum {
    public static int digitSum(int n){
        int sum=0;
        while(n>0){
            int temp=n%10;
            sum+=temp;
            n/=10;
        }
        return sum;
    }
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter a number to find sum of digits: ");
        int n=scanner.nextInt();
        System.out.println("sum of digits: "+digitSum(n));
    }
}
