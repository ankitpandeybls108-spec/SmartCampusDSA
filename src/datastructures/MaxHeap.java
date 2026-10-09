package datastructures;

public class MaxHeap {

    private int[] heap;
    private int size;

    public MaxHeap(int capacity) {

        if (capacity <= 0) {
            throw new IllegalArgumentException(
                    "Capacity must be greater than zero."
            );
        }

        heap = new int[capacity];
        size = 0;
    }

    public void insert(int value) {

        if (size == heap.length) {
            throw new IllegalStateException(
                    "Heap is full."
            );
        }

        heap[size] = value;

        heapifyUp(size);

        size++;
    }

    private void heapifyUp(int index) {

        while (index > 0) {

            int parent =
                    (index - 1) / 2;

            if (heap[parent] >= heap[index]) {
                break;
            }

            swap(parent, index);

            index = parent;
        }
    }

    public int extractMax() {

        if (isEmpty()) {
            throw new IllegalStateException(
                    "Heap is empty."
            );
        }

        int max = heap[0];

        heap[0] = heap[size - 1];

        size--;

        if (size > 0) {
            heapifyDown(0);
        }

        return max;
    }

    private void heapifyDown(int index) {

        while (true) {

            int left =
                    2 * index + 1;

            int right =
                    2 * index + 2;

            int largest = index;

            if (left < size &&
                    heap[left] > heap[largest]) {

                largest = left;
            }

            if (right < size &&
                    heap[right] > heap[largest]) {

                largest = right;
            }

            if (largest == index) {
                break;
            }

            swap(index, largest);

            index = largest;
        }
    }

    public int peekMax() {

        if (isEmpty()) {
            throw new IllegalStateException(
                    "Heap is empty."
            );
        }

        return heap[0];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private void swap(int i, int j) {

        int temp = heap[i];

        heap[i] = heap[j];

        heap[j] = temp;
    }
}