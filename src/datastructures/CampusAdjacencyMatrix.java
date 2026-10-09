package datastructures;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CampusAdjacencyMatrix {

    private int[][] matrix;

    private Map<String, Integer> indexMap;

    private List<String> locations;

    private int edgeCount;

    public CampusAdjacencyMatrix(int capacity) {

        if (capacity <= 0) {
            throw new IllegalArgumentException(
                    "Capacity must be greater than zero."
            );
        }

        matrix = new int[capacity][capacity];

        indexMap = new LinkedHashMap<>();

        locations = new ArrayList<>();

        edgeCount = 0;
    }

    // =========================
    // ADD LOCATION
    // =========================

    public void addLocation(String name) {

        if (indexMap.containsKey(name)) {
            return;
        }

        if (locations.size() >= matrix.length) {
            throw new IllegalStateException(
                    "Graph capacity exceeded."
            );
        }

        int index = locations.size();

        locations.add(name);

        indexMap.put(name, index);
    }

    // =========================
    // ADD ROAD
    // =========================

    public void addRoad(
            String from,
            String to,
            int distance) {

        if (distance < 0) {
            throw new IllegalArgumentException(
                    "Distance cannot be negative."
            );
        }

        if (!indexMap.containsKey(from)
                || !indexMap.containsKey(to)) {

            throw new IllegalArgumentException(
                    "Both locations must exist."
            );
        }

        int fromIndex =
                indexMap.get(from);

        int toIndex =
                indexMap.get(to);

        // Count only a new edge
        if (matrix[fromIndex][toIndex] == 0) {
            edgeCount++;
        }

        matrix[fromIndex][toIndex] = distance;

        matrix[toIndex][fromIndex] = distance;
    }

    // =========================
    // CHECK DIRECT CONNECTION
    // =========================

    public boolean areConnected(
            String from,
            String to) {

        if (!indexMap.containsKey(from)
                || !indexMap.containsKey(to)) {

            return false;
        }

        int fromIndex =
                indexMap.get(from);

        int toIndex =
                indexMap.get(to);

        return matrix[fromIndex][toIndex] != 0;
    }

    // =========================
    // GET DISTANCE
    // =========================

    public int getDistance(
            String from,
            String to) {

        if (!indexMap.containsKey(from)
                || !indexMap.containsKey(to)) {

            throw new IllegalArgumentException(
                    "Location not found."
            );
        }

        int fromIndex =
                indexMap.get(from);

        int toIndex =
                indexMap.get(to);

        return matrix[fromIndex][toIndex];
    }

    // =========================
    // DISPLAY MATRIX
    // =========================

    public void displayMatrix() {

    System.out.print("\t");

    for (String location : locations) {
        System.out.print(location + "\t");
    }

    System.out.println();

    for (int i = 0;
         i < locations.size();
         i++) {

        System.out.print(
                locations.get(i) + "\t"
        );

        for (int j = 0;
             j < locations.size();
             j++) {

            System.out.print(
                    matrix[i][j] + "\t"
            );
        }

        System.out.println();
    }
}

    public int locationCount() {
        return locations.size();
    }

    public int edgeCount() {
        return edgeCount;
    }
}