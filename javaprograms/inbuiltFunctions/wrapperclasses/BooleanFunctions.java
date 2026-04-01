package inbuiltFunctions.wrapperclasses;

public class BooleanFunctions {

    public static void main(String[] args) {
        demoParseAndValueOfString();
        System.out.println("-------------------------------------------------");
        demoValueOfBooleanAndPrimitiveExtractors();
        System.out.println("-------------------------------------------------");
        demoToStringVariants();
        System.out.println("-------------------------------------------------");
        demoCompareAndEquals();
        System.out.println("-------------------------------------------------");
        demoConstantsAndEdgeCases();
    }

    // ---------------------- valueOf(String) & parseBoolean(String) ----------------------
    private static void demoParseAndValueOfString() {
        System.out.println("valueOf(String) & parseBoolean(String)");

        // valueOf(String) -> returns a Boolean object
        Boolean bObjTrue = Boolean.valueOf("true");
        Boolean bObjFalse = Boolean.valueOf("false");
        Boolean bObjMixed = Boolean.valueOf("TrUe"); // case-insensitive
        Boolean bObjOther = Boolean.valueOf("yes");  // not "true" => false

        System.out.println("Boolean.valueOf(\"true\")   -> " + bObjTrue);
        System.out.println("Boolean.valueOf(\"false\")  -> " + bObjFalse);
        System.out.println("Boolean.valueOf(\"TrUe\")   -> " + bObjMixed);
        System.out.println("Boolean.valueOf(\"yes\")    -> " + bObjOther);

        // parseBoolean(String) -> returns primitive boolean
        boolean pTrue = Boolean.parseBoolean("true");
        boolean pFalse = Boolean.parseBoolean("anything_else"); // only "true" (ignoring case) yields true
        System.out.println("Boolean.parseBoolean(\"true\")        -> " + pTrue);
        System.out.println("Boolean.parseBoolean(\"anything_else\") -> " + pFalse);

        // Note: valueOf(null) and parseBoolean(null) both return false (no exception)
        Boolean bNullObj = Boolean.valueOf((String) null);
        boolean bNullPrim = Boolean.parseBoolean(null);
        System.out.println("Boolean.valueOf(null)  -> " + bNullObj);
        System.out.println("Boolean.parseBoolean(null) -> " + bNullPrim);
    }

    // ---------------------- valueOf(boolean) & booleanValue() ----------------------
    private static void demoValueOfBooleanAndPrimitiveExtractors() {
        System.out.println("valueOf(boolean) & booleanValue()");

        // valueOf(boolean) -> boxes primitive
        Boolean boxedTrue = Boolean.valueOf(true);
        Boolean boxedFalse = Boolean.valueOf(false);

        // booleanValue() -> unboxes
        boolean primTrue = boxedTrue.booleanValue();
        boolean primFalse = boxedFalse.booleanValue();

        System.out.println("Boolean.valueOf(true)  -> " + boxedTrue);
        System.out.println("Boolean.valueOf(false) -> " + boxedFalse);
        System.out.println("boxedTrue.booleanValue()  -> " + primTrue);
        System.out.println("boxedFalse.booleanValue() -> " + primFalse);
    }

    // ---------------------- toString(boolean) & instance toString() ----------------------
    private static void demoToStringVariants() {
        System.out.println("toString(boolean) & instance toString()");

        boolean x = true;
        boolean y = false;

        // Static: toString(boolean)
        String sx = Boolean.toString(x);
        String sy = Boolean.toString(y);

        // Instance: toString()
        Boolean bx = Boolean.valueOf(true);
        Boolean by = Boolean.valueOf(false);

        System.out.println("Boolean.toString(true)  -> \"" + sx + "\"");
        System.out.println("Boolean.toString(false) -> \"" + sy + "\"");
        System.out.println("Boolean.valueOf(true).toString()  -> \"" + bx.toString() + "\"");
        System.out.println("Boolean.valueOf(false).toString() -> \"" + by.toString() + "\"");
    }

    // ---------------------- compare(boolean, boolean) & equals(Object) ----------------------
    private static void demoCompareAndEquals() {
        System.out.println("compare(boolean, boolean) & equals(Object)");

        // compare(boolean x, boolean y): returns 0 if equal; >0 if x is true and y is false; <0 otherwise
        System.out.println("Boolean.compare(true, false)  -> " + Boolean.compare(true, false));  // >0
        System.out.println("Boolean.compare(false, true)  -> " + Boolean.compare(false, true));  // <0
        System.out.println("Boolean.compare(true, true)   -> " + Boolean.compare(true, true));   // 0
        System.out.println("Boolean.compare(false, false) -> " + Boolean.compare(false, false)); // 0

        // equals(Object) on Boolean objects
        Boolean a = Boolean.valueOf(true);
        Boolean b = Boolean.valueOf(true);
        Boolean c = Boolean.valueOf(false);
        System.out.println("a.equals(b) -> " + a.equals(b)); // true
        System.out.println("a.equals(c) -> " + a.equals(c)); // false
        System.out.println("a.equals(\"true\") -> " + a.equals("true")); // false (different type)
    }

    // ---------------------- Constants & Edge Cases ----------------------
    private static void demoConstantsAndEdgeCases() {
        System.out.println("Constants & Edge Cases");

        // Constants
        System.out.println("Boolean.TRUE  -> " + Boolean.TRUE);
        System.out.println("Boolean.FALSE -> " + Boolean.FALSE);

        // valueOf(String) caching: returns the canonical instances TRUE/FALSE
        Boolean t1 = Boolean.valueOf("true");
        Boolean t2 = Boolean.TRUE;
        System.out.println("Boolean.valueOf(\"true\") == Boolean.TRUE -> " + (t1 == t2));

        // Autoboxing considerations
        Boolean autoBoxTrue = true;  // same as Boolean.valueOf(true)
        System.out.println("Autoboxing true equals Boolean.TRUE -> " + autoBoxTrue.equals(Boolean.TRUE));

        // Typical parsing variations (case-insensitive "true" only)
        System.out.println("Boolean.parseBoolean(\"TRUE\") -> " + Boolean.parseBoolean("TRUE")); // true
        System.out.println("Boolean.parseBoolean(\"False\") -> " + Boolean.parseBoolean("False")); // false
        System.out.println("Boolean.parseBoolean(\"1\")     -> " + Boolean.parseBoolean("1"));     // false
        System.out.println("Boolean.valueOf(\"1\")          -> " + Boolean.valueOf("1"));          // false
    }
}
