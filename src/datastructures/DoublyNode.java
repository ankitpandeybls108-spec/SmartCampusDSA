package datastructures;

public class DoublyNode<T> {

    T data;

    DoublyNode<T> previous;
    DoublyNode<T> next;

    public DoublyNode(T data) {

        this.data = data;
        this.previous = null;
        this.next = null;
    }
}