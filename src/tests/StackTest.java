package tests;

import datastructures.Stack;

public class StackTest {

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();

        System.out.println("Stack empty: "
                + stack.isEmpty());

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("\nStack size: "
                + stack.size());

        System.out.println("Top element: "
                + stack.peek());

        System.out.println("\nPopping:");

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        System.out.println("\nStack empty: "
                + stack.isEmpty());
    }
}