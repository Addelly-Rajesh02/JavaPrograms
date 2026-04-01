package practiseprograms.streams;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class StreamFunctions {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        // 1) filter(Predicate): keep only even numbers
        System.out.println("filter (even): " +
                numbers.stream()
                        .filter(n -> n % 2 == 0)
                        .collect(Collectors.toList()));

        // 2) map(Function): square each number
        System.out.println("map (square): " +
                numbers.stream()
                        .map(n -> n * n)
                        .collect(Collectors.toList()));

        // 3) flatMap(Function): flatten nested lists
        List<List<Integer>> nested = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(3, 4, 5),
                Arrays.asList(6, 7, 8, 9, 10)
        );
        System.out.println("flatMap (flatten): " +
                nested.stream()
                        .flatMap(List::stream)
                        .collect(Collectors.toList()));

        // 4) peek(Consumer): debug/inspect stream elements (side effects)
        System.out.println("peek (debug even -> doubled): " +
                numbers.stream()
                        .filter(n -> n % 2 == 0)
                        .peek(n -> System.out.println(" seen even: " + n))
                        .map(n -> n * 2)
                        .collect(Collectors.toList()));

        // 5) sorted(): natural order; sorted(Comparator): custom order
        System.out.println("sorted (natural desc via comparator): " +
                numbers.stream()
                        .sorted(Comparator.reverseOrder())
                        .collect(Collectors.toList()));

        // 6) limit(n): first n elements; skip(n): drop first n
        System.out.println("limit(3): " +
                numbers.stream().limit(3).collect(Collectors.toList()));
        System.out.println("skip(5): " +
                numbers.stream().skip(5).collect(Collectors.toList()));

        // 7) distinct(): unique elements
        List<Integer> withDup = Arrays.asList(3,1,2,3,2,4,4,5,1);
        System.out.println("distinct: " +
                withDup.stream().distinct().collect(Collectors.toList()));

        // 8) takeWhile / dropWhile (Java 9+)
        System.out.println("takeWhile (n < 6): " +
                numbers.stream().takeWhile(n -> n < 6).collect(Collectors.toList()));
        System.out.println("dropWhile (n < 6): " +
                numbers.stream().dropWhile(n -> n < 6).collect(Collectors.toList()));

        // 9) terminal: forEach
        System.out.print("forEach (print odds): ");
        numbers.stream().filter(n -> n % 2 == 1).forEach(n -> System.out.print(n + " "));
        System.out.println();

        // 10) reduce: sum, product, max
        int sum = numbers.stream().reduce(0, Integer::sum);
        int product = numbers.stream().reduce(1, (a, b) -> a * b);
        Optional<Integer> max = numbers.stream().reduce(Integer::max);
        System.out.println("reduce (sum): " + sum);
        System.out.println("reduce (product): " + product);
        System.out.println("reduce (max): " + max.orElse(null));

        // 11) collect to List/Set/Map
        List<Integer> evens = numbers.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
        Set<Integer> squaresSet = numbers.stream().map(n -> n * n).collect(Collectors.toSet());
        Map<Integer, String> numToType = numbers.stream()
                .collect(Collectors.toMap(
                        n -> n,
                        n -> (n % 2 == 0 ? "even" : "odd")
                ));
        System.out.println("collect to List (evens): " + evens);
        System.out.println("collect to Set (squares): " + squaresSet);
        System.out.println("collect to Map (n -> odd/even): " + numToType);

        // 12) groupingBy / partitioningBy
        Map<String, List<Integer>> groupedByParity = numbers.stream()
                .collect(Collectors.groupingBy(n -> n % 2 == 0 ? "even" : "odd"));
        Map<Boolean, List<Integer>> partitionedEven = numbers.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println("groupingBy (parity): " + groupedByParity);
        System.out.println("partitioningBy (even?): " + partitionedEven);

        // 13) summarizingInt: count, sum, min, avg, max in one go
        IntSummaryStatistics stats = numbers.stream().collect(Collectors.summarizingInt(Integer::intValue));
        System.out.println("summarizingInt: " + stats);

        // 14) anyMatch / allMatch / noneMatch
        System.out.println("anyMatch (>9): " + numbers.stream().anyMatch(n -> n > 9));
        System.out.println("allMatch (<=10): " + numbers.stream().allMatch(n -> n <= 10));
        System.out.println("noneMatch (<0): " + numbers.stream().noneMatch(n -> n < 0));

        // 15) findFirst / findAny
        Optional<Integer> firstEven = numbers.stream().filter(n -> n % 2 == 0).findFirst();
        Optional<Integer> anyDivBy3 = numbers.stream().filter(n -> n % 3 == 0).findAny();
        System.out.println("findFirst (even): " + firstEven.orElse(null));
        System.out.println("findAny (divisible by 3): " + anyDivBy3.orElse(null));

        // 16) mapToInt / mapToDouble / mapToLong + sum/avg/min/max
        int sumSquares = numbers.stream().mapToInt(n -> n * n).sum();
        OptionalDouble avgVal = numbers.stream().mapToInt(Integer::intValue).average();
        System.out.println("mapToInt + sum (squares): " + sumSquares);
        System.out.println("mapToInt + average: " + (avgVal.isPresent() ? avgVal.getAsDouble() : null));

        // 17) joining (for strings)
        List<String> words = Arrays.asList("spring", "boot", "streams");
        String joined = words.stream().map(String::toUpperCase).collect(Collectors.joining(", "));
        System.out.println("joining: " + joined);

        // 18) custom Comparator (sort by parity then value)
        System.out.println("sorted by parity then value: " +
                numbers.stream()
                        .sorted(Comparator.comparingInt((Integer n) -> n % 2)  // even(0) first
                                .thenComparingInt(n -> n))
                        .collect(Collectors.toList()));

        // 19) generating streams: of, iterate, generate
        System.out.println("Stream.of: " + Stream.of(10, 20, 30).collect(Collectors.toList()));
        System.out.println("iterate (first 5 multiples of 3): " +
                Stream.iterate(3, n -> n + 3).limit(5).collect(Collectors.toList()));
        System.out.println("generate (random ints 5): " +
                Stream.generate(() -> new Random().nextInt(100)).limit(5).collect(Collectors.toList()));

        // 20) parallelStream (use carefully)
        int parallelSum = numbers.parallelStream().mapToInt(Integer::intValue).sum();
        System.out.println("parallelStream sum: " + parallelSum);

        // 21) handle Optional safely
        String maybeNull = null;
        String safe = Optional.ofNullable(maybeNull).orElse("fallback");
        System.out.println("Optional.ofNullable + orElse: " + safe);

        // 22) flatMap for transformations (e.g., parse & flatten)
        List<String> csv = Arrays.asList("1,2", "3,4,5", "6");
        List<Integer> flattenedInts = csv.stream()
                .flatMap(s -> Arrays.stream(s.split(",")))
                .map(String::trim)
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        System.out.println("flatMap (CSV -> ints): " + flattenedInts);

        // 23) collectingAndThen: post-process the collected result
        List<Integer> unmodifiableEvens = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
        System.out.println("collectingAndThen (unmodifiable evens): " + unmodifiableEvens);

        // 24) toUnmodifiableList/Set/Map (Java 10+)
        List<Integer> unmodList = numbers.stream()
                .filter(n -> n > 5)
                .collect(Collectors.toUnmodifiableList());
        System.out.println("toUnmodifiableList (>5): " + unmodList);

        // 25) mapMulti (Java 16+, alternative to flatMap with consumer)
        // Example: for each number n, emit n and -n
        List<Integer> mapMultiOut = numbers.stream()
                .<Integer>mapMulti((n, downstream) -> {
                    downstream.accept(n);
                    downstream.accept(-n);
                })
                .limit(10)
                .collect(Collectors.toList());
        System.out.println("mapMulti (n & -n, limited): " + mapMultiOut);
    }
}