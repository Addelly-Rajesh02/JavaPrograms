package practiseprograms.arrays;

import java.util.Scanner;
//print issue when it satisfy 4 times when size is 4
public class RotationOfArray {

    private static void leftRotateByOne(int[] arr, int n) {
        int first = arr[0];
        for (int i = 0; i < n - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[n - 1] = first;
    }

    private static void rightRotateByOne(int[] arr, int n) {
        int last = arr[n - 1];
        for (int i = n - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = last;
    }

    private static void leftRotate(int[] arr, int n, int k) {
        if (n == 0) return;
        k = k % n;
        for (int i = 0; i < k; i++) {
            leftRotateByOne(arr, n);
        }
    }

    private static void rightRotate(int[] arr, int n, int k) {
        if (n == 0) return;
        k = k % n;                 // handle k >= n
        for (int i = 0; i < k; i++) {
            rightRotateByOne(arr, n);
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

    public static void rotationOfArray() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = scanner.nextInt();

        if (n < 0) {
            System.out.println("Invalid size.");
            return;
        }

        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.print("Enter rotation count k: ");
        int k = scanner.nextInt();

        System.out.print("Rotate Left or Right? (L/R): ");
        char dir = Character.toUpperCase(scanner.next().charAt(0));

        System.out.print("Original: ");
        printArray(arr, n);

        if (dir == 'L') {
            leftRotate(arr, n, k);
            System.out.print("After Left Rotation by " + k + ": ");
            printArray(arr, n);
        } else if (dir == 'R') {
            rightRotate(arr, n, k);
            System.out.print("After Right Rotation by " + k + ": ");
            printArray(arr, n);
        } else {
            System.out.println("Invalid direction. Use 'L' or 'R'.");
        }

        scanner.close();
    }

    public static void main(String[] args) {
        rotationOfArray();
    }
}