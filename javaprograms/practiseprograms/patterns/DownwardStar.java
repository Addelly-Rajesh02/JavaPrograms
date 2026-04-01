package practiseprograms.patterns;

import java.util.Scanner;

public class DownwardStar {

    // Left-aligned inverted triangle
    public static void downwardStar(int n) {
        if (n <= 0) {
            System.out.println("Please enter a positive number.");
            return;
        }
        for (int i = n; i >= 1; i--) {
            // print i stars
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter number of rows: ");
            int n = scanner.nextInt();
            downwardStar(n);
        }
    }
}