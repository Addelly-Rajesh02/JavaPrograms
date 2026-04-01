package practiseprograms.conversions;

import java.util.Scanner;
import java.math.BigInteger;

public class HexadecimalToBinary {

    private static String toBinaryManual(String hex) {
        if (hex.isEmpty()) return "0";

        String[] map = {
                "0000","0001","0010","0011",
                "0100","0101","0110","0111",
                "1000","1001","1010","1011",
                "1100","1101","1110","1111"
        };

        StringBuilder bin = new StringBuilder();

        for (int i = 0; i < hex.length(); i++) {
            char ch = hex.charAt(i);
            int val;

            if (ch >= '0' && ch <= '9') {
                val = ch - '0';
            } else if (ch >= 'A' && ch <= 'F') {
                val = 10 + (ch - 'A');
            } else if (ch >= 'a' && ch <= 'f') {
                val = 10 + (ch - 'a');
            } else {
                throw new IllegalArgumentException("Invalid hex digit: " + ch);
            }

            bin.append(map[val]);
        }

        int k = 0;
        while (k < bin.length() - 1 && bin.charAt(k) == '0') k++;
        return bin.substring(k);
    }

    public static void hexadecimalToBinary() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a hexadecimal number (e.g., 1A3F): ");
        String hex = scanner.next().trim();

        if (hex.isEmpty()) {
            System.out.println("Input cannot be empty.");
            scanner.close();
            return;
        }

        try {
            String binManual = toBinaryManual(hex);
            System.out.println("Binary (manual):   " + binManual);

            BigInteger big = new BigInteger(hex, 16);
            String binBuiltin = big.toString(2);
            System.out.println("Binary (built-in): " + binBuiltin);
        } catch (IllegalArgumentException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        scanner.close();
    }

    public static void main(String[] args) {
        hexadecimalToBinary();
    }
}