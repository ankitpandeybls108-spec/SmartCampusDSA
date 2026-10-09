package datastructures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import model.MSTEdge;

public class CampusGraph {

    private Map<String, GraphNode> nodes;

    private Map<String, List<GraphEdge>> adjacencyList;

    public CampusGraph() {

        nodes = new HashMap<>();
        adjacencyList = new HashMap<>();
    }

    // =========================
    // ADD VERTEX
    // =========================

    public void addLocation(String name) {

        if (nodes.containsKey(name)) {
            return;
        }

        GraphNode node = new GraphNode(name);

        nodes.put(name, node);

        adjacencyList.put(
                name,
                new ArrayList<>()
        );
    }

    // =========================
    // ADD UNDIRECTED EDGE
    // =========================

    public void addRoad(
            String from,
            String to,
            int distance) {

        if (distance < 0) {
            throw new IllegalArgumentException(
                    "Distance cannot be negative."
            );
        }

        if (!nodes.containsKey(from)
                || !nodes.containsKey(to)) {

            throw new IllegalArgumentException(
                    "Both locations must exist."
            );
        }

        GraphNode destination =
                nodes.get(to);

        GraphNode source =
                nodes.get(from);

        adjacencyList
                .get(from)
                .add(
                        new GraphEdge(
                                destination,
                                distance
                        )
                );

        adjacencyList
                .get(to)
                .add(
                        new GraphEdge(
                                source,
                                distance
                        )
                );
    }

    // =========================
    // DISPLAY GRAPH
    // =========================

    public void displayGraph() {

        for (String location : adjacencyList.keySet()) {

            System.out.print(
                    location + " -> "
            );

            List<GraphEdge> edges =
                    adjacencyList.get(location);

            for (GraphEdge edge : edges) {

                System.out.print(
                        edge + " "
                );
            }

            System.out.println();
        }
    }

    // =========================
    // NUMBER OF LOCATIONS
    // =========================

    public int locationCount() {
        return nodes.size();
    }

    // =========================
    // NUMBER OF EDGES
    // =========================

    public int edgeCount() {

        int total = 0;

        for (List<GraphEdge> edges :
                adjacencyList.values()) {

            total += edges.size();
        }

        // Every undirected edge was stored twice.
        return total / 2;
    }

    // =========================
    // CHECK LOCATION
    // =========================

    public boolean containsLocation(
            String name) {

        return nodes.containsKey(name);
    }
    public List<GraphEdge> getNeighbors(
        String location) {

    if (!adjacencyList.containsKey(location)) {
        throw new IllegalArgumentException(
                "Location not found."
        );
    }

    return adjacencyList.get(location);
}
public int degree(String location) {

    if (!adjacencyList.containsKey(location)) {
        throw new IllegalArgumentException(
                "Location not found."
        );
    }

    return adjacencyList
            .get(location)
            .size();
}
public boolean areConnected(
        String from,
        String to) {

    if (!adjacencyList.containsKey(from)
            || !adjacencyList.containsKey(to)) {

        return false;
    }

    for (GraphEdge edge :
            adjacencyList.get(from)) {

        if (edge.getDestination()
                .getName()
                .equals(to)) {

            return true;
        }
    }

    return false;
}
public List<MSTEdge> getAllEdges() {

    List<MSTEdge> edges = new ArrayList<>();

    Set<String> processed = new HashSet<>();

    for (String location : adjacencyList.keySet()) {

        for (GraphEdge edge :
                adjacencyList.get(location)) {

            String destination =
                    edge.getDestination().getName();

            String key;

            if (location.compareTo(destination) < 0) {
                key = location + "|" + destination;
            } else {
                key = destination + "|" + location;
            }

            if (!processed.contains(key)) {

                edges.add(
                        new MSTEdge(
                                location,
                                destination,
                                edge.getWeight()
                        )
                );

                processed.add(key);
            }
        }
    }

    return edges;
}
public java.util.Set<String> getLocations() {
    return new java.util.HashSet<>(adjacencyList.keySet());
}
}