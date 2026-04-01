package practiseprograms.conversions;

import java.util.Scanner;

public class BinaryToDecimal {

    private static int toDecimal(String bin) {
        int decimal = 0;
        for (int i = 0; i < bin.length(); i++) {
            char ch = bin.charAt(i);
            if (ch != '0' && ch != '1') {
                throw new IllegalArgumentException("Invalid binary digit: " + ch);
            }
            decimal = decimal * 2 + (ch - '0');
        }
        return decimal;
    }

    public static void binaryToDecimal() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a binary number (e.g., 101101): ");
        String bin = scanner.next().trim();

        try {
            int decimal = toDecimal(bin);
            System.out.println("Decimal (loop method): " + decimal);
            int decimalBuiltin = Integer.parseInt(bin, 2);
            System.out.println("Decimal (Integer.parseInt): " + decimalBuiltin);
        } catch (IllegalArgumentException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        scanner.close();
    }

    public static void main(String[] args) {
        binaryToDecimal();
    }
}
