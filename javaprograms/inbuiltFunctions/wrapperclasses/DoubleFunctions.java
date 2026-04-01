package inbuiltFunctions.wrapperclasses;

public class DoubleFunctions {

    public static void main(String[] args) {
        demoParseAndValueOf();
        System.out.println("-------------------------------------------------");
        demoToStringAndPrimitiveExtractors();
        System.out.println("-------------------------------------------------");
        demoIsNaNAndIsInfinite();
        System.out.println("-------------------------------------------------");
        demoCompareAndEqualityNotes();
        System.out.println("-------------------------------------------------");
        demoEdgeCasesAndSpecialLiterals();
    }

    // ---------------------- valueOf(String) & parseDouble(String) ----------------------
    private static void demoParseAndValueOf() {
        System.out.println("valueOf(String) & parseDouble(String)");

        // ✔ valueOf(String s) – String -> Double (object)
        Double objFromStr = Double.valueOf("1234.567");
        System.out.println("Double.valueOf(\"1234.567\") -> " + objFromStr
                + " (type: " + objFromStr.getClass().getSimpleName() + ")");

        // ✔ parseDouble(String s) – String -> double (primitive)
        double primFromStr = Double.parseDouble("4567.89");
        System.out.println("Double.parseDouble(\"4567.89\") -> " + primFromStr);

        // ✔ valueOf(double d) – primitive -> wrapper
        Double objFromPrim = Double.valueOf(3.14159);
        System.out.println("Double.valueOf(3.14159) -> " + objFromPrim);
    }

    // ---------------------- toString() & primitive extractors ----------------------
    private static void demoToStringAndPrimitiveExtractors() {
        System.out.println("toString() & doubleValue() / intValue() / floatValue()");

        Double d = 99.75; // autoboxing

        // ✔ Instance toString()
        System.out.println("d.toString() -> \"" + d.toString() + "\"");

        // ✔ Static toString(double)
        System.out.println("Double.toString(12.5) -> \"" + Double.toString(12.5) + "\"");

        // ✔ doubleValue() and other primitive extractors
        System.out.println("d.doubleValue() -> " + d.doubleValue());
        System.out.println("d.intValue()    -> " + d.intValue());    // truncates toward zero
        System.out.println("d.floatValue()  -> " + d.floatValue());  // may lose precision
        System.out.println("d.longValue()   -> " + d.longValue());   // truncates toward zero
    }

    // ---------------------- isNaN() & isInfinite() ----------------------
    private static void demoIsNaNAndIsInfinite() {
        System.out.println("isNaN() & isInfinite()");

        double zero = 0.0;
        double posInf = 1.0 / zero;   // +Infinity
        double negInf = -1.0 / zero;  // -Infinity
        double nan    = 0.0 / 0.0;    // NaN

        // ✔ isInfinite()
        System.out.println("Double.isInfinite(+Infinity) -> " + Double.isInfinite(posInf)); // true
        System.out.println("Double.isInfinite(-Infinity) -> " + Double.isInfinite(negInf)); // true
        System.out.println("Double.isInfinite(123.45)    -> " + Double.isInfinite(123.45)); // false

        // ✔ isNaN()
        System.out.println("Double.isNaN(NaN) -> " + Double.isNaN(nan));   // true
        System.out.println("Double.isNaN(1.23) -> " + Double.isNaN(1.23)); // false

        // Instance versions
        Double dNaN = Double.valueOf(nan);
        System.out.println("dNaN.isNaN() -> " + dNaN.isNaN()); // true
    }

    // ---------------------- compare & equals notes ----------------------
    private static void demoCompareAndEqualityNotes() {
        System.out.println("compare() & equals() notes");

        Double a = 10.0, b = 20.0, c = 10.0;

        // Static compare for primitives
        System.out.println("Double.compare(10.0, 20.0) -> " + Double.compare(10.0, 20.0)); // <0
        System.out.println("Double.compare(20.0, 10.0) -> " + Double.compare(20.0, 10.0)); // >0
        System.out.println("Double.compare(10.0, 10.0) -> " + Double.compare(10.0, 10.0)); // 0

        // compareTo for objects
        System.out.println("a.compareTo(b) -> " + a.compareTo(b)); // <0
        System.out.println("a.compareTo(c) -> " + a.compareTo(c)); // 0

        // equals semantics: same type & same numeric value
        System.out.println("a.equals(c) -> " + a.equals(c));       // true
        System.out.println("a.equals(10.0f) -> " + a.equals(10.0f)); // false (Float vs Double)
    }

    // ---------------------- Edge cases & special literals ----------------------
    private static void demoEdgeCasesAndSpecialLiterals() {
        System.out.println("Edge cases & special literals");

        // Parsing special literals
        System.out.println("Double.parseDouble(\"NaN\") -> " + Double.parseDouble("NaN"));
        System.out.println("Double.parseDouble(\"Infinity\") -> " + Double.parseDouble("Infinity"));
        System.out.println("Double.parseDouble(\"-Infinity\") -> " + Double.parseDouble("-Infinity"));

        // NumberFormatException on invalid input
        try {
            Double.parseDouble("12a.34");
        } catch (NumberFormatException e) {
            System.out.println("Double.parseDouble(\"12a.34\") throws NumberFormatException");
        }

        // +0.0 vs -0.0:
        double pz = +0.0, nz = -0.0;
        System.out.println("+0.0 == -0.0 (primitive) -> " + (pz == nz));                // true
        System.out.println("Double.compare(+0.0, -0.0) -> " + Double.compare(pz, nz));  // non-zero (distinguishes sign)

        // NaN equality:
        System.out.println("Double.NaN == Double.NaN (primitive) -> " + (Double.NaN == Double.NaN));       // false
        Double dn1 = Double.NaN, dn2 = Double.NaN;
        System.out.println("new Double(NaN).equals(new Double(NaN)) -> " + dn1.equals(dn2));               // true
    }
}