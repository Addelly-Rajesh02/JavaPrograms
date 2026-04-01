package javainterfaces.iterableinterface.collectioninterface.maps;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample
{
    public static void main(String[] args)
    {
        Map<String, String> capitals = new HashMap<>();

        capitals.put("USA", "Washington D.C.");
        capitals.put("India", "New Delhi");
        capitals.put("Japan", "Tokyo");

        System.out.println("Capitals: " + capitals);
        System.out.println("Capital of India: " + capitals.get("India"));

        capitals.remove("Japan");
        System.out.println("Capitals after removing Japan: " + capitals);
    }
}