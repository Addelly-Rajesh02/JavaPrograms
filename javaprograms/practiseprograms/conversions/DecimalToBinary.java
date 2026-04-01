package practiseprograms.conversions;

import java.util.Scanner;

public class DecimalToBinary {

    private static String toBinaryManual(int n) {
        if (n == 0) return "0";

        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int bit = n % 2;
            sb.append(bit);
            n = n / 2;
        }
        return sb.reverse().toString();
    }

    public static void decimalToBinary() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a decimal integer: ");
        int n = scanner.nextInt();

        if (n < 0) {
            String bin = toBinaryManual(Math.abs(n));
            System.out.println("Binary (manual): -" + bin);
            System.out.println("Binary (built-in Integer.toBinaryString): " + Integer.toBinaryString(n));
        } else {
            String bin = toBinaryManual(n);
            System.out.println("Binary (manual): " + bin);

            String builtIn = Integer.toBinaryString(n);
            System.out.println("Binary (built-in Integer.toBinaryString): " + builtIn);
        }

        scanner.close();
    }

    public static void main(String[] args) {
        decimalToBinary();
    }
}