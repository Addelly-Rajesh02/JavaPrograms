package practiseprograms.patterns;

import java.util.Scanner;

public class DiamondStar {
    public static void diamondStar(int rows){
        int m, n;
        for (m = 1; m <= rows; m++) {
            for (n = 1; n <= rows - m; n++) {
                System.out.print(" ");
            }
            for (n = 1; n <= m * 2 - 1; n++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (m = rows - 1; m > 0; m--) {
            for (n = 1; n <= rows - m; n++) {
                System.out.print(" ");
            }
            for (n = 1; n <= m * 2 - 1; n++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter number of rows: ");
        int rows=scanner.nextInt();
        diamondStar(rows);
    }
}
