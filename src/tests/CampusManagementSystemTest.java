package tests;

import model.Priority;
import model.Resource;
import model.ServiceRequest;
import model.Student;
import services.CampusManagementSystem;

public class CampusManagementSystemTest {

    public static void main(String[] args) {
        CampusManagementSystem system = new CampusManagementSystem();

        Student student = new Student(
                101,
                "Asha",
                "CSE",
                "asha@example.com"
        );
        system.addStudent(student);

        if (system.findStudent(101) == null) {
            throw new AssertionError("Student lookup failed.");
        }

        Resource resource = new Resource(
                "LAB-01",
                "Laptop",
                "Equipment",
                "Computer Lab",
                true
        );
        system.addResource(resource);

        if (system.findResource("LAB-01") == null) {
            throw new AssertionError("Resource lookup failed.");
        }

        system.addServiceRequest(
                new ServiceRequest(1, student, "Network issue", Priority.LOW)
        );
        system.addServiceRequest(
                new ServiceRequest(2, student, "System outage", Priority.CRITICAL)
        );
        system.addServiceRequest(
                new ServiceRequest(3, student, "Projector issue", Priority.HIGH)
        );

        if (system.processRequest().getPriority() != Priority.CRITICAL) {
            throw new AssertionError("Critical request was not processed first.");
        }
        if (system.processRequest().getPriority() != Priority.HIGH) {
            throw new AssertionError("High request was not processed second.");
        }
        if (system.processRequest().getPriority() != Priority.LOW) {
            throw new AssertionError("Low request was not processed last.");
        }

        if (!system.removeStudent(101)) {
            throw new AssertionError("Student removal failed.");
        }
        if (!system.removeResource("LAB-01")) {
            throw new AssertionError("Resource removal failed.");
        }

        System.out.println("CampusManagementSystem integration test passed.");
    }
}
