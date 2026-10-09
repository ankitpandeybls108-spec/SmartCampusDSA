package algorithms;

import datastructures.CampusGraph;
import datastructures.DijkstraNode;
import datastructures.GraphEdge;
import datastructures.MinHeap;
import model.MSTEdge;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Prim {

    public static List<MSTEdge> findMST(
            CampusGraph graph,
            String start) {

        List<MSTEdge> mst =
                new ArrayList<>();

        if (!graph.containsLocation(start)) {
            return mst;
        }

        Set<String> visited =
                new HashSet<>();

        MinHeap minHeap =
                new MinHeap(
                        Math.max(
                                10,
                                graph.locationCount()
                        )
                );

        visited.add(start);

        addEdges(
                graph,
                start,
                visited,
                minHeap
        );

        while (!minHeap.isEmpty()
                && mst.size()
                < graph.locationCount() - 1) {

            DijkstraNode node =
                    minHeap.extractMin();

            String encoded =
                    node.getLocation();

            String[] parts =
                    encoded.split("\\|");

            String from = parts[0];
            String to = parts[1];

            if (visited.contains(to)) {
                continue;
            }

            int weight =
                    node.getDistance();

            mst.add(
                    new MSTEdge(
                            from,
                            to,
                            weight
                    )
            );

            visited.add(to);

            addEdges(
                    graph,
                    to,
                    visited,
                    minHeap
            );
        }

        return mst;
    }

    private static void addEdges(
            CampusGraph graph,
            String from,
            Set<String> visited,
            MinHeap minHeap) {

        for (GraphEdge edge :
                graph.getNeighbors(from)) {

            String destination =
                    edge.getDestination().getName();

            if (!visited.contains(destination)) {

                String encoded =
                        from + "|" + destination;

                minHeap.insert(
                        new DijkstraNode(
                                encoded,
                                edge.getWeight()
                        )
                );
            }
        }
    }

    public static int totalWeight(
            List<MSTEdge> mst) {

        int total = 0;

        for (MSTEdge edge : mst) {
            total += edge.getWeight();
        }

        return total;
    }
}