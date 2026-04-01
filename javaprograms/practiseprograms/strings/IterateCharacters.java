package practiseprograms.strings;

import java.util.Scanner;

public class IterateCharacters {

    // Method: Using charAt()
    public static void iterateUsingCharAt(String str) {
        System.out.println("\nIterating using charAt():");
        for (int i = 0; i < str.length(); i++) {
            System.out.println("Index " + i + " : " + str.charAt(i));
        }
    }

    // Method: Using toCharArray()
    public static void iterateUsingToCharArray(String str) {
        System.out.println("\nIterating using toCharArray():");
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Index " + i + " : " + arr[i]);
        }
    }

    // Method: Enhanced For-Loop
    public static void iterateUsingForEach(String str) {
        System.out.println("\nIterating using enhanced for-loop:");
        int index = 0;
        for (char c : str.toCharArray()) {
            System.out.println("Index " + index++ + " : " + c);
        }
    }

    // Method: Java 8 Streams
    public static void iterateUsingStreams(String str) {
        System.out.println("\nIterating using Java Streams:");
        str.chars().forEach(c -> System.out.println((char) c));
    }

    // Method: Unicode Code Points (for emojis, combined characters)
    public static void iterateUsingCodePoints(String str) {
        System.out.println("\nIterating using Unicode Code Points:");
        str.codePoints().forEach(cp -> System.out.println(Character.toChars(cp)));
    }

    // Wrapper for user-driven choice
    public static void iterateCharacters() {
        try (Scanner sc = new Scanner(System.in)) {

            System.out.print("Enter a string: ");
            String input = sc.nextLine();

            System.out.println("\nChoose iteration method:");
            System.out.println("1) Using charAt()");
            System.out.println("2) Using toCharArray()");
            System.out.println("3) Using enhanced for-loop");
            System.out.println("4) Using Streams");
            System.out.println("5) Using Unicode Code Points (best for emojis)");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> iterateUsingCharAt(input);
                case 2 -> iterateUsingToCharArray(input);
                case 3 -> iterateUsingForEach(input);
                case 4 -> iterateUsingStreams(input);
                case 5 -> iterateUsingCodePoints(input);
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    public static void main(String[] args) {
        iterateCharacters();
    }
}