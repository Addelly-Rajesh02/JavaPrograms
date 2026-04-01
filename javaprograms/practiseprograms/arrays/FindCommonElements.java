package practiseprograms.arrays;

import java.util.*;

public class FindCommonElements {

    private static List<Integer> uniqueIntersection(int[] a, int[] b) {
        Set<Integer> setA = new HashSet<>();
        for (int x : a) setA.add(x);

        Set<Integer> result = new HashSet<>();
        for (int y : b) {
            if (setA.contains(y)) {
                result.add(y);
            }
        }
        List<Integer> list = new ArrayList<>(result);
        Collections.sort(list);
        return list;
    }

    private static List<Integer> multisetIntersection(int[] a, int[] b) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : a) freq.put(x, freq.getOrDefault(x, 0) + 1);

        List<Integer> result = new ArrayList<>();
        for (int y : b) {
            Integer count = freq.get(y);
            if (count != null && count > 0) {
                result.add(y);
                freq.put(y, count - 1);
            }
        }
        Collections.sort(result);
        return result;
    }
    private static int[] readArray(Scanner sc, int n, String name) {
        int[] arr = new int[n];
        System.out.println("Enter " + n + " integers for " + name + ":");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
    }

    public static void commonElements() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter size of Array 1: ");
            int n1 = scanner.nextInt();
            System.out.print("Enter size of Array 2: ");
            int n2 = scanner.nextInt();

            if (n1 < 0 || n2 < 0) {
                System.out.println("Array sizes cannot be negative.");
                return;
            }

            int[] a = readArray(scanner, n1, "Array 1");
            int[] b = readArray(scanner, n2, "Array 2");

            System.out.println("\nArray 1: " + Arrays.toString(a));
            System.out.println("Array 2: " + Arrays.toString(b));

            List<Integer> unique = uniqueIntersection(a, b);
            List<Integer> withDuplicates = multisetIntersection(a, b);

            System.out.println("\nCommon elements (unique): " + (unique.isEmpty() ? "None" : unique));
            System.out.println("Common elements (including duplicates): " + (withDuplicates.isEmpty() ? "None" : withDuplicates));
        }
    }

    public static void main(String[] args) {
        commonElements();
    }
}
