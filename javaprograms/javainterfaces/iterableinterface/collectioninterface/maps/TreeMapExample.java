package javainterfaces.iterableinterface.collectioninterface.maps;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapExample
{
    public static void main(String[] args)
    {
        TreeMap<Integer, String> treeMap = new TreeMap<>();

        treeMap.put(101, "Chaitanya");
        treeMap.put(105, "Derick");
        treeMap.put(111, "Logan");
        treeMap.put(120, "Paul");

        Set<Map.Entry<Integer, String>> set = treeMap.entrySet();

        for (Map.Entry<Integer, String> integerStringEntry : set)
        {
            System.out.print("key is: " + ((Map.Entry) integerStringEntry).getKey() + " & Value is: ");
            System.out.println(((Map.Entry) integerStringEntry).getValue());
        }
    }
}
