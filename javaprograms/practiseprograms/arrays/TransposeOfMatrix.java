package practiseprograms.arrays;
import java.util.Scanner;

public class TransposeOfMatrix {

    public static void transpose() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter number of columns: ");
        int cols = scanner.nextInt();

        if (rows <= 0 || cols <= 0) {
            System.out.println("Rows and columns must be positive integers.");
            return;
        }

        int[][] a = new int[rows][cols];
        System.out.println("Enter elements of the matrix (" + rows + "x" + cols + "), row-wise:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                a[i][j] = scanner.nextInt();
            }
        }

        int[][] t = new int[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                t[j][i] = a[i][j];
            }
        }

        System.out.println("\nOriginal Matrix:");
        printMatrix(a, rows, cols);

        System.out.println("Transposed Matrix:");
        printMatrix(t, cols, rows);

        scanner.close();
    }

    private static void printMatrix(int[][] m, int r, int c) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        transpose();
    }
}
