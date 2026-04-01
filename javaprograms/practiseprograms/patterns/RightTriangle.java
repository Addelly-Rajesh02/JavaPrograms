package practiseprograms.patterns;

import java.util.Scanner;

//        *
//        * *
//        * * *
//        * * * *
//        * * * * *
public class RightTriangle {

    public static void usingOneLoop() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of rows");
        int rows = scanner.nextInt();
        String row = "* ";
        for (int i = 1; i <= rows; i++) {
            System.out.println(row);
            row += "* "; // Add one more star for next row
        }
    }
    public static void usingTwoLoops() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of rows");
        int rows = scanner.nextInt();
        for (int i = 1; i <= rows; i++) {       // Outer loop for rows
            for (int j = 1; j <= i; j++) {     // Inner loop for stars
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    public static void usingRecursion(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of rows");
        int rows = scanner.nextInt();
        printTriangle(1, rows);

    }
    public static void printStars(int stars) {
        if (stars == 0) return;
        System.out.print("* ");
        printStars(stars - 1);
    }
    // Prints rows recursively
    public static void printTriangle(int currentRow, int totalRows) {
        if (currentRow > totalRows) return;
        printStars(currentRow);
        System.out.println();
        printTriangle(currentRow + 1, totalRows);
    }


    public static void main(String[] args) {
        usingOneLoop();
        usingTwoLoops();
        usingRecursion();
    }
}
