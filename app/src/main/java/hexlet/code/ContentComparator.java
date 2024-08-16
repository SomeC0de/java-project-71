package hexlet.code;

import java.util.Map;
import java.util.Objects;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.TreeMap;

public class ContentComparator {
    public static Map<String, CompareRecord> compare(Map<String, Object> from, Map<String, Object> to) {
        var keys = new TreeSet<>();
        keys.addAll(from.keySet());
        keys.addAll(to.keySet());

        return keys.stream().collect(Collectors.toMap(key -> key.toString(), key -> {
            if (from.containsKey(key) && !to.containsKey(key)) {
                return new CompareRecord(RecordStatus.REMOVED, from.get(key));
            } else  if (!from.containsKey(key) && to.containsKey(key)) {
                return new CompareRecord(RecordStatus.ADDED, to.get(key));
            } else  if (from.containsKey(key) && to.containsKey(key)) {
                if (Objects.equals(from.get(key), to.get(key))) {
                    return new CompareRecord(RecordStatus.NOT_CHANGED, from.get(key));
                } else {
                    return new CompareRecord(RecordStatus.CHANGED, from.get(key), to.get(key));
                }
            } else {
                throw new RuntimeException("Error: Unknown key found!");
            }
        }, (existing, replacement) -> existing, TreeMap::new));
    }
}
