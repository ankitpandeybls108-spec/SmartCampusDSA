package algorithms;

import datastructures.CampusGraph;
import datastructures.GraphEdge;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

public class BFS {

    public static List<String> traverse(
            CampusGraph graph,
            String start) {

        if (!graph.containsLocation(start)) {

            throw new IllegalArgumentException(
                    "Starting location not found."
            );
        }

        Set<String> visited =
                new HashSet<>();

        Queue<String> queue =
                new LinkedList<>();

        List<String> order = new ArrayList<>();

        // Mark start as visited
        visited.add(start);

        // Add start to queue
        queue.offer(start);

        while (!queue.isEmpty()) {

            String current =
                    queue.poll();

            order.add(current);

            for (GraphEdge edge :
                    graph.getNeighbors(current)) {

                String neighbor =
                        edge.getDestination()
                                .getName();

                if (!visited.contains(neighbor)) {

                    visited.add(neighbor);

                    queue.offer(neighbor);
                }
            }
        }

        return order;
    }
    public static boolean isReachable(
        CampusGraph graph,
        String start,
        String target) {

    if (!graph.containsLocation(start)
            || !graph.containsLocation(target)) {

        return false;
    }

    Set<String> visited =
            new HashSet<>();

    Queue<String> queue =
            new LinkedList<>();

    visited.add(start);
    queue.offer(start);

    while (!queue.isEmpty()) {

        String current =
                queue.poll();

        if (current.equals(target)) {
            return true;
        }

        for (GraphEdge edge :
                graph.getNeighbors(current)) {

            String neighbor =
                    edge.getDestination()
                            .getName();

            if (!visited.contains(neighbor)) {

                visited.add(neighbor);

                queue.offer(neighbor);
            }
        }
    }

    return false;
}
public static java.util.List<String> shortestPath(
        CampusGraph graph,
        String start,
        String target) {

    java.util.List<String> path =
            new java.util.ArrayList<>();

    if (!graph.containsLocation(start)
            || !graph.containsLocation(target)) {

        return path;
    }

    Set<String> visited =
            new HashSet<>();

    Queue<String> queue =
            new LinkedList<>();

    java.util.Map<String, String> parent =
            new java.util.HashMap<>();

    visited.add(start);

    queue.offer(start);

    while (!queue.isEmpty()) {

        String current =
                queue.poll();

        if (current.equals(target)) {
            break;
        }

        for (GraphEdge edge :
                graph.getNeighbors(current)) {

            String neighbor =
                    edge.getDestination()
                            .getName();

            if (!visited.contains(neighbor)) {

                visited.add(neighbor);

                parent.put(
                        neighbor,
                        current
                );

                queue.offer(neighbor);
            }
        }
    }

    if (!visited.contains(target)) {
        return path;
    }

    String current = target;

    while (current != null) {

        path.add(0, current);

        current = parent.get(current);
    }

    return path;
}
}