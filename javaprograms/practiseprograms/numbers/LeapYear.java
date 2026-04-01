package practiseprograms.numbers;

import java.util.Scanner;

public class LeapYear {
    public static boolean leapYear(int n){
        if(n%4==0)
            return true;
        return false;
    }
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter a number to find leap year: ");
        int n=scanner.nextInt();
        if(leapYear(n))
            System.out.println("Leap year");
        else
            System.out.println("not a leap year");

        System.out.println("Enter a number to find next leap year: ");
        int leapYear=scanner.nextInt();
        while(!leapYear(leapYear)){
            leapYear++;
        }
        System.out.println("Next leap year: "+leapYear);
    }

}
