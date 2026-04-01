package practiseprograms.streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Streams implements CustomStreamFunctions {
    @Override
    public <T> String sequentialStream(List<T> items){
        return items.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        //items.stream().forEach(item->System.out.print(item+" "));
    }

    @Override
    public <T> String parallelStream(List<T> items){
        return items.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(" "));
        //items.parallelStream().forEach(System.out::print);
    }

    @Override
    public Boolean containingOdd(List<Integer> items){
        return items.parallelStream()
                    .anyMatch(x->x%2!=0);
    }

    @Override
    public Boolean onlyOdd(List<Integer> items){
        return items.parallelStream().allMatch(x->x%2!=0);
    }

    @Override
    public <T> List<T> palindromesInList(List<T> items){
        return items.stream()
                    .filter(n->new StringBuilder(n.toString())
                                                    .reverse()
                                                    .toString()
                                                    .equals(n.toString()))
                                                    .toList();
    }

    @Override
    public List<String> stringsToUpperCase(List<String> items){
        return items.stream().map(String::toUpperCase).toList();
    }

    @Override
    public <T> List<T> duplicatesInList(List<T> items){
        return items.stream()
                .filter(i-> Collections.frequency(items, i)>1)
                .distinct()
                .toList();
    }

    @Override
    public String nonRepeatedCharacter(String string){
        return String.valueOf(string.chars()
                                    .mapToObj(c->(char) c)
                .filter(ch->string.indexOf(ch)==string.lastIndexOf(ch))
                .findFirst()
                .orElse(null));
    }

    @Override
    public String nonRepeatedCharacters(String string){
        Map<Integer, Long> freq = string.codePoints()
                .boxed()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()
                ));

        StringBuilder stringBuilder = new StringBuilder();
        freq.forEach((cp, count) -> {
            if (count == 1) stringBuilder.appendCodePoint(cp);
        });
        if(stringBuilder.isEmpty())
        return null;
        else return stringBuilder.toString();
    }

    @Override
    public <T extends Comparable<? super T>> List<T> descendingOrder(List<T> items){
        return items.stream().sorted(Comparator.reverseOrder()).toList();
    }

    @Override
    public <T> List<T> removeNullValues(List<T> items){
        return items.stream()
                .filter(Objects::nonNull)
                .toList();
    }

    @Override
    public <T> String commaSeparatedStrings(List<T> items){
        return items.stream().map(String::valueOf)
                .collect(Collectors.joining(","));
    }
    @Override
    public Map<String, Long> countOccuranceOfWord(List<String> items){
        return items.stream().collect(Collectors.groupingBy(w->w, Collectors.counting()));
    }
    @Override
    public Integer maximumNumber(List<Integer> numbers){
        return numbers.stream().max(Integer::compareTo).orElse(null);
    }
    @Override
    public Integer sumOfNumbersInList(List<Integer> numbers){
        return numbers.stream().mapToInt(n->n).sum();
    }
    @Override
    public <T> List<T> flattenList(List<List<T>> listOfList){
        return listOfList.stream().flatMap(List::stream).toList();
    }
    @Override
    public Map<Integer, Employee> listOfObjectToMap() {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Rajesh"),
                new Employee(2, "Aman"),
                new Employee(3, "Riya")
        );

        Map<Integer, Employee> map = employees.stream()
                .collect(Collectors.toMap(
                        Employee::getId,  // key
                        e -> e            // value
                ));

        return map;
    }
    @Override
    public List<String> elementsStartingWith(List<String> items, String startsWith){
        return items.stream().filter(item->item.startsWith(startsWith)).toList();
    }
    @Override
    public <T> List<T> uniqueElements(List<T> items){
        return items.stream().distinct().toList();
    }
    @Override
    public Integer secondHighestNumber(List<Integer> items){
        return items.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(null);
    }
    @Override
    public Integer secondLowestNumber(List<Integer> items){
       return items.stream().sorted().skip(1).findFirst().orElse(null);
    }
    @Override
    public List<Integer> greaterThan(List<Integer> items, Integer greaterThan){
        return items.stream().filter(n->n>greaterThan).toList();
    }
    @Override
    public Long countEven(List<Integer> items){
        return items.stream().filter(n->n%2==0).count();
    }
    @Override
    public <T> List<String> listToList(List<T> items){
        return items.stream().map(String::valueOf).toList();
    }
    @Override
    public String removeDuplicateCharactersInString(String items){
        return items.chars().distinct().mapToObj(c->String.valueOf((char) c)).collect(Collectors.joining());

    }
    @Override
    public String findLongestStringInList(List<String> items){
        return items.stream().max(Comparator.comparing(String::length)).orElse(null);
    }
    @Override
    public String findShortestStringInList(List<String> items){
        return items.stream().min(Comparator.comparing(String::length)).orElse(null);
    }
    @Override
    public Map<Integer,List<String>> groupByLength(List<String> items){
        return items.stream().collect(Collectors.groupingBy(String::length));
    }
    @Override
    public Map<Character,Long> countOccurenceOfCharacter(String sentence){
        return sentence.chars().mapToObj(c->(char) c).collect(Collectors.groupingBy(ch->ch,Collectors.counting()));
    }
    @Override
    public List<String> startingWithDigit(List<Integer> items, String startingWith){
        return items.stream().map(String::valueOf).filter(s->s.startsWith(startingWith)).toList();
    }
    @Override
    public Boolean isNegative(List<Integer> numbers){
        return numbers.stream().anyMatch(n->n<0);
    }
    @Override
    public <T> T lastElementOfList(List<T> items){
        return items.stream().reduce((first, second)->second).orElse(null);
    }
    @Override
    public Map<Integer, String> listToMap() {
        List<String> list = Arrays.asList("Apple", "Ball", "Cat");
        Map<Integer, String> map =
                IntStream.range(0, list.size())
                        .boxed()
                        .collect(Collectors.toMap(
                                i -> i,              // key = index
                                list::get            // value = element
                        ));
        return map;
    }
    @Override
    public List<Integer> commaSeparatedToList(String sentence){
        return Arrays.stream(sentence.split(",")).map(Integer::valueOf).toList();
    }
    @Override
    public List<String> sortByLengthThenAlphabetically(List<String> words){
        return words.stream().sorted(Comparator.comparing(String::length).thenComparing(String::compareTo)).toList();
    }
    @Override
    public List<String> endingWith(List<String> items, String endsWith){
        return items.stream().filter(n->n.endsWith(endsWith)).toList();
    }

    @Override
    public Integer sumOfSquares(List<Integer> items){
        return items.stream().map(n->n*n).reduce(0, Integer::sum);
    }

    //done
    @Override
    public List<Integer> listOfFirstEvenNumbers(int limit){
        return Stream.iterate(2,n->n+2).limit(limit).toList();
    }

    //done
    @Override
    public List<Integer> squareOfEven(List<Integer> numbers){
        return numbers.stream().filter(n->n%2==0).map(n->n*n).toList();

    }

    @Override
    public String firstOneWithLengthGreaterThan(List<String> items, Long greaterThan) {
        return items.stream().filter(n->n.length()>greaterThan).findFirst().orElse(null);
    }

}
