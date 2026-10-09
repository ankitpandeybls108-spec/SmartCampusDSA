package datastructures;

public class Queue<T> {

    private Node<T> front;
    private Node<T> rear;
    private int size;

    public Queue() {
        front = null;
        rear = null;
        size = 0;
    }

    // Add element to rear
    public void enqueue(T data) {

        Node<T> newNode = new Node<>(data);

        if (rear == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }

        size++;
    }

    // Remove element from front
    public T dequeue() {

        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty.");
        }

        T data = front.data;

        front = front.next;

        if (front == null) {
            rear = null;
        }

        size--;

        return data;
    }

    // View front element
    public T peek() {

        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty.");
        }

        return front.data;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public int size() {
        return size;
    }
}