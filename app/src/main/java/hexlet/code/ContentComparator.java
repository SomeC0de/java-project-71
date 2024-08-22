package hexlet.code;

import java.util.*;
import java.util.stream.Collectors;

public class ContentComparator {
    public static List<Map<String, Object>>  compare(Map<String, Object> from, Map<String, Object> to) {
        var keys = new TreeSet<>();
        keys.addAll(from.keySet());
        keys.addAll(to.keySet());

        return keys.stream().map(key -> {
            if (from.containsKey(key.toString()) && !to.containsKey(key.toString())) {
                return new LinkedHashMap<String, Object>(){{
                    put("key", key.toString());
                    put("state", RecordStatus.REMOVED.getState());
                    put("value", from.get(key.toString()));
                }};
            } else  if (!from.containsKey(key.toString()) && to.containsKey(key.toString())) {
                return new LinkedHashMap<String, Object>(){{
                    put("key", key.toString());
                    put("state", RecordStatus.ADDED.getState());
                    put("value", to.get(key.toString()));
                }};
            } else if (from.containsKey(key.toString()) && to.containsKey(key.toString())) {
                if (Objects.equals(from.get(key.toString()), to.get(key.toString()))) {
                    return new LinkedHashMap<String, Object>(){{
                        put("key", key.toString());
                        put("state", RecordStatus.NOT_CHANGED.getState());
                        put("value", from.get(key.toString()));
                    }};
                } else {
                    return new LinkedHashMap<String, Object>() {{
                        put("key", key.toString());
                        put("state", RecordStatus.CHANGED.getState());
                        put("from", from.get(key.toString()));
                        put("to", to.get(key.toString()));
                    }};
                }
            } else {
                throw new RuntimeException("Error: Unknown key found!");
            }
        }).collect(Collectors.toList());
    }
}
