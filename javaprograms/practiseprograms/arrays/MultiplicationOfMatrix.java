package practiseprograms.arrays;

import java.util.Scanner;

public class MultiplicationOfMatrix {

    public static void multiplicationOfMatrices() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter rows for Matrix A: ");
        int r1 = scanner.nextInt();
        System.out.print("Enter cols for Matrix A: ");
        int c1 = scanner.nextInt();

        System.out.print("Enter rows for Matrix B: ");
        int r2 = scanner.nextInt();
        System.out.print("Enter cols for Matrix B: ");
        int c2 = scanner.nextInt();

        if (r1 <= 0 || c1 <= 0 || r2 <= 0 || c2 <= 0) {
            System.out.println("Rows and columns must be positive integers.");
            return;
        }
        if (c1 != r2) {
            System.out.println("Multiplication not possible: cols of A must equal rows of B.");
            System.out.println("You entered A: " + r1 + "x" + c1 + ", B: " + r2 + "x" + c2);
            return;
        }

        int[][] A = new int[r1][c1];
        System.out.println("Enter elements of Matrix A (" + r1 + "x" + c1 + "), row-wise:");
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c1; j++) {
                A[i][j] = scanner.nextInt();
            }
        }

        int[][] B = new int[r2][c2];
        System.out.println("Enter elements of Matrix B (" + r2 + "x" + c2 + "), row-wise:");
        for (int i = 0; i < r2; i++) {
            for (int j = 0; j < c2; j++) {
                B[i][j] = scanner.nextInt();
            }
        }

        int[][] C = new int[r1][c2];

        // Standard triple-loop multiplication: C[i][j] = sum(A[i][k] * B[k][j])
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                int sum = 0;
                for (int k = 0; k < c1; k++) {
                    sum += A[i][k] * B[k][j];
                }
                C[i][j] = sum;
            }
        }

        System.out.println("Product (A x B):");
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                System.out.print(C[i][j] + " ");
            }
            System.out.println();
        }
        scanner.close();
    }

    public static void main(String[] args) {
        multiplicationOfMatrices();
    }
}
