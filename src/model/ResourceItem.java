package model;

public class ResourceItem {

    private String name;
    private int value;
    private int weight;

    public ResourceItem(
            String name,
            int value,
            int weight) {

        if (weight <= 0) {
            throw new IllegalArgumentException(
                    "Weight must be positive"
            );
        }

        if (value < 0) {
            throw new IllegalArgumentException(
                    "Value cannot be negative"
            );
        }

        this.name = name;
        this.value = value;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return name
                + " [value="
                + value
                + ", weight="
                + weight
                + "]";
    }
}