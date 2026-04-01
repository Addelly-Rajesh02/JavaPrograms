package inbuiltFunctions.wrapperclasses;

public class ShortFunctions {

    public static void main(String[] args) {
        demoParseAndValueOf();
        System.out.println("-------------------------------------------------");
        demoToStringAndPrimitiveExtractors();
        System.out.println("-------------------------------------------------");
        demoCompareAndEquals();
        System.out.println("-------------------------------------------------");
        demoConstants();
        System.out.println("-------------------------------------------------");
        demoRadixAndEdgeCases();
    }

    // ---------------------- valueOf(String) & parseShort ----------------------
    private static void demoParseAndValueOf() {
        System.out.println("valueOf(String) & parseShort(String)");

        Short obj1 = Short.valueOf("12345");
        System.out.println("Short.valueOf(\"12345\") -> " + obj1);

        short primitive = Short.parseShort("32000");
        System.out.println("Short.parseShort(\"32000\") -> " + primitive);

        Short obj2 = Short.valueOf((short) 200);
        System.out.println("Short.valueOf((short)200) -> " + obj2);

        try {
            Short.parseShort("50000");
        } catch (NumberFormatException e) {
            System.out.println("Short.parseShort(\"50000\") -> NumberFormatException");
        }
    }

    // ---------------------- toString() & primitive extractors ----------------------
    private static void demoToStringAndPrimitiveExtractors() {
        System.out.println("toString() & numeric conversions");

        Short s = Short.valueOf((short) 150);

        System.out.println("s.toString() -> \"" + s.toString() + "\"");
        System.out.println("Short.toString((short)150) -> \"" + Short.toString((short)150) + "\"");

        System.out.println("s.shortValue()  -> " + s.shortValue());
        System.out.println("s.intValue()    -> " + s.intValue());
        System.out.println("s.doubleValue() -> " + s.doubleValue());
        System.out.println("s.longValue()   -> " + s.longValue());
    }

    // ---------------------- compareTo() & equals() ----------------------
    private static void demoCompareAndEquals() {
        System.out.println("compareTo() & equals()");

        Short a = 100, b = 200, c = 100;

        System.out.println("a.compareTo(b) -> " + a.compareTo(b));
        System.out.println("a.compareTo(c) -> " + a.compareTo(c));

        System.out.println("a.equals(c) -> " + a.equals(c));
        System.out.println("a.equals(100) -> " + a.equals(100)); // false
    }

    // ---------------------- MIN / MAX constants ----------------------
    private static void demoConstants() {
        System.out.println("Short.MIN_VALUE & Short.MAX_VALUE");

        System.out.println("Short.MIN_VALUE -> " + Short.MIN_VALUE);
        System.out.println("Short.MAX_VALUE -> " + Short.MAX_VALUE);
    }

    // ---------------------- Radix overloads & edge cases ----------------------
    private static void demoRadixAndEdgeCases() {
        System.out.println("Radix variants & edge cases");

        short hex = Short.parseShort("7F", 16);
        System.out.println("Short.parseShort(\"7F\", 16) -> " + hex);

        Short hexObj = Short.valueOf("7f", 16);
        System.out.println("Short.valueOf(\"7f\", 16) -> " + hexObj);

        try {
            Short.parseShort("8000", 16);
        } catch (NumberFormatException e) {
            System.out.println("Short.parseShort(\"8000\", 16) -> NumberFormatException");
        }
    }
}