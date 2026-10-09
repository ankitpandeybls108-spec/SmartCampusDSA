package tests;

import services.CampusGraphService;

public class CampusGraphTest {

    public static void main(String[] args) {

        CampusGraphService campus =
                new CampusGraphService();

        System.out.println(
                "=== SMART CAMPUS GRAPH ==="
        );

        System.out.println();

        campus.displayCampusMap();

        System.out.println();

        System.out.println(
                "Total Locations: "
                + campus.totalLocations()
        );

        System.out.println(
                "Total Roads: "
                + campus.totalRoads()
        );
    }
}