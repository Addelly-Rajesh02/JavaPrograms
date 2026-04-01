package practiseprograms.numbers;

import java.util.Scanner;

public class HavingRemainderWhenDividedBy {
    public static int remainder(int number, int divisor){
        return number%divisor;
    }
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int number=scanner.nextInt();
        int divisor=scanner.nextInt();
        System.out.println(remainder(number,divisor));
    }
}
