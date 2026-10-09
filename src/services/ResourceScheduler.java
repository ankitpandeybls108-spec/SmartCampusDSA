package services;

import algorithms.ActivitySelection;
import model.CampusActivity;

import java.util.List;

public class ResourceScheduler {

    public List<CampusActivity> createSchedule(
            List<CampusActivity> activities) {

        return ActivitySelection.selectActivities(
                activities
        );
    }
}