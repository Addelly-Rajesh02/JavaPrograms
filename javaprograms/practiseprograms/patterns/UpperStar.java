package practiseprograms.patterns;

import java.util.Scanner;

public class UpperStar {

    public static void upperStar(int n){
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int n = scanner.nextInt();

        upperStar(n);
    }
}
