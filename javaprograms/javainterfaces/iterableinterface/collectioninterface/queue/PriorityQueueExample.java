package javainterfaces.iterableinterface.collectioninterface.queue;

import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueExample
{
    public static void main(String[] args)
    {
        Queue<Integer> pq = new PriorityQueue<>();
        pq.add(30);
        pq.add(10);
        pq.add(20);

        System.out.println("Elements in PriorityQueue (order may vary): " + pq);
        System.out.println("Polling element (smallest): " + pq.poll());
        System.out.println("Elements after poll: " + pq);
    }
}