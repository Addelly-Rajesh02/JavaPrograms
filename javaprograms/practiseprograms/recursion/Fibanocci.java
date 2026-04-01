package practiseprograms.recursion;

import java.util.Scanner;

public class Fibanocci {
    static int n1=0, n2=1, n3=0;
    static void fibanocci(int n){
        if(n>0){
            n3=n1+n2;
            n1=n2;
            n2=n3;
            System.out.print(" "+n3);
            fibanocci(n-1);
        }
    }
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter any interger to find the fibanocci series:");
        int n=scanner.nextInt();
        System.out.println("Fibanocci series: ");
        System.out.print(n1+" "+n2);
        fibanocci(n-2);
    }
}
