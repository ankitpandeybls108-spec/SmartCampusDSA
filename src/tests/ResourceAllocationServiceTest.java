package tests;

import model.ResourceItem;
import services.ResourceAllocationService;

import java.util.ArrayList;
import java.util.List;

public class ResourceAllocationServiceTest {

    public static void main(String[] args) {

        List<ResourceItem> resources =
                new ArrayList<>();

        resources.add(
                new ResourceItem(
                        "Laptop",
                        60,
                        10
                )
        );

        resources.add(
                new ResourceItem(
                        "Projector",
                        100,
                        20
                )
        );

        resources.add(
                new ResourceItem(
                        "Server",
                        120,
                        30
                )
        );

        resources.add(
                new ResourceItem(
                        "Sensor Kit",
                        80,
                        15
                )
        );

        int capacity = 50;

        ResourceAllocationService service =
                new ResourceAllocationService();

        int value =
                service.calculateMaximumValue(
                        resources,
                        capacity
                );

        List<ResourceItem> selected =
                service.selectResources(
                        resources,
                        capacity
                );

        System.out.println(
                "=== Campus Resource Allocation ==="
        );

        System.out.println(
                "Maximum value = "
                + value
        );

        System.out.println(
                "\nSelected resources:"
        );

        int totalWeight = 0;

        for (ResourceItem resource :
                selected) {

            System.out.println(resource);

            totalWeight +=
                    resource.getWeight();
        }

        System.out.println(
                "\nTotal weight = "
                + totalWeight
        );
    }
}