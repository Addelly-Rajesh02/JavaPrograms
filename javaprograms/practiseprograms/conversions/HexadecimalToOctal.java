package practiseprograms.conversions;

import java.util.Scanner;
import java.math.BigInteger;

public class HexadecimalToOctal {

    private static String hexDigitToBin(char ch) {
        switch (Character.toUpperCase(ch)) {
            case '0': return "0000";
            case '1': return "0001";
            case '2': return "0010";
            case '3': return "0011";
            case '4': return "0100";
            case '5': return "0101";
            case '6': return "0110";
            case '7': return "0111";
            case '8': return "1000";
            case '9': return "1001";
            case 'A': return "1010";
            case 'B': return "1011";
            case 'C': return "1100";
            case 'D': return "1101";
            case 'E': return "1110";
            case 'F': return "1111";
            default:  throw new IllegalArgumentException("Invalid hex digit: " + ch);
        }
    }

    private static String hexToOctalManual(String hex) {
        if (hex.equals("0")) return "0";

        StringBuilder bin = new StringBuilder();
        for (int i = 0; i < hex.length(); i++) {
            bin.append(hexDigitToBin(hex.charAt(i)));
        }

        int k = 0;
        while (k < bin.length() - 1 && bin.charAt(k) == '0') k++;
        bin.delete(0, k);

        int rem = bin.length() % 3;
        if (rem != 0) {
            int pad = 3 - rem;
            StringBuilder padded = new StringBuilder(pad + bin.length());
            for (int i = 0; i < pad; i++) padded.append('0');
            padded.append(bin);
            bin = padded;
        }

        StringBuilder oct = new StringBuilder();
        for (int i = 0; i < bin.length(); i += 3) {
            int v = (bin.charAt(i) - '0') * 4
                    + (bin.charAt(i + 1) - '0') * 2
                    + (bin.charAt(i + 2) - '0');
            oct.append((char) ('0' + v));
        }

        int z = 0;
        while (z < oct.length() - 1 && oct.charAt(z) == '0') z++;
        return oct.substring(z);
    }

    public static void hexadecimalToOctal() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a hexadecimal number (e.g., 1A3F): ");
        String hex = scanner.next().trim();

        if (hex.isEmpty()) {
            System.out.println("Input cannot be empty.");
            scanner.close();
            return;
        }

        if (hex.startsWith("0x") || hex.startsWith("0X")) {
            hex = hex.substring(2);
        }

        for (int i = 0; i < hex.length(); i++) {
            char ch = hex.charAt(i);
            boolean ok = (ch >= '0' && ch <= '9') ||
                    (ch >= 'A' && ch <= 'F') ||
                    (ch >= 'a' && ch <= 'f');
            if (!ok) {
                System.out.println("Invalid hex input. Use digits 0-9 and letters A-F.");
                scanner.close();
                return;
            }
        }

        String octManual = hexToOctalManual(hex);
        System.out.println("Octal (manual):   " + octManual);

        BigInteger big = new BigInteger(hex, 16);
        String octBuiltIn = big.toString(8);
        System.out.println("Octal (built-in): " + octBuiltIn);

        scanner.close();
    }

    public static void main(String[] args) {
        hexadecimalToOctal();
    }
}