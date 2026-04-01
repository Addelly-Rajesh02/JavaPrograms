package javainterfaces.iterableinterface.collectioninterface.set;

import java.util.HashSet;
import java.util.Set;

public class HashSetExample
{
    public static void main(String[] args)
    {
        Set<Integer> numbers = new HashSet<>();
        numbers.add(10);
        numbers.add(20);

        System.out.println("Numbers in HashSet: " + numbers);
        System.out.println("Contains 20? " + numbers.contains(20));
    }
}