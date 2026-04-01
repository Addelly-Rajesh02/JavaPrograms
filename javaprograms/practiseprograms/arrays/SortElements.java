package practiseprograms.arrays;

import java.util.Scanner;

public class SortElements {

    private static void selectionSortAscending(int[] arr, int n) {
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;
        }
    }

    private static void selectionSortDescending(int[] arr, int n) {
        for (int i = 0; i < n - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[maxIdx]) {
                    maxIdx = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = temp;
        }
    }

    private static void printArray(int[] arr, int n) {
        System.out.print("[");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]);
            if (i < n - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    public static void sort() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = scanner.nextInt();

        if (n < 0) {
            System.out.println("Invalid size.");
            return;
        }

        int[] arr = new int[n];
        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.print("Sort order Ascending or Descending? (A/D): ");
        char order = Character.toUpperCase(scanner.next().charAt(0));

        System.out.print("Original: ");
        printArray(arr, n);

        if (order == 'A') {
            selectionSortAscending(arr, n);
            System.out.print("Sorted (Ascending): ");
            printArray(arr, n);
        } else if (order == 'D') {
            selectionSortDescending(arr, n);
            System.out.print("Sorted (Descending): ");
            printArray(arr, n);
        } else {
            System.out.println("Invalid choice. Use 'A' or 'D'.");
        }

        scanner.close();
    }

    public static void main(String[] args) {
        sort();
    }
}
