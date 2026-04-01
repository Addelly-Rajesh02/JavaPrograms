package practiseprograms.numbers;

import java.util.Scanner;

public class EvenOrOdd {

    public static int evenOrOdd(int n){
        if(n%2==0)
            return 1;
        return 0;
    }


    public static int isEven(int n){
        return (n&1);
    }


    public static boolean isEvenNumber(int n) {
        return ((n / 2) * 2 == n);
    }


    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter integer to find even or odd: ");
        int n=scanner.nextInt();
        //if(isEven(n)==0)
        if(isEvenNumber(n))
            System.out.println("Even");
        else
            System.out.println("Odd");
    }
}
