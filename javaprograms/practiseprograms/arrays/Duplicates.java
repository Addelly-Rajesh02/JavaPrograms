package practiseprograms.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Duplicates {
    public static boolean duplicates(int[] arr, int n){
        Arrays.sort(arr);
        for(int i=0;i<n-1;i++){
            if(arr[i]==arr[i+1])
                return true;
        }
        return false;
    }


    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter size of array: ");
        int n= scanner.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter "+n+" elements of array: ");
        for(int i=0;i<n;i++){
            arr[i]= scanner.nextInt();
        }
        if(duplicates(arr, n)){
            System.out.println("Duplicates found");
        }
        else {
            System.out.println("Duplicates not found");
        }
    }
}
