package practiseprograms.strings;

import java.util.Arrays;
import java.util.Scanner;

public class Anagram {

    // Method 1: Using sorting (simple and clear)
    public static boolean isAnagramBySorting(String s1, String s2) {
        s1 = s1.replaceAll("\\s", "").toLowerCase();
        s2 = s2.replaceAll("\\s", "").toLowerCase();

        if (s1.length() != s2.length()) return false;

        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();

        Arrays.sort(a);
        Arrays.sort(b);

        return Arrays.equals(a, b);
    }

    // Method 2: Using character frequency (faster than sorting)
    public static boolean isAnagramByFrequency(String s1, String s2) {
        s1 = s1.replaceAll("\\s", "").toLowerCase();
        s2 = s2.replaceAll("\\s", "").toLowerCase();

        if (s1.length() != s2.length()) return false;

        int[] freq = new int[256]; // ASCII frequency table

        for (char c : s1.toCharArray()) freq[c]++;
        for (char c : s2.toCharArray()) freq[c]--;

        for (int f : freq) {
            if (f != 0) return false;
        }
        return true;
    }

    // Wrapper method for user input
    public static void anagram() {
        try (Scanner sc = new Scanner(System.in)) {

            System.out.print("Enter first string: ");
            String s1 = sc.nextLine();

            System.out.print("Enter second string: ");
            String s2 = sc.nextLine();

            boolean result = isAnagramBySorting(s1, s2);

            if (result)
                System.out.println("\nResult: Strings are ANAGRAMS");
            else
                System.out.println("\nResult: Strings are NOT anagrams");
        }
    }

    public static void main(String[] args) {
        anagram();
    }
}