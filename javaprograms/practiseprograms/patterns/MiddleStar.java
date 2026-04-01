package practiseprograms.patterns;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MiddleStar {

    /**
     * Prints a plus ('+') shape in an n x n grid.
     * Works best with odd n; for even n, there will be two central lines around the middle index.
     */
    public static void middleStarPlus(int n) {
        if (n <= 0) {
            System.out.println("Please enter a positive integer.");
            return;
        }
        int mid = n / 2; // for odd n, exact center; for even n, the lower of the two middle indices
        for (int i = 0; i < n; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (i == mid || j == mid) row.append('*');
                else row.append(' ');
            }
            System.out.println(row);
        }
    }

    /**
     * Prints an 'X' shape in an n x n grid.
     * Middle star appears where diagonals cross (when n is odd).
     */
    public static void middleStarX(int n) {
        if (n <= 0) {
            System.out.println("Please enter a positive integer.");
            return;
        }
        for (int i = 0; i < n; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (i == j || i + j == n - 1) row.append('*');
                else row.append(' ');
            }
            System.out.println(row);
        }
    }

    /**
     * Prints only the vertical middle column of stars in an n x n grid.
     * Useful if the requirement is to show a single "middle star" per line vertically.
     */
    public static void middleStarVertical(int n) {
        if (n <= 0) {
            System.out.println("Please enter a positive integer.");
            return;
        }
        int mid = n / 2;
        for (int i = 0; i < n; i++) {
            // print spaces up to middle, then one star
            for (int s = 0; s < mid; s++) System.out.print(' ');
            System.out.println('*');
        }
    }

    /**
     * Wrapper that asks user which "middle star" pattern to print.
     */
    public static void middleStar() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Choose Middle Star pattern:");
            System.out.println("1) Plus (+) shape (middle row & column)");
            System.out.println("2) X shape (both diagonals)");
            System.out.println("3) Vertical middle line");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            System.out.print("Enter size n (recommended odd, e.g., 5, 7, 9): ");
            int n = scanner.nextInt();

            switch (choice) {
                case 1 -> middleStarPlus(n);
                case 2 -> middleStarX(n);
                case 3 -> middleStarVertical(n);
                default -> System.out.println("Invalid choice.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter integers only.");
        }
    }

    public static void main(String[] args) {
        middleStar();
    }
}