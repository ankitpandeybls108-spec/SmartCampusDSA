package tests;

import algorithms.Dijkstra;
import datastructures.CampusGraph;

import java.util.List;
import java.util.Map;

public class DijkstraTest {

    public static void main(String[] args) {

        CampusGraph graph = new CampusGraph();

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
                "=== Dijkstra Test ==="
        );

        Map<String, Integer> distances =
                Dijkstra.shortestDistances(
                        graph,
                        "Library"
                );

        System.out.println(
                "\nShortest distances from Library:"
        );

        for (Map.Entry<String, Integer> entry :
                distances.entrySet()) {

            System.out.println(
                    entry.getKey()
                    + " = "
                    + entry.getValue()
            );
        }

        List<String> path =
                Dijkstra.shortestPath(
                        graph,
                        "Library",
                        "Hostel"
                );

        int distance =
                Dijkstra.shortestDistance(
                        graph,
                        "Library",
                        "Hostel"
                );

        System.out.println(
                "\nShortest path to Hostel:"
        );

        System.out.println(path);

        System.out.println(
                "Shortest distance = "
                + distance
        );
    }
}