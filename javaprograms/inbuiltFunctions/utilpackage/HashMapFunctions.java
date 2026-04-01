package inbuiltFunctions.utilpackage;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapFunctions {

    public static void main(String[] args) {
        demoBasicOperations();
        System.out.println("-------------------------------------------------");
        demoIterationAndViews();
        System.out.println("-------------------------------------------------");
        demoEdgeCases();
    }

    // ---------------------- Basic put/get/remove/contains/size ----------------------
    private static void demoBasicOperations() {
        System.out.println("HashMap<String, Integer> - Basic Operations");

        Map<String, Integer> marks = new HashMap<>();

        // put(key, value) – adds or replaces a mapping, returns previous value (or null)
        Integer prev = marks.put("Math", 90);
        System.out.println("put(\"Math\", 90) -> previous: " + prev); // null (no previous)

        prev = marks.put("Math", 95); // replaces value for the same key
        System.out.println("put(\"Math\", 95) -> previous: " + prev); // 90

        marks.put("Physics", 88);
        marks.put("Chemistry", 92);
        System.out.println("Map after puts: " + marks);

        // get(key) – returns value or null if not present
        System.out.println("get(\"Math\"): " + marks.get("Math"));          // 95
        System.out.println("get(\"Biology\"): " + marks.get("Biology"));    // null (absent key)

        // containsKey(), containsValue()
        System.out.println("containsKey(\"Physics\"): " + marks.containsKey("Physics")); // true
        System.out.println("containsValue(100): " + marks.containsValue(100));           // false

        // size()
        System.out.println("size(): " + marks.size()); // 3

        // remove(key) – returns removed value or null
        Integer removed = marks.remove("Physics");
        System.out.println("remove(\"Physics\") -> " + removed + ", map: " + marks);

        // remove(key, value) – conditional remove (returns boolean)
        boolean removedPair = marks.remove("Chemistry", 92);
        System.out.println("remove(\"Chemistry\", 92) -> " + removedPair + ", map: " + marks);
    }

    // ---------------------- Views: keySet(), values(), entrySet() ----------------------
    private static void demoIterationAndViews() {
        System.out.println("HashMap Iteration & Views");

        Map<Integer, String> emp = new HashMap<>();
        emp.put(101, "Raj");
        emp.put(102, "Asha");
        emp.put(103, "Vikram");

        // keySet()
        Set<Integer> keys = emp.keySet();
        System.out.println("keySet(): " + keys);

        // values()
        Collection<String> vals = emp.values();
        System.out.println("values(): " + vals);

        // entrySet(): best way to iterate key+value together
        System.out.println("Iterate entrySet():");
        for (Map.Entry<Integer, String> e : emp.entrySet()) {
            System.out.println("  " + e.getKey() + " -> " + e.getValue());
        }

        // Example: update values while iterating via entrySet()
        for (Map.Entry<Integer, String> e : emp.entrySet()) {
            e.setValue(e.getValue().toUpperCase());
        }
        System.out.println("After uppercasing values: " + emp);
    }

    // ---------------------- Edge cases & tips ----------------------
    private static void demoEdgeCases() {
        System.out.println("HashMap Edge Cases");

        HashMap<String, String> map = new HashMap<>();

        // HashMap allows one null key and multiple null values
        map.put(null, "NULL_KEY_VALUE");
        map.put("k1", null);
        map.put("k2", null);
        System.out.println("With nulls: " + map);
        System.out.println("get(null): " + map.get(null));
        System.out.println("containsKey(null): " + map.containsKey(null));
        System.out.println("containsValue(null): " + map.containsValue(null)); // true

        // Duplicate key overwrites
        map.put("lang", "Java");
        map.put("lang", "Kotlin"); // overwrites previous
        System.out.println("Overwrite same key: " + map);

        // Safely reading absent keys – use getOrDefault
        String v = map.getOrDefault("missing", "default-value");
        System.out.println("getOrDefault(\"missing\", \"default-value\"): " + v);

        // computeIfAbsent – initialize only if key missing
        map.computeIfAbsent("region", k -> "APAC");
        map.computeIfAbsent("region", k -> "EU"); // won't run since key already present
        System.out.println("After computeIfAbsent: " + map);

        // replace methods
        map.replace("lang", "Kotlin", "Java"); // conditional replace
        map.replace("k1", "non-null-now");     // replace if present
        System.out.println("After replace ops: " + map);

        // clear()
        map.clear();
        System.out.println("After clear(): " + map + ", size=" + map.size());
    }
}