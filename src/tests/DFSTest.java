package tests;

import algorithms.DFS;
import datastructures.CampusGraph;

public class DFSTest {

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
                "DFS starting from Library:"
        );

        System.out.println(
                DFS.traverse(
                        graph,
                        "Library"
                )
        );
    }
}