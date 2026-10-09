package datastructures;

public class GraphEdge {

    private GraphNode destination;
    private int weight;

    public GraphEdge(
            GraphNode destination,
            int weight) {

        this.destination = destination;
        this.weight = weight;
    }

    public GraphNode getDestination() {
        return destination;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {

        return destination.getName()
                + " (" + weight + ")";
    }
}