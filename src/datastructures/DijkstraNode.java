package datastructures;

public class DijkstraNode {

    private String location;
    private int distance;

    public DijkstraNode(String location, int distance) {
        this.location = location;
        this.distance = distance;
    }

    public String getLocation() {
        return location;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        return location + " (" + distance + ")";
    }
}