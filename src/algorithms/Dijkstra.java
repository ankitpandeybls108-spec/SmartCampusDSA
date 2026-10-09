package algorithms;

import datastructures.CampusGraph;
import datastructures.DijkstraNode;
import datastructures.GraphEdge;
import datastructures.MinHeap;

import java.util.*;

public class Dijkstra {

    private static final int INF = Integer.MAX_VALUE;

    public static Map<String, Integer> shortestDistances(
            CampusGraph graph,
            String start) {

        Map<String, Integer> distances = new HashMap<>();

        for (String location : graph.getLocations()) {
            distances.put(location, INF);
        }

        if (!graph.containsLocation(start)) {
            return distances;
        }

        distances.put(start, 0);

        MinHeap minHeap = new MinHeap(
                Math.max(10, graph.locationCount())
        );

        minHeap.insert(
                new DijkstraNode(start, 0)
        );

        while (!minHeap.isEmpty()) {

            DijkstraNode current =
                    minHeap.extractMin();

            String currentLocation =
                    current.getLocation();

            int currentDistance =
                    current.getDistance();

            // Ignore outdated heap entries
            if (currentDistance >
                    distances.get(currentLocation)) {
                continue;
            }

            for (GraphEdge edge :
                    graph.getNeighbors(currentLocation)) {

                String neighbor =
                        edge.getDestination().getName();

                int weight =
                        edge.getWeight();

                int newDistance =
                        currentDistance + weight;

                if (newDistance <
                        distances.get(neighbor)) {

                    distances.put(
                            neighbor,
                            newDistance
                    );

                    minHeap.insert(
                            new DijkstraNode(
                                    neighbor,
                                    newDistance
                            )
                    );
                }
            }
        }

        return distances;
    }

    public static List<String> shortestPath(
            CampusGraph graph,
            String start,
            String target) {

        Map<String, Integer> distances =
                new HashMap<>();

        Map<String, String> parent =
                new HashMap<>();

        for (String location :
                graph.getLocations()) {

            distances.put(location, INF);
        }

        if (!graph.containsLocation(start)
                || !graph.containsLocation(target)) {

            return new ArrayList<>();
        }

        distances.put(start, 0);
        parent.put(start, null);

        MinHeap minHeap =
                new MinHeap(
                        Math.max(10,
                                graph.locationCount())
                );

        minHeap.insert(
                new DijkstraNode(start, 0)
        );

        while (!minHeap.isEmpty()) {

            DijkstraNode current =
                    minHeap.extractMin();

            String currentLocation =
                    current.getLocation();

            int currentDistance =
                    current.getDistance();

            if (currentDistance >
                    distances.get(currentLocation)) {

                continue;
            }

            if (currentLocation.equals(target)) {
                break;
            }

            for (GraphEdge edge :
                    graph.getNeighbors(currentLocation)) {

                String neighbor =
                        edge.getDestination().getName();

                int weight =
                        edge.getWeight();

                int newDistance =
                        currentDistance + weight;

                if (newDistance <
                        distances.get(neighbor)) {

                    distances.put(
                            neighbor,
                            newDistance
                    );

                    parent.put(
                            neighbor,
                            currentLocation
                    );

                    minHeap.insert(
                            new DijkstraNode(
                                    neighbor,
                                    newDistance
                            )
                    );
                }
            }
        }

        if (distances.get(target) == INF) {
            return new ArrayList<>();
        }

        LinkedList<String> path =
                new LinkedList<>();

        String current = target;

        while (current != null) {

            path.addFirst(current);

            current = parent.get(current);
        }

        return path;
    }

    public static int shortestDistance(
            CampusGraph graph,
            String start,
            String target) {

        Map<String, Integer> distances =
                shortestDistances(graph, start);

        if (!distances.containsKey(target)
                || distances.get(target) == INF) {

            return -1;
        }

        return distances.get(target);
    }
}