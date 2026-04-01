package practiseprograms.strings;

import java.util.Scanner;

public class EvenLengthWords {

    public static void evenLengthWords() {
        try (Scanner sc = new Scanner(System.in)) {

            System.out.print("Enter a sentence: ");
            String sentence = sc.nextLine().trim();

            if (sentence.isEmpty()) {
                System.out.println("Empty input! Please enter a valid sentence.");
                return;
            }

            // Split by spaces (one or more)
            String[] words = sentence.split("\\s+");

            System.out.println("Words with even length:");
            boolean found = false;

            for (String word : words) {
                // Remove punctuation if needed
                String clean = word.replaceAll("[^a-zA-Z0-9]", "");

                if (clean.length() % 2 == 0 && clean.length() > 0) {
                    System.out.println(clean);
                    found = true;
                }
            }

            if (!found) {
                System.out.println("No even-length words found.");
            }
        }
    }

    public static void main(String[] args) {
        evenLengthWords();
    }
}