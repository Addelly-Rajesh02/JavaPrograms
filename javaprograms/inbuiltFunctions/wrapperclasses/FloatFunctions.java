package inbuiltFunctions.wrapperclasses;

public class FloatFunctions {

    public static void main(String[] args) {
        demoParseAndValueOf();
        System.out.println("-------------------------------------------------");
        demoToStringAndPrimitiveExtractors();
        System.out.println("-------------------------------------------------");
        demoCompareToAndEquals();
        System.out.println("-------------------------------------------------");
        demoIsNaNAndIsInfinite();
        System.out.println("-------------------------------------------------");
        demoEdgeCases();
    }

    // ---------------------- valueOf(String) & parseFloat(String) ----------------------
    private static void demoParseAndValueOf() {
        System.out.println("valueOf(String) & parseFloat(String)");

        // ✔ valueOf(String s) – String -> Float (object)
        Float obj1 = Float.valueOf("123.45");
        System.out.println("Float.valueOf(\"123.45\") -> " + obj1 + " (type: " + obj1.getClass().getSimpleName() + ")");

        // ✔ parseFloat(String s) – String -> float (primitive)
        float prim1 = Float.parseFloat("456.78");
        System.out.println("Float.parseFloat(\"456.78\") -> " + prim1);

        // ✔ valueOf(float f) – primitive to wrapper
        Float obj2 = Float.valueOf(3.14f);
        System.out.println("Float.valueOf(3.14f) -> " + obj2);
    }

    // ---------------------- toString() & primitive extractors ----------------------
    private static void demoToStringAndPrimitiveExtractors() {
        System.out.println("toString() & intValue()/doubleValue()/floatValue()");

        Float f = 99.5f;

        // ✔ toString() – instance
        String s1 = f.toString();
        System.out.println("f.toString() -> \"" + s1 + "\"");

        // ✔ Float.toString(float) – static
        String s2 = Float.toString(12.75f);
        System.out.println("Float.toString(12.75f) -> \"" + s2 + "\"");

        // ✔ intValue(), doubleValue(), floatValue()
        System.out.println("f.intValue() -> " + f.intValue());       // truncates toward zero
        System.out.println("f.doubleValue() -> " + f.doubleValue());
        System.out.println("f.floatValue() -> " + f.floatValue());
    }

    // ---------------------- compareTo() & equals() ----------------------
    private static void demoCompareToAndEquals() {
        System.out.println("compareTo() & equals()");

        Float a = 10.0f;
        Float b = 20.0f;
        Float c = 10.0f;

        // ✔ compareTo(Float another)
        System.out.println("a.compareTo(b) (10.0 vs 20.0) -> " + a.compareTo(b)); // negative
        System.out.println("b.compareTo(a) (20.0 vs 10.0) -> " + b.compareTo(a)); // positive
        System.out.println("a.compareTo(c) (10.0 vs 10.0) -> " + a.compareTo(c)); // zero

        // ✔ equals(Object o)
        System.out.println("a.equals(c) -> " + a.equals(c));   // true
        System.out.println("a.equals(10.0) -> " + a.equals(10.0)); // false (10.0 is Double, not Float)
        System.out.println("a.equals(10.0f) -> " + a.equals(10.0f)); // true (same type & value)
    }

    // ---------------------- isNaN() & isInfinite() ----------------------
    private static void demoIsNaNAndIsInfinite() {
        System.out.println("isNaN() & isInfinite()");

        float zero = 0.0f;
        float posInf = 1.0f / zero;   // +Infinity
        float negInf = -1.0f / zero;  // -Infinity
        float notANum = 0.0f / 0.0f;  // NaN

        // ✔ isInfinite()
        System.out.println("Float.isInfinite(posInf) -> " + Float.isInfinite(posInf)); // true
        System.out.println("Float.isInfinite(negInf) -> " + Float.isInfinite(negInf)); // true
        System.out.println("Float.isInfinite(123.45f) -> " + Float.isInfinite(123.45f)); // false

        // ✔ isNaN()
        System.out.println("Float.isNaN(notANum) -> " + Float.isNaN(notANum)); // true
        System.out.println("Float.isNaN(1.23f) -> " + Float.isNaN(1.23f));     // false

        // Instance versions
        Float fNaN = Float.valueOf(notANum);
        System.out.println("fNaN.isNaN() -> " + fNaN.isNaN()); // true
    }

    // ---------------------- Edge cases worth knowing ----------------------
    private static void demoEdgeCases() {
        System.out.println("Edge Cases");

        // Parsing special strings
        System.out.println("Float.parseFloat(\"NaN\") -> " + Float.parseFloat("NaN"));               // NaN
        System.out.println("Float.parseFloat(\"Infinity\") -> " + Float.parseFloat("Infinity"));     // Infinity
        System.out.println("Float.parseFloat(\"-Infinity\") -> " + Float.parseFloat("-Infinity"));   // -Infinity

        // NumberFormatException on bad input
        try {
            Float.parseFloat("12a");
        } catch (NumberFormatException e) {
            System.out.println("Float.parseFloat(\"12a\") throws NumberFormatException");
        }

        // compare static vs compareTo
        System.out.println("Float.compare(1.0f, 2.0f) -> " + Float.compare(1.0f, 2.0f)); // negative
        System.out.println("Float.compare(2.0f, 1.0f) -> " + Float.compare(2.0f, 1.0f)); // positive
        System.out.println("Float.compare(1.0f, 1.0f) -> " + Float.compare(1.0f, 1.0f)); // zero

        // +0.0f vs -0.0f: equals treats them equal, compare distinguishes by bit pattern per IEEE 754
        Float pz = +0.0f, nz = -0.0f;
        System.out.println("+0.0f equals -0.0f -> " + pz.equals(nz));    // true
        System.out.println("Float.compare(+0.0f, -0.0f) -> " + Float.compare(pz, nz)); // 1 or -1 depending on sign

        // NaN equality: equals returns true for Float.NaN compared to Float.NaN (unlike primitive '==')
        Float f1 = Float.NaN, f2 = Float.NaN;
        System.out.println("Float.NaN equals Float.NaN -> " + f1.equals(f2)); // true
        System.out.println("Primitive NaN == NaN -> " + (Float.NaN == Float.NaN));      // false
    }
}