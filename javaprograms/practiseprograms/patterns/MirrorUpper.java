package practiseprograms.patterns;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MirrorUpper {

    // 1) Right-aligned upper triangle
    // For n = 5:
    //     *
    //    **
    //   ***
    //  ****
    // *****
    public static void mirrorUpperRightAligned(int n) {
        if (n <= 0) {
            System.out.println("Please enter a positive number.");
            return;
        }
        for (int i = 1; i <= n; i++) {
            // leading spaces decrease each row
            for (int s = 0; s < n - i; s++) System.out.print(' ');
            // stars increase each row
            for (int k = 0; k < i; k++) System.out.print('*');
            System.out.println();
        }
    }

    // 2) Centered (upright) pyramid
    // For n = 5:
    //     *
    //    ***
    //   *****
    //  *******
    // *********
    public static void mirrorUpperCentered(int n) {
        if (n <= 0) {
            System.out.println("Please enter a positive number.");
            return;
        }
        for (int row = 0; row < n; row++) {
            int spaces = n - 1 - row;    // left padding
            int stars  = 2 * row + 1;    // grows by 2 each row
            for (int s = 0; s < spaces; s++) System.out.print(' ');
            for (int k = 0; k < stars;  k++) System.out.print('*');
            System.out.println();
        }
    }

    // Wrapper to choose which "mirror upper" pattern to print
    public static void mirrorUpper() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Choose Mirror Upper pattern:");
            System.out.println("1) Right-aligned upper triangle");
            System.out.println("2) Centered (upright) pyramid");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            System.out.print("Enter number of rows (n): ");
            int n = scanner.nextInt();

            switch (choice) {
                case 1 -> mirrorUpperRightAligned(n);
                case 2 -> mirrorUpperCentered(n);
                default -> System.out.println("Invalid choice.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter integers only.");
        }
    }

    public static void main(String[] args) {
        mirrorUpper();
    }
}