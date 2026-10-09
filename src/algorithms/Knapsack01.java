package algorithms;

import model.ResourceItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Knapsack01 {

    public static int maximizeValue(
            List<ResourceItem> items,
            int capacity) {

        if (capacity <= 0 || items.isEmpty()) {
            return 0;
        }

        int n = items.size();

        int[][] dp =
                new int[n + 1][capacity + 1];

        for (int i = 1; i <= n; i++) {

            ResourceItem item =
                    items.get(i - 1);

            int weight =
                    item.getWeight();

            int value =
                    item.getValue();

            for (int w = 0; w <= capacity; w++) {

                // Option 1: don't take item
                dp[i][w] =
                        dp[i - 1][w];

                // Option 2: take item
                if (weight <= w) {

                    dp[i][w] =
                            Math.max(
                                    dp[i][w],
                                    value
                                    + dp[i - 1]
                                    [w - weight]
                            );
                }
            }
        }

        return dp[n][capacity];
    }

    public static List<ResourceItem> selectedItems(
            List<ResourceItem> items,
            int capacity) {

        if (capacity <= 0 || items.isEmpty()) {
            return new ArrayList<>();
        }

        int n = items.size();

        int[][] dp =
                new int[n + 1][capacity + 1];

        for (int i = 1; i <= n; i++) {

            ResourceItem item =
                    items.get(i - 1);

            for (int w = 0; w <= capacity; w++) {

                dp[i][w] =
                        dp[i - 1][w];

                if (item.getWeight() <= w) {

                    dp[i][w] =
                            Math.max(
                                    dp[i][w],
                                    item.getValue()
                                    + dp[i - 1]
                                    [w - item.getWeight()]
                            );
                }
            }
        }

        List<ResourceItem> selected =
                new ArrayList<>();

        int w = capacity;

        for (int i = n; i >= 1; i--) {

            if (dp[i][w] != dp[i - 1][w]) {

                ResourceItem item =
                        items.get(i - 1);

                selected.add(item);

                w -= item.getWeight();
            }
        }

        Collections.reverse(selected);

        return selected;
    }
    public static int maximizeValueMemoized(
        List<ResourceItem> items,
        int capacity) {

    if (capacity <= 0 || items.isEmpty()) {
        return 0;
    }

    Integer[][] memo =
            new Integer[
                    items.size()
                    ][capacity + 1];

    return solve(
            items,
            items.size() - 1,
            capacity,
            memo
    );
}

private static int solve(
        List<ResourceItem> items,
        int index,
        int capacity,
        Integer[][] memo) {

    if (index < 0 || capacity <= 0) {
        return 0;
    }

    if (memo[index][capacity] != null) {
        return memo[index][capacity];
    }

    ResourceItem item =
            items.get(index);

    int skip =
            solve(
                    items,
                    index - 1,
                    capacity,
                    memo
            );

    int take = 0;

    if (item.getWeight() <= capacity) {

        take =
                item.getValue()
                + solve(
                        items,
                        index - 1,
                        capacity
                                - item.getWeight(),
                        memo
                );
    }

    memo[index][capacity] =
            Math.max(skip, take);

    return memo[index][capacity];
}
}