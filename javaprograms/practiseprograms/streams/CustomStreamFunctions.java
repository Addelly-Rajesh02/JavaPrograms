package practiseprograms.streams;

import java.util.List;
import java.util.Map;

interface CustomStreamFunctions {
    <T> String sequentialStream(List<T> items);
    <T> String parallelStream(List<T> items);
    Boolean containingOdd(List<Integer> items);
    Boolean onlyOdd(List<Integer> items);
    <T> List<T> palindromesInList(List<T> items);
    List<String> stringsToUpperCase(List<String> items);
    <T> List<T> duplicatesInList(List<T> items);
    String nonRepeatedCharacter(String string);
    String nonRepeatedCharacters(String string);
    <T extends Comparable<? super T>> List<T> descendingOrder(List<T> items);
    <T> List<T> removeNullValues(List<T> items);
    <T> String commaSeparatedStrings(List<T> items);
    Map<String, Long> countOccuranceOfWord(List<String> items);
    Integer maximumNumber(List<Integer> numbers);
    Integer sumOfNumbersInList(List<Integer> numbers);
    <T> List<T> flattenList(List<List<T>> listOfList);
    Map<Integer, Employee> listOfObjectToMap();
    List<String> elementsStartingWith(List<String> items, String startsWith);
    <T> List<T> uniqueElements(List<T> items);
    Integer secondHighestNumber(List<Integer> items);
    Integer secondLowestNumber(List<Integer> items);
    List<Integer> greaterThan(List<Integer> items, Integer greaterThan);
    Long countEven(List<Integer> items);
    <T> List<String> listToList(List<T> items);
    String removeDuplicateCharactersInString(String items);
    String findLongestStringInList(List<String> items);
    String findShortestStringInList(List<String> items);
    Map<Integer,List<String>> groupByLength(List<String> items);
    Map<Character,Long> countOccurenceOfCharacter(String sentence);
    List<String> startingWithDigit(List<Integer> items, String startingWith);
    public Boolean isNegative(List<Integer> numbers);
    public <T> T lastElementOfList(List<T> items);
    Map<Integer,String> listToMap();
    List<Integer> commaSeparatedToList(String sentence);
    List<String> sortByLengthThenAlphabetically(List<String> words);
    List<String> endingWith(List<String> items, String endsWith);
    Integer sumOfSquares(List<Integer> items);
    List<Integer> listOfFirstEvenNumbers(int limit);
    List<Integer> squareOfEven(List<Integer> numbers);
    String firstOneWithLengthGreaterThan(List<String> items, Long greaterThan);
}
