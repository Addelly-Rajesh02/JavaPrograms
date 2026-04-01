package javainterfaces.iterableinterface.collectioninterface.maps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LinkedHashMapExample
{
    public static void main(String[] args)
    {
        LinkedHashMap<Integer, String> hashMap = new LinkedHashMap<>();

        hashMap.put(100, "Chaitanya");
        hashMap.put(120, "Paul");
        hashMap.put(105, "Derick");
        hashMap.put(111, "Logan");

        Set<Map.Entry<Integer, String>> set = hashMap.entrySet();
        for (Object o : set) {
            Map.Entry m = (Map.Entry) o;
            System.out.print("key is: " + m.getKey() + " & Value is: ");
            System.out.println(m.getValue());
        }
    }
}
