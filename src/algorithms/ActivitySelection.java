package algorithms;

import model.CampusActivity;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ActivitySelection {

    public static List<CampusActivity> selectActivities(
            List<CampusActivity> activities) {

        List<CampusActivity> sorted =
                new ArrayList<>(activities);

        sorted.sort(
                Comparator.comparingInt(
                        CampusActivity::getEndTime
                )
        );

        List<CampusActivity> selected =
                new ArrayList<>();

        int lastEndTime = Integer.MIN_VALUE;

        for (CampusActivity activity : sorted) {

            if (activity.getStartTime()
                    >= lastEndTime) {

                selected.add(activity);

                lastEndTime =
                        activity.getEndTime();
            }
        }

        return selected;
    }
}