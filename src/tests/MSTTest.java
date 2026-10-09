package tests;

import algorithms.Kruskal;
import algorithms.Prim;
import datastructures.CampusGraph;
import model.MSTEdge;

import java.util.List;

public class MSTTest {

    public static void main(String[] args) {

        CampusGraph graph =
                new CampusGraph();

        graph.addLocation("Library");
        graph.addLocation("Canteen");
        graph.addLocation("Academic Block");
        graph.addLocation("Hostel");
        graph.addLocation("Computer Lab");

        graph.addRoad(
                "Library",
                "Canteen",
                200
        );

        graph.addRoad(
                "Library",
                "Academic Block",
                300
        );

        graph.addRoad(
                "Canteen",
                "Academic Block",
                250
        );

        graph.addRoad(
                "Canteen",
                "Hostel",
                250
        );

        graph.addRoad(
                "Academic Block",
                "Computer Lab",
                150
        );

        graph.addRoad(
                "Hostel",
                "Computer Lab",
                180
        );

        System.out.println(
                "=== KRUSKAL MST ==="
        );

        List<MSTEdge> kruskalMST =
                Kruskal.findMST(graph);

        for (MSTEdge edge :
                kruskalMST) {

            System.out.println(edge);
        }

        System.out.println(
                "Total cost = "
                + Kruskal.totalWeight(
                        kruskalMST
                )
        );

        System.out.println();

        System.out.println(
                "=== PRIM MST ==="
        );

        List<MSTEdge> primMST =
                Prim.findMST(
                        graph,
                        "Library"
                );

        for (MSTEdge edge :
                primMST) {

            System.out.println(edge);
        }

        System.out.println(
                "Total cost = "
                + Prim.totalWeight(
                        primMST
                )
        );
    }
}