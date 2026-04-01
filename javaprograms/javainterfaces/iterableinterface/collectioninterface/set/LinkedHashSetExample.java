package javainterfaces.iterableinterface.collectioninterface.set;

import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetExample
{
    public static void main(String[] args)
    {
        Set<String> set=new LinkedHashSet<>();
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

