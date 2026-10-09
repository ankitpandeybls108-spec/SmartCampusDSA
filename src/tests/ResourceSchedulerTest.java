package tests;

import model.CampusActivity;
import services.ResourceScheduler;

import java.util.ArrayList;
import java.util.List;

public class ResourceSchedulerTest {

    public static void main(String[] args) {

        List<CampusActivity> activities =
                new ArrayList<>();

        activities.add(
                new CampusActivity(
                        "AI Seminar",
                        9,
                        10
                )
        );

        activities.add(
                new CampusActivity(
                        "DSA Workshop",
                        9,
                        11
                )
        );

        activities.add(
                new CampusActivity(
                        "ML Workshop",
                        10,
                        12
                )
        );

        activities.add(
                new CampusActivity(
                        "Project Review",
                        11,
                        13
                )
        );

        ResourceScheduler scheduler =
                new ResourceScheduler();

        List<CampusActivity> schedule =
                scheduler.createSchedule(
                        activities
                );

        System.out.println(
                "=== Campus Resource Schedule ==="
        );

        for (CampusActivity activity :
                schedule) {

            System.out.println(activity);
        }
    }
}