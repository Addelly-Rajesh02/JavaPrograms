package practiseprograms.recursion;

import java.math.BigInteger;
import java.util.Scanner;

public class Factorial {

    // Recursive factorial using BigInteger (handles very large n, limited by stack depth)
    public static BigInteger factorial(BigInteger n) {
        if (n.signum() < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers.");
        }
        if (n.equals(BigInteger.ZERO) || n.equals(BigInteger.ONE)) {
            return BigInteger.ONE; // base case
        }
        return n.multiply(factorial(n.subtract(BigInteger.ONE))); // recursive case
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a non-negative integer: ");
        int input = scanner.nextInt();

        if (input < 0) {
            System.out.println("Please enter a non-negative integer.");
            return;
        }

        BigInteger n = BigInteger.valueOf(input);
        BigInteger result = factorial(n);
        System.out.println(input + "! = " + result);
    }
}
