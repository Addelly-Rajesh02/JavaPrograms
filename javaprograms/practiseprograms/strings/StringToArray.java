package practiseprograms.strings;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class StringToArray {

    // 1) Convert to char[]
    public static char[] toCharArray(String s) {
        return s.toCharArray();
    }

    // 2) Convert to String[] of words (split on whitespace)
    public static String[] toWords(String s) {
        // Trim to avoid empty leading element if string starts with spaces
        String trimmed = s.trim();
        if (trimmed.isEmpty()) return new String[0];
        return trimmed.split("\\s+");
    }

    // 3) Convert to String[] of characters (each element is a single-character string)
    //    Note: For basic BMP characters this is fine; for emojis (surrogate pairs),
    //    prefer code points (see method 5).
    public static String[] toStringCharacters(String s) {
        String[] result = new String[s.length()];
        for (int i = 0; i < s.length(); i++) {
            result[i] = String.valueOf(s.charAt(i));
        }
        return result;
    }

    // 4) Convert to byte[] using a given Charset (e.g., UTF-8)
    public static byte[] toBytes(String s, Charset charset) {
        return s.getBytes(charset);
    }

    // 5) Convert to int[] code points (correct for emojis and all Unicode)
    public static int[] toCodePoints(String s) {
        return s.codePoints().toArray();
    }

    // Helper to pretty print code points as characters (where printable)
    private static String codePointsPretty(int[] cps) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < cps.length; i++) {
            int cp = cps[i];
            String ch = new String(Character.toChars(cp));
            sb.append(cp).append(" ('").append(ch).append("')");
            if (i < cps.length - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    // Wrapper for user interaction (matches your method signature)
    public static void stringToArray() {
        try (Scanner sc = new Scanner(System.in)) {

            System.out.print("Enter a string: ");
            String input = sc.nextLine();

            System.out.println("\nChoose conversion:");
            System.out.println("1) char[] (toCharArray)");
            System.out.println("2) String[] of words (split by whitespace)");
            System.out.println("3) String[] of single characters");
            System.out.println("4) byte[] (UTF-8)");
            System.out.println("5) int[] code points (emoji-safe)");
            System.out.print("Enter choice: ");
            int choice = Integer.parseInt(sc.nextLine().trim());

            switch (choice) {
                case 1 -> {
                    char[] arr = toCharArray(input);
                    System.out.println("char[]: " + Arrays.toString(arr));
                }
                case 2 -> {
                    String[] words = toWords(input);
                    System.out.println("String[] words: " + Arrays.toString(words));
                }
                case 3 -> {
                    String[] chars = toStringCharacters(input);
                    System.out.println("String[] characters: " + Arrays.toString(chars));
                }
                case 4 -> {
                    byte[] bytes = toBytes(input, StandardCharsets.UTF_8);
                    System.out.println("byte[] (UTF-8): " + Arrays.toString(bytes));
                }
                case 5 -> {
                    int[] cps = toCodePoints(input);
                    System.out.println("code points: " + Arrays.toString(cps));
                    System.out.println("code points pretty: " + codePointsPretty(cps));
                }
                default -> System.out.println("Invalid choice.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid numeric input for choice.");
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        stringToArray();
    }
}