package datastructures;

public class HashMap<K, V> {

    private HashNode<K, V>[] buckets;
    private int capacity;
    private int size;

    @SuppressWarnings("unchecked")
    public HashMap(int capacity) {

        if (capacity <= 0) {
            throw new IllegalArgumentException(
                    "Capacity must be greater than zero."
            );
        }

        this.capacity = capacity;
        this.size = 0;

        buckets =
                (HashNode<K, V>[]) new HashNode[capacity];
    }

    // Calculate bucket index
    private int getIndex(K key) {

        if (key == null) {
            throw new IllegalArgumentException(
                    "Key cannot be null."
            );
        }

        return Math.floorMod(
                key.hashCode(),
                capacity
        );
    }

    // Insert or update
    public void put(K key, V value) {

        int index = getIndex(key);

        HashNode<K, V> current =
                buckets[index];

        // Check whether key already exists
        while (current != null) {

            if (current.key.equals(key)) {

                current.value = value;
                return;
            }

            current = current.next;
        }

        // Insert new node at beginning
        HashNode<K, V> newNode =
                new HashNode<>(key, value);

        newNode.next = buckets[index];

        buckets[index] = newNode;

        size++;
    }

    // Retrieve value
    public V get(K key) {

        int index = getIndex(key);

        HashNode<K, V> current =
                buckets[index];

        while (current != null) {

            if (current.key.equals(key)) {
                return current.value;
            }

            current = current.next;
        }

        return null;
    }

    // Check key
    public boolean containsKey(K key) {

        int index = getIndex(key);
        HashNode<K, V> current = buckets[index];

        while (current != null) {
            if (current.key.equals(key)) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    // Remove key
    public V remove(K key) {

        int index = getIndex(key);

        HashNode<K, V> current =
                buckets[index];

        HashNode<K, V> previous = null;

        while (current != null) {

            if (current.key.equals(key)) {

                if (previous == null) {

                    buckets[index] =
                            current.next;

                } else {

                    previous.next =
                            current.next;
                }

                size--;

                return current.value;
            }

            previous = current;
            current = current.next;
        }

        return null;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}