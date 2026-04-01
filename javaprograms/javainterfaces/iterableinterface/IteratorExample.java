package javainterfaces.iterableinterface;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorExample
{
    public static void main(String[] args)
    {
        List<String> al = new ArrayList<>();

        al.add("C");
        al.add("A");
        al.add("E");
        al.add("B");
        al.add("D");
        al.add("F");

        System.out.print("Original contents of al: ");

        /*
        //Use iterator to display contents of al
        Iterator<String> itr=al.iterator();
            while(itr.hasNext())
            {
                Object element = itr.next();
                System.out.print(element + " ");
            }
        */
        for (Object element : al) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}