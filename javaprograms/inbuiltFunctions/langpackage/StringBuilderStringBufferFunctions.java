package inbuiltFunctions.langpackage;

public class StringBuilderStringBufferFunctions {

    public static void main(String[] args) {
        demoStringBuilder();
        System.out.println("-------------------------------------------------");
        demoStringBuffer();
    }

    // ---------------------- StringBuilder Demo ----------------------
    private static void demoStringBuilder() {
        System.out.println("StringBuilder Demo");

        // Start with initial content
        StringBuilder sb = new StringBuilder("Hello");

        // append()
        sb.append(" World");                 // "Hello World"
        sb.append('!');                      // "Hello World!"
        sb.append(" Count: ").append(123);   // supports chaining
        System.out.println("append()   -> " + sb.toString());

        // insert(int offset, ...)
        sb.insert(6, "Java ");               // "Hello Java World! Count: 123"
        System.out.println("insert()   -> " + sb);

        // replace(int start, int end, String str)
        // Replace "Java " with "Beautiful "
        int start = sb.indexOf("Java");
        int end   = start + "Java ".length();
        sb.replace(start, end, "Beautiful "); // "Hello Beautiful World! Count: 123"
        System.out.println("replace()  -> " + sb);

        // delete(int start, int end)
        // Delete " Count: 123"
        int delStart = sb.indexOf(" Count");
        sb.delete(delStart, sb.length());    // "Hello Beautiful World!"
        System.out.println("delete()   -> " + sb);

        // reverse()
        sb.reverse();                        // "!dlroW lufituaeB olleH"
        System.out.println("reverse()  -> " + sb);

        // toString()
        String result = sb.toString();
        System.out.println("toString() -> " + result);
    }

    // ---------------------- StringBuffer Demo -----------------------
    private static void demoStringBuffer() {
        System.out.println("StringBuffer Demo");

        // Start with initial content
        StringBuffer sb = new StringBuffer("Core");

        // append()
        sb.append(" Java");                  // "Core Java"
        sb.append(" API");                   // "Core Java API"
        System.out.println("append()   -> " + sb.toString());

        // insert(int offset, ...)
        sb.insert(5, "and ");                // "Core and Java API"
        System.out.println("insert()   -> " + sb);

        // replace(int start, int end, String str)
        // Replace "and " with "& "
        int start = sb.indexOf("and ");
        int end   = start + "and ".length();
        sb.replace(start, end, "& ");        // "Core & Java API"
        System.out.println("replace()  -> " + sb);

        // delete(int start, int end)
        // Delete " API"
        int delStart = sb.indexOf(" API");
        sb.delete(delStart, sb.length());    // "Core & Java"
        System.out.println("delete()   -> " + sb);

        // reverse()
        sb.reverse();                        // "avaJ & eroC"
        System.out.println("reverse()  -> " + sb);

        // toString()
        String result = sb.toString();
        System.out.println("toString() -> " + result);
    }
}