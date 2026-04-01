package practiseprograms.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class Main {
    private static <T> List<T> readList(Scanner scanner, Function<String, T> mapper){
        return Arrays.stream(scanner.nextLine()
                                    .trim()
                                    .split("\\s+"))
                                    .map(mapper)
                                    .toList();
    }

    private static List<Integer> readInteger(){
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter the values: ");
        // If you wish to use integers in list
        return readList(scanner, Integer::parseInt);
    }
    private static List<String> readString(){
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter the values: ");
        // If you wish to use strings in list
        return readList(scanner, s->s);
    }
    private static List<Character> readCharacter(){
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter the values: ");
        // If you wish to use characters in list
        return readList(scanner, s -> s.charAt(0));
    }
    public static void main(String[] args){
        Streams streams=new Streams();

//        List<Integer> sequenceNumbers=readInteger();
//        System.out.print(streams.sequentialStream(sequenceNumbers));

//        List<Integer> parallelNumbers=readInteger();
//        System.out.print(streams.parallelStream(parallelNumbers));

//        List<Integer> containingOddNumbers=readInteger();
//        System.out.print(streams.containingOdd(containingOddNumbers));

//        List<Integer> onlyOddNumbers=readInteger();
//        System.out.print(streams.onlyOdd(onlyOddNumbers));

//        List<Integer> palindromeNumbers=readInteger();
//        System.out.print(streams.palindromesInList(palindromeNumbers));

//        List<String> palindromeStrings=readString();
//        System.out.print(streams.palindromesInList(palindromeStrings));

//        List<String> upperCaseStrings=readString();
//        System.out.print(streams.stringsToUpperCase(upperCaseStrings));

//        List<Integer> duplicateIntegers=readInteger();
//        System.out.print(streams.duplicatesInList(duplicateIntegers));

//        List<Character> duplicateCharacters=readCharacter();
//        System.out.print(streams.duplicatesInList(duplicateCharacters));

//        List<String> duplicateStrings=readString();
//        System.out.print(streams.duplicatesInList(duplicateStrings));

//        System.out.print(streams.nonRepeatedCharacter("rajesh"));
//        System.out.print(streams.nonRepeatedCharacters("rajesh"));

//        List<Integer> descendingOrderNumbers=readInteger();
//        System.out.print(streams.descendingOrder(descendingOrderNumbers));

//        List<Character> descendingOrderCharacters=readCharacter();
//        System.out.print(streams.descendingOrder(descendingOrderCharacters));

//        List<String> descendingOrderStrings=readString();
//        System.out.print(streams.descendingOrder(descendingOrderStrings));

//        List<String> removeNullValues=readString();
//        System.out.print(streams.descendingOrder(removeNullValues));

//        List<Integer> separateByCommaIntegers=readInteger();
//        System.out.print(streams.commaSeparatedStrings(separateByCommaIntegers));

//        List<Character> separateByCommaCharacters=readCharacter();
//        System.out.print(streams.commaSeparatedStrings(separateByCommaCharacters));

//        List<String> separateByCommaStrings=readString();
//        System.out.print(streams.commaSeparatedStrings(separateByCommaStrings));

        List<String> occuranceOfWords=readString();
        System.out.print(streams.countOccuranceOfWord(occuranceOfWords));

//        List<Integer> largestNumber=readInteger();
//        System.out.print(streams.maximumNumber(largestNumber));

//        List<Integer> sumOfNumbers=readInteger();
//        System.out.print(streams.sumOfNumbersInList(sumOfNumbers));

//        List<List<Integer>> flattenListInteger=Arrays.asList(Arrays.asList(1,2,3),Arrays.asList(2,3,4),Arrays.asList(1,1,1));
//        System.out.print(streams.flattenList(flattenListInteger));

//        List<List<Character>> flattenListCharacter=Arrays.asList(Arrays.asList('a','b','c'),Arrays.asList('e','f','g'),Arrays.asList('a','a','b'));
//        System.out.print(streams.flattenList(flattenListCharacter));

//        List<List<String>> flattenListString=Arrays.asList(Arrays.asList("Rajesh","Ramu","ravi"),Arrays.asList("rakesh","Raju","rahul"),Arrays.asList("rajesh"));
//        System.out.print(streams.flattenList(flattenListString));

//        System.out.print(streams.listOfObjectToMap());

//        List<String> stringsStartingWith=readString();
//        System.out.print(streams.elementsStartingWith(stringsStartingWith,"R"));

//        List<Integer> uniqueIntegers=readInteger();
//        System.out.print(streams.uniqueElements(uniqueIntegers));

//        List<Character> uniqueCharacter=readCharacter();
//        System.out.print(streams.uniqueElements(uniqueCharacter));

//        List<String> uniqueString=readString();
//        System.out.print(streams.uniqueElements(uniqueString));

//        List<Integer> secondHighestInteger=readInteger();
//        System.out.print(streams.secondHighestNumber(secondHighestInteger));

//        List<Integer> secondLowestInteger=readInteger();
//        System.out.print(streams.secondLowestNumber(secondLowestInteger));

//        List<Integer> largestElement =readInteger();
//        System.out.print(streams.greaterThan(largestElement,10));

//        List<Integer> largestElement =readInteger();
//        System.out.print(streams.greaterThan(largestElement,10));

//        List<Integer> countEvenNumbers =readInteger();
//        System.out.print(streams.countEven(countEvenNumbers));

//        List<Integer> printListIntegers =readInteger();
//        System.out.print(streams.listToList(printListIntegers));

//        List<Character> printListCharacters =readCharacter();
//        System.out.print(streams.listToList(printListCharacters));

//        List<String> printListStrings =readString();
//        System.out.print(streams.listToList(printListStrings));

//        System.out.print(streams.removeDuplicateCharactersInString("rajeshrajesh"));

//        List<String> longestStringInList =readString();
//        System.out.print(streams.findLongestStringInList(longestStringInList));

//        List<String> shortestStringInList =readString();
//        System.out.print(streams.findShortestStringInList(shortestStringInList));

//        List<String> groupByLength =readString();
//        System.out.print(streams.groupByLength(groupByLength));

//        System.out.print(streams.countOccurenceOfCharacter("countCharacters"));

//        List<Integer> startingWithDigit =readInteger();
//        System.out.print(streams.startingWithDigit(startingWithDigit,"3"));

//        List<Integer> negativeNumbers =readInteger();
//        System.out.print(streams.isNegative(negativeNumbers));

//        List<Integer> lastInteger =readInteger();
//        System.out.print(streams.lastElementOfList(lastInteger));

//        List<Character> lastCharacter =readCharacter();
//        System.out.print(streams.lastElementOfList(lastCharacter));

//        List<String> lastString =readString();
//        System.out.print(streams.lastElementOfList(lastString));

//        System.out.print(streams.listToMap());

//        System.out.print(streams.commaSeparatedToList("1,2,3,4,5,4,6,7"));

//        List<String> sortLengthAlphabetical =readString();
//        System.out.print(streams.sortByLengthThenAlphabetically(sortLengthAlphabetical));

//        List<String> endingWith =readString();
//        System.out.print(streams.endingWith(endingWith,"a"));

//        List<Integer> sumOfSquareIntegers =readInteger();
//        System.out.print(streams.sumOfSquares(sumOfSquareIntegers));

//        System.out.print(streams.listOfFirstEvenNumbers(10));

//        List<Integer> squareOfEvenNumbers =readInteger();
//        System.out.print(streams.squareOfEven(squareOfEvenNumbers));

//        List<String> firstWordGreaterThan =readString();
//        System.out.print(streams.firstOneWithLengthGreaterThan(firstWordGreaterThan,3L));

    }
}
