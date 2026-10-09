package algorithms;

import datastructures.CampusGraph;
import datastructures.GraphEdge;

import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;

public class DFS {

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
        List<String> order = new ArrayList<>();

        dfsRecursive(
                graph,
                start,
                visited,
                order
        );

        return order;
    }

    private static void dfsRecursive(
            CampusGraph graph,
            String current,
            Set<String> visited,
            List<String> order) {

        // Mark current node visited
        visited.add(current);

        order.add(current);

        // Visit neighbors
        for (GraphEdge edge :
                graph.getNeighbors(current)) {

            String neighbor =
                    edge.getDestination()
                            .getName();

            if (!visited.contains(neighbor)) {

                dfsRecursive(
                        graph,
                        neighbor,
                        visited,
                        order
                );
            }
        }
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

    return search(
            graph,
            start,
            target,
            visited
    );
}

private static boolean search(
        CampusGraph graph,
        String current,
        String target,
        Set<String> visited) {

    if (current.equals(target)) {
        return true;
    }

    visited.add(current);

    for (GraphEdge edge :
            graph.getNeighbors(current)) {

        String neighbor =
                edge.getDestination()
                        .getName();

        if (!visited.contains(neighbor)) {

            if (search(
                    graph,
                    neighbor,
                    target,
                    visited)) {

                return true;
            }
        }
    }

    return false;
}
public static void traverseIterative(
        CampusGraph graph,
        String start) {

    if (!graph.containsLocation(start)) {

        throw new IllegalArgumentException(
                "Starting location not found."
        );
    }

    Set<String> visited =
            new HashSet<>();

    java.util.Stack<String> stack =
            new java.util.Stack<>();

    stack.push(start);

    while (!stack.isEmpty()) {

        String current =
                stack.pop();

        if (visited.contains(current)) {
            continue;
        }

        visited.add(current);

        System.out.print(
                current + " "
        );

        for (GraphEdge edge :
                graph.getNeighbors(current)) {

            String neighbor =
                    edge.getDestination()
                            .getName();

            if (!visited.contains(neighbor)) {

                stack.push(neighbor);
            }
        }
    }

    System.out.println();
}
public static boolean hasCycle(
        CampusGraph graph,
        String start) {

    if (!graph.containsLocation(start)) {
        return false;
    }

    Set<String> visited =
            new HashSet<>();

    return hasCycleDFS(
            graph,
            start,
            null,
            visited
    );
}

private static boolean hasCycleDFS(
        CampusGraph graph,
        String current,
        String parent,
        Set<String> visited) {

    visited.add(current);

    for (GraphEdge edge :
            graph.getNeighbors(current)) {

        String neighbor =
                edge.getDestination()
                        .getName();

        if (!visited.contains(neighbor)) {

            if (hasCycleDFS(
                    graph,
                    neighbor,
                    current,
                    visited)) {

                return true;
            }

        } else if (!neighbor.equals(parent)) {

            return true;
        }
    }

    return false;
}
}