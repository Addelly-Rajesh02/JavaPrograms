package javainterfaces.comparatorinterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparatorExample
{
    public static void main(String[] args)
    {
        List<Dog> list = new ArrayList<>();
        list.add(new Dog("Shaggy", 3));
        list.add(new Dog("Lacy", 2));
        list.add(new Dog("Roger", 10));
        list.add(new Dog("Tommy", 4));
        list.add(new Dog("Tammy", 1));

        //Use of comparable
        Collections.sort(list);
        System.out.println("Sorted by name:");
        System.out.print(list);

        //Use of comparator
        Collections.sort(list, new Dog());
        System.out.println(" ");
        System.out.println("Sorted by age:");
        System.out.print(list);
    }
}