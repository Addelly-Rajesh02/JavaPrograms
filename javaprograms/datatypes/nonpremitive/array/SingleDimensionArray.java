package datatypes.nonpremitive.array;

import java.util.Scanner;

public class SingleDimensionArray
{

    public static int[] returnArray()
    {
        return new int[]{ 1,2,3,4,5,6,7,8,9};
    }

    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);

        int[] arr = { 0,1,2,3,4,5,6,7,8};
        int n = arr.length;
        for (int j : arr) {
            System.out.print(j + " ");
        }

        System.out.println();
        System.out.println("Enter size of array: ");
        int size=scanner.nextInt();
        System.out.println("Enter array elements: ");
        int[] aar=new int[size];
        for(int i=0;i<size;i++){
            aar[i]=scanner.nextInt();
        }
        for(int x:aar){
            System.out.print(x+" ");
        }

        int[] ar=returnArray();
        System.out.println();
        for(int i=0;i<n;i++) {
            System.out.print(ar[i]+" ");
        }
    }

}
