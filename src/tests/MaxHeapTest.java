package tests;

import datastructures.MaxHeap;

public class MaxHeapTest {

    public static void main(String[] args) {

        MaxHeap heap = new MaxHeap(10);

        heap.insert(50);
        heap.insert(30);
        heap.insert(70);
        heap.insert(20);
        heap.insert(90);

        System.out.println(
                "Maximum: " +
                heap.peekMax()
        );

        System.out.println(
                "Extract: " +
                heap.extractMax()
        );

        System.out.println(
                "Extract: " +
                heap.extractMax()
        );

        System.out.println(
                "Maximum now: " +
                heap.peekMax()
        );
    }
}