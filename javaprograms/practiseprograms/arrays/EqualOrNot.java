package practiseprograms.arrays;

import java.util.Scanner;
import java.util.Arrays;
public class EqualOrNot {

    private static boolean arraysAreEqual(int[] a, int[] b) {
        if (a == b) return true;
        if (a == null || b == null) return false;
        if (a.length != b.length) return false;

        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }

    public static void isEqual() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter size of arrays: ");
            int n = scanner.nextInt();

            if (n < 0) {
                System.out.println("Size cannot be negative.");
                return;
            }

            int[] arr1 = new int[n];
            int[] arr2 = new int[n];

            System.out.println("Enter " + n + " elements for Array 1:");
            for (int i = 0; i < n; i++) {
                arr1[i] = scanner.nextInt();
            }

            System.out.println("Enter " + n + " elements for Array 2:");
            for (int i = 0; i < n; i++) {
                arr2[i] = scanner.nextInt();
            }

            boolean equalManual = arraysAreEqual(arr1, arr2);

            boolean equalUsingLib = Arrays.equals(arr1, arr2);

            System.out.println("\nArray 1: " + Arrays.toString(arr1));
            System.out.println("Array 2: " + Arrays.toString(arr2));

            System.out.println("\nAre arrays equal? " + (equalManual ? "YES" : "NO"));
            System.out.println("(Using Arrays.equals) -> " + (equalUsingLib ? "YES" : "NO"));
        }
    }

    public static void main(String[] args) {
        isEqual();
    }
}
