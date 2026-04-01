package practiseprograms.conversions;

import java.math.BigInteger;
import java.util.Scanner;

public class OctalToDecimal {

    // Validate that the string is a valid octal (digits 0..7), allowing leading zeros
    private static boolean isValidOctal(String s) {
        if (s == null || s.isEmpty()) return false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c < '0' || c > '7') return false;
        }
        return true;
    }

    // Remove leading zeros but leave a single '0' if the entire string is zeros
    private static String stripLeadingZeros(String s) {
        int i = 0;
        while (i < s.length() - 1 && s.charAt(i) == '0') i++;
        return s.substring(i);
    }

    /**
     * Method 1: Manual conversion Octal -> Decimal using integer math.
     * Works for values that fit into a Java long.
     */
    public static long octalToDecimalManual(String octal) {
        octal = stripLeadingZeros(octal);
        long result = 0L;
        for (int i = 0; i < octal.length(); i++) {
            int digit = octal.charAt(i) - '0';  // 0..7
            result = result * 8 + digit;
        }
        return result;
    }

    /**
     * Method 2: Using BigInteger for arbitrary-length octal values.
     * Safe for very large inputs that exceed long/ int range.
     */
    public static String octalToDecimalBig(String octal) {
        octal = stripLeadingZeros(octal);
        BigInteger value = new BigInteger(octal, 8);   // parse base-8
        return value.toString(10);                     // output base-10
    }

    // Console wrapper
    public static void octalToDecimal() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter an octal number: ");
            String input = scanner.nextLine().trim();

            if (!isValidOctal(input)) {
                System.out.println("Invalid octal input. Use digits 0–7 only.");
                return;
            }

            // Manual (long) conversion
            try {
                long decimal = octalToDecimalManual(input);
                System.out.println("Decimal (manual long): " + decimal);
            } catch (Exception e) {
                System.out.println("Manual conversion overflowed or failed.");
            }

            // BigInteger conversion (always safe)
            String bigDec = octalToDecimalBig(input);
            System.out.println("Decimal (BigInteger):   " + bigDec);
        }
    }

    public static void main(String[] args) {
        octalToDecimal();
    }
}