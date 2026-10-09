package datastructures;

public class Stack<T> {

    private Node<T> top;
    private int size;

    public Stack() {
        top = null;
        size = 0;
    }

    // Push element
    public void push(T data) {

        Node<T> newNode = new Node<>(data);

        newNode.next = top;
        top = newNode;

        size++;
    }

    // Pop element
    public T pop() {

        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty.");
        }

        T data = top.data;

        top = top.next;
        size--;

        return data;
    }

    // Peek top element
    public T peek() {

        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty.");
        }

        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        return size;
    }
}