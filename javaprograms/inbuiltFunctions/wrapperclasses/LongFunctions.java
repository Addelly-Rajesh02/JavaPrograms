package inbuiltFunctions.wrapperclasses;

public class LongFunctions {

    public static void main(String[] args) {
        demoParseAndValueOf();
        System.out.println("-------------------------------------------------");
        demoToStringAndPrimitiveExtractors();
        System.out.println("-------------------------------------------------");
        demoCompareAndEquals();
        System.out.println("-------------------------------------------------");
        demoConstantsAndArithmeticUtilities();
        System.out.println("-------------------------------------------------");
        demoRadixVariantsAndUnsigned();
        System.out.println("-------------------------------------------------");
        demoBitUtilitiesAndRepresentations();
        System.out.println("-------------------------------------------------");
        demoEdgeCases();
    }

    // ---------------------- valueOf(String) / valueOf(long) / parseLong(String) ----------------------
    private static void demoParseAndValueOf() {
        System.out.println("valueOf(String) / valueOf(long) / parseLong(String)");

        // String -> Long (object)
        Long objFromString = Long.valueOf("1234567890123");
        System.out.println("Long.valueOf(\"1234567890123\") -> " + objFromString +
                " (type: " + objFromString.getClass().getSimpleName() + ")");

        // String -> long (primitive)
        long primFromString = Long.parseLong("9876543210");
        System.out.println("Long.parseLong(\"9876543210\") -> " + primFromString);

        // long -> Long (boxing)
        Long objFromPrim = Long.valueOf(42L);
        System.out.println("Long.valueOf(42L) -> " + objFromPrim);
    }

    // ---------------------- toString() & primitive extractors ----------------------
    private static void demoToStringAndPrimitiveExtractors() {
        System.out.println("toString() & longValue()/intValue()");

        Long L = 2025L; // autoboxing

        // Instance toString()
        System.out.println("L.toString() -> \"" + L.toString() + "\"");

        // Static toString(long)
        System.out.println("Long.toString(123456789L) -> \"" + Long.toString(123456789L) + "\"");

        // Primitive extractors
        System.out.println("L.longValue() -> " + L.longValue());
        System.out.println("L.intValue()  -> " + L.intValue()); // truncates if out of int range
    }

    // ---------------------- compareTo / compare / equals ----------------------
    private static void demoCompareAndEquals() {
        System.out.println("compareTo / compare / equals");

        Long a = 10L, b = 20L, c = 10L;

        // compareTo (object)
        System.out.println("a.compareTo(b) -> " + a.compareTo(b)); // <0
        System.out.println("a.compareTo(c) -> " + a.compareTo(c)); // 0

        // compare (static, primitives)
        System.out.println("Long.compare(20L, 10L) -> " + Long.compare(20L, 10L)); // >0

        // equals
        System.out.println("a.equals(10L) -> " + a.equals(10L));   // true (autoboxing to Long)
        System.out.println("a.equals(10)  -> " + a.equals(10));    // false (Integer vs Long)
    }

    // ---------------------- MIN/MAX & sum/max/min utilities ----------------------
    private static void demoConstantsAndArithmeticUtilities() {
        System.out.println("MIN_VALUE / MAX_VALUE & sum/max/min");

        System.out.println("Long.MIN_VALUE -> " + Long.MIN_VALUE);
        System.out.println("Long.MAX_VALUE -> " + Long.MAX_VALUE);

        System.out.println("Long.sum(100L, 50L) -> " + Long.sum(100L, 50L)); // 150
        System.out.println("Long.max(100L, 50L) -> " + Long.max(100L, 50L)); // 100
        System.out.println("Long.min(100L, 50L) -> " + Long.min(100L, 50L)); // 50
    }

    // ---------------------- Radix parsing/printing & unsigned helpers ----------------------
    private static void demoRadixVariantsAndUnsigned() {
        System.out.println("Radix variants & unsigned helpers");

        // parseLong with radix
        long parseHex = Long.parseLong("7fffffffffffffff", 16); // Long.MAX_VALUE
        System.out.println("Long.parseLong(\"7fffffffffffffff\", 16) -> " + parseHex);

        // valueOf with radix
        Long valHex = Long.valueOf("ff", 16);
        System.out.println("Long.valueOf(\"ff\", 16) -> " + valHex);

        // Unsigned parsing (treats text as unsigned 64-bit)
        long unsigned = Long.parseUnsignedLong("18446744073709551615", 10); // 2^64 - 1
        System.out.println("Long.parseUnsignedLong(\"18446744073709551615\") -> " + unsigned);

        // Unsigned toString for negative numbers (interpret two's complement as unsigned)
        String unsignedStr = Long.toUnsignedString(-1L); // should print 2^64 - 1
        System.out.println("Long.toUnsignedString(-1L) -> " + unsignedStr);
    }

    // ---------------------- Bit operations & representations ----------------------
    private static void demoBitUtilitiesAndRepresentations() {
        System.out.println("Bit utilities & representations");

        long x = 0b1011_0001L; // 177

        System.out.println("Long.bitCount(0b1011_0001) -> " + Long.bitCount(x)); // number of 1-bits

        long rl = Long.rotateLeft(x, 4);
        long rr = Long.rotateRight(x, 4);
        System.out.println("Long.rotateLeft(0b1011_0001, 4)  -> " + rl +
                " (bin: " + Long.toBinaryString(rl) + ")");
        System.out.println("Long.rotateRight(0b1011_0001, 4) -> " + rr +
                " (bin: " + Long.toBinaryString(rr) + ")");

        // Other handy representations
        System.out.println("Long.toBinaryString(177) -> " + Long.toBinaryString(177));
        System.out.println("Long.toHexString(177)    -> " + Long.toHexString(177));
        System.out.println("Long.toOctalString(177)  -> " + Long.toOctalString(177));
    }

    // ---------------------- Common edge cases ----------------------
    private static void demoEdgeCases() {
        System.out.println("Edge cases");

        // NumberFormatException on invalid or out-of-range
        try {
            Long.parseLong("9223372036854775808"); // Long.MAX_VALUE + 1
        } catch (NumberFormatException e) {
            System.out.println("Long.parseLong(\"9223372036854775808\") -> NumberFormatException (overflow)");
        }
        try {
            Long.parseLong("12a");
        } catch (NumberFormatException e) {
            System.out.println("Long.parseLong(\"12a\") -> NumberFormatException (invalid format)");
        }

        // Leading + / - signs are supported
        System.out.println("Long.parseLong(\"-10\") -> " + Long.parseLong("-10"));
        System.out.println("Long.parseLong(\"+10\") -> " + Long.parseLong("+10"));

        // Autoboxing & caching note: Long caches values in [-128, 127]
        Long l1 = Long.valueOf(127L);
        Long l2 = Long.valueOf(127L);
        Long l3 = Long.valueOf(128L);
        Long l4 = Long.valueOf(128L);
        System.out.println("Long.valueOf(127L) == Long.valueOf(127L) -> " + (l1 == l2)); // likely true (cached)
        System.out.println("Long.valueOf(128L) == Long.valueOf(128L) -> " + (l3 == l4)); // likely false (not cached)
    }
}