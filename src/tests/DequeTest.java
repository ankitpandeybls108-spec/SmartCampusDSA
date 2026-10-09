package tests;

import datastructures.Deque;

public class DequeTest {

    public static void main(String[] args) {

        Deque<Integer> deque =
                new Deque<>();

        deque.addRear(20);
        deque.addRear(30);

        deque.addFront(10);
        deque.addFront(5);

        System.out.println(
                "Front: " +
                deque.peekFront()
        );

        System.out.println(
                "Rear: " +
                deque.peekRear()
        );

        System.out.println(
                "\nRemove Front: " +
                deque.removeFront()
        );

        System.out.println(
                "Remove Rear: " +
                deque.removeRear()
        );

        System.out.println(
                "\nNew Front: " +
                deque.peekFront()
        );

        System.out.println(
                "New Rear: " +
                deque.peekRear()
        );

        System.out.println(
                "\nSize: " +
                deque.size()
        );
    }
}