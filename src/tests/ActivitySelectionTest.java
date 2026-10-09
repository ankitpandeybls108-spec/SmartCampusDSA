package tests;

import algorithms.ActivitySelection;
import model.CampusActivity;

import java.util.ArrayList;
import java.util.List;

public class ActivitySelectionTest {

    public static void main(String[] args) {

        List<CampusActivity> activities =
                new ArrayList<>();

        activities.add(
                new CampusActivity("A", 9, 10)
        );

        activities.add(
                new CampusActivity("B", 9, 12)
        );

        activities.add(
                new CampusActivity("C", 10, 11)
        );

        activities.add(
                new CampusActivity("D", 11, 13)
        );

        activities.add(
                new CampusActivity("E", 12, 14)
        );

        List<CampusActivity> selected =
                ActivitySelection.selectActivities(
                        activities
                );

        System.out.println(
                "=== Activity Selection ==="
        );

        for (CampusActivity activity :
                selected) {

            System.out.println(activity);
        }

        System.out.println(
                "Selected activities = "
                + selected.size()
        );
    }
}