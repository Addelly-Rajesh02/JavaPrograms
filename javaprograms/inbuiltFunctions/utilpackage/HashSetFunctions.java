package inbuiltFunctions.utilpackage;

import java.util.HashSet;
import java.util.Set;

public class HashSetFunctions {

    public static void main(String[] args) {
        demoHashSetBasic();
        System.out.println("----------------------------------------------");
        demoHashSetEdgeCases();
    }

    // ---------------------- Basic HashSet Operations ----------------------
    private static void demoHashSetBasic() {
        System.out.println("HashSet Basic Operations");

        Set<String> fruits = new HashSet<>();

        // add()
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        // HashSet ignores duplicates
        fruits.add("Apple");

        System.out.println("After add(): " + fruits);

        // contains()
        System.out.println("contains(\"Apple\"): " + fruits.contains("Apple"));
        System.out.println("contains(\"Grapes\"): " + fruits.contains("Grapes"));

        // size()
        System.out.println("size(): " + fruits.size());  // unique elements only

        // remove()
        boolean removed = fruits.remove("Banana");
        System.out.println("remove(\"Banana\"): " + removed + ", set: " + fruits);

        // clear()
        fruits.clear();
        System.out.println("After clear(): " + fruits + ", size: " + fruits.size());
    }

    // ---------------------- Edge Cases & Behavior ----------------------
    private static void demoHashSetEdgeCases() {
        System.out.println("HashSet Edge Cases");

        HashSet<Integer> numbers = new HashSet<>();

        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(20);   // duplicate, will be ignored

        System.out.println("Numbers: " + numbers);  // no duplicates

        // contains() check
        System.out.println("contains(20): " + numbers.contains(20));

        // remove() check
        numbers.remove(10);
        System.out.println("After remove(10): " + numbers);

        // Add null (HashSet allows one null)
        numbers.add(null);
        System.out.println("After adding null: " + numbers);

        // size()
        System.out.println("size(): " + numbers.size());

        // clear()
        numbers.clear();
        System.out.println("After clear(): " + numbers);
    }
}