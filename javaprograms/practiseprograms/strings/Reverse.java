package practiseprograms.strings;

import java.util.Scanner;

public class Reverse {

    // Method 1: Reverse using loop
    public static String reverseUsingLoop(String str) {
        String rev = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            rev = rev + str.charAt(i);
        }
        return rev;
    }

    // Method 2: Reverse using StringBuilder
    public static String reverseUsingStringBuilder(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    // Method 3: Reverse using char array
    public static String reverseUsingCharArray(String str) {
        char[] arr = str.toCharArray();
        int left = 0, right = arr.length - 1;

        while (left < right) {
            char tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }

        return new String(arr);
    }

    // Wrapper method for user selection
    public static void reverse() {
        try (Scanner sc = new Scanner(System.in)) {

            System.out.print("Enter string to reverse: ");
            String input = sc.nextLine();

            System.out.println("\nChoose method:");
            System.out.println("1) Reverse using loop");
            System.out.println("2) Reverse using StringBuilder");
            System.out.println("3) Reverse using char array");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            String result = "";

            switch (choice) {
                case 1 -> result = reverseUsingLoop(input);
                case 2 -> result = reverseUsingStringBuilder(input);
                case 3 -> result = reverseUsingCharArray(input);
                default -> System.out.println("Invalid choice!");
            }

            System.out.println("\nReversed String: " + result);
        }
    }

    public static void main(String[] args) {
        reverse();
    }
}