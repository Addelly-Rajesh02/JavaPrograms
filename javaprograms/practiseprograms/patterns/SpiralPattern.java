package practiseprograms.patterns;

import java.util.Scanner;

public class SpiralPattern {

    public static void spiralPattern(int n){
        int[][] arr = new int[n][n];

        int top = 0, bottom = n - 1;
        int left = 0, right = n - 1;
        int num = 1;

        while (top <= bottom && left <= right) {

            // left → right
            for (int i = left; i <= right; i++) {
                arr[top][i] = num++;
            }
            top++;

            // top → bottom
            for (int i = top; i <= bottom; i++) {
                arr[i][right] = num++;
            }
            right--;

            // right → left
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    arr[bottom][i] = num++;
                }
                bottom--;
            }

            // bottom → top
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    arr[i][left] = num++;
                }
                left++;
            }
        }

        // print matrix
        for (int[] row : arr) {
            for (int val : row) {
                System.out.printf("%4d", val);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter n (matrix size): ");
        int n = scanner.nextInt();

        spiralPattern(n);
    }
}
