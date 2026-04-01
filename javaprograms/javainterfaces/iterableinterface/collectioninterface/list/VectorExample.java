package javainterfaces.iterableinterface.collectioninterface.list;

import java.util.*;

class VectorExample
{
    public static void main(String[] args)
    {
        List<Integer> v = new Vector<>();

        for (int i = 1; i <= 5; i++)
            v.add(i);

        System.out.println(v);

        v.remove(3);

        System.out.println(v);

        for (Integer integer : v)
        {
            System.out.print(integer + " ");
        }
    }
}