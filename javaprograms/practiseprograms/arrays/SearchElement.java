package practiseprograms.arrays;
import java.util.Scanner;

public class SearchElement {

    private static int linearSearch(int[] arr, int n, int target) {
        for (int i = 0; i < n; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void find() {
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

        System.out.print("Enter element to search: ");
        int target = scanner.nextInt();

        int index = linearSearch(arr, n, target);

        if (index != -1) {
            System.out.println("Element " + target + " found at index: " + index);
        } else {
            System.out.println("Element " + target + " not found in the array.");
        }

        scanner.close();
    }

    public static void main(String[] args) {
        find();
    }
}
