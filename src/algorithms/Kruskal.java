package algorithms;

import datastructures.CampusGraph;
import datastructures.DisjointSet;
import model.MSTEdge;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Kruskal {

    public static List<MSTEdge> findMST(
            CampusGraph graph) {

        List<MSTEdge> edges =
                graph.getAllEdges();

        edges.sort(
                Comparator.comparingInt(
                        MSTEdge::getWeight
                )
        );

        DisjointSet disjointSet =
                new DisjointSet();

        for (String location :
                graph.getLocations()) {

            disjointSet.makeSet(location);
        }

        List<MSTEdge> mst =
                new ArrayList<>();

        for (MSTEdge edge : edges) {

            boolean added =
                    disjointSet.union(
                            edge.getFrom(),
                            edge.getTo()
                    );

            if (added) {

                mst.add(edge);
            }

            if (mst.size() ==
                    graph.locationCount() - 1) {

                break;
            }
        }

        return mst;
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