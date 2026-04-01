package practiseprograms.conversions;

import java.math.BigInteger;
import java.util.Scanner;

public class OctalToHexadecimal {

    // --- Validation: octal contains only 0..7 (allow leading zeros) ---
    private static boolean isValidOctal(String s) {
        if (s == null || s.isEmpty()) return false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c < '0' || c > '7') return false;
        }
        return true;
    }

    // --- Remove leading zeros; leave a single zero if all zeros ---
    private static String stripLeadingZeros(String s) {
        int i = 0;
        while (i < s.length() - 1 && s.charAt(i) == '0') i++;
        return s.substring(i);
    }

    public static String octalToHexViaBinary(String octal) {
        octal = stripLeadingZeros(octal);
        if (octal.equals("0")) return "0";

        StringBuilder bin = new StringBuilder(octal.length() * 3);
        for (int i = 0; i < octal.length(); i++) {
            int d = octal.charAt(i) - '0'; // 0..7
            // 3-bit padded binary for each octal digit
            bin.append((d & 0b100) != 0 ? '1' : '0');
            bin.append((d & 0b010) != 0 ? '1' : '0');
            bin.append((d & 0b001) != 0 ? '1' : '0');
        }

        int start = 0;
        while (start < bin.length() - 1 && bin.charAt(start) == '0') start++;
        String binary = bin.substring(start);

        int rem = binary.length() % 4;
        if (rem != 0) {
            int pad = 4 - rem;
            StringBuilder padded = new StringBuilder(binary.length() + pad);
            for (int i = 0; i < pad; i++) padded.append('0');
            padded.append(binary);
            binary = padded.toString();
        }

        StringBuilder hex = new StringBuilder(binary.length() / 4);
        for (int i = 0; i < binary.length(); i += 4) {
            int nibble =
                    (binary.charAt(i)     - '0') << 3 |
                            (binary.charAt(i + 1) - '0') << 2 |
                            (binary.charAt(i + 2) - '0') << 1 |
                            (binary.charAt(i + 3) - '0');
            if (nibble < 10) hex.append((char) ('0' + nibble));
            else             hex.append((char) ('A' + (nibble - 10)));
        }

        String result = hex.toString();
        int j = 0;
        while (j < result.length() - 1 && result.charAt(j) == '0') j++;
        return result.substring(j);
    }

    public static String octalToHexViaBigInteger(String octal) {
        octal = stripLeadingZeros(octal);
        if (octal.equals("0")) return "0";
        BigInteger value = new BigInteger(octal, 8); // parse as base-8
        return value.toString(16).toUpperCase();     // output base-16
    }

    public static void octalToHecadecimal() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter an octal number: ");
            String input = scanner.nextLine().trim();

            if (!isValidOctal(input)) {
                System.out.println("Invalid octal input. Use digits 0–7 only.");
                return;
            }

            String hex1 = octalToHexViaBinary(input);
            String hex2 = octalToHexViaBigInteger(input); // sanity check / alternative
            System.out.println("Hexadecimal (via binary):     " + hex1);
            System.out.println("Hexadecimal (via BigInteger): " + hex2);
        }
    }

    public static void main(String[] args) {
        octalToHecadecimal();
    }
}
