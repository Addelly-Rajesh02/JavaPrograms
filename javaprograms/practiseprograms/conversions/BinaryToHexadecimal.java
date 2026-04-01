package practiseprograms.conversions;

import java.util.Scanner;

public class BinaryToHexadecimal {

    public static void binaryToHexadecimal() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a binary number (e.g., 101101): ");
        String bin = scanner.next().trim();

        for (int i = 0; i < bin.length(); i++) {
            char ch = bin.charAt(i);
            if (ch != '0' && ch != '1') {
                System.out.println("Invalid input. Only 0 and 1 are allowed.");
                scanner.close();
                return;
            }
        }

        int decimal = Integer.parseInt(bin, 2);
        String hex = Integer.toHexString(decimal).toUpperCase();

        System.out.println("Hexadecimal: " + hex);

        scanner.close();
    }

    public static void main(String[] args) {
        binaryToHexadecimal();
    }
}