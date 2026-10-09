package datastructures;

import java.util.HashMap;
import java.util.Map;

public class DisjointSet {

    private Map<String, String> parent;
    private Map<String, Integer> rank;

    public DisjointSet() {
        parent = new HashMap<>();
        rank = new HashMap<>();
    }

    public void makeSet(String value) {

        if (!parent.containsKey(value)) {
            parent.put(value, value);
            rank.put(value, 0);
        }
    }

    public String find(String value) {

        if (!parent.containsKey(value)) {
            makeSet(value);
        }

        if (!parent.get(value).equals(value)) {

            parent.put(
                    value,
                    find(parent.get(value))
            );
        }

        return parent.get(value);
    }

    public boolean union(String first, String second) {

        String rootFirst = find(first);
        String rootSecond = find(second);

        if (rootFirst.equals(rootSecond)) {
            return false;
        }

        int rankFirst = rank.get(rootFirst);
        int rankSecond = rank.get(rootSecond);

        if (rankFirst < rankSecond) {

            parent.put(rootFirst, rootSecond);

        } else if (rankFirst > rankSecond) {

            parent.put(rootSecond, rootFirst);

        } else {

            parent.put(rootSecond, rootFirst);

            rank.put(
                    rootFirst,
                    rankFirst + 1
            );
        }

        return true;
    }
}