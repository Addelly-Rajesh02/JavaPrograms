package practiseprograms.conversions;

import java.util.Scanner;
import java.math.BigInteger;

public class HexadecimalToDecimal {

    private static long toDecimalManual(String hex) {
        long value = 0L;
        for (int i = 0; i < hex.length(); i++) {
            char ch = hex.charAt(i);
            int digit;

            if (ch >= '0' && ch <= '9') {
                digit = ch - '0';
            } else if (ch >= 'A' && ch <= 'F') {
                digit = 10 + (ch - 'A');
            } else if (ch >= 'a' && ch <= 'f') {
                digit = 10 + (ch - 'a');
            } else {
                throw new IllegalArgumentException("Invalid hex digit: " + ch);
            }

            if (value > (Long.MAX_VALUE - digit) / 16L) {
                return -1L;
            }
            value = value * 16L + digit;
        }
        return value;
    }

    public static void hexadecimalToDecimal() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a hexadecimal number (e.g., 1A3F): ");
        String hex = scanner.next().trim();

        if (hex.isEmpty()) {
            System.out.println("Input cannot be empty.");
            scanner.close();
            return;
        }

        try {
            long manual = toDecimalManual(hex);
            if (manual >= 0) {
                System.out.println("Decimal (manual): " + manual);
            } else {
                System.out.println("Decimal (manual): value too large for 'long'");
            }

            try {
                int asInt = Integer.parseInt(hex, 16);
                System.out.println("Decimal (built-in int): " + asInt);
            } catch (NumberFormatException nfe) {
                System.out.println("Decimal (built-in int): out of int range");
            }

            BigInteger big = new BigInteger(hex, 16);
            System.out.println("Decimal (BigInteger): " + big.toString(10));

        } catch (IllegalArgumentException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        scanner.close();
    }

    public static void main(String[] args) {
        hexadecimalToDecimal();
    }
}