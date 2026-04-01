package practiseprograms.conversions;

import java.util.Scanner;

public class DecimalToOctal {

    private static String toOctalManual(int n) {
        if (n == 0) return "0";

        boolean negative = n < 0;
        long x = Math.abs((long) n);

        StringBuilder sb = new StringBuilder();
        while (x > 0) {
            int digit = (int) (x % 8);
            sb.append(digit);
            x /= 8;
        }

        if (negative) sb.append('-');
        return sb.reverse().toString();
    }

    public static void decimalToOctal() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a decimal integer: ");
        int n = scanner.nextInt();

        String octManual = toOctalManual(n);
        System.out.println("Octal (manual): " + octManual);

        String octBuiltin = Integer.toOctalString(n);
        System.out.println("Octal (built-in Integer.toOctalString): " + octBuiltin);

        scanner.close();
    }

    public static void main(String[] args) {
        decimalToOctal();
    }
}