package practiseprograms.arrays;

import java.util.Scanner;

public class RemoveDuplicates {

    private static int removeDuplicatesInPlace(int[] arr, int n) {
        if (n == 0) return 0;
        int k = 0;
        for (int i = 0; i < n; i++) {
            boolean seen = false;
            for (int j = 0; j < k; j++) {
                if (arr[i] == arr[j]) {
                    seen = true;
                    break;
                }
            }
            if (!seen) {
                arr[k] = arr[i];
                k++;
            }
        }
        return k;
    }

    public static void removeDuplicates() {
        Scanner scanner = new Scanner(System.in);
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
        int newLen = removeDuplicatesInPlace(arr, n);
        System.out.println("\nArray after removing duplicates:");
        if (newLen == 0) {
            System.out.println("[]");
        } else {
            System.out.print("[");
            for (int i = 0; i < newLen; i++) {
                System.out.print(arr[i]);
                if (i < newLen - 1) System.out.print(", ");
            }
            System.out.println("]");
        }

        scanner.close();
    }

    public static void main(String[] args) {
        removeDuplicates();
    }
}