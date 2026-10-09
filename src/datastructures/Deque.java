package datastructures;

public class Deque<T> {

    private DoublyNode<T> front;
    private DoublyNode<T> rear;
    private int size;

    public Deque() {

        front = null;
        rear = null;
        size = 0;
    }

    // Add at front
    public void addFront(T data) {

        DoublyNode<T> newNode =
                new DoublyNode<>(data);

        if (isEmpty()) {

            front = newNode;
            rear = newNode;

        } else {

            newNode.next = front;
            front.previous = newNode;
            front = newNode;
        }

        size++;
    }

    // Add at rear
    public void addRear(T data) {

        DoublyNode<T> newNode =
                new DoublyNode<>(data);

        if (isEmpty()) {

            front = newNode;
            rear = newNode;

        } else {

            rear.next = newNode;
            newNode.previous = rear;
            rear = newNode;
        }

        size++;
    }

    // Remove from front
    public T removeFront() {

        if (isEmpty()) {
            throw new IllegalStateException(
                    "Deque is empty."
            );
        }

        T data = front.data;

        if (front == rear) {

            front = null;
            rear = null;

        } else {

            front = front.next;
            front.previous = null;
        }

        size--;

        return data;
    }

    // Remove from rear
    public T removeRear() {

        if (isEmpty()) {
            throw new IllegalStateException(
                    "Deque is empty."
            );
        }

        T data = rear.data;

        if (front == rear) {

            front = null;
            rear = null;

        } else {

            rear = rear.previous;
            rear.next = null;
        }

        size--;

        return data;
    }

    // View front
    public T peekFront() {

        if (isEmpty()) {
            throw new IllegalStateException(
                    "Deque is empty."
            );
        }

        return front.data;
    }

    // View rear
    public T peekRear() {

        if (isEmpty()) {
            throw new IllegalStateException(
                    "Deque is empty."
            );
        }

        return rear.data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}