package hexlet.code;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Comparator {
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
                return generateRecord(s, RecordStatus.DELETED, from.get(key.toString()));
            } else  if (!from.containsKey(s) && to.containsKey(s)) {
                return generateRecord(s, RecordStatus.ADDED, to.get(s));
            } else if (from.containsKey(s) && to.containsKey(s)) {
                if (Objects.equals(from.get(s), to.get(s))) {
                    return generateRecord(s, RecordStatus.UNCHANGED, from.get(s));
                } else {
                    return generateRecord(s, RecordStatus.CHANGED, from.get(s), to.get(s));
                }
            } else {
                throw new RuntimeException("Error: Unknown key found!");
            }
        }).collect(Collectors.toList());
    }

    private static Map<String, Object> generateRecord(String key, Object state, Object value) {
        Map<String, Object> record = new LinkedHashMap<String, Object>();

        record.put(KEY_ID_KEY, key);
        record.put(KEY_ID_STATE, state);
        record.put(KEY_ID_VALUE, value);

        return record;
    }

    private static Map<String, Object> generateRecord(String key, Object state, Object from, Object to) {
        Map<String, Object> record = new LinkedHashMap<String, Object>();

        record.put(KEY_ID_KEY, key);
        record.put(KEY_ID_STATE, state);
        record.put(KEY_ID_FROM, from);
        record.put(KEY_ID_TO, to);

        return record;
    }
}
