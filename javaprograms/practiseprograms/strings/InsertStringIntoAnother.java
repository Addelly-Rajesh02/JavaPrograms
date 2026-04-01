package practiseprograms.strings;

import java.util.Scanner;

public class InsertStringIntoAnother {

    // Insert at a specific index
    public static String insertAtIndex(String original, String toInsert, int index) {
        if (index < 0 || index > original.length()) {
            System.out.println("Invalid index! Inserting at the end.");
            index = original.length();
        }

        String part1 = original.substring(0, index);
        String part2 = original.substring(index);

        return part1 + toInsert + part2;
    }

    // Wrapper for user input
    public static void insertStringIntoAnother() {
        try (Scanner sc = new Scanner(System.in)) {

            System.out.print("Enter the main/original string: ");
            String mainStr = sc.nextLine();

            System.out.print("Enter the string to insert: ");
            String insertStr = sc.nextLine();

            System.out.println("\nChoose option:");
            System.out.println("1) Insert at beginning");
            System.out.println("2) Insert at end");
            System.out.println("3) Insert at specific index");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            String result = "";

            switch (choice) {
                case 1 -> result = insertStr + mainStr;  // beginning
                case 2 -> result = mainStr + insertStr;  // end
                case 3 -> {
                    System.out.print("Enter index: ");
                    int index = sc.nextInt();
                    result = insertAtIndex(mainStr, insertStr, index);
                }
                default -> System.out.println("Invalid choice.");
            }

            System.out.println("\nFinal Result: " + result);
        }
    }

    public static void main(String[] args) {
        insertStringIntoAnother();
    }
}
