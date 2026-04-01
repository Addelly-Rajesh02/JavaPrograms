package practiseprograms.numbers;

import java.util.Scanner;

public class Palindrome {
    public static boolean isPalindrome(int n){
        int reverse=0, num=n;
        while (n>0){
            int temp=n%10;
            reverse=(reverse*10)+temp;
            n/=10;
        }
        if(reverse==num)
            return true;
        return false;
    }

    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter number to find Palindrome: ");
        int n=scanner.nextInt();
        if(isPalindrome(n))
            System.out.println("Palindrome");
        else
            System.out.println("Not a Palindrome");

        System.out.println("Enter number to find next Palindrome: ");
        int palindrome=scanner.nextInt();
        while(!isPalindrome(palindrome)){
                palindrome++;
        }
        System.out.println("Next Palindrome: "+palindrome);
    }
}
