package practiseprograms.patterns;

import java.util.Scanner;

public class LeftTriangle {

    // Prints a left-aligned triangle of n rows
    public static void leftTriangle(int n) {
        if (n <= 0) {
            System.out.println("Please enter a positive number of rows.");
            return;
        }
        for (int i = 1; i <= n; i++) {       // row
            for (int j = 1; j <= i; j++) {   // stars in the row
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter number of rows: ");
            int n = scanner.nextInt();
            leftTriangle(n);
        }
    }
}