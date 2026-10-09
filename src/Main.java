import model.CampusActivity;
import model.Priority;
import model.Resource;
import model.ResourceItem;
import model.ServiceRequest;
import model.Student;
import model.MSTEdge;

import services.CampusManagementSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final CampusManagementSystem system = new CampusManagementSystem();

    public static void main(String[] args) {
        printBanner();

        boolean running = true;
        while (running) {
            displayMenu();
            int choice = readInt("Enter choice: ");
            System.out.println();

            try {
                switch (choice) {
                    case 1 -> addStudent();
                    case 2 -> findStudent();
                    case 3 -> removeStudent();
                    case 4 -> addResource();
                    case 5 -> findResource();
                    case 6 -> addServiceRequest();
                    case 7 -> processRequest();
                    case 8 -> campusBFS();
                    case 9 -> campusDFS();
                    case 10 -> shortestRoute();
                    case 11 -> displayMST();
                    case 12 -> scheduleActivities();
                    case 13 -> allocateResources();
                    case 14 -> system.displayStatistics();
                    case 0 -> running = false;
                    default -> System.out.println("Invalid choice.");
                }
            } catch (IllegalArgumentException | IllegalStateException e) {
                System.out.println("Operation failed: " + e.getMessage());
            }
        }

        System.out.println("Thank you for using Smart Campus System.");
        scanner.close();
    }

    private static void printBanner() {
        System.out.println("==============================================");
        System.out.println("       SMART CAMPUS DSA MANAGEMENT SYSTEM");
        System.out.println("==============================================");
    }

    private static void displayMenu() {
        System.out.println();
        System.out.println("============== MAIN MENU ==============");
        System.out.println("1. Add Student");
        System.out.println("2. Find Student");
        System.out.println("3. Remove Student");
        System.out.println("4. Add Resource");
        System.out.println("5. Find Resource");
        System.out.println("6. Add Service Request");
        System.out.println("7. Process Service Request");
        System.out.println("8. Campus BFS Traversal");
        System.out.println("9. Campus DFS Traversal");
        System.out.println("10. Find Shortest Route");
        System.out.println("11. Minimum Campus Network");
        System.out.println("12. Schedule Campus Activities");
        System.out.println("13. Optimize Resource Allocation");
        System.out.println("14. Display Statistics");
        System.out.println("0. Exit");
        System.out.println("========================================");
    }

    private static void addStudent() {
        int id = readInt("Student ID: ");
        String name = readString("Student name: ");
        String department = readString("Department: ");
        String email = readString("Student email: ");

        if (system.findStudent(id) != null) {
            System.out.println("A student with this ID already exists.");
            return;
        }

        system.addStudent(new Student(id, name, department, email));
        System.out.println("Student added successfully.");
    }

    private static void findStudent() {
        int id = readInt("Student ID: ");
        Student student = system.findStudent(id);

        if (student == null) {
            System.out.println("Student not found.");
        } else {
            System.out.println("Student found: " + student);
        }
    }

    private static void removeStudent() {
        int id = readInt("Student ID: ");
        boolean removed = system.removeStudent(id);
        System.out.println(removed ? "Student removed." : "Student not found.");
    }

    private static void addResource() {
        String id = readString("Resource ID: ");
        String name = readString("Resource name: ");
        String type = readString("Resource type: ");
        String location = readString("Resource location: ");
        boolean available = readBoolean("Is resource available? (y/n): ");

        if (system.findResource(id) != null) {
            System.out.println("A resource with this ID already exists.");
            return;
        }

        system.addResource(new Resource(id, name, type, location, available));
        System.out.println("Resource added successfully.");
    }

    private static void findResource() {
        String id = readString("Resource ID: ");
        Resource resource = system.findResource(id);
        System.out.println(resource == null ? "Resource not found." : resource);
    }

    private static void addServiceRequest() {
        int requestId = readInt("Request ID: ");
        int studentId = readInt("Student ID: ");
        Student student = system.findStudent(studentId);

        if (student == null) {
            System.out.println("Student not found. Add the student first.");
            return;
        }

        String description = readString("Request description: ");
        Priority priority = readPriority();

        system.addServiceRequest(
                new ServiceRequest(requestId, student, description, priority)
        );

        System.out.println("Service request added successfully.");
    }

    private static void processRequest() {
        ServiceRequest next = system.viewNextRequest();
        if (next == null) {
            System.out.println("No pending service requests.");
            return;
        }

        System.out.println("Next request: " + next);
        System.out.println("Processed: " + system.processRequest());
    }

    private static void campusBFS() {
        String start = readString("Starting location: ");
        System.out.println("BFS traversal: " + system.bfs(start));
    }

    private static void campusDFS() {
        String start = readString("Starting location: ");
        System.out.println("DFS traversal: " + system.dfs(start));
    }

    private static void shortestRoute() {
        String start = readString("Starting location: ");
        String destination = readString("Destination: ");

        List<String> path = system.shortestPath(start, destination);
        int distance = system.shortestDistance(start, destination);

        if (path.isEmpty()) {
            System.out.println("No route found.");
            return;
        }

        System.out.println("Shortest route: " + String.join(" -> ", path));
        System.out.println("Distance = " + distance);
    }

    private static void displayMST() {
        System.out.println("========== MINIMUM CAMPUS NETWORK ==========");
        List<MSTEdge> mst = system.getKruskalMST();

        for (MSTEdge edge : mst) {
            System.out.println(edge);
        }

        System.out.println("Total network cost = " + system.getKruskalCost());
    }

    private static void scheduleActivities() {
        List<CampusActivity> activities = new ArrayList<>();
        activities.add(new CampusActivity("AI Seminar", 9, 10));
        activities.add(new CampusActivity("DSA Workshop", 9, 11));
        activities.add(new CampusActivity("ML Workshop", 10, 12));
        activities.add(new CampusActivity("Project Review", 11, 13));

        List<CampusActivity> schedule = system.createSchedule(activities);

        System.out.println("========== OPTIMAL SCHEDULE ==========");
        schedule.forEach(System.out::println);
    }

    private static void allocateResources() {
        List<ResourceItem> resources = new ArrayList<>();
        resources.add(new ResourceItem("Laptop", 60, 10));
        resources.add(new ResourceItem("Projector", 100, 20));
        resources.add(new ResourceItem("Server", 120, 30));
        resources.add(new ResourceItem("Sensor Kit", 80, 15));

        int capacity = 50;
        int maximumValue = system.maximumResourceValue(resources, capacity);
        List<ResourceItem> selected = system.selectResources(resources, capacity);

        System.out.println("========== RESOURCE ALLOCATION ==========");
        System.out.println("Maximum value = " + maximumValue);
        System.out.println("Selected resources:");
        selected.forEach(System.out::println);
    }

    private static Priority readPriority() {
        while (true) {
            String input = readString("Priority (LOW/MEDIUM/HIGH/CRITICAL): ")
                    .trim()
                    .toUpperCase(Locale.ROOT);
            try {
                return Priority.valueOf(input);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid priority. Choose LOW, MEDIUM, HIGH, or CRITICAL.");
            }
        }
    }

    private static boolean readBoolean(String message) {
        while (true) {
            String input = readString(message).trim().toLowerCase(Locale.ROOT);
            if (input.equals("y") || input.equals("yes")) {
                return true;
            }
            if (input.equals("n") || input.equals("no")) {
                return false;
            }
            System.out.println("Please enter y/yes or n/no.");
        }
    }

    private static int readInt(String message) {
        while (true) {
            try {
                return Integer.parseInt(readString(message).trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer.");
            }
        }
    }

    private static String readString(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }
}
