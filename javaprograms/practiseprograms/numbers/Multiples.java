package practiseprograms.numbers;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Multiples {

    public static List<Long> firstNMultiples(long k, int n) {
        if (n < 0) throw new IllegalArgumentException("n must be non-negative");
        List<Long> res = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            res.add(k * i);
        }
        return res;
    }

     public static boolean isMultiple(long a, long b) {
        if (b == 0) throw new IllegalArgumentException("Divisor cannot be zero");
        return a % b == 0;
    }

    public static List<Long> multiplesInRange(long k, long L, long R) {
        if (k == 0) throw new IllegalArgumentException("k cannot be zero");
        if (L > R) { long tmp = L; L = R; R = tmp; }

        List<Long> res = new ArrayList<>();
        // Normalize to work with positive step using absolute k
        long step = Math.abs(k);

        // Find the first multiple of k >= L
        long first;
        if (L % step == 0) {
            first = L;
        } else {
            first = L + (step - Math.floorMod(L, step));
        }

        for (long x = first; x <= R; x += step) {
            // Keep the sign consistent with k: if k < 0, the multiples can be negative too
            // But typically we print by magnitude; sticking to x is fine.
            res.add(x);
        }
        return res;
    }

    // 4) LCM (Least Common Multiple) using GCD
    public static long gcd(long a, long b) {
        a = Math.abs(a); b = Math.abs(b);
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    public static long lcm(long a, long b) {
        if (a == 0 || b == 0) return 0;
        return Math.abs(a / gcd(a, b) * b);
    }

    // 5) Sum of multiples of 3 or 5 up to N (inclusive or exclusive)
    // Here: sum of multiples of 3 or 5 below N (exclusive), classic problem
    public static long sumMultiples3or5Below(long n) {
        if (n <= 0) return 0;
        return sumOfMultiplesBelow(n, 3) + sumOfMultiplesBelow(n, 5) - sumOfMultiplesBelow(n, 15);
    }

    // Arithmetic progression sum: k + 2k + ... + mk = k * (1 + 2 + ... + m) = k * m * (m + 1) / 2
    private static long sumOfMultiplesBelow(long n, long k) {
        long m = (n - 1) / k;
        return k * m * (m + 1) / 2;
    }

    // --- Demo printer (you can keep only the one you need) ---
    public static void multiples() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Choose an option:");
            System.out.println("1) Print first N multiples of K");
            System.out.println("2) Check if A is a multiple of B");
            System.out.println("3) Print multiples of K in range [L, R]");
            System.out.println("4) LCM of two numbers (and first few common multiples)");
            System.out.println("5) Sum of multiples of 3 or 5 below N");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1: {
                    System.out.print("Enter K: ");
                    long k = scanner.nextLong();
                    System.out.print("Enter N: ");
                    int n = scanner.nextInt();
                    List<Long> list = firstNMultiples(k, n);
                    System.out.println("First " + n + " multiples of " + k + ": " + list);
                    break;
                }
                case 2: {
                    System.out.print("Enter A: ");
                    long a = scanner.nextLong();
                    System.out.print("Enter B: ");
                    long b = scanner.nextLong();
                    System.out.println(a + (isMultiple(a, b) ? " is " : " is NOT ") + "a multiple of " + b);
                    break;
                }
                case 3: {
                    System.out.print("Enter K: ");
                    long k = scanner.nextLong();
                    System.out.print("Enter L (start): ");
                    long L = scanner.nextLong();
                    System.out.print("Enter R (end): ");
                    long R = scanner.nextLong();
                    List<Long> list = multiplesInRange(k, L, R);
                    System.out.println("Multiples of " + k + " in [" + L + ", " + R + "]: " + list);
                    break;
                }
                case 4: {
                    System.out.print("Enter A: ");
                    long a = scanner.nextLong();
                    System.out.print("Enter B: ");
                    long b = scanner.nextLong();
                    long l = lcm(a, b);
                    System.out.println("LCM(" + a + ", " + b + ") = " + l);
                    if (l != 0) {
                        System.out.print("How many common multiples to print? ");
                        int n = scanner.nextInt();
                        List<Long> commons = new ArrayList<>();
                        for (int i = 1; i <= n; i++) commons.add(l * i);
                        System.out.println("First " + n + " common multiples: " + commons);
                    }
                    break;
                }
                case 5: {
                    System.out.print("Enter N (sum multiples of 3 or 5 below N): ");
                    long n = scanner.nextLong();
                    System.out.println("Sum = " + sumMultiples3or5Below(n));
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

    public static void main(String[] args){
        // Run the demo menu
        multiples();
    }
}