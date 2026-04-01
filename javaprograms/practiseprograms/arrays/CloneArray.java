package practiseprograms.arrays;

import java.util.Scanner;

import java.util.Arrays;
public class CloneArray {

    public static int[] cloneIntArray(int[] original) {
        return original.clone();
    }

    public static int[][] deepCopy2D(int[][] original) {
        int[][] copy = new int[original.length][];
        for (int i = 0; i < original.length; i++) {
            copy[i] = original[i].clone(); // clones each row
        }
        return copy;
    }

    public static void cloneArray() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter number of elements: ");
            int n = scanner.nextInt();

            if (n < 0) {
                System.out.println("Size cannot be negative.");
                return;
            }

            int[] arr = new int[n];
            System.out.println("Enter " + n + " integers:");
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            int[] cloned = cloneIntArray(arr);

            System.out.println("\nOriginal array: " + Arrays.toString(arr));
            System.out.println("Cloned array  : " + Arrays.toString(cloned));

            System.out.println("\nAre both references same? " + (arr == cloned));
            if (arr.length > 0) {
                arr[0] = arr[0] + 100;
                System.out.println("\nAfter modifying arr[0] += 100");
                System.out.println("Original array: " + Arrays.toString(arr));
                System.out.println("Cloned array  : " + Arrays.toString(cloned));
            }

            System.out.print("\nDo you want to see a 2D deep copy demo? (y/n): ");
            char ans = Character.toLowerCase(scanner.next().charAt(0));
            if (ans == 'y') {
                int[][] mat = {
                        {1, 2, 3},
                        {4, 5, 6}
                };
                int[][] shallow = mat.clone();
                int[][] deep = deepCopy2D(mat);

                mat[0][0] = 999;

                System.out.println("\nOriginal 2D     : " + Arrays.deepToString(mat));
                System.out.println("Shallow clone   : " + Arrays.deepToString(shallow));
                System.out.println("Deep copy (2D)  : " + Arrays.deepToString(deep));
            }
        }
    }

    public static void main(String[] args) {
        //cloneArray();
        Scanner scanner=new Scanner(System.in);
        System.out.println("enter size:");
        int n=scanner.nextInt();
        System.out.println("enter "+n+" array elements:");
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scanner.nextInt();
        }

        int[] a=arr.clone();
        int[] b=Arrays.copyOf(arr, arr.length);

        int[] c = new int[arr.length];
        System.arraycopy(arr, 0, c, 0, arr.length);

        cloneArray();

    }
}
