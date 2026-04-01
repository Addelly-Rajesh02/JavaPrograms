package practiseprograms.numbers;

import java.util.Scanner;

public class CountDigits {
    public static int countDigits(int n){
        if(n==0)
            return 1;
        int count=0;
        while(n!=0){
            n/=10;
            count++;
        }
        return count;
    }
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter number to count digits: ");
        int n=scanner.nextInt();
        System.out.println("Entered number is a "+countDigits(n)+" digits number");
    }
}
