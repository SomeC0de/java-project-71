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
            String s =  key.toString();
            if (from.containsKey(s) && !to.containsKey(s)) {
                return generateRecord(s, STATUS_DELETED, from.get(key.toString()));
            } else  if (!from.containsKey(s) && to.containsKey(s)) {
                return generateRecord(s, STATUS_ADDED, to.get(s));
            } else if (from.containsKey(s) && to.containsKey(s)) {
                if (Objects.equals(from.get(s), to.get(s))) {
                    return generateRecord(s, STATUS_UNCHANGED, from.get(s));
                } else {
                    return generateRecord(s, STATUS_CHANGED, from.get(s), to.get(s));
                }
            } else {
                throw new RuntimeException("Error: Unknown key found!");
            }
        }).collect(Collectors.toList());
    }

    private static Map<String, Object> generateRecord(String key, Object state, Object value) {
        return new LinkedHashMap<String, Object>(Map.of(
                KEY_ID_KEY, key.toString(),
                KEY_ID_STATE, state,
                KEY_ID_VALUE, value));
    }

    private static Map<String, Object> generateRecord(String key, Object state, Object from, Object to) {
        return new LinkedHashMap<String, Object>(Map.of(
                KEY_ID_KEY, key.toString(),
                KEY_ID_STATE, state,
                KEY_ID_FROM, from,
                KEY_ID_TO, to));
    }
}
