package javainterfaces.iterableinterface.collectioninterface.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class ArrayListExample
{
    public static void main(String[] args)
    {
        List<Integer> numbers= Arrays.asList(1,2,3,4);
        System.out.print(numbers);

        List<Integer> numbers1=new ArrayList<>(Arrays.asList(1,2,3,4));
        System.out.print(numbers1);

        List<Integer> list = new ArrayList<>(List.of(1,2,34));
        System.out.println(list);

        List<String> name=List.of("a","b","c");
        System.out.println(name);

        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");

        System.out.println("Names in ArrayList: " + names);
        System.out.println("Element at index 1: " + names.get(1));

        names.remove("Bob");
        System.out.println("Names after removing Bob: " + names);


    }
}