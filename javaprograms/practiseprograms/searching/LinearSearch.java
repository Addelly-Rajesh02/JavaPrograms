package practiseprograms.searching;

import java.util.Scanner;

public class LinearSearch {

    // Core linear search logic
    public static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;  // key found at index i
            }
        }
        return -1; // key not found
    }

    // Wrapper method to handle user input
    public static void LinearSearch() {
        try (Scanner scanner = new Scanner(System.in)) {

            System.out.print("Enter number of elements: ");
            int n = scanner.nextInt();

            int[] arr = new int[n];
            System.out.println("Enter elements:");
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            System.out.print("Enter element to search: ");
            int key = scanner.nextInt();

            int result = linearSearch(arr, key);

            if (result != -1) {
                System.out.println("Element found at index (0-based): " + result);
            } else {
                System.out.println("Element not found in the array.");
            }
        }
    }

    public static void main(String[] args) {
        LinearSearch();
    }
}