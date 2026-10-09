package datastructures;

import java.util.Comparator;

/**
 * Generic max-priority heap backed by an array.
 * The element with the highest comparator value is extracted first.
 */
public class PriorityHeap<T> {

    private Object[] heap;
    private int size;
    private final Comparator<T> comparator;

    public PriorityHeap(int capacity, Comparator<T> comparator) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than zero.");
        }
        if (comparator == null) {
            throw new IllegalArgumentException("Comparator cannot be null.");
        }
        this.heap = new Object[capacity];
        this.comparator = comparator;
    }

    public void insert(T value) {
        if (value == null) {
            throw new IllegalArgumentException("Heap value cannot be null.");
        }
        ensureCapacity();
        heap[size] = value;
        heapifyUp(size);
        size++;
    }

    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return elementAt(0);
    }

    public T extractMax() {
        if (isEmpty()) {
            return null;
        }

        T result = elementAt(0);
        heap[0] = heap[size - 1];
        heap[size - 1] = null;
        size--;

        if (size > 0) {
            heapifyDown(0);
        }

        return result;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    @SuppressWarnings("unchecked")
    private T elementAt(int index) {
        return (T) heap[index];
    }

    private void ensureCapacity() {
        if (size < heap.length) {
            return;
        }

        Object[] expanded = new Object[heap.length * 2];
        System.arraycopy(heap, 0, expanded, 0, heap.length);
        heap = expanded;
    }

    private void heapifyUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (comparator.compare(elementAt(parent), elementAt(index)) >= 0) {
                break;
            }
            swap(parent, index);
            index = parent;
        }
    }

    private void heapifyDown(int index) {
        while (true) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int largest = index;

            if (left < size
                    && comparator.compare(elementAt(left), elementAt(largest)) > 0) {
                largest = left;
            }

            if (right < size
                    && comparator.compare(elementAt(right), elementAt(largest)) > 0) {
                largest = right;
            }

            if (largest == index) {
                return;
            }

            swap(index, largest);
            index = largest;
        }
    }

    private void swap(int first, int second) {
        Object temp = heap[first];
        heap[first] = heap[second];
        heap[second] = temp;
    }
}
