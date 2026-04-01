package practiseprograms.conversions;

import java.math.BigInteger;
import java.util.Scanner;

public class OctalToBinary {

    // Validate octal: only '0'..'7', allow leading zeros
    private static boolean isValidOctal(String s) {
        if (s == null || s.isEmpty()) return false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c < '0' || c > '7') return false;
        }
        return true;
    }

    // Remove leading zeros but keep a single zero if all are zeros
    private static String stripLeadingZeros(String s) {
        int i = 0;
        while (i < s.length() - 1 && s.charAt(i) == '0') i++;
        return s.substring(i);
    }

    /**
     * Method 1: Octal -> Binary using 3-bit mapping per octal digit.
     * Works for arbitrarily long inputs without numeric overflow.
     */
    public static String octalToBinaryViaMapping(String octal) {
        octal = stripLeadingZeros(octal);
        if (octal.equals("0")) return "0";

        // Map octal digit to fixed 3-bit binary string
        final String[] map = {
                "000","001","010","011","100","101","110","111"
        };

        StringBuilder bin = new StringBuilder(octal.length() * 3);

        // First digit: no left-padding beyond required (avoid leading zeros)
        int first = octal.charAt(0) - '0';
        String firstBits = map[first];
        // Drop leading zeros from the very first 3-bit block
        int k = 0;
        while (k < 2 && firstBits.charAt(k) == '0') k++;
        bin.append(firstBits.substring(k)); // at least one char will remain

        // Remaining digits: always append full 3 bits
        for (int i = 1; i < octal.length(); i++) {
            int d = octal.charAt(i) - '0'; // 0..7
            bin.append(map[d]);
        }
        return bin.toString();
    }

    /**
     * Method 2: Octal -> Decimal (BigInteger) -> Binary.
     * Also supports arbitrarily large inputs.
     */
    public static String octalToBinaryViaBigInteger(String octal) {
        octal = stripLeadingZeros(octal);
        BigInteger value = new BigInteger(octal, 8); // parse base-8
        return value.toString(2);                    // output base-2
    }

    // Console wrapper
    public static void octalToBinary() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter an octal number: ");
            String input = scanner.nextLine().trim();

            if (!isValidOctal(input)) {
                System.out.println("Invalid octal input. Use digits 0–7 only.");
                return;
            }

            String bin1 = octalToBinaryViaMapping(input);
            String bin2 = octalToBinaryViaBigInteger(input); // alternate / sanity check

            System.out.println("Binary (via mapping):     " + bin1);
            System.out.println("Binary (via BigInteger):  " + bin2);
        }
    }

    public static void main(String[] args) {
        octalToBinary();
    }
}