package tests;

import algorithms.Knapsack01;
import model.ResourceItem;

import java.util.ArrayList;
import java.util.List;

public class Knapsack01Test {

    public static void main(String[] args) {

        List<ResourceItem> items =
                new ArrayList<>();

        items.add(
                new ResourceItem(
                        "Laptop",
                        60,
                        10
                )
        );

        items.add(
                new ResourceItem(
                        "Projector",
                        100,
                        20
                )
        );

        items.add(
                new ResourceItem(
                        "Server",
                        120,
                        30
                )
        );

        int capacity = 50;

        int maximumValue =
                Knapsack01.maximizeValue(
                        items,
                        capacity
                );

        List<ResourceItem> selected =
                Knapsack01.selectedItems(
                        items,
                        capacity
                );

        System.out.println(
                "=== 0/1 Knapsack ==="
        );

        System.out.println(
                "Maximum value = "
                + maximumValue
        );

        System.out.println(
                "Selected resources:"
        );

        for (ResourceItem item : selected) {
            System.out.println(item);
        }
    }
}