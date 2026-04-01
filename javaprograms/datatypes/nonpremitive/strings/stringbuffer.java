package datatypes.nonpremitive.strings;

public class stringbuffer {
    public static void main(String args[]){
        StringBuffer sb = new StringBuffer("Hello");

        sb.append(" World");       // Add text
        sb.insert(5, ",");         // Insert comma
        sb.replace(0, 5, "Hi");    // Replace "Hello" with "Hi"
        sb.delete(2, 3);           // Delete character at index 2
        sb.reverse();              // Reverse the string

        System.out.println("StringBuffer result: " + sb);
    }
}
