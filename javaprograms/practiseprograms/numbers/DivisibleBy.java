package practiseprograms.numbers;

import java.util.Scanner;

public class DivisibleBy {
    public static boolean isDivisibleBy(int number, int divisibleBy){
        if((number%divisibleBy)==0)
            return true;
        return false;
    }
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter a number which you want to divide by");
        int number=scanner.nextInt();
        System.out.println("Enter a number you want to check disible by");
        int divisibleBy=scanner.nextInt();
        if(number<divisibleBy){
            System.out.println("number should be greater than divisor");
            return;
        }
        if(isDivisibleBy(number, divisibleBy)){
            System.out.println(number+ " is divisible by "+divisibleBy);
        }
        else{
            System.out.println(number+ " is not divisible by "+divisibleBy);
        }
    }
}
