package hexlet.code;

import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;

import java.util.*;

public class ContentComparator {
    public static Map<String, CompareEntity> compare (Map<String, Object> left, Map<String, Object>right) {
        var keys = new TreeSet<>();
        keys.addAll(left.keySet());
        keys.addAll(right.keySet());

        return Map.of();
    }
}
