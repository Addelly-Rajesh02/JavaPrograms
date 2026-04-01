package inbuiltFunctions.langpackage;

import java.util.Arrays;

public class StringFunctions {

    public static void main(String[] args) {
        String s = "  Hello Java World  ";

        // -------- length() --------
        System.out.println("length(): " + s.length()); // includes spaces

        // -------- charAt(int index) --------
        // Accessing character at index 2 (remember 0-based indexing)
        System.out.println("charAt(2): '" + s.charAt(2) + "'");
        // Edge case: uncommenting below will throw StringIndexOutOfBoundsException
        // System.out.println(s.charAt(s.length()));

        // -------- substring(int start, int end) --------
        // Extract "Hello" (start inclusive, end exclusive)
        String sub1 = s.substring(2, 7);
        System.out.println("substring(2, 7): \"" + sub1 + "\"");

        // Extract from index 2 to end
        String sub2 = s.substring(2);
        System.out.println("substring(2): \"" + sub2 + "\"");

        // -------- toLowerCase(), toUpperCase() --------
        System.out.println("toLowerCase(): \"" + s.toLowerCase() + "\"");
        System.out.println("toUpperCase(): \"" + s.toUpperCase() + "\"");

        // -------- contains(), startsWith(), endsWith() --------
        System.out.println("contains(\"Java\"): " + s.contains("Java"));
        System.out.println("startsWith(\"  He\"): " + s.startsWith("  He")); // includes the leading spaces
        System.out.println("endsWith(\"ld  \"): " + s.endsWith("ld  "));     // includes the trailing spaces

        // -------- replace() --------
        // Replace all occurrences of "Java" with "Core Java"
        String replaced = s.replace("Java", "Core Java");
        System.out.println("replace(\"Java\", \"Core Java\"): \"" + replaced + "\"");

        // -------- trim() --------
        // Removes leading and trailing whitespace (not middle spaces)
        String trimmed = s.trim();
        System.out.println("trim(): \"" + trimmed + "\"");

        // -------- split(String regex) --------
        // Split on one or more spaces using regex "\\s+"
        String[] parts = trimmed.split("\\s+");
        System.out.println("split(\"\\\\s+\"): " + Arrays.toString(parts));

        // -------- equals(), equalsIgnoreCase() --------
        String a = "Hello";
        String b = "hello";
        System.out.println("equals(\"Hello\", \"hello\"): " + a.equals(b));                 // false
        System.out.println("equalsIgnoreCase(\"Hello\", \"hello\"): " + a.equalsIgnoreCase(b)); // true

        // Bonus tips (optional prints for learning):
        // Safe check before charAt:
        System.out.println("Safe charAt: " + (trimmed.length() > 0 ? trimmed.charAt(0) : "empty string"));

        // Replace vs replaceAll (regex):
        String dotted = "v1.2.3";
        System.out.println("replace('.', '-') -> \"" + dotted.replace('.', '-') + "\"");     // char-based
        System.out.println("replaceAll(\"\\\\.\", \"-\") -> \"" + dotted.replaceAll("\\\\.", "-") + "\""); // regex-based
    }
}
