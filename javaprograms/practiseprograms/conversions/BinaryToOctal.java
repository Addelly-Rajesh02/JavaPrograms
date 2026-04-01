package practiseprograms.conversions;

import java.util.Scanner;

public class BinaryToOctal {

    private static String toOctalManual(String bin) {
        int rem = bin.length() % 3;
        if (rem != 0) {
            int pad = 3 - rem;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < pad; i++) sb.append('0');
            sb.append(bin);
            bin = sb.toString();
        }

        StringBuilder oct = new StringBuilder();
        for (int i = 0; i < bin.length(); i += 3) {
            int val = 0;
            for (int j = 0; j < 3; j++) {
                val = (val << 1) + (bin.charAt(i + j) - '0');
            }
            oct.append((char) ('0' + val));
        }

        int k = 0;
        while (k < oct.length() - 1 && oct.charAt(k) == '0') k++;
        return oct.substring(k);
    }

    public static void binaryToOctal() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a binary number (e.g., 101101): ");
        String bin = scanner.next().trim();

        if (bin.isEmpty()) {
            System.out.println("Input cannot be empty.");
            scanner.close();
            return;
        }
        for (int i = 0; i < bin.length(); i++) {
            char ch = bin.charAt(i);
            if (ch != '0' && ch != '1') {
                System.out.println("Invalid input. Only 0 and 1 are allowed.");
                scanner.close();
                return;
            }
        }

        int decimal = Integer.parseInt(bin, 2);
        String octBuiltIn = Integer.toOctalString(decimal);

        System.out.println("Octal (built-in): " + octBuiltIn);

        String octManual = toOctalManual(bin);
        System.out.println("Octal (manual):   " + octManual);

        scanner.close();
    }

    public static void main(String[] args) {
        binaryToOctal();
    }
}