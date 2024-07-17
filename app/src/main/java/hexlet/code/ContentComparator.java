package hexlet.code;

import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;

import java.util.*;

public class ContentComparator {
    public static Map<String, CompareEntity> compare (Map<String, Object> from, Map<String, Object> to) {
        var keys = new TreeSet<>();
        keys.addAll(from.keySet());
        keys.addAll(to.keySet());

        return Map.of();
    }
}
