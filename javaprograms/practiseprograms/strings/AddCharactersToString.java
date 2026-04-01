package practiseprograms.strings;

import java.util.Scanner;

public class AddCharactersToString {

    // Adds characters at beginning
    public static String addAtBeginning(String original, String toAdd) {
        return toAdd + original;
    }

    // Adds characters at end
    public static String addAtEnd(String original, String toAdd) {
        return original + toAdd;
    }

    // Adds characters at a specific index
    public static String addAtIndex(String original, String toAdd, int index) {
        if (index < 0 || index > original.length()) {
            System.out.println("Invalid index. Adding at the end.");
            index = original.length();
        }
        String left = original.substring(0, index);
        String right = original.substring(index);
        return left + toAdd + right;
    }

    // Wrapper for user-driven operation
    public static void addCharToString() {
        try (Scanner sc = new Scanner(System.in)) {

            System.out.print("Enter the original string: ");
            String original = sc.nextLine();

            System.out.print("Enter the characters to add: ");
            String toAdd = sc.nextLine();

            System.out.println("\nChoose option:");
            System.out.println("1) Add at beginning");
            System.out.println("2) Add at end");
            System.out.println("3) Add at index");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            String result = "";

            switch (choice) {
                case 1 -> result = addAtBeginning(original, toAdd);
                case 2 -> result = addAtEnd(original, toAdd);
                case 3 -> {
                    System.out.print("Enter index: ");
                    int index = sc.nextInt();
                    result = addAtIndex(original, toAdd, index);
                }
                default -> System.out.println("Invalid choice.");
            }

            System.out.println("\nResult: " + result);
        }
    }

    public static void main(String[] args) {
        addCharToString();
    }
}