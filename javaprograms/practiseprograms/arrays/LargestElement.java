package practiseprograms.arrays;

import java.util.Scanner;

public class LargestElement {
    public static void largestElement() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = scanner.nextInt();
        if (n <= 0) {
            System.out.println("Invalid size.");
            return;
        }
        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int largest = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > largest) {
                largest = arr[i];
            }
        }
        System.out.println("Largest element: " + largest);
        scanner.close();
    }

    public static void main(String[] args) {
        largestElement();
    }
}