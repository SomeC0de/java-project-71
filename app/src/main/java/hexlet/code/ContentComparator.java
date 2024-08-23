package hexlet.code;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class ContentComparator {
    public static final String STATUS_UNCHANGED = "unchanged";
    public static final String STATUS_CHANGED = "changed";
    public static final String STATUS_ADDED = "added";
    public static final String STATUS_DELETED = "deleted";
    public static final String KEY_ID_KEY = "key";
    public static final String KEY_ID_STATE = "state";
    public static final String KEY_ID_VALUE = "value";
    public static final String KEY_ID_FROM = "from";
    public static final String KEY_ID_TO = "to";
    public static List<Map<String, Object>> compare(Map<String, Object> from, Map<String, Object> to) {
        var keys = new TreeSet<>();
        keys.addAll(from.keySet());
        keys.addAll(to.keySet());

        return keys.stream().map(key -> {
            if (from.containsKey(key.toString()) && !to.containsKey(key.toString())) {
                return new LinkedHashMap<String, Object>() {{
                        put(KEY_ID_KEY, key.toString());
                        put(KEY_ID_STATE, STATUS_DELETED);
                        put(KEY_ID_VALUE, from.get(key.toString()));
                    }};
            } else  if (!from.containsKey(key.toString()) && to.containsKey(key.toString())) {
                return new LinkedHashMap<String, Object>() {{
                        put(KEY_ID_KEY, key.toString());
                        put(KEY_ID_STATE, STATUS_ADDED);
                        put(KEY_ID_VALUE, to.get(key.toString()));
                    }};
            } else if (from.containsKey(key.toString()) && to.containsKey(key.toString())) {
                if (Objects.equals(from.get(key.toString()), to.get(key.toString()))) {
                    return new LinkedHashMap<String, Object>() {{
                            put(KEY_ID_KEY, key.toString());
                            put(KEY_ID_STATE, STATUS_UNCHANGED);
                            put(KEY_ID_VALUE, from.get(key.toString()));
                        }};
                } else {
                    return new LinkedHashMap<String, Object>() {{
                            put(KEY_ID_KEY, key.toString());
                            put(KEY_ID_STATE, STATUS_CHANGED);
                            put(KEY_ID_FROM, from.get(key.toString()));
                            put(KEY_ID_TO, to.get(key.toString()));
                        }};
                }
            } else {
                throw new RuntimeException("Error: Unknown key found!");
            }
        }).collect(Collectors.toList());
    }
}
