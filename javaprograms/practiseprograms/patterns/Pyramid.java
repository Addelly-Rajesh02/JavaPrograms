package practiseprograms.patterns;

import java.util.Scanner;

public class Pyramid {

    // Centered (upright) pyramid with '*'
    public static void pyramid(int n) {
        if (n <= 0) {
            System.out.println("Please enter a positive number.");
            return;
        }
        for (int row = 0; row < n; row++) {
            int spaces = n - 1 - row;
            int stars  = 2 * row + 1;
            for (int s = 0; s < spaces; s++) System.out.print(' ');
            for (int k = 0; k < stars;  k++) System.out.print('*');
            System.out.println();
        }
    }

    // wrapper as per your original method signature (no args)
    public static void pyramid() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter number of rows: ");
            int n = scanner.nextInt();
            pyramid(n);
        }
    }

    public static void main(String[] args) {
        pyramid();
    }
}