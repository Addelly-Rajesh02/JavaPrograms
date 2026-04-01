package practiseprograms;

import java.util.*;
import static java.util.Comparator.*;

public class Main {
    public static void main(String[] args) {
        // Same data used for both Comparable and Comparator demos
        List<Employee> employees = new ArrayList<>(List.of(
                new Employee(103, "Rajesh",    26,  88000.0, "male","IT"),
                new Employee(101, "Addelly",    30,  92000.0, "female","Support"),
                new Employee(104, "addelly",    28,  75000.0, "female","Developer"), // lower-case name to show case-insensitive sort
                new Employee(102, "Narender",  30,  null,"male","IT"),    // null salary to show null-safe comparator
                new Employee(105, "priya",    24,  88000.0,"female","Developer"),  // duplicate name to show secondary keys
                new Employee(106,"praneeth",23,87990.0,"male", "Developer")
        ));

        System.out.println("Original:");
        print(employees);

        // 1) Comparable (natural order) → by id ascending
        List<Employee> byId = new ArrayList<>(employees);
        Collections.sort(employees); // uses Employee.compareTo
        System.out.println("\nComparable (Natural) → by id ↑ :");
        print(byId);

        // 2) Comparator examples

        // 2a) by name ascending (case-insensitive)
        Comparator<Employee> byNameIgnoreCase =
                comparing(e -> e.getName(), String.CASE_INSENSITIVE_ORDER);

        List<Employee> byName = new ArrayList<>(employees);
        byName.sort(byNameIgnoreCase);
        System.out.println("\nComparator → by name (case-insensitive) ↑ :");
        print(byName);

        // 2b) by age descending
        Comparator<Employee> byAgeDesc = comparing(Employee::getAge, nullsLast(naturalOrder())).reversed();

        List<Employee> byAge = new ArrayList<>(employees);
        byAge.sort(byAgeDesc);
        System.out.println("\nComparator → by age ↓ :");
        print(byAge);

        // 2c) by salary ascending (nulls last)
        Comparator<Employee> bySalaryAscNullsLast =
                comparing(Employee::getSalary, nullsLast(naturalOrder()));

        List<Employee> bySalary = new ArrayList<>(employees);
        bySalary.sort(bySalaryAscNullsLast);
        System.out.println("\nComparator → by salary ↑ (null salaries last):");
        print(bySalary);

        // 2d) Composed comparator: name ↑ (case-insensitive), then age ↑, then id ↑
        Comparator<Employee> byNameThenAgeThenId =
                byNameIgnoreCase
                        .thenComparing(Employee::getAge) // age asc
                        .thenComparing(Employee::getId); // final tiebreaker

        List<Employee> composed = new ArrayList<>(employees);
        composed.sort(byNameThenAgeThenId);
        System.out.println("\nComparator (composed) → by name ↑, then age ↑, then id ↑ :");
        print(composed);

        // 3) Show that Comparable is always available as a fallback order
        // (e.g., TreeSet without custom comparator uses natural order)
        Set<Employee> setByNatural = new TreeSet<>(); // uses Comparable (id)
        setByNatural.addAll(employees);
        System.out.println("\nTreeSet (uses Comparable) → natural by id ↑ :");
        setByNatural.forEach(System.out::println);
    }

    private static void print(List<Employee> list) {
        list.forEach(System.out::println);
    }
}