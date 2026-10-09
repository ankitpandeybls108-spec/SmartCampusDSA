package services;

import datastructures.CampusGraph;

public class CampusGraphService {

    private CampusGraph graph;

    public CampusGraphService() {

        graph = new CampusGraph();

        buildCampusGraph();
    }

    private void buildCampusGraph() {

        // Locations
        graph.addLocation("Library");
        graph.addLocation("Canteen");
        graph.addLocation("Academic Block");
        graph.addLocation("Hostel");
        graph.addLocation("Computer Lab");

        // Roads
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
    }

    public void displayCampusMap() {

        graph.displayGraph();
    }

    public int totalLocations() {

        return graph.locationCount();
    }

    public int totalRoads() {

        return graph.edgeCount();
    }
}