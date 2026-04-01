package inbuiltFunctions.wrapperclasses;

public class IntegerFunctions {

    public static void main(String[] args) {
        demoWrapperCommonMethods();
        System.out.println("-------------------------------------------------");
        demoIntegerSpecificMethods();
        System.out.println("-------------------------------------------------");
        demoConstantsAndUtilities();
    }

    // ---------------------- 1) Common Wrapper-like Methods (for Integer) ----------------------
    private static void demoWrapperCommonMethods() {
        System.out.println("Common Wrapper Methods (Integer)");

        // ✔ valueOf(String s) – Converts String to wrapper object
        Integer objFromString = Integer.valueOf("123");
        System.out.println("Integer.valueOf(\"123\") -> " + objFromString + " (type: " + objFromString.getClass().getSimpleName() + ")");

        // ✔ parseInt(String s) – Converts String to primitive int
        int primitiveFromString = Integer.parseInt("456");
        System.out.println("Integer.parseInt(\"456\") -> " + primitiveFromString);

        // ✔ toString() – Convert wrapper object to String
        String sObj = objFromString.toString();
        System.out.println("objFromString.toString() -> \"" + sObj + "\"");

        // ✔ intValue(), doubleValue(), floatValue() – Convert wrapper to primitives
        int intVal = objFromString.intValue();
        double doubleVal = objFromString.doubleValue();
        float floatVal = objFromString.floatValue();
        System.out.println("intValue() -> " + intVal);
        System.out.println("doubleValue() -> " + doubleVal);
        System.out.println("floatValue() -> " + floatVal);

        // ✔ compareTo() – Compare two wrapper objects
        Integer another = Integer.valueOf(200);
        int cmp = objFromString.compareTo(another); // 123 vs 200 -> negative
        System.out.println("objFromString.compareTo(200) -> " + cmp + " (negative means <)");

        // ✔ equals() – Check equality
        System.out.println("objFromString.equals(123) -> " + objFromString.equals(123)); // true (autoboxing)
        System.out.println("objFromString.equals(124) -> " + objFromString.equals(124)); // false
    }

    // ---------------------- 2) Integer-specific important methods ----------------------
    private static void demoIntegerSpecificMethods() {
        System.out.println("Integer-specific Methods");

        // parseInt(String s)
        int p1 = Integer.parseInt("1000");
        System.out.println("Integer.parseInt(\"1000\") -> " + p1);

        // valueOf(int i)
        Integer objFromInt = Integer.valueOf(250);
        System.out.println("Integer.valueOf(250) -> " + objFromInt);

        // toString(int i) – static
        String s1 = Integer.toString(789);
        System.out.println("Integer.toString(789) -> \"" + s1 + "\"");

        // compare(int a, int b) – static comparison of primitives
        System.out.println("Integer.compare(5, 9) -> " + Integer.compare(5, 9));   // <0
        System.out.println("Integer.compare(9, 5) -> " + Integer.compare(9, 5));   // >0
        System.out.println("Integer.compare(7, 7) -> " + Integer.compare(7, 7));   // 0

        // compareTo(Integer another) – instance comparison (already shown above; again for clarity)
        Integer a = 42, b = 42, c = 100;
        System.out.println("a.compareTo(b) where a=42, b=42 -> " + a.compareTo(b)); // 0
        System.out.println("a.compareTo(c) where a=42, c=100 -> " + a.compareTo(c)); // <0

        // intValue() (again) & byteValue()
        System.out.println("a.intValue() -> " + a.intValue());
        System.out.println("a.byteValue() -> " + a.byteValue()); // may truncate if value > 127 or < -128

        // equals()
        System.out.println("a.equals(b) -> " + a.equals(b));     // true
        System.out.println("a.equals(100) -> " + a.equals(100)); // false
    }

    // ---------------------- 3) Constants and utility methods ----------------------
    private static void demoConstantsAndUtilities() {
        System.out.println("Constants & Utility Methods");

        // MIN_VALUE, MAX_VALUE
        System.out.println("Integer.MIN_VALUE -> " + Integer.MIN_VALUE);
        System.out.println("Integer.MAX_VALUE -> " + Integer.MAX_VALUE);

        // sum(), max(), min()
        System.out.println("Integer.sum(10, 20) -> " + Integer.sum(10, 20)); // 30
        System.out.println("Integer.max(10, 20) -> " + Integer.max(10, 20)); // 20
        System.out.println("Integer.min(10, 20) -> " + Integer.min(10, 20)); // 10

        // Bonus: show toString for different bases (useful in practice)
        System.out.println("Integer.toString(255, 16) -> \"" + Integer.toString(255, 16) + "\" (hex)"); // "ff"
        System.out.println("Integer.toBinaryString(10) -> \"" + Integer.toBinaryString(10) + "\"");
        System.out.println("Integer.toHexString(255) -> \"" + Integer.toHexString(255) + "\"");
        System.out.println("Integer.toOctalString(64) -> \"" + Integer.toOctalString(64) + "\"");
    }
}