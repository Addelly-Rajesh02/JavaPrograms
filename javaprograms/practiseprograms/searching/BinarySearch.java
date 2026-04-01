package practiseprograms.searching;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {

    // Core binary search logic
    public static int binarySearch(int[] arr, int key) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;  // safe midpoint calculation

            if (arr[mid] == key) {
                return mid;   // element found
            }
            else if (arr[mid] < key) {
                left = mid + 1; // search right half
            }
            else {
                right = mid - 1; // search left half
            }
        }

        return -1; // not found
    }

    // Wrapper method as per your original structure
    public static void binarySearch() {
        try (Scanner scanner = new Scanner(System.in)) {

            // Take array input
            System.out.print("Enter number of elements: ");
            int n = scanner.nextInt();

            int[] arr = new int[n];
            System.out.println("Enter elements:");
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            // Sort array before searching
            Arrays.sort(arr);
            System.out.println("Sorted array: " + Arrays.toString(arr));

            // Key to search
            System.out.print("Enter element to search: ");
            int key = scanner.nextInt();

            // Perform search
            int result = binarySearch(arr, key);

            // Output result
            if (result != -1) {
                System.out.println("Element found at index (0-based): " + result);
            } else {
                System.out.println("Element not found in the array.");
            }
        }
    }

    public static void main(String[] args) {
        binarySearch();
    }
}