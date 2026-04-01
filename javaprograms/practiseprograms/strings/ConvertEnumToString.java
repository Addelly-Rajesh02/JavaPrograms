package practiseprograms.strings;

import java.util.Scanner;

public class ConvertEnumToString {

    // Example enum
    enum Color {
        RED, GREEN, BLUE, YELLOW, BLACK, WHITE
    }

    // Convert enum to string using different techniques
    public static void enumToString() {
        try (Scanner sc = new Scanner(System.in)) {

            System.out.println("Available Colors:");
            for (Color c : Color.values()) {
                System.out.println("- " + c);
            }

            System.out.print("\nEnter enum constant (e.g., RED): ");
            String input = sc.nextLine().trim().toUpperCase();

            try {
                Color selected = Color.valueOf(input);

                // Different ways to convert enum → string
                String str1 = selected.toString();     // 1) using toString()
                String str2 = selected.name();         // 2) using name()
                String str3 = "" + selected;           // 3) implicit string conversion
                String str4 = String.valueOf(selected);// 4) using valueOf()

                System.out.println("\nConverted to string using multiple methods:");
                System.out.println("toString() : " + str1);
                System.out.println("name()     : " + str2);
                System.out.println("Concatenate: " + str3);
                System.out.println("valueOf()  : " + str4);

            } catch (IllegalArgumentException e) {
                System.out.println("Invalid enum constant: " + input);
            }
        }
    }

    public static void main(String[] args) {
        enumToString();
    }
}