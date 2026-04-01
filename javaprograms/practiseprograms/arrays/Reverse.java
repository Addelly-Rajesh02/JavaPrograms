package practiseprograms.arrays;

import java.util.Scanner;

public class Reverse {
    public static void reverseArray(int arr[], int n){
        int temp, start=0, end=n-1;
        while(start<end){
            temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
        for(int a:arr){
            System.out.print(a+" ");
        }
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter size of array:");
        int n=scanner.nextInt();
        System.out.println("Enter "+n+" array elements:");
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scanner.nextInt();
        }
        reverseArray(arr,n);
    }
}
