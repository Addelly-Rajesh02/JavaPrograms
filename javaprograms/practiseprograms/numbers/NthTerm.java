package practiseprograms.numbers;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NthTerm {

    // ----- AP -----
    public static long nthTermAP(long a1, long d, long n) {
        return a1 + (n - 1) * d;
    }

    // ----- GP -----
    public static long nthTermGP(long a1, long r, long n) {
        long pow = 1;
        for (long i = 1; i < n; i++) pow *= r;
        return a1 * pow;
    }

    // ----- Fibonacci -----
    public static long nthFibonacci(long n) {
        if (n <= 0) throw new IllegalArgumentException("n must be positive");
        if (n == 1 || n == 2) return 1;
        long a = 1, b = 1;
        for (long i = 3; i <= n; i++) {
            long c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    // ----- Triangular -----
    public static long nthTriangular(long n) {
        if (n < 0) throw new IllegalArgumentException("n must be non-negative");
        return n * (n + 1) / 2;
    }

    // ----- n-th Prime -----
    public static long nthPrime(int n) {
        if (n < 1) throw new IllegalArgumentException("n must be ≥ 1");
        int count = 0;
        int num = 1;
        while (count < n) {
            num++;
            if (isPrime(num)) count++;
        }
        return num;
    }

    private static boolean isPrime(int x) {
        if (x < 2) return false;
        if (x % 2 == 0) return x == 2;
        for (int i = 3; i * i <= x; i += 2) {
            if (x % i == 0) return false;
        }
        return true;
    }

    // ----- Main -----
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Choose sequence for n-th term:");
            System.out.println("1) Arithmetic Progression (AP)");
            System.out.println("2) Geometric Progression (GP)");
            System.out.println("3) Fibonacci");
            System.out.println("4) Triangular");
            System.out.println("5) n-th Prime");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1: {
                    System.out.print("Enter first term (a1): ");
                    long a1 = scanner.nextLong();
                    System.out.print("Enter common difference (d): ");
                    long d = scanner.nextLong();
                    System.out.print("Enter n: ");
                    long n = scanner.nextLong();
                    System.out.println("AP n-th term = " + nthTermAP(a1, d, n));
                    break;
                }
                case 2: {
                    System.out.print("Enter first term (a1): ");
                    long a1 = scanner.nextLong();
                    System.out.print("Enter common ratio (r): ");
                    long r = scanner.nextLong();
                    System.out.print("Enter n: ");
                    long n = scanner.nextLong();
                    System.out.println("GP n-th term = " + nthTermGP(a1, r, n));
                    break;
                }
                case 3: {
                    System.out.print("Enter n: ");
                    long n = scanner.nextLong();
                    System.out.println("Fibonacci n-th term = " + nthFibonacci(n));
                    break;
                }
                case 4: {
                    System.out.print("Enter n: ");
                    long n = scanner.nextLong();
                    System.out.println("Triangular n-th term = " + nthTriangular(n));
                    break;
                }
                case 5: {
                    System.out.print("Enter n: ");
                    int n = scanner.nextInt();
                    System.out.println("n-th prime = " + nthPrime(n));
                    break;
                }
                default:
                    System.out.println("Invalid choice.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter numeric values only.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
