package inbuiltFunctions.langpackage;

public class MathFunctions {

    public static void main(String[] args) {
        // ------- sqrt() -------
        double sqrtOf16 = Math.sqrt(16);        // 4.0
        double sqrtOf2  = Math.sqrt(2);         // ~1.4142135623730951
        System.out.println("sqrt(16) = " + sqrtOf16);
        System.out.println("sqrt(2)  = " + sqrtOf2);

        // ------- pow() -------
        double twoPowFive = Math.pow(2, 5);     // 32.0
        double ninePowHalf = Math.pow(9, 0.5);  // 3.0 (same as sqrt(9))
        System.out.println("pow(2, 5)   = " + twoPowFive);
        System.out.println("pow(9, 0.5) = " + ninePowHalf);

        // ------- abs() -------
        int absInt = Math.abs(-42);             // 42
        double absDouble = Math.abs(-13.75);    // 13.75
        System.out.println("abs(-42)      = " + absInt);
        System.out.println("abs(-13.75)   = " + absDouble);

        // ------- round(), ceil(), floor() -------
        long round1 = Math.round(3.4);          // 3
        long round2 = Math.round(3.5);          // 4
        long round3 = Math.round(-3.5);         // -3 (rounds to nearest long, ties to +infinity)
        double ceil1 = Math.ceil(3.01);         // 4.0
        double ceil2 = Math.ceil(-3.01);        // -3.0
        double floor1 = Math.floor(3.99);       // 3.0
        double floor2 = Math.floor(-3.01);      // -4.0
        System.out.println("round(3.4)   = " + round1);
        System.out.println("round(3.5)   = " + round2);
        System.out.println("round(-3.5)  = " + round3);
        System.out.println("ceil(3.01)   = " + ceil1);
        System.out.println("ceil(-3.01)  = " + ceil2);
        System.out.println("floor(3.99)  = " + floor1);
        System.out.println("floor(-3.01) = " + floor2);

        // ------- max(), min() -------
        int maxInt = Math.max(10, 25);          // 25
        int minInt = Math.min(10, 25);          // 10
        double maxDouble = Math.max(2.718, 3.1415); // 3.1415
        double minDouble = Math.min(2.718, 3.1415); // 2.718
        System.out.println("max(10, 25)           = " + maxInt);
        System.out.println("min(10, 25)           = " + minInt);
        System.out.println("max(2.718, 3.1415)    = " + maxDouble);
        System.out.println("min(2.718, 3.1415)    = " + minDouble);

        // ------- random() -------
        // Math.random() -> [0.0, 1.0) double
        double r = Math.random();
        // Example: random int in range [low, high] inclusive
        int low = 1, high = 6; // like a dice roll
        int dice = low + (int) (Math.random() * (high - low + 1));
        System.out.println("random() in [0,1) = " + r);
        System.out.println("random dice [1..6] = " + dice);
    }
}