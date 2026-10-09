package tests;

import datastructures.Queue;

public class QueueTest {

    public static void main(String[] args) {

        Queue<Integer> queue = new Queue<>();

        System.out.println(
                "Queue empty: " + queue.isEmpty()
        );

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println(
                "\nQueue size: " + queue.size()
        );

        System.out.println(
                "Front element: " + queue.peek()
        );

        System.out.println("\nDequeuing:");

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

        System.out.println(
                "\nQueue empty: " + queue.isEmpty()
        );
    }
}