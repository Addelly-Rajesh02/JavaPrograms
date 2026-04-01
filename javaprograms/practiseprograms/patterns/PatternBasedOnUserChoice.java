package practiseprograms.patterns;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PatternBasedOnUserChoice {

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

    private static String normSymbol(String sym) {
        if (sym == null || sym.isBlank()) return "*"; // default
        return sym;
    }

    private static boolean invalidN(int n) {
        if (n <= 0) {
            System.out.println("Please enter a positive number for rows/size.");
            return true;
        }
        return false;
    }

    // --- Patterns ---

    // 1) Left-aligned triangle
    private static void leftTriangle(int n, String sym) {
        sym = normSymbol(sym);
        for (int i = 1; i <= n; i++) {
            System.out.println(repeat(sym, i));
        }
    }

    // 2) Right-aligned triangle
    private static void rightTriangle(int n, String sym) {
        sym = normSymbol(sym);
        int w = sym.length();
        for (int i = 1; i <= n; i++) {
            System.out.println(spaces((n - i) * w) + repeat(sym, i));
        }
    }

    // 3) Centered (upright) pyramid
    private static void pyramid(int n, String sym) {
        sym = normSymbol(sym);
        int w = sym.length();
        for (int row = 0; row < n; row++) {
            int leftPad = (n - 1 - row) * w;
            int count = 2 * row + 1;
            System.out.println(spaces(leftPad) + repeat(sym, count));
        }
    }

    // 4) Inverted left-aligned triangle
    private static void invertedLeftTriangle(int n, String sym) {
        sym = normSymbol(sym);
        for (int i = n; i >= 1; i--) {
            System.out.println(repeat(sym, i));
        }
    }

    // 5) Inverted right-aligned triangle
    private static void invertedRightTriangle(int n, String sym) {
        sym = normSymbol(sym);
        int w = sym.length();
        for (int i = n; i >= 1; i--) {
            System.out.println(spaces((n - i) * w) + repeat(sym, i));
        }
    }

    // 6) Centered inverted pyramid
    private static void invertedPyramid(int n, String sym) {
        sym = normSymbol(sym);
        int w = sym.length();
        int width = 2 * n - 1;
        for (int row = 0; row < n; row++) {
            int leftPad = row * w;
            int count = width - 2 * row;
            System.out.println(spaces(leftPad) + repeat(sym, count));
        }
    }

    // 7) Diamond (top pyramid + bottom inverted pyramid)
    private static void diamond(int n, String sym) {
        sym = normSymbol(sym);
        int w = sym.length();
        // top
        for (int row = 0; row < n; row++) {
            int leftPad = (n - 1 - row) * w;
            int count = 2 * row + 1;
            System.out.println(spaces(leftPad) + repeat(sym, count));
        }
        // bottom (exclude middle row to avoid duplication)
        for (int row = n - 2; row >= 0; row--) {
            int leftPad = (n - 1 - row) * w;
            int count = 2 * row + 1;
            System.out.println(spaces(leftPad) + repeat(sym, count));
        }
    }

    // 8) Hollow centered pyramid
    private static void hollowPyramid(int n, String sym) {
        sym = normSymbol(sym);
        int w = sym.length();
        for (int row = 0; row < n; row++) {
            int leftPad = (n - 1 - row) * w;
            if (row == 0) {
                System.out.println(spaces(leftPad) + sym);
            } else if (row == n - 1) {
                System.out.println(repeat(sym, 2 * n - 1));
            } else {
                int innerSpaces = (2 * row - 1) * w; // preserve alignment for multi-char symbols
                System.out.println(spaces(leftPad) + sym + spaces(innerSpaces) + sym);
            }
        }
    }

    // 9) Plus ('+') shape in s x s grid (best with odd s)
    private static void plusShape(int s, String sym) {
        sym = normSymbol(sym);
        int w = sym.length();
        int mid = s / 2; // for odd s, exact middle; for even, the lower middle
        for (int i = 0; i < s; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < s; j++) {
                if (i == mid || j == mid) row.append(sym);
                else row.append(spaces(w));
            }
            System.out.println(row);
        }
    }

    // 10) X shape in s x s grid
    private static void xShape(int s, String sym) {
        sym = normSymbol(sym);
        int w = sym.length();
        for (int i = 0; i < s; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < s; j++) {
                if (i == j || i + j == s - 1) row.append(sym);
                else row.append(spaces(w));
            }
            System.out.println(row);
        }
    }

    // 11) Hollow rectangle (rows x cols)
    private static void hollowRectangle(int rows, int cols, String sym) {
        sym = normSymbol(sym);
        int w = sym.length();
        if (rows <= 0 || cols <= 0) {
            System.out.println("Rows and columns must be positive.");
            return;
        }
        for (int i = 1; i <= rows; i++) {
            StringBuilder line = new StringBuilder();
            for (int j = 1; j <= cols; j++) {
                if (i == 1 || i == rows || j == 1 || j == cols) line.append(sym);
                else line.append(spaces(w));
            }
            System.out.println(line);
        }
    }

    // --- Menu & input handler ---
    public static void patternBasedOnUserChoice() {
        try (Scanner sc = new Scanner(System.in)) {
            boolean running = true;
            while (running) {
                System.out.println("\n=== Pattern Menu ===");
                System.out.println(" 1) Left triangle");
                System.out.println(" 2) Right-aligned triangle");
                System.out.println(" 3) Centered pyramid");
                System.out.println(" 4) Inverted left triangle");
                System.out.println(" 5) Inverted right triangle");
                System.out.println(" 6) Centered inverted pyramid");
                System.out.println(" 7) Diamond");
                System.out.println(" 8) Hollow pyramid");
                System.out.println(" 9) Plus (+) shape");
                System.out.println("10) X shape");
                System.out.println("11) Hollow rectangle");
                System.out.println("12) Exit");
                System.out.print("Enter your choice: ");

                int choice;
                try {
                    choice = sc.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Please enter a valid number.");
                    sc.nextLine(); // clear invalid token
                    continue;
                }

                if (choice == 12) {
                    running = false;
                    break;
                }

                // Read the symbol (any text; default "*")
                System.out.print("Enter symbol (any text, default '*'): ");
                sc.nextLine(); // consume leftover newline
                String sym = sc.nextLine().trim();
                if (sym.isEmpty()) sym = "*";

                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter rows (n): ");
                        int n = sc.nextInt();
                        if (!invalidN(n)) leftTriangle(n, sym);
                    }
                    case 2 -> {
                        System.out.print("Enter rows (n): ");
                        int n = sc.nextInt();
                        if (!invalidN(n)) rightTriangle(n, sym);
                    }
                    case 3 -> {
                        System.out.print("Enter rows (n): ");
                        int n = sc.nextInt();
                        if (!invalidN(n)) pyramid(n, sym);
                    }
                    case 4 -> {
                        System.out.print("Enter rows (n): ");
                        int n = sc.nextInt();
                        if (!invalidN(n)) invertedLeftTriangle(n, sym);
                    }
                    case 5 -> {
                        System.out.print("Enter rows (n): ");
                        int n = sc.nextInt();
                        if (!invalidN(n)) invertedRightTriangle(n, sym);
                    }
                    case 6 -> {
                        System.out.print("Enter rows (n): ");
                        int n = sc.nextInt();
                        if (!invalidN(n)) invertedPyramid(n, sym);
                    }
                    case 7 -> {
                        System.out.print("Enter half-height (n): ");
                        int n = sc.nextInt();
                        if (!invalidN(n)) diamond(n, sym);
                    }
                    case 8 -> {
                        System.out.print("Enter rows (n): ");
                        int n = sc.nextInt();
                        if (!invalidN(n)) hollowPyramid(n, sym);
                    }
                    case 9 -> {
                        System.out.print("Enter grid size (odd recommended, e.g., 5): ");
                        int s = sc.nextInt();
                        if (!invalidN(s)) plusShape(s, sym);
                    }
                    case 10 -> {
                        System.out.print("Enter grid size (odd recommended, e.g., 5): ");
                        int s = sc.nextInt();
                        if (!invalidN(s)) xShape(s, sym);
                    }
                    case 11 -> {
                        System.out.print("Enter rows: ");
                        int r = sc.nextInt();
                        System.out.print("Enter cols: ");
                        int c = sc.nextInt();
                        if (r > 0 && c > 0) hollowRectangle(r, c, sym);
                        else System.out.println("Rows and columns must be positive.");
                    }
                    default -> System.out.println("Invalid choice.");
                }
            }
            System.out.println("Exiting. Goodbye!");
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        patternBasedOnUserChoice();
    }
}