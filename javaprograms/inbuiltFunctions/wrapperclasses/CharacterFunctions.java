package inbuiltFunctions.wrapperclasses;

public class CharacterFunctions {

    public static void main(String[] args) {
        demoValueOfAndToString();
        System.out.println("-------------------------------------------------");
        demoCharacterPredicates();
        System.out.println("-------------------------------------------------");
        demoMoreExamples();
    }

    // ---------------------- valueOf(...) & toString() ----------------------
    private static void demoValueOfAndToString() {
        System.out.println("valueOf(...) & toString()");

        // Proper way: valueOf(char)
        Character ch = Character.valueOf('A'); // wrapper from primitive
        System.out.println("Character.valueOf('A') -> " + ch + " (type: " + ch.getClass().getSimpleName() + ")");

        // From String: take the first character (since Character.valueOf(String) doesn't exist)
        String s = "Hello";
        Character first = s != null && !s.isEmpty() ? s.charAt(0) : null;
        System.out.println("First char from \"Hello\" -> " + first);

        // toString() on Character object
        String asText = ch.toString();
        System.out.println("new Character('A').toString() -> \"" + asText + "\"");
    }

    // ---------------------- Character classification methods ----------------------
    private static void demoCharacterPredicates() {
        System.out.println("Character classification methods");

        char c1 = '7';
        char c2 = 'G';
        char c3 = 'g';
        char c4 = ' ';
        char c5 = '\n';
        char c6 = '©';
        char c7 = 'अ'; // Devanagari (letter)
        char c8 = '中'; // CJK (letter)

        // isDigit
        System.out.println("isDigit('7') -> " + Character.isDigit(c1)); // true
        System.out.println("isDigit('G') -> " + Character.isDigit(c2)); // false

        // isLetter
        System.out.println("isLetter('G') -> " + Character.isLetter(c2)); // true
        System.out.println("isLetter('©') -> " + Character.isLetter(c6)); // false
        System.out.println("isLetter('अ') -> " + Character.isLetter(c7)); // true
        System.out.println("isLetter('中') -> " + Character.isLetter(c8)); // true

        // isLetterOrDigit
        System.out.println("isLetterOrDigit('7') -> " + Character.isLetterOrDigit(c1)); // true
        System.out.println("isLetterOrDigit('©') -> " + Character.isLetterOrDigit(c6)); // false

        // isUpperCase / isLowerCase
        System.out.println("isUpperCase('G') -> " + Character.isUpperCase(c2)); // true
        System.out.println("isLowerCase('g') -> " + Character.isLowerCase(c3)); // true
        System.out.println("isUpperCase('7') -> " + Character.isUpperCase(c1)); // false

        // isWhitespace (space, tab, newline, etc.)
        System.out.println("isWhitespace(' ')  -> " + Character.isWhitespace(c4)); // true
        System.out.println("isWhitespace('\\n') -> " + Character.isWhitespace(c5)); // true
        System.out.println("isWhitespace('G')  -> " + Character.isWhitespace(c2)); // false
    }

    // ---------------------- Extra: show typical usage in small contexts ----------------------
    private static void demoMoreExamples() {
        System.out.println("More examples");

        String token = "Java-17";
        int letters = 0, digits = 0, whitespace = 0, others = 0;

        for (int i = 0; i < token.length(); i++) {
            char c = token.charAt(i);
            if (Character.isLetter(c)) letters++;
            else if (Character.isDigit(c)) digits++;
            else if (Character.isWhitespace(c)) whitespace++;
            else others++;
        }

        System.out.println("In \"" + token + "\": letters=" + letters + ", digits=" + digits +
                ", whitespace=" + whitespace + ", others=" + others);

        // Case checks
        char x = 'q';
        char y = 'Q';
        System.out.println("'q' isLowerCase -> " + Character.isLowerCase(x));
        System.out.println("'Q' isUpperCase -> " + Character.isUpperCase(y));
    }
}