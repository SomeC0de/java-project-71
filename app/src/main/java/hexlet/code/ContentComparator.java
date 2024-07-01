package hexlet.code;

import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class ContentComparator {
    public static List<Map<String, Object>> compare (Map<String, Object> content1, Map<String, Object>content2) {
        // TBD: foreach for every key to compare
        var keys = new TreeSet<>();
        keys.addAll(content1.keySet());
        keys.addAll(content2.keySet());
        return List.of(Map.of());
    }
}
