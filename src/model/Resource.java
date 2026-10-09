package model;

public class Resource {

    private String resourceId;
    private String name;
    private String type;
    private String location;
    private boolean available;

    public Resource(
            String resourceId,
            String name,
            String type,
            String location,
            boolean available) {

        this.resourceId = resourceId;
        this.name = name;
        this.type = type;
        this.location = location;
        this.available = available;
    }

    public String getResourceId() {
        return resourceId;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getLocation() {
        return location;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "resourceId='" + resourceId + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", location='" + location + '\'' +
                ", available=" + available +
                '}';
    }
}