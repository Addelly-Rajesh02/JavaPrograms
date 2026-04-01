package practiseprograms.numbers;

import java.util.Scanner;

public class Reverse {
    public static int reverse(int n){
        int reverse=0;
        while (n>0) {
            int temp=n%10;
            reverse=(reverse*10)+temp;
            n/=10;
        }
        return reverse;
    }
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int number=scanner.nextInt();
        System.out.println(reverse(number));
    }
}
