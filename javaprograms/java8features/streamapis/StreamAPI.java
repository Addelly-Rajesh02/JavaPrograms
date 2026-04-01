package java8features.streamapis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPI {
    public static void main(String args[]){
        List<Integer> sampleList= Arrays.asList(1,43,3,2,5,7,223);
        List<Integer> sorted=sampleList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(sorted);

        List<String> names=Arrays.asList("vikram","rajesh","deadly","sporty");
        List<String> sortedNames=names.stream().sorted().toList();
        System.out.println(sortedNames);

        List<String> namess=Arrays.asList("a","bb","aaaaaa","b");

        List<String> sortedNamesByLen=namess.stream().sorted(Comparator.comparingInt(String::length)).toList();
        System.out.println(sortedNamesByLen);
}
}

//public static void main(String[] args) {
//    List<List<String>> listOfLists = Arrays.asList(
//            Arrays.asList("Reflection", "Collection", "Stream"),
//            Arrays.asList("Structure", "State", "Flow"),
//            Arrays.asList("Sorting", "Mapping", "Reduction", "Stream")
//    );
//    Set<String> intermediateResults = new HashSet<>();
//    List<String> result = listOfLists.stream()
//            .flatMap(List::stream)
//            .filter(s -> s.startsWith("S"))
//            .map(String::toUpperCase)
//            .distinct()
//            .sorted()
//            .peek(s -> intermediateResults.add(s))
//            .collect(Collectors.toList());
//    System.out.println("Intermediate Results:");
//    intermediateResults.forEach(System.out::println);
//    System.out.println("Final Result:");
//    result.forEach(System.out::println);
//}