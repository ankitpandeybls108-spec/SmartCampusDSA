package services;

import datastructures.HashMap;
import model.Resource;

public class ResourceDirectory {

    private HashMap<String, Resource> resources;

    public ResourceDirectory(int capacity) {
        resources = new HashMap<>(capacity);
    }

    public void addResource(Resource resource) {

        resources.put(
                resource.getResourceId(),
                resource
        );
    }

    public Resource findResource(String resourceId) {

        return resources.get(resourceId);
    }

    public boolean containsResource(
            String resourceId) {

        return resources.containsKey(resourceId);
    }

    public Resource removeResource(
            String resourceId) {

        return resources.remove(resourceId);
    }

    public int totalResources() {

        return resources.size();
    }
}