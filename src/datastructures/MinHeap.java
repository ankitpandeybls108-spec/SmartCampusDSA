package datastructures;

public class MinHeap {

    private DijkstraNode[] heap;
    private int size;

    public MinHeap(int capacity) {
        heap = new DijkstraNode[capacity];
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void insert(DijkstraNode node) {

        if (size == heap.length) {
            resize();
        }

        heap[size] = node;

        int current = size;
        size++;

        while (current > 0) {

            int parent = (current - 1) / 2;

            if (heap[parent].getDistance()
                    <= heap[current].getDistance()) {
                break;
            }

            swap(parent, current);
            current = parent;
        }
    }

    public DijkstraNode extractMin() {

        if (isEmpty()) {
            return null;
        }

        DijkstraNode min = heap[0];

        heap[0] = heap[size - 1];
        heap[size - 1] = null;
        size--;

        if (size > 0) {
            heapifyDown(0);
        }

        return min;
    }

    private void heapifyDown(int index) {

        while (true) {

            int left = 2 * index + 1;
            int right = 2 * index + 2;

            int smallest = index;

            if (left < size &&
                    heap[left].getDistance()
                    < heap[smallest].getDistance()) {

                smallest = left;
            }

            if (right < size &&
                    heap[right].getDistance()
                    < heap[smallest].getDistance()) {

                smallest = right;
            }

            if (smallest == index) {
                break;
            }

            swap(index, smallest);
            index = smallest;
        }
    }

    private void swap(int i, int j) {

        DijkstraNode temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private void resize() {

        DijkstraNode[] newHeap =
                new DijkstraNode[heap.length * 2];

        System.arraycopy(
                heap,
                0,
                newHeap,
                0,
                heap.length
        );

        heap = newHeap;
    }
}