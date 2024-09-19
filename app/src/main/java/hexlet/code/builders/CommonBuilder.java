package hexlet.code.builders;

import hexlet.code.RecordKey;

import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class CommonBuilder {
    public static String build(List<Map<String, Object>> records, RecordMaker[] generators, StringJoiner template) {
        final StringJoiner result = template;

        records.forEach(value -> {
            String status = value.get(RecordKey.STATE.name()).toString();
            int statusId = RecordKey.valueOf(status).ordinal();
            String s = generators[statusId].generate(value);
            if (!s.equals("")) { result.add(s); }
        });

        return result.toString();
    }
}
