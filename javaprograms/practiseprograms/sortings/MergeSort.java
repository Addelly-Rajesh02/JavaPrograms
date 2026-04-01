package practiseprograms.sortings;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MergeSort {

    // ---- Public API (with option to show merge steps) ----
    public static void mergeSortArray(int[] arr, boolean showSteps) {
        if (arr == null || arr.length < 2) return;
        int[] temp = new int[arr.length];          // single temp buffer reused
        mergeSortRec(arr, temp, 0, arr.length - 1, showSteps);
    }

    // ---- Recursive merge sort ----
    private static void mergeSortRec(int[] arr, int[] temp, int left, int right, boolean showSteps) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;

        mergeSortRec(arr, temp, left, mid, showSteps);
        mergeSortRec(arr, temp, mid + 1, right, showSteps);

        // Optimization: if already in order, skip merge
        if (arr[mid] <= arr[mid + 1]) return;

        merge(arr, temp, left, mid, right);

        if (showSteps) {
            System.out.println("Merged [" + left + "," + right + "] -> " +
                    Arrays.toString(Arrays.copyOfRange(arr, left, right + 1)));
        }
    }

    // ---- Merge two sorted halves: [left..mid] and [mid+1..right] ----
    private static void merge(int[] arr, int[] temp, int left, int mid, int right) {
        // copy the segment to temp
        for (int i = left; i <= right; i++) temp[i] = arr[i];

        int i = left;     // pointer for left half
        int j = mid + 1;  // pointer for right half
        int k = left;     // write pointer

        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {      // <= keeps it STABLE
                arr[k++] = temp[i++];
            } else {
                arr[k++] = temp[j++];
            }
        }
        // copy remaining from left half (right half already in place)
        while (i <= mid) {
            arr[k++] = temp[i++];
        }
    }

    // ---- Optional: Iterative (bottom-up) Merge Sort (no recursion) ----
    public static void mergeSortIterative(int[] arr, boolean showSteps) {
        int n = arr.length;
        if (n < 2) return;
        int[] temp = new int[n];

        // size is current subarray size; start with 1 and double each time
        for (int size = 1; size < n; size <<= 1) {
            for (int left = 0; left < n - size; left += (size << 1)) {
                int mid = left + size - 1;
                int right = Math.min(left + (size << 1) - 1, n - 1);

                // merge arr[left..mid] and arr[mid+1..right]
                // copy to temp
                for (int i = left; i <= right; i++) temp[i] = arr[i];

                int i = left, j = mid + 1, k = left;
                while (i <= mid && j <= right) {
                    if (temp[i] <= temp[j]) arr[k++] = temp[i++];
                    else                    arr[k++] = temp[j++];
                }
                while (i <= mid) arr[k++] = temp[i++];

                if (showSteps) {
                    System.out.println("Merged [" + left + "," + right + "] -> " +
                            Arrays.toString(Arrays.copyOfRange(arr, left, right + 1)));
                }
            }
        }
    }

    // ---- Wrapper as per your original method signature ----
    public static void mergeSort() {
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

            System.out.println("\nOriginal: " + Arrays.toString(arr));
            System.out.println("Choose variant:");
            System.out.println("1) Recursive Merge Sort");
            System.out.println("2) Iterative (Bottom-Up) Merge Sort");
            System.out.print("Enter choice: ");
            int variant = scanner.nextInt();

            System.out.print("Show intermediate merges? (1 = Yes, 0 = No): ");
            boolean show = scanner.nextInt() == 1;

            if (variant == 2) {
                mergeSortIterative(arr, show);
                System.out.println("Sorted (iterative): " + Arrays.toString(arr));
            } else {
                mergeSortArray(arr, show);
                System.out.println("Sorted (recursive): " + Arrays.toString(arr));
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter integers only.");
        }
    }

    public static void main(String[] args) {
        mergeSort();
    }
}