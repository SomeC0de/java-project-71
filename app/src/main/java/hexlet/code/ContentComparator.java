package hexlet.code;

import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;

import java.util.*;

public class ContentComparator {
    public enum fieldState {
        NOT_CHANGED,
        CHANGED,
        REMOVED,
        ADDED
    };
    public static List<Map<String, Object>> compare (Map<String, Object> left, Map<String, Object>right) {
        // TBD: foreach for every key to compare
        var keys = new TreeSet<>();
        ArrayList<Map<String, Object>> compared = new ArrayList<Map<String, Object>>();
        keys.addAll(left.keySet());
        keys.addAll(right.keySet());
        MapDifference<String, Object> difference = Maps.difference(left, right);

        return List.of(Map.of());
    }
}
