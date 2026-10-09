package model;

public class CampusActivity {

    private String name;
    private int startTime;
    private int endTime;

    public CampusActivity(
            String name,
            int startTime,
            int endTime) {

        if (endTime <= startTime) {
            throw new IllegalArgumentException(
                    "End time must be greater than start time"
            );
        }

        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getName() {
        return name;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    @Override
    public String toString() {

        return name
                + " ["
                + startTime
                + "-"
                + endTime
                + "]";
    }
}