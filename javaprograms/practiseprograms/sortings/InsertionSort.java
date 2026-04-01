package practiseprograms.sortings;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InsertionSort {

    // Core Insertion Sort logic
    public static void insertionSortArray(int[] arr, boolean showPasses) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            // Shift larger elements to the right
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            // Insert the key in its correct position
            arr[j + 1] = key;

            if (showPasses) {
                System.out.println("After pass " + i + ": " + Arrays.toString(arr));
            }
        }
    }

    // Wrapper method for user interaction
    public static void insertionSort() {
        try (Scanner scanner = new Scanner(System.in)) {

            System.out.print("Enter number of elements: ");
            int n = scanner.nextInt();

            int[] arr = new int[n];
            System.out.println("Enter " + n + " integers:");
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            System.out.println("\nOriginal Array: " + Arrays.toString(arr));

            System.out.print("Show passes? (1 = Yes, 0 = No): ");
            int show = scanner.nextInt();

            insertionSortArray(arr, show == 1);

            System.out.println("Sorted Array:   " + Arrays.toString(arr));

        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter integers only.");
        }
    }

    public static void main(String[] args) {
        insertionSort();
    }
}