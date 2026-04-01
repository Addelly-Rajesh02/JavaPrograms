package javainterfaces.iterableinterface.collectioninterface.list;
import java.util.*;
public class StackExample
{
        public static void main(String[] args)
        {
            Stack<String> stack = new Stack<>();
            stack.push("Geeks");
            stack.push("For");
            stack.push("Geeks");
            stack.push("Geeks");

            Iterator<String> itr = stack.iterator();

            while (itr.hasNext())
            {
                System.out.print(itr.next() + " ");
            }
            System.out.println();
            stack.pop();

            itr = stack.iterator();
            while (itr.hasNext())
            {
                System.out.print(itr.next() + " ");
            }
        }

}
