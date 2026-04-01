package practiseprograms.sortings;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BubbleSort {

    // Basic Bubble Sort (ascending)
    public static void bubbleSortAscending(int[] arr) {
        int n = arr.length;
        for (int pass = 0; pass < n - 1; pass++) {
            for (int j = 0; j < n - 1 - pass; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    // Optimized Bubble Sort (ascending) with early exit when no swaps occur
    public static void bubbleSortAscendingOptimized(int[] arr, boolean showPasses) {
        int n = arr.length;
        for (int pass = 0; pass < n - 1; pass++) {
            boolean swapped = false;
            for (int j = 0; j < n - 1 - pass; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    swapped = true;
                }
            }
            if (showPasses) {
                System.out.println("After pass " + (pass + 1) + ": " + Arrays.toString(arr));
            }
            if (!swapped) {
                // already sorted
                if (showPasses) {
                    System.out.println("No swaps in pass " + (pass + 1) + ". Early exit.");
                }
                break;
            }
        }
    }

    // Bubble Sort (descending)
    public static void bubbleSortDescending(int[] arr) {
        int n = arr.length;
        for (int pass = 0; pass < n - 1; pass++) {
            boolean swapped = false;
            for (int j = 0; j < n - 1 - pass; j++) {
                if (arr[j] < arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    // Wrapper as per your method signature (reads input and sorts)
    public static void bubbleSort() {
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

            System.out.println("\nChoose sort order:");
            System.out.println("1) Ascending (optimized, shows passes)");
            System.out.println("2) Ascending (basic)");
            System.out.println("3) Descending");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            System.out.println("Original: " + Arrays.toString(arr));

            switch (choice) {
                case 1 -> {
                    bubbleSortAscendingOptimized(arr, true);
                    System.out.println("Sorted (ascending, optimized): " + Arrays.toString(arr));
                }
                case 2 -> {
                    bubbleSortAscending(arr);
                    System.out.println("Sorted (ascending): " + Arrays.toString(arr));
                }
                case 3 -> {
                    bubbleSortDescending(arr);
                    System.out.println("Sorted (descending): " + Arrays.toString(arr));
                }
                default -> System.out.println("Invalid choice.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter integers only.");
        }
    }

    public static void main(String[] args) {
        bubbleSort();
    }
}
