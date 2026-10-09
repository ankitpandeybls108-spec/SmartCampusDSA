package services;

import algorithms.Knapsack01;
import model.ResourceItem;

import java.util.List;

public class ResourceAllocationService {

    public int calculateMaximumValue(
            List<ResourceItem> resources,
            int capacity) {

        return Knapsack01.maximizeValue(
                resources,
                capacity
        );
    }

    public List<ResourceItem> selectResources(
            List<ResourceItem> resources,
            int capacity) {

        return Knapsack01.selectedItems(
                resources,
                capacity
        );
    }
}