package javainterfaces.iterableinterface.collectioninterface.list;

import java.util.*;

public class LinkedListExample
{
    public static void main(String[] args)
    {
        List<String> fruits = new LinkedList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.addFirst("Orange");

        System.out.println("Fruits in LinkedList: " + fruits);
        System.out.println("First fruit: " + fruits.getFirst());
    }
}