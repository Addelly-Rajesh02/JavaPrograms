package javainterfaces.iterableinterface.collectioninterface.set;

import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetExample
{
    public static void main(String[] args)
    {
        SortedSet<String> set=new TreeSet<>();
        set.add("Paul");
        set.add("Ram");
        set.add("Aaron");
        set.add("Leo");
        set.add("Becky");

        for (String s : set)
        {
            System.out.println(s);
        }
    }
}
