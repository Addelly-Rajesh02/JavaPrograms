package practiseprograms.patterns;

import java.util.Scanner;

public class ReversePyramid {

    // --- Helpers ---
    private static String repeat(String s, int times) {
        if (times <= 0) return "";
        StringBuilder sb = new StringBuilder(s.length() * times);
        for (int i = 0; i < times; i++) sb.append(s);
        return sb.toString();
    }

    private static String spaces(int count) {
        if (count <= 0) return "";
        return repeat(" ", count);
    }

    // --- Patterns ---

    /**
     * Filled centered inverted pyramid using any symbol.
     * Keeps alignment correct for multi-character symbols by scaling left padding.
     *
     * Example (n=5, sym="*"):
     * *********
     *  *******
     *   *****
     *    ***
     *     *
     */
    public static void reversePyramidFilled(int n, String sym) {
        if (n <= 0) {
            System.out.println("Please enter a positive number.");
            return;
        }
        if (sym == null || sym.isBlank()) sym = "*";
        int w = sym.length();
        int width = 2 * n - 1; // number of symbols in the top row

        for (int row = 0; row < n; row++) {
            int leftPad = row * w;                 // grows each row
            int count   = width - (2 * row);       // shrinks by 2 each row
            System.out.println(spaces(leftPad) + repeat(sym, count));
        }
    }

    /**
     * Hollow centered inverted pyramid.
     *
     * Example (n=5, sym="*"):
     * *********
     *  *     *
     *   *   *
     *    * *
     *     *
     */
    public static void reversePyramidHollow(int n, String sym) {
        if (n <= 0) {
            System.out.println("Please enter a positive number.");
            return;
        }
        if (sym == null || sym.isBlank()) sym = "*";
        int w = sym.length();

        // Top row: full width
        System.out.println(repeat(sym, 2 * n - 1));

        // Middle rows: two symbols with inner spaces
        for (int row = 1; row < n - 1; row++) {
            int leftPad     = row * w;                        // scaled to symbol width
            int innerSpaces = ((2 * (n - row) - 3) * w);      // spaces between the two border symbols
            System.out.println(spaces(leftPad) + sym + spaces(innerSpaces) + sym);
        }

        // Last row: single symbol at the center
        if (n > 1) {
            int leftPadCenter = (n - 1) * w;
            System.out.println(spaces(leftPadCenter) + sym);
        }
    }

    // --- Input-driven wrapper as per your method signature ---
    public static void reversePyramid() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter number of rows (n): ");
            int n = sc.nextInt();
            sc.nextLine(); // consume newline

            System.out.print("Enter symbol (press Enter for '*'): ");
            String sym = sc.nextLine().trim();
            if (sym.isEmpty()) sym = "*";

            System.out.print("Choose type: 1) Filled  2) Hollow : ");
            int type = sc.nextInt();

            if (type == 2) reversePyramidHollow(n, sym);
            else           reversePyramidFilled(n, sym);
        } catch (Exception e) {
            System.out.println("Invalid input. Please run again with proper values.");
        }
    }

    public static void main(String[] args) {
        reversePyramid();
    }
}