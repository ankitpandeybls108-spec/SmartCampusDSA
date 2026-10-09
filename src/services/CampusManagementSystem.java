package services;

import algorithms.BFS;
import algorithms.DFS;
import algorithms.Dijkstra;
import algorithms.Kruskal;
import algorithms.Prim;

import datastructures.CampusGraph;

import model.MSTEdge;
import model.Student;
import model.Resource;
import model.ServiceRequest;
import model.CampusActivity;
import model.ResourceItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CampusManagementSystem {

    private StudentManager studentManager;
    private ResourceDirectory resourceDirectory;
    private PriorityRequestQueue requestQueue;

    private CampusGraph campusGraph;

    private ResourceScheduler resourceScheduler;
    private ResourceAllocationService resourceAllocationService;

    public CampusManagementSystem() {

        studentManager =
                new StudentManager(1000);

        resourceDirectory =
                new ResourceDirectory(1000);

        requestQueue =
                new PriorityRequestQueue(1000);

        campusGraph =
                new CampusGraph();

        resourceScheduler =
                new ResourceScheduler();

        resourceAllocationService =
                new ResourceAllocationService();

        initializeCampusGraph();
    }

    // =========================
    // STUDENT MANAGEMENT
    // =========================

    public void addStudent(Student student) {

        studentManager.addStudent(student);
    }

    public Student findStudent(int studentId) {

        return studentManager.findStudent(studentId);
    }

    public boolean removeStudent(int studentId) {

        return studentManager.removeStudent(studentId);
    }

    // =========================
    // RESOURCE MANAGEMENT
    // =========================

    public void addResource(Resource resource) {

        resourceDirectory.addResource(resource);
    }

    public Resource findResource(String resourceId) {

        return resourceDirectory.findResource(resourceId);
    }

    public boolean removeResource(String resourceId) {

        return resourceDirectory.removeResource(
                resourceId
        ) != null;
    }

    // =========================
    // SERVICE REQUESTS
    // =========================

    public void addServiceRequest(
            ServiceRequest request) {

        requestQueue.addRequest(request);
    }

    public ServiceRequest viewNextRequest() {

        return requestQueue.nextRequest();
    }

    public ServiceRequest processRequest() {

        return requestQueue.processNext();
    }

    // =========================
    // CAMPUS GRAPH
    // =========================

    private void initializeCampusGraph() {

        campusGraph.addLocation("Library");
        campusGraph.addLocation("Canteen");
        campusGraph.addLocation("Academic Block");
        campusGraph.addLocation("Hostel");
        campusGraph.addLocation("Computer Lab");

        campusGraph.addRoad(
                "Library",
                "Canteen",
                200
        );

        campusGraph.addRoad(
                "Library",
                "Academic Block",
                300
        );

        campusGraph.addRoad(
                "Canteen",
                "Academic Block",
                250
        );

        campusGraph.addRoad(
                "Canteen",
                "Hostel",
                250
        );

        campusGraph.addRoad(
                "Academic Block",
                "Computer Lab",
                150
        );

        campusGraph.addRoad(
                "Hostel",
                "Computer Lab",
                180
        );
    }

    public CampusGraph getCampusGraph() {

        return campusGraph;
    }

    // =========================
    // BFS
    // =========================

    public List<String> bfs(
            String start) {

        return BFS.traverse(
                campusGraph,
                start
        );
    }

    // =========================
    // DFS
    // =========================

    public List<String> dfs(
            String start) {

        return DFS.traverse(
                campusGraph,
                start
        );
    }

    // =========================
    // DIJKSTRA
    // =========================

    public List<String> shortestPath(
            String start,
            String destination) {

        return Dijkstra.shortestPath(
                campusGraph,
                start,
                destination
        );
    }

    public int shortestDistance(
            String start,
            String destination) {

        return Dijkstra.shortestDistance(
                campusGraph,
                start,
                destination
        );
    }

    public Map<String, Integer> shortestDistances(
            String start) {

        return Dijkstra.shortestDistances(
                campusGraph,
                start
        );
    }

    public int totalStudents() {
        return studentManager.totalStudents();
    }

    public int totalResources() {
        return resourceDirectory.totalResources();
    }

    public int pendingRequests() {
        return requestQueue.pendingRequests();
    }

    // =========================
    // MST
    // =========================

    public List<MSTEdge> getPrimMST(
            String start) {

        return Prim.findMST(
                campusGraph,
                start
        );
    }

    public List<MSTEdge> getKruskalMST() {

        return Kruskal.findMST(
                campusGraph
        );
    }

    public int getPrimCost(
            String start) {

        return Prim.totalWeight(
                getPrimMST(start)
        );
    }

    public int getKruskalCost() {

        return Kruskal.totalWeight(
                getKruskalMST()
        );
    }

    // =========================
    // GREEDY SCHEDULING
    // =========================

    public List<CampusActivity> createSchedule(
            List<CampusActivity> activities) {

        return resourceScheduler.createSchedule(
                activities
        );
    }

    // =========================
    // DP RESOURCE ALLOCATION
    // =========================

    public int maximumResourceValue(
            List<ResourceItem> resources,
            int capacity) {

        return resourceAllocationService
                .calculateMaximumValue(
                        resources,
                        capacity
                );
    }

    public List<ResourceItem> selectResources(
            List<ResourceItem> resources,
            int capacity) {

        return resourceAllocationService
                .selectResources(
                        resources,
                        capacity
                );
    }

    // =========================
    // STATISTICS
    // =========================

    public void displayStatistics() {

        System.out.println();
        System.out.println(
                "========== SYSTEM STATISTICS =========="
        );

        System.out.println(
                "Campus locations : "
                + campusGraph.locationCount()
        );

        System.out.println(
                "Campus roads     : "
                + campusGraph.edgeCount()
        );
        System.out.println(
                "Students         : "
                + studentManager.totalStudents()
        );
        System.out.println(
                "Resources        : "
                + resourceDirectory.totalResources()
        );
        System.out.println(
                "Pending requests : "
                + requestQueue.pendingRequests()
        );

        System.out.println(
                "======================================="
        );
    }
}