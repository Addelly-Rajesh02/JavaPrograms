package inbuiltFunctions.wrapperclasses;

public class ByteFunctions {

    public static void main(String[] args) {
        demoValueOfStringAndParseByte();
        System.out.println("-------------------------------------------------");
        demoValueOfPrimitiveAndByteValue();
        System.out.println("-------------------------------------------------");
        demoToStringVariants();
        System.out.println("-------------------------------------------------");
        demoRadixAndEdgeCases();
    }

    // ---------------------- valueOf(String) & parseByte(String) ----------------------
    private static void demoValueOfStringAndParseByte() {
        System.out.println("valueOf(String) & parseByte(String)");

        // ✔ valueOf(String s) – String -> Byte (object)
        Byte bObj = Byte.valueOf("120");
        System.out.println("Byte.valueOf(\"120\") -> " + bObj + " (type: " + bObj.getClass().getSimpleName() + ")");

        // ✔ parseByte(String s) – String -> byte (primitive)
        byte bPrim = Byte.parseByte("100");
        System.out.println("Byte.parseByte(\"100\") -> " + bPrim);

        // Out-of-range or invalid input throws NumberFormatException
        try {
            Byte.parseByte("200"); // 200 is outside byte range [-128..127]
        } catch (NumberFormatException e) {
            System.out.println("Byte.parseByte(\"200\") -> NumberFormatException (out of range)");
        }

        try {
            Byte.parseByte("12a");
        } catch (NumberFormatException e) {
            System.out.println("Byte.parseByte(\"12a\") -> NumberFormatException (invalid format)");
        }
    }

    // ---------------------- valueOf(byte) & byteValue() ----------------------
    private static void demoValueOfPrimitiveAndByteValue() {
        System.out.println("valueOf(byte) & byteValue()");

        // ✔ valueOf(byte b) – primitive -> Byte object (boxing)
        Byte bx = Byte.valueOf((byte) 42);
        System.out.println("Byte.valueOf((byte)42) -> " + bx);

        // ✔ byteValue() – Byte object -> primitive (unboxing)
        byte bxPrim = bx.byteValue();
        System.out.println("bx.byteValue() -> " + bxPrim);

        // Other primitive extractors (useful to see truncation rules)
        System.out.println("bx.intValue() -> " + bx.intValue());
        System.out.println("bx.doubleValue() -> " + bx.doubleValue());
        System.out.println("bx.floatValue() -> " + bx.floatValue());
    }

    // ---------------------- toString() variants ----------------------
    private static void demoToStringVariants() {
        System.out.println("toString() variants");

        Byte b = Byte.valueOf((byte) -7);

        // ✔ Instance toString()
        System.out.println("Byte.valueOf((byte)-7).toString() -> \"" + b.toString() + "\"");

        // ✔ Static toString(byte)
        String s = Byte.toString((byte) 99);
        System.out.println("Byte.toString((byte)99) -> \"" + s + "\"");
    }

    // ---------------------- Radix overloads & more edge cases ----------------------
    private static void demoRadixAndEdgeCases() {
        System.out.println("Radix overloads & edge cases");

        // parseByte(String s, int radix)
        byte hexVal = Byte.parseByte("7f", 16);  // 0x7F = 127
        System.out.println("Byte.parseByte(\"7f\", 16) -> " + hexVal);

        // valueOf(String s, int radix)
        Byte bHex = Byte.valueOf("7F", 16);
        System.out.println("Byte.valueOf(\"7F\", 16) -> " + bHex);

        // Demonstrate signed range [-128..127]
        System.out.println("Byte.MIN_VALUE -> " + Byte.MIN_VALUE);
        System.out.println("Byte.MAX_VALUE -> " + Byte.MAX_VALUE);

        // Out-of-range in given radix
        try {
            Byte.parseByte("80", 16); // 0x80 = 128 (out of range for byte)
        } catch (NumberFormatException e) {
            System.out.println("Byte.parseByte(\"80\", 16) -> NumberFormatException (128 out of byte range)");
        }

        // Leading + / - signs are supported
        System.out.println("Byte.parseByte(\"-128\") -> " + Byte.parseByte("-128"));
        System.out.println("Byte.parseByte(\"+127\") -> " + Byte.parseByte("+127"));
    }
}
