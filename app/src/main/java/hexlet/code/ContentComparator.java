package hexlet.code;

import java.util.*;
import java.util.stream.Collectors;

public class ContentComparator {
    public static Map<String, CompareRecord> compare(Map<String, Object> from, Map<String, Object> to) {
        var keys = new TreeSet<>();
        keys.addAll(from.keySet());
        keys.addAll(to.keySet());

        List<Map<String, Object>> compared = new ArrayList<Map<String, Object>>();

        compared = keys.stream().map(key -> {
            if (from.containsKey(key.toString()) && !to.containsKey(key.toString())) {
                return new LinkedHashMap<String, Object>(){{
                    put("key", key.toString());
                    put("state", RecordStatus.REMOVED);
                    put("value", from.get(key.toString()));
                }};
            } else  if (!from.containsKey(key.toString()) && to.containsKey(key.toString())) {
                return new LinkedHashMap<String, Object>(){{
                    put("key", key.toString());
                    put("state", RecordStatus.ADDED);
                    put("value", to.get(key.toString()));
                }};
            } else if (from.containsKey(key.toString()) && to.containsKey(key.toString())) {
                if (Objects.equals(from.get(key.toString()), to.get(key.toString()))) {
                    return new LinkedHashMap<String, Object>(){{
                        put("key", key.toString());
                        put("state", RecordStatus.NOT_CHANGED);
                        put("value", from.get(key.toString()));
                    }};
                } else {
                    return new LinkedHashMap<String, Object>() {{
                        put("key", key.toString());
                        put("state", RecordStatus.CHANGED);
                        put("from", from.get(key.toString()));
                        put("to", to.get(key.toString()));
                    }};
                }
            } else {
                throw new RuntimeException("Error: Unknown key found!");
            }
        }).collect(Collectors.toList());

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
