package model;

public class CampusLocation {

    private String locationId;
    private String name;

    public CampusLocation(String locationId, String name) {
        this.locationId = locationId;
        this.name = name;
    }

    public String getLocationId() {
        return locationId;
    }

    public String getName() {
        return name;
    }

    

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CampusLocation)) {
            return false;
        }
        CampusLocation other = (CampusLocation) obj;
        return this.locationId.equals(other.locationId);
    }

    @Override
    public int hashCode() {
        return locationId.hashCode();
    }
}