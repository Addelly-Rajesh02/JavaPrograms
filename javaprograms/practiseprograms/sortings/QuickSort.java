package practiseprograms.sortings;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class QuickSort {

    // ---------- Public API wrappers ----------
    public static void quickSortLomuto(int[] arr, boolean randomized, boolean showSteps) {
        if (arr == null || arr.length < 2) return;
        quickSortLomutoRec(arr, 0, arr.length - 1, randomized, showSteps, new Random());
    }

    public static void quickSortHoare(int[] arr, boolean randomized, boolean showSteps) {
        if (arr == null || arr.length < 2) return;
        quickSortHoareRec(arr, 0, arr.length - 1, randomized, showSteps, new Random());
    }

    // ---------- Lomuto partition scheme ----------
    private static void quickSortLomutoRec(int[] a, int lo, int hi, boolean randomized, boolean showSteps, Random rnd) {
        if (lo >= hi) return;

        if (randomized) {
            int pivotIndex = lo + rnd.nextInt(hi - lo + 1);
            swap(a, pivotIndex, hi); // move random pivot to end
        }
        int p = partitionLomuto(a, lo, hi);

        if (showSteps) {
            System.out.println("Pivot (Lomuto) at index " + p + " -> " + Arrays.toString(a));
        }

        quickSortLomutoRec(a, lo, p - 1, randomized, showSteps, rnd);
        quickSortLomutoRec(a, p + 1, hi, randomized, showSteps, rnd);
    }

    // Lomuto: pivot = a[hi]
    private static int partitionLomuto(int[] a, int lo, int hi) {
        int pivot = a[hi];
        int i = lo; // place for next smaller element
        for (int j = lo; j < hi; j++) {
            if (a[j] <= pivot) {
                swap(a, i, j);
                i++;
            }
        }
        swap(a, i, hi);
        return i;
    }

    // ---------- Hoare partition scheme ----------
    private static void quickSortHoareRec(int[] a, int lo, int hi, boolean randomized, boolean showSteps, Random rnd) {
        if (lo >= hi) return;

        int pivotIndex = lo + (hi - lo) / 2;
        if (randomized) {
            pivotIndex = lo + rnd.nextInt(hi - lo + 1);
        }
        int pivot = a[pivotIndex];

        int i = lo - 1, j = hi + 1;
        while (true) {
            do { i++; } while (a[i] < pivot);
            do { j--; } while (a[j] > pivot);
            if (i >= j) {
                // j is the partition index
                if (showSteps) {
                    System.out.println("Partition (Hoare) around pivot=" + pivot + ", j=" + j + " -> " + Arrays.toString(a));
                }
                // sort the two halves
                quickSortHoareRec(a, lo, j, randomized, showSteps, rnd);
                quickSortHoareRec(a, j + 1, hi, randomized, showSteps, rnd);
                return;
            }
            swap(a, i, j);
        }
    }

    // ---------- Utils ----------
    private static void swap(int[] a, int i, int j) {
        if (i == j) return;
        int t = a[i]; a[i] = a[j]; a[j] = t;
    }

    // ---------- Input-driven wrapper (as per your method signature) ----------
    public static void quickSort() {
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
            System.out.println("Choose partition scheme:");
            System.out.println("1) Lomuto (pivot at end)");
            System.out.println("2) Hoare  (pivot at middle by default)");
            System.out.print("Enter choice: ");
            int scheme = scanner.nextInt();

            System.out.print("Use randomized pivot? (1 = Yes, 0 = No): ");
            boolean randomized = scanner.nextInt() == 1;

            System.out.print("Show steps? (1 = Yes, 0 = No): ");
            boolean show = scanner.nextInt() == 1;

            if (scheme == 2) {
                quickSortHoare(arr, randomized, show);
                System.out.println("Sorted (Hoare):  " + Arrays.toString(arr));
            } else {
                quickSortLomuto(arr, randomized, show);
                System.out.println("Sorted (Lomuto): " + Arrays.toString(arr));
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter integers only.");
        }
    }

    public static void main(String[] args) {
        quickSort();
    }
}