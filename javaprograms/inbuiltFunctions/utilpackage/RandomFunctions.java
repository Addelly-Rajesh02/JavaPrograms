package inbuiltFunctions.utilpackage;

import java.util.Random;

public class RandomFunctions {

    public static void main(String[] args) {
        demoRandomBasic();
        System.out.println("----------------------------------------------");
        demoRandomWithRange();
    }

    // ---------------------- Basic Random Methods ----------------------
    private static void demoRandomBasic() {
        System.out.println("Random Basic Methods");

        Random random = new Random(); // Random number generator

        // nextInt()
        int r1 = random.nextInt();          // any int
        int r2 = random.nextInt(100);       // 0 to 99
        System.out.println("nextInt(): " + r1);
        System.out.println("nextInt(100): " + r2);

        // nextDouble()
        double d1 = random.nextDouble();    // 0.0 to 1.0
        System.out.println("nextDouble(): " + d1);

        // nextBoolean()
        boolean b1 = random.nextBoolean();  // true or false
        System.out.println("nextBoolean(): " + b1);
    }

    // ---------------------- Random With Range Examples ----------------------
    private static void demoRandomWithRange() {
        System.out.println("Random With Range");

        Random random = new Random();

        // Random int between min and max (inclusive)
        int min = 1;
        int max = 6; // like dice
        int dice = random.nextInt(max - min + 1) + min;
        System.out.println("Random int [1..6]: " + dice);

        // Random double between 5.0 and 10.0
        double low = 5.0;
        double high = 10.0;
        double dblRange = low + (high - low) * random.nextDouble();
        System.out.println("Random double [5.0..10.0]: " + dblRange);

        // Random boolean already shown above
    }
}