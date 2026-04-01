package inbuiltFunctions.utilpackage;

import java.util.ArrayList;
import java.util.List;

public class ArrayListFunctions {

    public static void main(String[] args) {
        demoIntegerList();
        System.out.println("-------------------------------------------------");
        demoStringListWithEdgeCases();
    }

    // ---------------------- Demo with Integer ----------------------
    private static void demoIntegerList() {
        System.out.println("ArrayList<Integer> Demo");

        List<Integer> numbers = new ArrayList<>();

        // add()
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(1, 15); // add at index
        System.out.println("After add(): " + numbers); // [10, 15, 20, 30]

        // get()
        int first = numbers.get(0);
        int third = numbers.get(2);
        System.out.println("get(0): " + first); // 10
        System.out.println("get(2): " + third); // 20

        // set()
        numbers.set(2, 25); // replace element at index 2
        System.out.println("After set(2, 25): " + numbers); // [10, 15, 25, 30]

        // contains()
        System.out.println("contains(15): " + numbers.contains(15)); // true
        System.out.println("contains(100): " + numbers.contains(100)); // false

        // remove() - by index
        Integer removedByIndex = numbers.remove(1); // removes element 15
        System.out.println("remove(1) -> " + removedByIndex + ", list: " + numbers); // [10, 25, 30]

        // remove() - by value (careful: overload resolution!)
        boolean removedByValue = numbers.remove(Integer.valueOf(25));
        System.out.println("remove(Integer.valueOf(25)) -> " + removedByValue + ", list: " + numbers); // [10, 30]

        // size()
        System.out.println("size(): " + numbers.size()); // 2

        // clear()
        numbers.clear();
        System.out.println("After clear(): " + numbers + ", size: " + numbers.size()); // [], 0
    }

    // ---------------------- Demo with String + edge cases ----------------------
    private static void demoStringListWithEdgeCases() {
        System.out.println("ArrayList<String> Demo (with edge cases)");

        ArrayList<String> words = new ArrayList<>();

        // add()
        words.add("Hello");
        words.add("Java");
        words.add("World");
        System.out.println("After add(): " + words); // [Hello, Java, World]

        // get()
        System.out.println("get(1): " + words.get(1)); // Java

        // set()
        words.set(1, "Core Java");
        System.out.println("After set(1, \"Core Java\"): " + words); // [Hello, Core Java, World]

        // contains() (case-sensitive)
        System.out.println("contains(\"World\"): " + words.contains("World"));   // true
        System.out.println("contains(\"world\"): " + words.contains("world"));   // false

        // remove() by index
        String removedAt0 = words.remove(0);
        System.out.println("remove(0) -> " + removedAt0 + ", list: " + words);  // [Core Java, World]

        // remove() by value
        boolean removedWorld = words.remove("World");
        System.out.println("remove(\"World\") -> " + removedWorld + ", list: " + words); // [Core Java]

        // size()
        System.out.println("size(): " + words.size()); // 1

        // Edge case: get/set/remove invalid index (commented to avoid exception)
        // words.get(5);                 // throws IndexOutOfBoundsException
        // words.set(-1, "X");           // throws IndexOutOfBoundsException
        // words.remove(2);              // throws IndexOutOfBoundsException

        // clear()
        words.clear();
        System.out.println("After clear(): " + words + " (isEmpty=" + words.isEmpty() + ")");
    }
}