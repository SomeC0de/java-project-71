package hexlet.code;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Comparator {
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
                return generateRecord(s, RecordStatus.DELETED.name(), from.get(key.toString()));
            } else  if (!from.containsKey(s) && to.containsKey(s)) {
                return generateRecord(s, RecordStatus.ADDED.name(), to.get(s));
            } else if (from.containsKey(s) && to.containsKey(s)) {
                if (Objects.equals(from.get(s), to.get(s))) {
                    return generateRecord(s, RecordStatus.UNCHANGED.name(), from.get(s));
                } else {
                    return generateRecord(s, RecordStatus.CHANGED.name(), from.get(s), to.get(s));
                }
            } else {
                throw new RuntimeException("Error: Unknown key found!");
            }
        }).collect(Collectors.toList());
    }

    private static Map<String, Object> generateRecord(String key, Object state, Object value) {
        Map<String, Object> record = new LinkedHashMap<String, Object>();

        record.put(FieldId.KEY.name(), key);
        record.put(FieldId.STATE.name(), state);
        record.put(FieldId.VALUE.name(), value);

        return record;
    }

    private static Map<String, Object> generateRecord(String key, Object state, Object from, Object to) {
        Map<String, Object> record = new LinkedHashMap<String, Object>();

        record.put(FieldId.KEY.name(), key);
        record.put(FieldId.STATE.name(), state);
        record.put(FieldId.FROM.name(), from);
        record.put(FieldId.TO.name(),  to);

        return record;
    }
}
