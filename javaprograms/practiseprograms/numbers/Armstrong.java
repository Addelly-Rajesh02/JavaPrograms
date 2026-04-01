package practiseprograms.numbers;

import java.util.Scanner;

public class Armstrong {

    public static int countDigits(int n) {
        if (n == 0) return 1;
        int count = 0;
        n = Math.abs(n);
        while (n != 0) {
            n /= 10;
            count++;
        }
        return count;
    }

    private static int intPow(int base, int exp) {
        int result = 1;
        for (int i = 0; i < exp; i++) {
            result *= base;
        }
        return result;
    }

    public static boolean isArmstrong(int n) {
        if (n < 0)
            return false;
        int digits = countDigits(n);
        int sum = 0;
        int num = n;

        while (num > 0) {
            int d = num % 10;
            sum += intPow(d, digits);
            num /= 10;
        }

        return sum == n;
    }

    public static int nextArmstrong(int start) {
        int x = Math.max(0, start + 1);
        while (!isArmstrong(x)) {
            x++;
        }
        return x;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter number to check if Armstrong: ");
            int n = scanner.nextInt();
            System.out.println(isArmstrong(n) ? "Armstrong number" : "Not Armstrong number");

            System.out.print("Enter number to find next Armstrong number: ");
            int m = scanner.nextInt();
            int next = nextArmstrong(m);
            System.out.println("Next Armstrong number: " + next);
        }
    }
}
