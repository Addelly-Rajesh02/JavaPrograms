package practiseprograms.patterns;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MirrorDownWard {

    // 1) Right-aligned inverted triangle
    // For n = 5:
    // *****
    //  ****
    //   ***
    //    **
    //     *
    public static void mirrorDownwardRightAligned(int n) {
        if (n <= 0) {
            System.out.println("Please enter a positive number.");
            return;
        }
        for (int i = n; i >= 1; i--) {
            // leading spaces increase each row
            for (int s = 0; s < n - i; s++) System.out.print(' ');
            // stars decrease each row
            for (int k = 0; k < i; k++) System.out.print('*');
            System.out.println();
        }
    }

    // 2) Symmetric (double) inverted triangle / centered inverted pyramid
    // For n = 5:
    // *********
    //  *******
    //   *****
    //    ***
    //     *
    public static void mirrorDownwardCentered(int n) {
        if (n <= 0) {
            System.out.println("Please enter a positive number.");
            return;
        }
        int width = 2 * n - 1; // top row width (odd)
        for (int row = 0; row < n; row++) {
            int spaces = row;                 // left padding
            int stars = width - 2 * row;      // stars shrink by 2 each row
            for (int s = 0; s < spaces; s++) System.out.print(' ');
            for (int k = 0; k < stars; k++) System.out.print('*');
            System.out.println();
        }
    }

    // Wrapper to choose which mirror-downward pattern to print
    public static void mirrorDownward() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Choose Mirror Downward pattern:");
            System.out.println("1) Right-aligned inverted triangle");
            System.out.println("2) Centered (double) inverted triangle");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            System.out.print("Enter number of rows (n): ");
            int n = scanner.nextInt();

            switch (choice) {
                case 1 -> mirrorDownwardRightAligned(n);
                case 2 -> mirrorDownwardCentered(n);
                default -> System.out.println("Invalid choice.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter integers only.");
        }
    }

    public static void main(String[] args) {
        mirrorDownward();
    }
}