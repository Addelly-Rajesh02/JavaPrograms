package practiseprograms.strings;

import java.util.Scanner;

public class PalindromeString {

    // Check palindrome (ignores spaces, case)
    public static boolean isPalindrome(String str) {
        // Remove spaces and convert to lowercase
        String clean = str.replaceAll("\\s+", "").toLowerCase();

        int left = 0;
        int right = clean.length() - 1;

        while (left < right) {
            if (clean.charAt(left) != clean.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void palindromeString() {
        try (Scanner sc = new Scanner(System.in)) {

            System.out.print("Enter a string: ");
            String input = sc.nextLine();

            // call helper
            boolean result = isPalindrome(input);

            if (result) {
                System.out.println("The string is a PALINDROME.");
            } else {
                System.out.println("The string is NOT a palindrome.");
            }
        }
    }

    public static void main(String[] args) {
        palindromeString();
    }
}