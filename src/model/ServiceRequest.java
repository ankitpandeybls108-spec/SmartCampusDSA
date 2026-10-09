package model;

public class ServiceRequest {

    private int requestId;
    private Student student;
    private String description;
    private Priority priority;

    public ServiceRequest(
            int requestId,
            Student student,
            String description,
            Priority priority) {

        this.requestId = requestId;
        this.student = student;
        this.description = description;
        this.priority = priority;
    }

    public int getRequestId() {
        return requestId;
    }

    public Student getStudent() {
        return student;
    }

    public String getDescription() {
        return description;
    }

    public Priority getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return "ServiceRequest{" +
                "requestId=" + requestId +
                ", student=" + student.getName() +
                ", description='" + description + '\'' +
                ", priority=" + priority +
                '}';
    }
}