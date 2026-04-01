package practiseprograms.sortings;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SelectionSort {

    // ---- Core Selection Sort Ascending ----
    public static void selectionSortAscending(int[] arr, boolean showPasses) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            // find index of minimum element in remaining unsorted part
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // swap minimum to correct position
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;

            if (showPasses) {
                System.out.println("After pass " + (i + 1) + ": " + Arrays.toString(arr));
            }
        }
    }

    // ---- Core Selection Sort Descending ----
    public static void selectionSortDescending(int[] arr, boolean showPasses) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[maxIndex];
            arr[maxIndex] = temp;

            if (showPasses) {
                System.out.println("After pass " + (i + 1) + ": " + Arrays.toString(arr));
            }
        }
    }

    // ---- Wrapper matching your method signature ----
    public static void selectionSort() {
        try (Scanner scanner = new Scanner(System.in)) {

            System.out.print("Enter number of elements: ");
            int n = scanner.nextInt();

            int[] arr = new int[n];
            System.out.println("Enter " + n + " integers:");
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            System.out.println("\nOriginal Array: " + Arrays.toString(arr));

            System.out.println("Choose order:");
            System.out.println("1) Ascending");
            System.out.println("2) Descending");
            System.out.print("Enter choice: ");
            int order = scanner.nextInt();

            System.out.print("Show passes? (1 = Yes, 0 = No): ");
            boolean show = scanner.nextInt() == 1;

            if (order == 2) {
                selectionSortDescending(arr, show);
                System.out.println("Sorted (Descending): " + Arrays.toString(arr));
            } else {
                selectionSortAscending(arr, show);
                System.out.println("Sorted (Ascending): " + Arrays.toString(arr));
            }

        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter integers only.");
        }
    }

    public static void main(String[] args) {
        selectionSort();
    }
}