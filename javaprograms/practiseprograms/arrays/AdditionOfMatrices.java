package practiseprograms.arrays;

import java.util.Scanner;

public class AdditionOfMatrices {

    private static int[][] readMatrix(Scanner scanner, int rows, int cols, String name) {
        int[][] m = new int[rows][cols];
        System.out.println("Enter elements of " + name + " (" + rows + "x" + cols + "), row-wise:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                m[i][j] = scanner.nextInt();
            }
        }
        return m;
    }

    private static int[][] addMatrices(int[][] a, int[][] b) {
        int rows = a.length;
        int cols = a[0].length;
        int[][] sum = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sum[i][j] = a[i][j] + b[i][j];
            }
        }
        return sum;
    }

    private static void printMatrix(int[][] m, String title) {
        System.out.println(title);
        for (int[] row : m) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static void additionOfMatrices() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter number of rows: ");
            int rows = scanner.nextInt();

            System.out.print("Enter number of columns: ");
            int cols = scanner.nextInt();

            if (rows <= 0 || cols <= 0) {
                System.out.println("Rows and columns must be positive integers.");
                return;
            }

            int[][] a = readMatrix(scanner, rows, cols, "Matrix A");
            int[][] b = readMatrix(scanner, rows, cols, "Matrix B");
            if (a.length != b.length || a[0].length != b[0].length) {
                System.out.println("Matrices must have the same dimensions to add.");
                return;
            }

            int[][] sum = addMatrices(a, b);

            printMatrix(a, "Matrix A:");
            printMatrix(b, "Matrix B:");
            printMatrix(sum, "Sum (A + B):");
        }
    }

    public static void main(String[] args) {
        additionOfMatrices();
    }
}