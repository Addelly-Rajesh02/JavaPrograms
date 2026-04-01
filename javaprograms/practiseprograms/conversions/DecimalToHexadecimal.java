package practiseprograms.conversions;
import java.util.Scanner;

public class DecimalToHexadecimal {

    private static String toHexManual(int n) {
        if (n == 0) return "0";

        boolean negative = n < 0;
        long x = Math.abs((long) n);

        char[] hexMap = "0123456789ABCDEF".toCharArray();
        StringBuilder sb = new StringBuilder();

        while (x > 0) {
            int digit = (int) (x % 16);
            sb.append(hexMap[digit]);
            x /= 16;
        }

        if (negative) sb.append('-');
        return sb.reverse().toString();
    }

    public static void decimalToHexadecimal() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a decimal integer: ");
        int n = scanner.nextInt();

        String hexManual = toHexManual(n);
        System.out.println("Hex (manual): " + hexManual);

        String hexBuiltin = Integer.toHexString(n).toUpperCase();
        System.out.println("Hex (built-in Integer.toHexString): " + hexBuiltin);

        scanner.close();
    }

    public static void main(String[] args) {
        decimalToHexadecimal();
    }
}